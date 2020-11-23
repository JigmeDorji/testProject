package com.test.srv.lis.dao;


import com.test.srv.helper.BaseDao;
import com.test.srv.lis.entity.ItemGroup;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ItemGroupDao extends BaseDao {


    @Transactional(value = "txManager", rollbackFor = Exception.class)
    public void saveItemGroup(ItemGroup itemGroup) {
        em.merge(itemGroup);
    }

//    @Transactional(readOnly = true)
//    public List<ItemGroupDTO> getItemGroup() {
//        String sqlQuery = "SELECT itemgroup_id,item_group_name,item_group_description,mandatory_item_group FROM tbl_itemgroup";
//        NativeQuery hQuery = (NativeQuery) hibernateQuery(sqlQuery, ItemGroupDTO.class);
//        return hQuery.list();
//    }
//
//    @Transactional
//    public void deleteItemGroup(Integer itemgroup_id) {
//        String sqlQuery = "DELETE FROM tbl_itemgroup WHERE itemgroup_id=:itemgroup_id";
//        hibernateQuery(sqlQuery)
//                .setParameter("itemgroup_id", itemgroup_id)
//                .executeUpdate();
//    }
//
//    @Transactional
//    public void update(ItemGroup itemGroup) {
//        em.merge(itemGroup);
//    }


}
