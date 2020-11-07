package com.test.srv.lis.service;

import com.test.srv.lis.dto.CompanyDTO;
import com.test.srv.lis.entity.Company;
import com.test.srv.lis.entity.Company_a;
import com.test.srv.enumeration.CmdFlag;
import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.CurrentUser;
import com.test.srv.helper.DropdownDTO;
import com.test.srv.helper.ResponseMessage;
import com.test.srv.lis.dao.CompanyDao;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by nzepa on 10/11/2020.
 */
@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;

    //region public methods

    public List<DropdownDTO> getPortfolioList() {
        return companyDao.getPortfolioList();
    }

    public List<DropdownDTO> getCompanyTypeList() {
        return companyDao.getCompanyTypeList();
    }

    public ResponseMessage getCompanyList() {
        ResponseMessage responseMessage = new ResponseMessage();
        List<CompanyDTO> companyDTOs = companyDao.getCompanyList();
        if (companyDTOs != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(companyDTOs);
        }
        return responseMessage;
    }

    public ResponseMessage getCompanyDetail(Integer companyId) {
        ResponseMessage responseMessage = new ResponseMessage();
        CompanyDTO companyDTO = companyDao.getCompanyDetail(companyId);
        if (companyDTO == null) {
            responseMessage.setText("Data not available");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
        } else {
            responseMessage.setDTO(companyDTO);
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        }
        return responseMessage;
    }

    public ResponseMessage addCompany(CompanyDTO companyDTO, CurrentUser currentUser) throws IOException {
        ResponseMessage responseMessage = new ResponseMessage();
        Boolean isParentChecked = companyDTO.getIsParentCompany();
        Character isParentCompany = isParentChecked == null || !isParentChecked ? 'N' : 'Y';
        companyDTO.setIsParent(isParentCompany);

        MultipartFile logo = companyDTO.getLogo();
        if (logo != null) {
            byte[] logoByte = IOUtils.toByteArray(logo.getInputStream());
            String logoName = logo.getOriginalFilename();
            String logoExtension = logoName.substring(logoName.lastIndexOf(".") + 1, logoName.length()).toUpperCase();
            if (companyDTO.getCompanyId() != null && logoExtension.length() < 2) {
                CompanyDTO companyDTOdb = companyDao.getCompanyDetail(companyDTO.getCompanyId());
                companyDTO.setLogoByte(companyDTOdb.getLogoByte());
                companyDTO.setLogoExtension(companyDTOdb.getLogoExtension());
                companyDTO.setLogoName(companyDTOdb.getLogoName());
            } else {
                if (logoExtension.length() < 2) {
                    responseMessage.setText("Please Select Company Logo.");
                    responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                    return responseMessage;
                }
                companyDTO.setLogoByte(logoByte);
                companyDTO.setLogoExtension(logoExtension);
                companyDTO.setLogoName(logoName);
            }
        }
        if (companyDTO.getCompanyId() == null) {
            Character isParent = companyDao.getParentCompany();
            if (companyDTO.getIsParent() == 'Y' && isParent != null) {
                responseMessage.setText("Parent company already registered. Please un check parent company.");
                responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                return responseMessage;
            }
            Integer companyId = companyDao.getLastCompanyId();
            companyId = companyId == null ? 0 : companyId;
            companyDTO.setCompanyId(companyId + 1);
            companyDTO.setUpdatedBy(null);
            companyDTO.setUpdatedDate(null);
            companyDTO.setCreatedBy(currentUser.getLoginId());
            companyDTO.setCreatedDate(new Date());
            Company company = convertCompanyEntityToDto(currentUser, companyDTO, false);
            Company_a company_a = convertCompany_aEntityToDto(company, CmdFlag.CREATE.getValue());
            companyDao.addCompany(company, company_a);
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setText("Company added successfully.");
        } else {
            if (isParentCompany == 'Y') {
                Character isParent = companyDao.getParentCompanyByCompanyId(companyDTO.getCompanyId());
                isParent = isParent == null || isParent == 'N' ? 'N' : isParent;
                if (isParent != 'Y') {
                    Character isParentSet = companyDao.getParentCompany();
                    if (isParentSet != null) {
                        responseMessage.setText("Parent company already registered. Please un check parent company.");
                        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                        return responseMessage;
                    }
                }
            }
            CompanyDTO companyDTOdb = companyDao.getCompanyDetail(companyDTO.getCompanyId());
            companyDTO.setCreatedBy(companyDTOdb.getCreatedBy());
            companyDTO.setCreatedDate(companyDTOdb.getCreatedDate());
            companyDTO.setUpdatedBy(currentUser.getLoginId());
            companyDTO.setUpdatedDate(new Date());
            Company company = convertCompanyEntityToDto(currentUser, companyDTO, true);
            Company_a company_a = convertCompany_aEntityToDto(company, CmdFlag.MODIFY.getValue());
            companyDao.addCompany(company, company_a);
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setText("Data updated successfully.");
        }
        return responseMessage;
    }

    //endregion

    //region private methods
    private Company convertCompanyEntityToDto(CurrentUser currentUser, CompanyDTO companyDTO, Boolean isEdit) throws IOException {
        Company company = new Company();
        company.setCompanyId(companyDTO.getCompanyId());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setIsParent(companyDTO.getIsParent());
        company.setShortForm(companyDTO.getShortForm());
        company.setDescription(companyDTO.getDescription());
        company.setCompanyTypeId(companyDTO.getCompanyTypeId());
        company.setPortfolioId(companyDTO.getPortfolioId());
        company.setShareAmount(companyDTO.getShareAmount());
        company.setStatus(companyDTO.getStatus());
        company.setUpdatedBy(companyDTO.getUpdatedBy());
        company.setUpdatedDate(companyDTO.getUpdatedDate());
        company.setCreatedBy(companyDTO.getCreatedBy());
        company.setCreatedDate(companyDTO.getCreatedDate());
        if (isEdit) {
            company.setLogo(companyDTO.getLogoByte());
        } else {
            company.setLogo(companyDTO.getLogo().getBytes());
        }
        company.setLogoName(companyDTO.getLogoName());
        company.setLogoExtension(companyDTO.getLogoExtension());
        return company;
    }


    private Company_a convertCompany_aEntityToDto(Company company, Character cmdFlag) {
        Company_a company_a = new Company_a();
        BigInteger lastCompanyAuditId = companyDao.getLastCompanyAuditId();
        lastCompanyAuditId = lastCompanyAuditId == null ? BigInteger.ONE : lastCompanyAuditId.add(lastCompanyAuditId);
        company_a.setCompanyAuditId(lastCompanyAuditId);
        company_a.setCmdFlag(cmdFlag);
        company_a.setCompanyId(company.getCompanyId());
        company_a.setCompanyName(company.getCompanyName());
        company_a.setIsParent(company.getIsParent());
        company_a.setShortForm(company.getShortForm());
        company_a.setDescription(company.getDescription());
        company_a.setCompanyTypeId(company.getCompanyTypeId());
        company_a.setPortfolioId(company.getPortfolioId());
        company_a.setShareAmount(company.getShareAmount());
        company_a.setStatus(company.getStatus());
        company_a.setUpdatedBy(company.getUpdatedBy());
        company_a.setUpdatedDate(company.getUpdatedDate());
        company_a.setCreatedBy(company.getCreatedBy());
        company_a.setCreatedDate(company.getCreatedDate());
        company_a.setLogo(company.getLogo());
        company_a.setLogoName(company.getLogoName());
        company_a.setLogoExtension(company.getLogoExtension());
        return company_a;
    }
    //endregion
}
