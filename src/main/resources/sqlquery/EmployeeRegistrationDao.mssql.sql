EmployeeRegistrationDao.getEmployeeList = SELECT id,  \
                                        emp_Name AS employeeName,  \
                                        emp_Designation AS employeeDesignation,  \
                                        emp_Department AS employeeDepartment, \
                                        emp_Contact_No AS employeeContactNumber, \
                                        emp_Dob AS employeeDateOfBirth FROM tbl_employee