
ApplicationDao.getCompanyList = SELECT companyId AS valueInteger,companyName AS text FROM tbl_company;

ApplicationDao.getLastApplicationDocumentId = select max(a.documentId) from tbl_application_document a

ApplicationDao.getApplicationList = select a.applicationNo, a.companyId, c.companyName,a.subject, a.description, a.acreage, a.amount, \
               a.applicationDate ,a.status, a.updatedBy, a.updatedDate, a.createdBy, a.createdDate \
               from tbl_application a inner join tbl_company c on c.companyId = a.companyId

ApplicationDao.getApplicationDetail = select a.applicationNo, a.companyId,a.subject, a.description, a.acreage, a.amount, \
              a.applicationDate ,a.status, a.updatedBy, a.updatedDate, a.createdBy, a.createdDate \
              from tbl_application a where a.applicationNo =:applicationNo

ApplicationDao.getSubmittedApplicationDocuments = select d.documentId, d.applicationNo, d.documentUrl, d.documentName, \
              d.documentStage, d.updatedBy, d.updatedDate, d.createdBy, d.createdDate from tbl_application_document d \
              where d.documentStage = 'I' and d.applicationNo =:applicationNo

ApplicationDao.downloadSubmittedDocument = select d.documentUrl,d.documentName from tbl_application_document d where d.documentId =:documentId

ApplicationDao.getApplicationComments = select c.commentId, c.comments, u.userFullName as commentedBy, u.createdBy, \
date_format(c.createdDate ,'%Y-%m-%d, %h:%i %p') as commentedDate \
,concat((substring(u.userFullName,1,1)),(substring(reverse(u.userFullName),position(' ' in reverse(u.userFullName))-1,1))) as commentedByShortForm \
from tbl_application_comment c inner join tbl_user u on u.userId = c.createdBy where c.applicationNo=:applicationNo order by c.createdDate desc

ApplicationDao.getLastCommentId = select max(c.commentId) from tbl_application_comment c
