CREATE TABLE `sys_company` (
`id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '编号',
`name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
`custom_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编号',
`code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '逻辑编号',
`parent_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '逻辑上级编号',
`contact` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
`contact_phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人电话',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '公司表'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_department` (
`id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '编号',
`company_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属公司',
`parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级编号',
`name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
`master` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
`phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
`fax` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
`email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
`remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '部门表'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_dict` (
`id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '编号',
`value` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据值',
`name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据名',
`code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据编号',
`parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '父级编号',
`remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '字典表'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_log` (
`id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '编号',
`type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '日志类型',
`title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '日志标题',
`create_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`remote_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作IP地址',
`user_agent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户代理',
`request_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求URI',
`method` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方式',
`params` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作提交的数据',
`exception` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常信息',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '日志表'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_menu` (
`id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '编号',
`parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级编号',
`name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
`sort` int(11) NULL DEFAULT NULL COMMENT '排序',
`href` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
`icon` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '菜单表'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_role` (
`id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '编号',
`company_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属公司',
`department_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属部门',
`name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
`remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '角色表'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_role_menu` (
`role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色编号',
`menu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '菜单编号',
PRIMARY KEY (`role_id`, `menu_id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '角色-菜单'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_user` (
`id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '编号',
`company_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属公司',
`department_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属部门',
`username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
`password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
`code` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号',
`name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
`email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
`phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
`mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
`user_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
`photo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
`login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登陆IP',
`login_date` datetime NULL DEFAULT NULL COMMENT '最后登陆时间',
`login_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可登录 1是0否',
`remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '用户表'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `sys_user_role` (
`user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户编号',
`role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '角色编号',
PRIMARY KEY (`user_id`, `role_id`) 
)
ENGINE = InnoDB
AUTO_INCREMENT = 0
AVG_ROW_LENGTH = 0
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci
COMMENT = '用户-角色'
KEY_BLOCK_SIZE = 0
MAX_ROWS = 0
MIN_ROWS = 0
ROW_FORMAT = Compact;

CREATE TABLE `t_store` (
`id` varchar(32) NOT NULL,
`company_id` varchar(32) NULL COMMENT '所属机构',
`name` varchar(20) NULL,
`code` varchar(20) NULL,
`state` int(1) NULL COMMENT '状态0停用1正常2锁定',
`is_default` int(1) NULL COMMENT '是否默认仓库0否1是',
`contact` varchar(10) NULL,
`contact_phone` varchar(11) NULL,
`address` varchar(30) NULL,
`remarks` varchar(30) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_product` (
`id` varchar(32) NOT NULL,
`company_id` varchar(32) NULL,
`code` varchar(20) NULL,
`name` varchar(20) NULL,
`model` varchar(30) NULL COMMENT '规格型号',
`unit_id` varchar(20) NULL COMMENT '单位id',
`buy_price` int(11) NULL COMMENT '进货价',
`sale_price` int(11) NULL COMMENT '销售价',
`sn` varchar(30) NULL,
`remarks` varchar(30) NULL,
`common_id` varchar(32) NULL,
`price1` varchar(255) NULL,
`price2` varchar(255) NULL,
`price3` varchar(255) NULL,
`price4` varchar(255) NULL,
`price5` varchar(255) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_product_type` (
`id` varchar(32) NOT NULL,
`name` varchar(20) NULL,
`parent_id` varchar(32) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_unit` (
`id` varchar(32) NOT NULL,
`name` varchar(32) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_brand` (
`id` varchar(32) NOT NULL,
`name` varchar(20) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_common` (
`id` varchar(32) NOT NULL,
`state` int(4) NULL COMMENT '0删除1正常2禁用',
`root_company_id` varchar(32) NULL COMMENT '所属客户',
`create_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`create_user_id` varchar(32) NULL,
`update_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`update_user_id` varchar(32) NULL,
`disable_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`disable_user_id` varchar(32) NULL,
`enable_time` datetime NULL ON UPDATE CURRENT_TIMESTAMP,
`enable_user_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_supplier` (
`id` varchar(32) NOT NULL,
`name` varchar(20) NULL,
`contact` varchar(10) NULL,
`contact_phone` varchar(20) NULL,
`common_id` 32 NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_customer` (
`id` varchar(32) NOT NULL,
`name` varchar(20) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_subject` (
`id` varchar(32) NOT NULL,
`name` varchar(20) NULL,
`type` int(1) NULL COMMENT '科目类型1收入2支出',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_purchase_order` (
`id` varchar(32) NOT NULL,
`product_id` varchar(32) NULL COMMENT '商品id',
`store_id` varchar(32) NULL COMMENT '仓库id',
`number` int(11) NULL COMMENT '订购数量',
`price` int(11) NULL COMMENT '订购单价',
`remarks` varchar(255) NULL,
`state` int(4) NULL COMMENT '订单状态0待提交1待审核2审核通过3审核退回',
`type` int(1) NULL COMMENT '1采购2退货',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_purchase` (
`id` varchar(32) NOT NULL,
`product_id` varchar(32) NULL,
`store_id` varchar(32) NULL,
`number` int(11) NULL,
`price` int(11) NULL,
`remarks` varchar(255) NULL,
`state` int(4) NULL COMMENT '0已保存1已生成进货单',
`type` int(1) NULL COMMENT '1进货2退货',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_sale_order` (
`id` varchar(32) NOT NULL,
`product_id` varchar(32) NULL,
`store_id` varchar(32) NULL,
`number` int(11) NULL,
`price` int(11) NULL,
`remarks` varchar(255) NULL,
`state` int(4) NULL COMMENT '0待提交1待审批2审核通过3审核退回',
`common_id` varchar(32) NULL,
`type` int(1) NULL COMMENT '1销售2退货',
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_sale` (
`id` varchar(32) NOT NULL,
`producct_id` varchar(32) NULL,
`store_id` varchar(32) NULL,
`number` int(11) NULL,
`price` int(11) NULL,
`remarks` varchar(255) NULL,
`state` int(4) NULL COMMENT '0已保存1已生成销售单',
`type` int(1) NULL COMMENT '1销售2退货',
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_allotted` (
`id` varchar(32) NOT NULL,
`store_id_out` varchar(32) NULL COMMENT '调出仓库',
`store_id_in` varchar(32) NULL COMMENT '调入仓库',
`product_id` varchar(32) NULL,
`number` int(11) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_disassembly` (
`id` varchar(32) NOT NULL,
`t_dis_ass_id` varchar(32) NULL,
`store_id` varchar(32) NULL,
`product_id` varchar(32) NULL,
`number` int(11) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_assembly` (
`id` varchar(32) NOT NULL,
`t_dis_ass_id` varchar(32) NULL,
`store_id` varchar(32) NULL,
`product_id` varchar(32) NULL,
`number` int(11) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_dis_ass` (
`id` varchar(32) NOT NULL,
`type` int(1) NULL COMMENT '1组装2拆散',
`date` date NULL COMMENT '拆装日期',
`remarks` varchar(255) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_inventory` (
`id` varchar(32) NOT NULL,
`date` date NULL,
`store_id` varchar(32) NULL,
`common_id` varchar(32) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_inventory_detail` (
`id` varchar(32) NOT NULL,
`inventory_id` varchar(32) NULL,
`product_id` varchar(32) NULL,
`number` int(11) NULL COMMENT '盘点数量',
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_product_store` (
`id` varchar(32) NOT NULL,
`product_id` varchar(32) NULL,
`store_id` varchar(32) NULL,
`number` int(11) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_store_other` (
`id` varchar(32) NOT NULL,
`type` int(1) NULL COMMENT '1入库2出库',
`store_id` varchar(32) NULL,
`product_id` varchar(32) NULL,
`number` int(11) NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_cost_adjust` (
`id` varchar(32) NOT NULL,
`company_id` varchar(32) NULL COMMENT '调整机构',
`store_id` varchar(32) NULL,
`product_id` varchar(32) NULL,
`adjustAmount` int(11) NULL COMMENT '调整金额',
`date` date NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `t_receipt` (
);

CREATE TABLE `t_payment` (
);

CREATE TABLE `t_receipt_other` (
);

CREATE TABLE `t_payment_other` (
);

CREATE TABLE `table_1` (
);

