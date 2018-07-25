package com.dlts.hrms.domain.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 商品多级单位
 */
@Table(name = "sys_product_multi_unit")
public class ProductMultiUnit extends BaseEntity{

    /**
     * 商品id
     */
    @Column(length = 19)
    private Long productId;

    /**
     * 单位名称
     */
    @Column(length = 5)
    private String name;

    /**
     * 换算率：主单位数量=辅助单位数量*换算率
     */
    @Column(length = 10)
    private Integer rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
