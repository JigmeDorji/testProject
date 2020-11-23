package com.test.srv.lis.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_itemgroup")
public class ItemGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemgroup_id")
    private Integer itemgroup_id;

    @Column(name = "item_group_name")
    private String item_group_name;

    @Column(name = "item_group_description")
    private String item_group_description;

    @Column(name = "mandatory_item_group")
    private String mandatory_item_group;

    public Integer getItemgroup_id() {
        return itemgroup_id;
    }

    public void setItemgroup_id(Integer itemgroup_id) {
        this.itemgroup_id = itemgroup_id;
    }

    public String getItem_group_name() {
        return item_group_name;
    }

    public void setItem_group_name(String item_group_name) {
        this.item_group_name = item_group_name;
    }

    public String getItem_group_description() {
        return item_group_description;
    }

    public void setItem_group_description(String item_group_description) {
        this.item_group_description = item_group_description;
    }

    public String getMandatory_item_group() {
        return mandatory_item_group;
    }

    public void setMandatory_item_group(String mandatory_item_group) {
        this.mandatory_item_group = mandatory_item_group;
    }
}