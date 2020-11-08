package com.test.srv.lis.service;

import com.test.srv.enumeration.CommonStatus;
import com.test.srv.enumeration.SystemDataInt;
import com.test.srv.helper.*;
import com.test.srv.lis.dao.ApplicationDao;
import com.test.srv.lis.entity.Application;
import com.test.srv.lis.entity.ApplicationComment;
import com.test.srv.lis.entity.ApplicationDocument;
import com.test.srv.lis.dto.ApplicationCommentDTO;
import com.test.srv.lis.dto.ApplicationDTO;
import com.test.srv.lis.dto.ApplicationDocumentDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by nzepa on 10/13/2020.
 */
@Service
public class ApplicationService {
    private final ApplicationDao applicationDao;

    public ApplicationService(ApplicationDao applicationDao) {
        this.applicationDao = applicationDao;
    }

    //region public methods
    public List<DropdownDTO> getCompanyList() {
        return applicationDao.getCompanyList();
    }

    //region asdasd
    @Transactional(rollbackOn = Exception.class)
    public ResponseMessage submitApplication(HttpServletRequest request, CurrentUser currentUser
            , ApplicationDTO applicationDTO) throws IOException {
        ResponseMessage responseMessage;
        String applicationNo = getApplicationNoRandom(4);
        applicationDTO.setApplicationNo(applicationNo);
        applicationDTO.setStatus(CommonStatus.Submitted.getValue());
        applicationDTO.setApplicationDate(new Date());
        applicationDTO.setUpdatedBy(null);
        applicationDTO.setUpdatedDate(null);
        applicationDTO.setCreatedBy(currentUser.getLoginId());
        applicationDTO.setCreatedDate(new Date());
        Application application = convertApplicationDtoToEntity(applicationDTO, currentUser);
        applicationDao.submitApplication(application);
        List<MultipartFile> attachedFile = applicationDTO.getAttachedFile();
        responseMessage = validateFile(applicationDTO.getAttachedFile());
        if (attachedFile != null && responseMessage.getStatus() == SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value()) {
            for (MultipartFile multipartFile : attachedFile) {
                String attachedFileName = multipartFile.getOriginalFilename();
                FileUploadDTO fileUploadDTO = FileUploadToExternalLocation.fileUploadPathRetriever(request);
                String uploadedDirectory = fileUploadDTO.getUploadFilePath().concat(Objects.requireNonNull(attachedFileName));
                if (!attachedFileName.equals("")) {
                    responseMessage = FileUploadToExternalLocation.fileUploader(multipartFile, attachedFileName, "attachFile.properties", request);
                    BigInteger documentId = applicationDao.getLastApplicationDocumentId();
                    documentId = documentId == null ? BigInteger.ONE : documentId.add(BigInteger.ONE);
                    ApplicationDocument applicationDocument = new ApplicationDocument();
                    applicationDocument.setDocumentId(documentId);
                    applicationDocument.setApplicationNo(applicationNo);
                    applicationDocument.setDocumentName(attachedFileName);
                    applicationDocument.setDocumentUrl(uploadedDirectory);
                    applicationDocument.setDocumentStage('I');
                    applicationDocument.setCreatedBy(currentUser.getLoginId());
                    applicationDocument.setCreatedDate(new Date());
                    applicationDao.saveApplicationDocument(applicationDocument);
                }
            }
        }
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setText("Submitted successfully");
        return responseMessage;
    }

    public ResponseMessage getApplicationList() {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDTO> applicationDTOs = applicationDao.getApplicationList();
        if (applicationDTOs != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(applicationDTOs);
        }
        return responseMessage;
    }
    //endregion

    public ResponseMessage getApplicationDetail(String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDTO companyDTO = applicationDao.getApplicationDetail(applicationNo);
        if (companyDTO == null) {
            responseMessage.setText("Data not available");
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
        } else {
            responseMessage.setDTO(companyDTO);
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        }
        return responseMessage;
    }


    public ResponseMessage getSubmittedApplicationDocuments(String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationDocumentDTO> applicationDocumentDTOs =
                applicationDao.getSubmittedApplicationDocuments(applicationNo);
        if (applicationDocumentDTOs != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(applicationDocumentDTOs);
        }
        return responseMessage;
    }

    public ResponseMessage getApplicationComments(String applicationNo) {
        ResponseMessage responseMessage = new ResponseMessage();
        List<ApplicationCommentDTO> applicationCommentDTOS = applicationDao.getApplicationComments(applicationNo);
        if (applicationCommentDTOS != null) {
            responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
            responseMessage.setDTO(applicationCommentDTOS);
        }
        return responseMessage;
    }

    public ResponseMessage downloadSubmittedDocument(BigInteger documentId, HttpServletResponse response) throws IOException {
        ResponseMessage responseMessage;
        ApplicationDocumentDTO applicationDocumentDTO = applicationDao.downloadSubmittedDocument(documentId);
        String documentUrl = applicationDocumentDTO.getDocumentUrl();
        String fileName = applicationDocumentDTO.getDocumentName();

        responseMessage = FileUploadToExternalLocation.fileDownloader(fileName, documentUrl, response);
        if (responseMessage.getStatus() == SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value()) {
            return responseMessage;
        }
        responseMessage.setDTO(applicationDocumentDTO);
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        return responseMessage;
    }

