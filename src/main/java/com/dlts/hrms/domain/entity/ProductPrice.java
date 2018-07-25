package com.dlts.hrms.domain.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 商品多级价
 */
@Table(name = "sys_product_price")
public class ProductPrice extends BaseEntity{

    /**
     * 商品id
     */
    @Column(length = 19)
    private Long productId;

    @Column(length = 19)
    private Long price1;

    @Column(length = 19)
    private Long price2;

    @Column(length = 19)
    private Long price3;

    @Column(length = 19)
    private Long price4;

    @Column(length = 19)
    private Long price5;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPrice1() {
        return price1;
    }

    public void setPrice1(Long price1) {
        this.price1 = price1;
    }

    public Long getPrice2() {
        return price2;
    }

    public void setPrice2(Long price2) {
        this.price2 = price2;
    }

    public Long getPrice3() {
        return price3;
    }

    public void setPrice3(Long price3) {
        this.price3 = price3;
    }

    public Long getPrice4() {
        return price4;
    }

    public void setPrice4(Long price4) {
        this.price4 = price4;
    }

    public Long getPrice5() {
        return price5;
    }

    public void setPrice5(Long price5) {
        this.price5 = price5;
    }
}
