package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.PurchaseOrderDetail;
import com.dlts.hrms.mapper.PurchaseOrderDetailMapper;
import com.dlts.hrms.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2018/4/27.
 */
@Service
public class PurchaseOrderDetailService extends BaseService {
    
    @Autowired
    PurchaseOrderDetailMapper purchaseOrderDetailMapper;
    
    public Unified<List<PurchaseOrderDetail>> select(PurchaseOrderDetail purchaseOrderDetail) {
        return select(purchaseOrderDetail, purchaseOrderDetailMapper);
    }

    public Unified<Integer> insertBatch(List<PurchaseOrderDetail> purchaseOrderDetails) {
        return insertBatch(purchaseOrderDetails,purchaseOrderDetailMapper);
    }

    public Unified<Integer> insert(PurchaseOrderDetail purchaseOrderDetail) {
        return insert(purchaseOrderDetail ,purchaseOrderDetailMapper);
    }

    public Unified<Integer> delete(PurchaseOrderDetail purchaseOrderDetail) {
        return update(purchaseOrderDetail);
    }

    public PageResult page(PurchaseOrderDetail purchaseOrderDetail) {
        return page(purchaseOrderDetail, purchaseOrderDetailMapper);
    }

    public Unified<PurchaseOrderDetail> get(PurchaseOrderDetail purchaseOrderDetail) {
        return get(purchaseOrderDetail,purchaseOrderDetailMapper);
    }

    public Unified<Integer> update(PurchaseOrderDetail purchaseOrderDetail) {
        return update(purchaseOrderDetail ,purchaseOrderDetailMapper);
    }
}
