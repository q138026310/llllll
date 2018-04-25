SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
	id bigint(19) NOT NULL COMMENT '编号',
	company_id bigint(19) NOT NULL COMMENT '归属公司',
	customer_id bigint(19) NOT NULL COMMENT '',
	department_id bigint(19) NOT NULL COMMENT '归属部门',
	username char(20) NOT NULL COMMENT '登录名',
	password char(255) NOT NULL COMMENT '密码',
	code char(20) NOT NULL COMMENT '工号',
	name char(5) NOT NULL COMMENT '姓名',
	email char(30) NOT COMMENT '邮箱',
	phone char(15) NOT COMMENT '电话',
	mobile char(11) NOT NULL COMMENT '手机',
	photo char(100) NOT NULL COMMENT '用户头像',
	login_ip int UNSIGNED NOT NULL COMMENT '最后登陆IP',
	login_time char(14) NOT NULL COMMENT '最后登陆时间',
	login_flag TINYINT  NOT NULL COMMENT '是否可登录 1是0否',
	create_user_id bigint(19) NOT NULL COMMENT '创建者',
	create_time char(19) NOT NULL COMMENT '创建时间',
	update_user_id bigint(19) NOT NULL COMMENT '更新者',
	status TINYINT NOT NULL COMMENT '状态',
	update_time char(19) NOT NULL COMMENT '更新时间',
	remarks char(20) NOT NULL COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '用户表';


insert into sys_user(id,company_id,username,password,login_flag,mobile,create_user_id,create_time,status,customer_id) values(1524620071074378496,1,'superadmin','d826cdbf45f431aac8dac3f44510c902',1,'13166668888',1,'20180101020304',1,123);
insert into sys_user(id,company_id,username,password,login_flag,mobile,create_user_id,create_time,status,customer_id) values(2,100,'wuwen','1',1,'13255556666',1,'20180101020304',1,123);


DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu
(
	id int(19) NOT NULL COMMENT '编号',
	parent_id int(19) NOT NULL COMMENT '父级编号',
	name char(10) NOT NULL COMMENT '名称',
	sort int NOT NULL COMMENT '排序',
	href char(200) NOT NULL COMMENT '链接',
	icon char(20) NOT NULL COMMENT '图标',
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
  id bigint(19) NULL COMMENT '编号',
  name varchar(50) NULL COMMENT '名称',
  code varchar(50) NULL COMMENT '逻辑编号',
  parent_id bigint(19) NOT NULL COMMENT '',
  contact varchar(10) NULL COMMENT '联系人',
  contact_phone varchar(50) NULL COMMENT '联系人电话',
  create_user_id varchar(32) NULL COMMENT '创建者',
  create_time datetime NULL COMMENT '创建时间',
  update_user_id varchar(32) NULL COMMENT '更新者',
  update_time datetime NULL COMMENT '更新时间',
  status TINYINT NOT null comment '删除标记0删除1正常',
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
