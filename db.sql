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
	login_flag char(1) COMMENT '是否可登录',
	create_by varchar(32) NULL COMMENT '创建者',
	create_date datetime NULL COMMENT '创建时间',
	update_by varchar(32) NULL COMMENT '更新者',
	update_date datetime NULL COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '用户表';


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


DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
	id varchar(32) NULL COMMENT '编号',
	company_id varchar(32) NULL COMMENT '归属公司',
	department_id varchar(32) NULL COMMENT '归属部门',
	name varchar(100) NULL COMMENT '角色名称',
	create_by varchar(32) NULL COMMENT '创建者',
	create_date datetime NULL COMMENT '创建时间',
	update_by varchar(32) NULL COMMENT '更新者',
	update_date datetime NULL COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '角色表';


DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
	user_id varchar(32) NULL COMMENT '用户编号',
	role_id varchar(32) NULL COMMENT '角色编号',
	PRIMARY KEY (user_id, role_id)
) COMMENT = '用户-角色';


DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu
(
	role_id varchar(32) NULL COMMENT '角色编号',
	menu_id varchar(32) NULL COMMENT '菜单编号',
	PRIMARY KEY (role_id, menu_id)
) COMMENT = '角色-菜单';

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
	create_by varchar(32) NULL COMMENT '创建者',
	create_date datetime NULL COMMENT '创建时间',
	update_by varchar(32) NULL COMMENT '更新者',
	update_date datetime NULL COMMENT '更新时间',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '部门表';



DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict
(
	id varchar(32) NULL COMMENT '编号',
	value varchar(100) NULL COMMENT '数据值',
	label varchar(100) NULL COMMENT '标签名',
	parent_id varchar(32) DEFAULT '0' COMMENT '父级编号',
	remarks varchar(255) COMMENT '备注信息',
	PRIMARY KEY (id)
) COMMENT = '字典表';

DROP TABLE IF EXISTS sys_log;
CREATE TABLE sys_log
(
	id varchar(32) NULL COMMENT '编号',
	type char(1) DEFAULT '1' COMMENT '日志类型',
	title varchar(255) DEFAULT '' COMMENT '日志标题',
	create_by varchar(32) COMMENT '创建者',
	create_date datetime COMMENT '创建时间',
	remote_addr varchar(255) COMMENT '操作IP地址',
	user_agent varchar(255) COMMENT '用户代理',
	request_uri varchar(255) COMMENT '请求URI',
	method varchar(5) COMMENT '操作方式',
	params text COMMENT '操作提交的数据',
	exception text COMMENT '异常信息',
	PRIMARY KEY (id)
) COMMENT = '日志表';









