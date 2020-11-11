StudentRegistrationDao.getStudentList = SELECT id AS studentId, studentName \
                        FROM tbl_student_registration

StudentRegistrationDao.deleteStudentInfoByStudentId=DELETE FROM tbl_student_registration WHERE id=:studentId