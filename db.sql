SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

/* Create Tables */
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
	id varchar(32) NULL COMMENT '编号',
	company_id varchar(32) NULL COMMENT '归属公司',
	department_id varchar(32) NULL COMMENT '归属部门',
	username varchar(30) NULL COMMENT '登录名',
	password varchar(255) NULL COMMENT '密码',
	code varchar(30) COMMENT '工号',
	name varchar(10) NULL COMMENT '姓名',
	email varchar(50) COMMENT '邮箱',
	phone varchar(20) COMMENT '电话',
	mobile varchar(20) COMMENT '手机',
	user_type char(1) COMMENT '用户类型',
	photo varchar(100) COMMENT '用户头像',
	login_ip varchar(20) COMMENT '最后登陆IP',
	login_date datetime COMMENT '最后登陆时间',
	login_flag char(1) COMMENT '是否可登录 1是0否',
	create_user_id varchar(32) NULL COMMENT '创建者',
	create_time datetime NULL COMMENT '创建时间',
	update_user_id varchar(32) NULL COMMENT '更新者',
	update_time datetime NULL COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '用户表';

insert into sys_user(id,company_id,username,password,login_flag) values(1,1,'superadmin','superadmin',1);
insert into sys_user(id,company_id,username,password,login_flag) values(2,100,'wuwen','1',1);


DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu
(
	id varchar(32) NULL COMMENT '编号',
	parent_id varchar(32) NULL COMMENT '父级编号',
	name varchar(20) NULL COMMENT '名称',
	sort int NULL COMMENT '排序',
	href varchar(200) COMMENT '链接',
	icon varchar(20) COMMENT '图标',
	PRIMARY KEY (id)
) COMMENT = '菜单表';

insert into sys_menu(id,parent_id,name,sort,href,icon) values(1,-1,'销售',1,'a/b','-1');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(2,-1,'采购',2,'a/b','-1');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(3,-1,'仓库',3,'a/b','-1');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(4,-1,'资金',4,'a/b','-1');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(5,-1,'报表',5,'a/b','-1');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(6,-1,'基础设置',6,'a/b','-1');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(7,-1,'系统设置',7,'a/b','-1');

insert into sys_menu(id,parent_id,name,sort,href,icon) values(100,1,'销售订单',1,'a/b','order');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(101,1,'销售出库',2,'a/b','order');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(102,1,'销售退货',3,'a/b','order');

insert into sys_menu(id,parent_id,name,sort,href,icon) values(700,7,'公司管理',1,'company/company_list','order');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(701,7,'部门管理',2,'department/department_list','order');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(702,7,'角色管理',3,'role/role_list','order');
insert into sys_menu(id,parent_id,name,sort,href,icon) values(703,7,'用户管理',4,'user/user_list','order');


DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
	id varchar(32) NULL COMMENT '编号',
	company_id varchar(32) NULL COMMENT '归属公司',
	department_id varchar(32) NULL COMMENT '归属部门',
	name varchar(100) NULL COMMENT '角色名称',
	create_user_id varchar(32) NULL COMMENT '创建者',
	create_time datetime NULL COMMENT '创建时间',
	update_user_id varchar(32) NULL COMMENT '更新者',
	update_time datetime NULL COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '角色表';

insert into sys_role(id,company_id,name) values(1,1,'管理员');
insert into sys_role(id,company_id,name) values(2,100,'管理员');

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
	user_id varchar(32) NULL COMMENT '用户编号',
	role_id varchar(32) NULL COMMENT '角色编号',
	PRIMARY KEY (user_id, role_id)
) COMMENT = '用户-角色';

insert into sys_user_role(user_id,role_id) values(1,1);
insert into sys_user_role(user_id,role_id) values(2,2);


DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu
(
	role_id varchar(32) NULL COMMENT '角色编号',
	menu_id varchar(32) NULL COMMENT '菜单编号',
	PRIMARY KEY (role_id, menu_id)
) COMMENT = '角色-菜单';

insert into sys_role_menu(role_id,menu_id) values(1,1);
insert into sys_role_menu(role_id,menu_id) values(1,2);
insert into sys_role_menu(role_id,menu_id) values(1,3);
insert into sys_role_menu(role_id,menu_id) values(1,4);
insert into sys_role_menu(role_id,menu_id) values(1,5);
insert into sys_role_menu(role_id,menu_id) values(1,6);
insert into sys_role_menu(role_id,menu_id) values(1,7);

insert into sys_role_menu(role_id,menu_id) values(1,100);
insert into sys_role_menu(role_id,menu_id) values(1,101);
insert into sys_role_menu(role_id,menu_id) values(1,102);

insert into sys_role_menu(role_id,menu_id) values(1,700);
insert into sys_role_menu(role_id,menu_id) values(1,701);
insert into sys_role_menu(role_id,menu_id) values(1,702);
insert into sys_role_menu(role_id,menu_id) values(1,703);

--
insert into sys_role_menu(role_id,menu_id) values(2,1);
insert into sys_role_menu(role_id,menu_id) values(2,2);
insert into sys_role_menu(role_id,menu_id) values(2,3);
insert into sys_role_menu(role_id,menu_id) values(2,4);
insert into sys_role_menu(role_id,menu_id) values(2,5);
insert into sys_role_menu(role_id,menu_id) values(2,6);
insert into sys_role_menu(role_id,menu_id) values(2,7);

insert into sys_role_menu(role_id,menu_id) values(2,100);
insert into sys_role_menu(role_id,menu_id) values(2,101);
insert into sys_role_menu(role_id,menu_id) values(2,102);

