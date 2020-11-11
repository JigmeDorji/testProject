ChiwogRegistrationDao.getChiwogList = SELECT id,chiwogName,mobile FROM tbl_chiwog

ChiwogRegistrationDao.deleteChiwogInfoByChiwogId=DELETE  FROM tbl_chiwog WHERE id=:chiwogId