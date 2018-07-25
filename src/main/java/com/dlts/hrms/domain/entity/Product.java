package com.dlts.hrms.domain.entity;

import com.dlts.hrms.domain.cm.Validate;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 商品
 */
@Table(name = "sys_product")
public class Product extends BaseEntity{

    /**
     * 商品名称
     */
    @Column(length = 20)
    private String name;

    /**
     * 商品编码
     */
    @Column(length = 20)
    private String code;

    /**
     * 商品分类
     */
    @Column(length = 19)
    private Long productTypeId;

    /**
     * 规格型号
     */
    @Column(length = 20)
    private String model;

    /**
     * 计量单位
     */
    @Column(length = 19)
    private Long unitId;

    /**
     * 进货价
     */
    @Column(length = 19)
    private Long purchasePrice;

    /**
     * 售价
     */
    @Column(length = 19)
    private Long salePrice;
    /**
     * 零售价
     */
    @Column(length = 19)
    private Long retailSellPrice;

    /**
     * 备注
     */
    @Column(length = 30)
    private String comments;

    @Validate
    private Integer status;

    @Validate
    private Long createUserId;

    @Validate
    private String createTime;

    @Validate(insert=false,update=true)
    private Long updateUserId;

    @Validate(insert=false,update=true)
    private String updateTime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public Long getRetailSellPrice() {
        return retailSellPrice;
    }

    public void setRetailSellPrice(Long retailSellPrice) {
        this.retailSellPrice = retailSellPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
