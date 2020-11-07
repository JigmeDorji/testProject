
CommonDao.getOldCredentials = SELECT UserPassword FROM tbl_user WHERE userId =:userId
CommonDao.getParentCompanyId = SELECT S.companyId FROM tbl_company_setup S WHERE S.isParentCompany = 'Y' LIMIT 1

CommonDao.updateUserPassword = UPDATE tbl_user SET UserPassword =:newPassword WHERE UserId =:userId

CommonDao.getStatusList = SELECT CAST(StatusId AS CHAR(1)) AS value, StatusTitle AS text FROM tbl_systemstatus

CommonDao.isLoginIdAlreadyExists = SELECT COUNT(*) FROM tbl_user WHERE UserId =:loginValue
CommonDao.getParentCompanyId =  select C.companyId from tbl_company_setup C where C.isParentCompany = 'Y';

CommonDao.getUserList = SELECT A.userId, \
                      A.userFullName, \
                      A.createdDate, \
                      A.userStatus ,\
                      A.userMobileNo ,\
                      B.userRoleTypeName, \
                      A.companyId, \
                      C.companyName \
                      FROM tbl_user A \
                      INNER JOIN tbl_user_role_type B ON A.userRoleTypeId = B.userRoleTypeId \
                      INNER JOIN tbl_company_setup C ON C.companyId = A.companyId
CommonDao.getUserInfo = SELECT UserPassword FROM tbl_user WHERE userId =:loginId

CommonDao.getUserDetail = SELECT userId, userFullName, userMobileNo,userRoleTypeId, companyId, \
                       createdDate, userStatus, emailId FROM tbl_user WHERE UserId =:userId

CommonDao.deleteUser = DELETE FROM tbl_user  WHERE userId=:userId

CommonDao.getUserRoleList = SELECT userRoleTypeId AS valueInteger,userRoleTypeName AS text FROM tbl_user_role_type

CommonDao.getScreenList = SELECT * FROM (SELECT \
                          a.screenId, \
                          a.screenName , \
                          b.userAccessPermissionId , \
                          b.isScreenAccessAllowed, \
                          b.isEditAccessAllowed, \
                          b.isDeleteAccessAllowed, \
                          b.isSaveAccessAllowed \
                          FROM tbl_screen a INNER JOIN tbl_useraccesspermission b \
                          ON a.screenId = b.screenId WHERE b.userRoleTypeId =:userRoleTypeId \
                          UNION \
                          SELECT  \
                          a.screenId, \
                          a.screenName , \
                          null AS userAccessPermissionId, \
                          null AS isScreenAccessAllowed, \
                          null AS isEditAccessAllowed, \
                          null AS isDeleteAccessAllowed,\
                          null AS isSaveAccessAllowed  \
                          FROM tbl_screen a WHERE a.screenId NOT IN (SELECT a.screenId \
                          FROM tbl_screen a INNER JOIN tbl_useraccesspermission b \
                          ON a.screenId = b.screenId WHERE b.userRoleTypeId =:userRoleTypeId)) AS TEMP
CommonDao.getUnScreenList = SELECT a.screenId , a.screenName FROM tbl_screen a

CommonDao.isUserRoleAssigned = SELECT * FROM tbl_useraccesspermission WHERE userRoleTypeId=:roleTypeId

CommonDao.login = SELECT \
                  A.userId , \
                  A.userFullName , \
                  A.userMobileNo , \
                  A.userPassword , \
                  A.createdDate , \
                  A.updatedDate , \
                  A.updatedBy , \
                  A.userStatus , \
                  A.userRoleTypeId, \
                  A.companyId,  \
                  A.emailId,  \
                  B.companyName  \
                  FROM tbl_user A INNER JOIN tbl_company B ON A.companyId=B.companyId WHERE A.UserId =:username

CommonDao.getCompanyList = SELECT companyId AS valueInteger,companyName AS text FROM tbl_company where status = 'A';

CommonDao.getFinancialList=SELECT financialYearId as valueBigInteger, \
                        CONCAT(financialYearFrom,' to ',financialYearTo) AS text \
                        FROM tbl_financial_year_setup;

CommonDao.getDocumentVersionList = SELECT DISTINCT versionNo AS valueInteger FROM tbl_draft_compact_master_a WHERE companyId=:companyId AND compactTypeId=:compactTypeId

CommonDao.getProductionVersionList = SELECT DISTINCT versionNo AS valueInteger \
                                     FROM tbl_production_a WHERE companyId=:companyId AND compactTypeId=:compactTypeId

CommonDao.getCompanyDetail=SELECT companyName,description FROM tbl_company_setup WHERE companyId=:companyId

CommonDao.getDetailWriteupVersionList=SELECT versionNo AS valueInteger FROM tbl_production_detail_writeup_a WHERE productionId=:productionId

CommonDao.getMaxCurrentId=SELECT id FROM tbl_user_wise_company_mapping ORDER BY id DESC LIMIT 1

CommonDao.getMappingCompanyListByUserId=SELECT a.companyId \
                                        FROM tbl_user_wise_company_mapping a \
                                        INNER JOIN tbl_company_setup b ON a.companyId=b.companyId WHERE userId=:userId

CommonDao.isUserWiseCompanyMappingExists=SELECT COUNT(*) FROM tbl_user_wise_company_mapping WHERE userId =:userId

CommonDao.deleteUserWiseCompanyMappingDetails=DELETE FROM tbl_user_wise_company_mapping WHERE userId =:userId

CommonDao.checkReviewerCompanyAuth=SELECT COUNT(*) FROM tbl_user_wise_company_mapping WHERE userId =:userId AND companyId=:companyId
CommonDao.getReviewerEmailId=SELECT emailId FROM tbl_user_wise_company_mapping A INNER JOIN  tbl_user B ON A.userId=B.userId WHERE A.companyId=:companyId LIMIT 1
CommonDao.getSelectedCompanyEmailId=SELECT emailId FROM tbl_user WHERE companyId=:selectedCompanyId LIMIT 1

CommonDao.getTotalWeight = CALL USP_DCA_GET_TOTAL_WEIGHT(:companyId,:financialYearId)

CommonDao.getAllocateWeight = SELECT financialCompact , customerService, production,organizationalManagement FROM tbl_company_setup WHERE companyId=:companyId

CommonDao.isEmailIdValid = SELECT COUNT(*) FROM tbl_user WHERE emailId=:emailId

CommonDao.resetPassword=UPDATE tbl_user SET userPassword=:newPassword WHERE emailId=:emailId
CommonDao.getAddressName=SELECT userFullName FROM tbl_user WHERE emailId=:emailId
CommonDao.getLastMefcMidtermDetailId = SELECT MAX(A.mefcMidtermDetailId) FROM tbl_mefc_detail_midterm A
CommonDao.getLastMefcMidtermDetailAuditId = SELECT MAX(A.mefcMidtermDetailAuditId) FROM tbl_mefc_detail_midterm_a A
CommonDao.getTotalScore = CALL USP_DCA_GET_TOTAL_SCORE(:companyId, :financialYearId)
CommonDao.checkIfEmailExist = select u.emailId from tbl_user u where u.emailId =:email
CommonDao.getEmail = select u.emailId from tbl_user u where u.userId =:username
CommonDao.checkEmailOnUpdate =  select u.emailId from tbl_user u where u.userId !=:username and u.emailId =:email limit 1
