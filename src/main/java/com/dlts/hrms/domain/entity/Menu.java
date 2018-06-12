package com.dlts.hrms.domain.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 不提供维护界面
 */
@Table(name = "sys_menu")
public class Menu extends BaseEntity{

    private Long parentId;

    @Column(length = 20)
    private String name;

    private int sort;

    @Column(length = 200)
    private String href;

    @Column(length = 20)
    private String icon;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
