package com.dlts.hrms.web;

import com.dlts.hrms.domain.cm.Response;
import com.dlts.hrms.domain.entity.PurchaseOrder;
import com.dlts.hrms.domain.vo.order.PurchaseOrderVo;
import com.dlts.hrms.service.impl.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderAction extends BaseAction{
    
    @Autowired
    PurchaseOrderService purchaseOrderService;

    @RequestMapping("/insert")
    public String insert(PurchaseOrderVo purchaseOrderVo) {
        return Response.body(purchaseOrderService.insert(purchaseOrderVo));
    }

    @RequestMapping("/update")
    public String update(PurchaseOrder purchaseOrder) {
        return Response.body(purchaseOrderService.update(purchaseOrder));
    }

    @RequestMapping("/delete")
    public String delete(PurchaseOrder purchaseOrder) {
        return Response.body(purchaseOrderService.delete(purchaseOrder));
    }

    @RequestMapping("/page")
    public String page(PurchaseOrder purchaseOrder) {
        return Response.body(purchaseOrderService.page(purchaseOrder));
    }

    @RequestMapping("/select")
    public String select(PurchaseOrder purchaseOrder) {
        return Response.body(purchaseOrderService.select(purchaseOrder));
    }

    @RequestMapping("/get")
    public String get(PurchaseOrder purchaseOrder) {
        return Response.body(purchaseOrderService.get(purchaseOrder));
    }
    
}
