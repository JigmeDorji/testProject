SbBankDAO.getDzongkhagList = SELECT dongkhagId AS valueInteger, dongkhagName AS valueText FROM tbl_dzongkhag

SbBankDAO.getSbBankList = SELECT a.`id`, a.`address`, a.`cid`, a.`customerName`, a.`dzongkhagId`, a.`email`, a.`gender`, a.`mobile`, a.`dob`, b.`dongkhagName` \
FROM `tbl_sbbankaccount` a INNER JOIN `tbl_dzongkhag` b ON a.`dzongkhagId`= b.`dongkhagId`

SbBankDAO.deleteSbBankList= DELETE FROM `tbl_sbbankaccount` WHERE id=:id