insert into sys_role_menu(role_id,menu_id) values(2,700);
insert into sys_role_menu(role_id,menu_id) values(2,701);
insert into sys_role_menu(role_id,menu_id) values(2,702);
insert into sys_role_menu(role_id,menu_id) values(2,703);


-- admin 所有公司都在custom_code=0的公司下   custom_code=0的公司为虚拟根公司
DROP TABLE IF EXISTS sys_company;
CREATE TABLE sys_company
(
  id varchar(32) NULL COMMENT '编号',
  name varchar(50) NULL COMMENT '名称',
  custom_code varchar(50) NULL COMMENT '编号',
  code varchar(50) NULL COMMENT '逻辑编号',
  parent_code varchar(50) NULL COMMENT '逻辑上级编号',
  contact varchar(10) NULL COMMENT '联系人',
  contact_phone varchar(50) NULL COMMENT '联系人电话',
  create_user_id varchar(32) NULL COMMENT '创建者',
	create_time datetime NULL COMMENT '创建时间',
	update_user_id varchar(32) NULL COMMENT '更新者',
	update_time datetime NULL COMMENT '更新时间',
  PRIMARY KEY (id)
)COMMENT = '公司表';


insert into sys_company(id,name,custom_code,code,parent_code) values(1,'平台','0','10','-1');
insert into sys_company(id,name,custom_code,code,parent_code) values(100,'小浪淘沙','0356','10001','10');


DROP TABLE IF EXISTS sys_department;
CREATE TABLE sys_department
(
	id varchar(32) NULL COMMENT '编号',
  company_id varchar(32) NULL COMMENT '归属公司',
	parent_id varchar(32) NULL COMMENT '父级编号',
	name varchar(100) NULL COMMENT '名称',
	master varchar(100) COMMENT '负责人',
	phone varchar(200) COMMENT '电话',
	fax varchar(200) COMMENT '传真',
	email varchar(200) COMMENT '邮箱',
	create_user_id varchar(32) NULL COMMENT '创建者',
	create_time datetime NULL COMMENT '创建时间',
	update_user_id varchar(32) NULL COMMENT '更新者',
	update_time datetime NULL COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '部门表';




DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict
(
	id varchar(32) NULL COMMENT '编号',
	value varchar(20) NULL COMMENT '数据值',
	name varchar(20) NULL COMMENT '数据名',
	code varchar(20) NULL COMMENT '数据编号',
	parent_id varchar(32) DEFAULT '0' COMMENT '父级编号',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '字典表';


insert into sys_dict(id,value,name,code,parent_id) values(1,1,'是否启用log,0否1是','10000100',-1);

DROP TABLE IF EXISTS sys_log;
CREATE TABLE sys_log
(
	id varchar(32) NULL COMMENT '编号',
	type char(1) DEFAULT '1' COMMENT '日志类型',
	title varchar(255) DEFAULT '' COMMENT '日志标题',
	create_user_id varchar(32) COMMENT '创建者',
	create_time datetime COMMENT '创建时间',
	remote_addr varchar(255) COMMENT '操作IP地址',
	user_agent varchar(255) COMMENT '用户代理',
	request_uri varchar(255) COMMENT '请求URI',
	method varchar(5) COMMENT '操作方式',
	params text COMMENT '操作提交的数据',
	exception text COMMENT '异常信息',
	PRIMARY KEY (id)
) COMMENT = '日志表';





-- test DATA
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(21,'大浪淘沙1','1367','-1','张三1','13100112230',str_to_date('2014-04-22 15:47:00','%Y-%m-%d %H:%i:%s'));
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(3,'大浪淘沙2','2367','-1','张三2','13100112231',str_to_date('2014-04-22 15:47:01','%Y-%m-%d %H:%i:%s'));
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(4,'大浪淘沙3','3367','2367','张三3','13100112232',str_to_date('2014-04-22 15:47:02','%Y-%m-%d %H:%i:%s'));
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(5,'大浪淘沙4','4367','-1','张三4','13100112233',str_to_date('2014-04-22 15:47:03','%Y-%m-%d %H:%i:%s'));
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(6,'大浪淘沙5','5367','-1','张三5','13100112234',str_to_date('2014-04-22 15:47:04','%Y-%m-%d %H:%i:%s'));
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(7,'大浪淘沙6','6367','-1','张三6','13100112235',str_to_date('2014-04-22 15:47:05','%Y-%m-%d %H:%i:%s'));
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(8,'大浪淘沙7','7367','7367','张三7','13100112236',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(9,'大浪淘沙8','8367','-1','张三8','13100112237',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(10,'大浪淘沙9','9367','-1','张三9','13100112238',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(11,'大浪淘沙10','10367','-1','张三10','13100112239',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(12,'大浪淘沙11','110367','-1','张三11','131001122310',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(13,'大浪淘沙12','120367','-1','张三12','131001122311',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(14,'大浪淘沙13','130367','-1','张三13','131001122312',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(15,'大浪淘沙14','140367','-1','张三14','131001122313',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(16,'大浪淘沙15','150367','120367','张三15','131001122314',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(17,'大浪淘沙16','160367','-1','张三16','131001122315',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(18,'大浪淘沙17','170367','-1','张三17','131001122316',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(19,'大浪淘沙18','180367','170367','张三18','131001122317',SYSDATE());
insert into sys_company(id,name,code,parent_code,contact,contact_phone,create_time) values(20,'大浪淘沙19','190367','-1','张三19','131001122318',SYSDATE());

