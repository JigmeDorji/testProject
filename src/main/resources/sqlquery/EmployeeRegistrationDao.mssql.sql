EmployeeRegistrationDao.getEmployeeList =SELECT e.id,  \
e.emp_Name AS employeeName,  \
e.emp_Designation AS employeeDesignation,  \
e.emp_Department AS employeeDepartment, \
e.emp_Contact_No AS employeeContactNumber, \
e.emp_Dob AS employeeDateOfBirth, \
e.emp_Dzongkhag_Id AS employeeDzongkhagId, \
e.emp_Gewog_Id AS employeeGewogId, \
g.gew_name AS geogName, \
d.dzongkhagName \
FROM tbl_employee e \
INNER JOIN tbl_gewog g ON g.gew_id = e.emp_Gewog_Id \
INNER JOIN tbl_dzongkhag d ON d.id =  e.emp_Dzongkhag_Id

EmployeeRegistrationDao.deleteEmployeeById = DELETE FROM tbl_employee WHERE id =:employeeId