package com.dlts.hrms.service.impl;

import com.dlts.hrms.domain.cm.PageResult;
import com.dlts.hrms.domain.cm.Unified;
import com.dlts.hrms.domain.entity.PurchaseOrder;
import com.dlts.hrms.domain.vo.order.PurchaseOrderVo;
import com.dlts.hrms.mapper.PurchaseOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseOrderService extends BaseService{
    
    @Autowired
    PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    PurchaseOrderDetailService purchaseOrderDetailService;

    public Unified<List<PurchaseOrder>> select(PurchaseOrder purchaseOrder) {
        return select(purchaseOrder,purchaseOrderMapper);
    }

    @Transactional
    public Unified<Integer> insert(PurchaseOrderVo purchaseOrderVo) {
        Unified<Integer> unified = insert((PurchaseOrder)purchaseOrderVo,purchaseOrderMapper);
        purchaseOrderDetailService.insertBatch(purchaseOrderVo.getPurchaseOrderDetails());
        return unified;
    }

    public Unified<Integer> delete(PurchaseOrder purchaseOrder) {
        return update(purchaseOrder);
    }

    public Unified<PageResult> page(PurchaseOrder purchaseOrder) {
        return page(purchaseOrder,purchaseOrderMapper);
    }

    public Unified<PurchaseOrder> get(PurchaseOrder purchaseOrder) {
        return get(purchaseOrder,purchaseOrderMapper);
    }

    public Unified<Integer> update(PurchaseOrder purchaseOrder) {
        return update(purchaseOrder,purchaseOrderMapper);
    }
    
}
