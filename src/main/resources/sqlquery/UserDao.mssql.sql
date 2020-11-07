UserDao.isLoginIdAlreadyExists = SELECT COUNT(*) FROM tbl_user WHERE UserId =:userId
 
UserDao.getUserList = SELECT A.userId, A.userFullName, A.createdDate, \
                      A.userStatus,A.userMobileNo, B.userRoleTypeName, A.companyId, C.companyName \
                      FROM tbl_user A INNER JOIN tbl_user_role_type B ON A.userRoleTypeId = B.userRoleTypeId \
                      INNER JOIN tbl_company C ON C.companyId = A.companyId
                      
UserDao.getLastAuditId = select max(u.userAuditId) from tbl_user_a u

UserDao.getOldPassword = SELECT UserPassword FROM tbl_user WHERE userId =:loginId

UserDao.getUserDetail = SELECT userId, userFullName, userMobileNo,userRoleTypeId, companyId, userStatus, emailId \
                       ,updatedBy, updatedDate, createdBy, createdDate FROM tbl_user WHERE UserId =:userId
                       
UserDao.getUserLog = call USP_GET_USER_LOG(:username)

UserDao.getUserLogDetail = select a.userId, a.userFullName, a.userMobileNo, a.emailId, a.userStatus, a.userRoleTypeId \
       ,a.companyId, a.createdDate from tbl_user_a a where a.userAuditId =:userAuditId

UserDao.deleteUser = DELETE FROM tbl_user WHERE userId=:userId

UserDao.checkEmailOnAddNew = select u.emailId from tbl_user u where u.emailId =:email

UserDao.checkEmailOnUpdate =  select u.emailId from tbl_user u where u.userId !=:username and u.emailId =:email limit 1

