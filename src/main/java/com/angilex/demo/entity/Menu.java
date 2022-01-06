package com.angilex.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable{

    // id
    private Integer id;

    // 菜单编码
    private String menuCode;

    // 菜单名字
    private String menuName;

    // 菜单类型
    private Integer menuType;

    // 链接
    private String url;

    // 父级菜单
    private Integer parentId;

    // 创建时间
    private Date gmtCreate;

    // 修改时间
    private Date gmtModified;

    public Menu() {
    }

    public Menu(Integer id, String menuCode, String menuName, Integer menuType, String url, Integer parentId, Date gmtCreate, Date gmtModified) {
        this.id = id;
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuType = menuType;
        this.url = url;
        this.parentId = parentId;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuCode='" + menuCode + '\'' +
                ", menuName='" + menuName + '\'' +
                ", menuType=" + menuType +
                ", url='" + url + '\'' +
                ", parentId=" + parentId +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
