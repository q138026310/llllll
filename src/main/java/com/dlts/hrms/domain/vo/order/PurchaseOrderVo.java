package com.dlts.hrms.domain.vo.order;

import com.dlts.hrms.domain.entity.PurchaseOrder;
import com.dlts.hrms.domain.entity.PurchaseOrderDetail;

import java.util.List;

/**
 * Created by admin on 2018/4/27.
 */
public class PurchaseOrderVo extends PurchaseOrder {

    private List<PurchaseOrderDetail> purchaseOrderDetails;

    public List<PurchaseOrderDetail> getPurchaseOrderDetails() {
        return purchaseOrderDetails;
    }

    public void setPurchaseOrderDetails(List<PurchaseOrderDetail> purchaseOrderDetails) {
        this.purchaseOrderDetails = purchaseOrderDetails;
    }
}
