
CompanyDao.getPortfolioList = select p.portfolioId as valueInteger,p.portfolioName as valueText from tbl_portfolio p where p.status = 'Y'

CompanyDao.getCompanyTypeList = select t.companyTypeId as valueInteger,t.companyTypeName as valueText from tbl_company_type t where t.status = 'Y'

CompanyDao.getParentCompanyByCompanyId = SELECT C.isParentCompany FROM tbl_company C WHERE C.isParentCompany = 'Y' AND C.companyId =:companyId

CompanyDao.getCompanyList = select c.companyId,c.companyName,c.shortForm,c.description,t.companyTypeId, \
          t.companyTypeName,p.portfolioId, p.portfolioName,c.isParent,c.shareAmount,c.logo as logoByte \
          ,c.status from tbl_company c inner join tbl_company_type t on t.companyTypeId = c.companyTypeId \
          inner join tbl_portfolio p on p.portfolioId = c.portfolioId

CompanyDao.getCompanyDetail = select c.companyId,c.companyName,c.isParent,c.shortForm,c.description, c.portfolioId, \
          c.companyTypeId,c.shareAmount,c.status,c.updatedBy,c.updatedDate,c.createdBy,c.createdDate, \
          c.logoName, c.logo as logoByte, c.logoExtension from tbl_company c where c.companyId =:companyId

CompanyDao.getParentCompany = SELECT C.isParent FROM tbl_company C WHERE C.isParent = 'Y' LIMIT 1

CompanyDao.getLastCompanyId = SELECT MAX(C.companyId) FROM tbl_company C

CompanyDao.getLastCompanyAuditId = SELECT MAX(C.companyAuditId) FROM tbl_company_a C

CompanyDao.getParentCompanyByCompanyId = SELECT C.isParent FROM tbl_company C WHERE C.isParent = 'Y' AND C.companyId =:companyId