    @Transactional(rollbackOn = Exception.class)
    public ResponseMessage approveApplication(CurrentUser currentUser, String applicationNo, String comments) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDTO applicationDTO = applicationDao.getApplicationDetail(applicationNo);
        Character status = null;
        if (applicationDTO.getStatus() == CommonStatus.Submitted.getValue()) {
            status = CommonStatus.Approve.getValue();
        } else if (applicationDTO.getStatus() == CommonStatus.Approve.getValue()) {
            status = CommonStatus.ApproveByDirector.getValue();
        } else if (applicationDTO.getStatus() == CommonStatus.ApproveByDirector.getValue()) {
            status = CommonStatus.ApproveByCeo.getValue();
        }
        applicationDTO.setStatus(status);
        applicationDTO.setUpdatedBy(currentUser.getLoginId());
        applicationDTO.setUpdatedDate(new Date());
        Application application = convertApplicationDtoToEntity(applicationDTO, currentUser);
        applicationDao.submitApplication(application);
        ApplicationCommentDTO applicationCommentDTO = new ApplicationCommentDTO();
        applicationCommentDTO.setComments(comments);
        applicationCommentDTO.setApplicationNo(applicationNo);
        applicationCommentDTO.setApplicationStatus(status);
        applicationCommentDTO.setUpdatedBy(null);
        applicationCommentDTO.setUpdatedDate(null);
        applicationCommentDTO.setCreatedBy(currentUser.getLoginId());
        applicationCommentDTO.setCreatedDate(new Date());
        responseMessage = saveComment(applicationCommentDTO);
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setText("Approved successfully");
        return responseMessage;
    }

    @Transactional(rollbackOn = Exception.class)
    public ResponseMessage rejectApplication(CurrentUser currentUser, String applicationNo, String comments) {
        ResponseMessage responseMessage = new ResponseMessage();
        ApplicationDTO applicationDTO = applicationDao.getApplicationDetail(applicationNo);
        applicationDTO.setUpdatedBy(currentUser.getLoginId());
        applicationDTO.setUpdatedDate(new Date());
        applicationDTO.setStatus(CommonStatus.Reject.getValue());
        Application application = convertApplicationDtoToEntity(applicationDTO, currentUser);
        applicationDao.submitApplication(application);
        ApplicationCommentDTO applicationCommentDTO = new ApplicationCommentDTO();
        applicationCommentDTO.setComments(comments);
        applicationCommentDTO.setApplicationNo(applicationNo);
        applicationCommentDTO.setApplicationStatus(CommonStatus.Reject.getValue());
        applicationCommentDTO.setUpdatedBy(null);
        applicationCommentDTO.setUpdatedDate(null);
        applicationCommentDTO.setCreatedBy(currentUser.getLoginId());
        applicationCommentDTO.setCreatedDate(new Date());
        responseMessage = saveComment(applicationCommentDTO);
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        responseMessage.setText("Rejected successfully");
        return responseMessage;
    }
    //endregion

    //region private variables
    private ResponseMessage saveComment(ApplicationCommentDTO applicationCommentDTO) {
        ResponseMessage responseMessage = new ResponseMessage();
        BigInteger lastCommentId = applicationDao.getLastCommentId();
        lastCommentId = lastCommentId == null ? BigInteger.ONE : lastCommentId.add(BigInteger.ONE);
        applicationCommentDTO.setCommentId(lastCommentId);
        ApplicationComment applicationComment = convertCommentDtoToEntity(applicationCommentDTO);
        applicationDao.saveComment(applicationComment);
        responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
        return responseMessage;
    }

    private ResponseMessage validateFile(List<MultipartFile> attachedFile) {
        ResponseMessage responseMessage = new ResponseMessage();
        if (attachedFile != null) {
            for (MultipartFile multipartFile : attachedFile) {
                String attachedFileName = multipartFile.getOriginalFilename();
                if (!Objects.equals(attachedFileName, "")) {
                    responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_SUCCESSFUL.value());
                } else {
                    responseMessage.setStatus(SystemDataInt.MESSAGE_STATUS_UNSUCCESSFUL.value());
                }
                return responseMessage;
            }
        }
        return responseMessage;
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvxyz0123456789";

    public static String getApplicationNoRandom(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    private Application convertApplicationDtoToEntity(ApplicationDTO applicationDTO, CurrentUser currentUser) {
        Application application = new Application();
        application.setApplicationNo(applicationDTO.getApplicationNo());
        application.setCompanyId(currentUser.getCompanyId());
        application.setSubject(applicationDTO.getSubject());
        application.setDescription(applicationDTO.getDescription());
        application.setAcreage(applicationDTO.getAcreage());
        application.setAmount(applicationDTO.getAmount());
        application.setStatus(applicationDTO.getStatus());
        application.setApplicationDate(applicationDTO.getApplicationDate());
        application.setUpdatedBy(applicationDTO.getUpdatedBy());
        application.setUpdatedDate(applicationDTO.getUpdatedDate());
        application.setCreatedBy(applicationDTO.getCreatedBy());
        application.setCreatedDate(applicationDTO.getCreatedDate());
        return application;
    }

    private ApplicationComment convertCommentDtoToEntity(ApplicationCommentDTO applicationCommentDTO) {
        ApplicationComment applicationComment = new ApplicationComment();
        applicationComment.setCommentId(applicationCommentDTO.getCommentId());
        applicationComment.setApplicationNo(applicationCommentDTO.getApplicationNo());
        applicationComment.setComments(applicationCommentDTO.getComments());
        applicationComment.setApplicationStatus(applicationCommentDTO.getApplicationStatus());
        applicationComment.setUpdatedBy(applicationCommentDTO.getUpdatedBy());
        applicationComment.setUpdatedDate(applicationCommentDTO.getUpdatedDate());
        applicationComment.setCreatedBy(applicationCommentDTO.getCreatedBy());
        applicationComment.setCreatedDate(applicationCommentDTO.getCreatedDate());
        return applicationComment;
    }
    //endregion

}
