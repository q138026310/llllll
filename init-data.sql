TRUNCATE TABLE sys_menu;
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(1,-1,'采购',1,'a/b','-1',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(2,-1,'销售',2,'a/b','-1',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(3,-1,'仓库',3,'a/b','-1',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(4,-1,'财务',4,'a/b','-1',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(5,-1,'报表',5,'a/b','-1',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(6,-1,'基础设置',6,'a/b','-1',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(7,-1,'系统设置',7,'a/b','-1',-1);

insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(100,1,'采购订单',1,'purchase/purchaseorder/purchaseorder_list','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(101,1,'进货单',2,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(102,1,'采购退货',3,'a/b','order',-1);

insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(200,2,'销售订单',1,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(201,2,'销售单',2,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(202,2,'销售退货',3,'a/b','order',-1);

insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(300,3,'商品库存',1,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(301,3,'调拨单',2,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(302,3,'拆装单',3,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(303,3,'库存盘点',4,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(304,3,'成本调整',5,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(305,3,'其他入库',6,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(306,3,'其他出库',7,'a/b','order',-1);

insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(400,4,'收款单',1,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(401,4,'付款单',2,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(402,4,'其他收入',3,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(403,4,'其他支出',4,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(404,4,'核销',5,'a/b','order',-1);

insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(600,6,'仓库管理',1,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(601,6,'商品管理',2,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(602,6,'商品分类',3,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(603,6,'单位管理',4,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(604,6,'品牌设置',5,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(605,6,'会员管理',6,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(606,6,'供应商管理',7,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(607,6,'客户管理',8,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(608,6,'收支科目',9,'a/b','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(609,6,'打印管理',10,'a/b','order',-1);

insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(700,7,'公司管理',1,'system/company/company_list','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(701,7,'部门管理',2,'system/department/department_list','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(702,7,'角色管理',3,'role/role_list','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(703,7,'员工管理',4,'user/user_list','order',-1);
insert into sys_menu(id,parent_id,name,sort,href,icon,customer_id) values(704,7,'参数设置',5,'user/user_list','order',-1);

truncate table sys_customer;
INSERT INTO `hrms`.`sys_customer`(`id`,`customer_id`,`contact`, `contact_phone`, `status`, `create_user_id`, `create_time`, `update_user_id`, `update_time`) 
    VALUES ('100000001','100000001','如来', '13999999999', 1, 0, sysdate(), 0, '0');
truncate table sys_company;
INSERT INTO `hrms`.`sys_company`(`id`, `name`, `code`, `parent_id`, `contact`, `contact_phone`, `status`, `create_user_id`, `create_time`,`update_user_id`, `update_time`, `customer_id`) 
    VALUES (200000001, '平台', '000', -1, 'admin', '13888888888', 1, 300000001, sysdate(), -1, -1,100000001);
truncate table  sys_user;
insert into sys_user(id,company_id,organization_id,username,password,code,name,email,phone,mobile,photo,login_ip,login_time,status,create_user_id,create_time,update_user_id,update_time,customer_id)
		 values(300000001,200000001,1,'admin','176d8ab94944e3883779f50f7638fd4a','0001','121','','',131,'',1,'',1,1,'',1,'',100000001);


