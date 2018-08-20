
create table `boss_login_user` (
	`id` int(11) primary key not null auto_increment comment '主键',
	`created_time` datetime not null comment '创建时间',
    `updated_time` datetime not null comment '修改时间',
	`open_id` varchar(50) not null comment '登陆微信账号',
	`wechat_user_info` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci default null comment '微信用户信息',
	`login_phone_number` varchar(11) default null comment '登录手机号',
    `login_time` datetime not null comment '登陆时间',
	key `open_id` (`open_id`)
) engine=innodb auto_increment=1 default charset=utf8mb4  comment '微信绑定信息表';

create table `boss_common_dist` (
  `id` int(11) primary key   not null auto_increment comment '记录id',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `pid` int(22) default null comment '父id',
  `data_type` varchar(50) default null comment '数据类别',
  `data_code` varchar(50) default null comment '数据编码',
  `data_value` varchar(200) default null comment '数据名称/值',
  `sort_no` int(22) default null comment '顺序',
  `status` int(22) default null comment '状态',
  `data_desc` varchar(400) default null comment '数据类别说明',
  key `idx_dc_dt` (`data_type`,`data_code`),
  key `data_type` (`data_type`),
  key `data_code` (`data_code`)
) engine=innodb auto_increment=1 default charset=utf8 comment '基础信息表';

create table `boss_goods` (
  `id` int(11) primary key   not null auto_increment comment '主键id',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `brand_id` int(11) not null comment '品牌表主键',
  `price` decimal(9,2) not null comment '商品价格',
  `big_type` varchar(20) not null comment '商品类别大类,dist表goods_big_type',
  `small_type` varchar(20) not null comment '商品类别小类，dist表goods_small_type',
  `intro` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci default null comment '简介，简单说明',
  `details` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci default null comment '商品详情说明',
  `post_method` varchar(2) not null comment '邮寄方式，dist表post_method',
  `inventory` decimal(9,2) not null comment '库存，数量-重量-体积-面积等',
  `status` varchar(2) not null comment '状态，01-在售，02-预售，03-售空，04-下架，05-断码',
  `show_int` varchar(1) not null comment '是否首页展示,0-不是，1-是',
  `show_sales` varchar(1) not null comment '是否显示销量，0-不是，1-是',
  `sales_type` varchar(2) not null comment '销量类型，01-实际销量，02-订单销量',
  `hot_recommend` varchar(1) not null comment '是否热门推荐，0-不是，1-是',
  key `goods_type` (`big_type`,`small_type`),
  key `brand` (`brand_id`)
) engine=innodb auto_increment=1 default charset=utf8mb4 comment '商品基础信息表';

create table `boss_goods_ext` (
  `id` int(11) primary key   not null auto_increment comment '主键id',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `goods_id` int(11) not null comment '商品表主键',
  `has_customs` varchar(1) not null comment '是否有关税,0-不含关税，1-包含关税',
  `customs_price` decimal(9,2) default 0 comment '关税金额',
  `pinkage` varchar(1) not null comment '是否包邮，0-不包邮，1-包邮',
  `postage` decimal(5,2) default 0 comment '邮费金额',
  `logistics` varchar(100) default null comment '物流说明',
  `can_chang_refund` varchar(1) default null comment '是否支持退换货,0-不支持，1-支持',
  `explain_chang_refund` varchar(200) default null comment '退换货说明',
  `fit_people` varchar(2) default null comment '适用人群，dist表fit_people',
  `place_of_origin ` varchar(2) default null comment '原产地，dist表place_of_origin',
  `curing_type ` varchar(100) default null comment '养护类型',
  `texture ` varchar(100) default null comment '材质',
  key `goods_id` (`goods_id`)
) engine=innodb auto_increment=1 default charset=utf8mb4 comment '商品基础信息表';


create table `boss_discount` (
  `id` int(11) primary key   not null auto_increment comment '主键id',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `goods_id` int(11) not null comment '商品表主键',
  `discount` varchar(2) not null comment '折扣度，，dist表discount，01-0.1折，10-1折，85-8.5折...',
  `begin_time` datetime not null comment '折扣开始时间',
  `end_time` datetime not null comment '折扣结束时间',
  key `goods_id` (`goods_id`)
) engine=innodb auto_increment=1 default charset=utf8mb4 comment '商品折扣信息表';

create table `boss_brand` (
  `id` int(11) primary key   not null auto_increment comment '主键id',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `brand_intro` varchar(200) default null comment '简介，简单说明',
  `brand_type` varchar(20) not null comment '品牌类别',
  `region` varchar(2) default null comment '品牌地区，01-美国，02-中国，03-法国，04-英国，05-香港，06-澳门，07-韩国，08-日本，09-泰国，10-其他',
  `status` int(2) default null comment '状态',
  `details` varchar(400) default null comment '品牌详细说明',
  key `idx_dc_dt` (`data_type`,`data_code`),
  key `data_type` (`data_type`),
  key `data_code` (`data_code`)
) engine=innodb auto_increment=1 default charset=utf8 comment '品牌信息表';

create table `boss_document_info` (
  `id` int(11) primary key   not null auto_increment comment '主键',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `id_foreign_key` int(11) default null comment '关联表主键',
  `group_code` varchar(30) not null comment '文件属组',
  `file_name` varchar(100) default null comment '文件名',
  `file_type` varchar(5) default null comment '文件后缀名',
  `file_size` int(8) default null comment '文件大小，单位：字节',
  `file_path` varchar(200) not null comment '文件存储地址，',
  `file_remark` varchar(400) default null comment '文件备注',
  `row_no` int(3) not null comment '文件顺序',
   key `group_code` (`group_code`),
	key `id_foreign_key` (`id_foreign_key`)
) engine=innodb auto_increment=1 default charset=utf8 comment 'boss附件表';

create table `boss_coupon` (
  `id` int(11) primary key not null auto_increment comment '主键',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `goods_small_type` varchar(20) default null comment '指定商品小类的优惠券',
  `coupon_type` varchar(2) not null comment '优惠券类型，01-单品满减券，02-总价满减券，03-抵现金券，04-折扣券',
  `discount` varchar(2) default null comment '折扣度，dist表discount',
  `coupon_amount` decimal(9,2) default 0 comment '优惠券金额',
  `coupon_count` int(3) default 0 comment '优惠券数量',
  `start_time` datetime not null comment '生效时间',
  `end_time` datetime default null comment '失效时间，如果为空，永久有效',
  `coupon_status` varchar(1) not null comment '优惠券状态，0-可用，1-作废，2-过期',
  `coupon_remark` varchar(200) default null comment '优惠券备注'
   key `coupon_type` (`coupon_type`)
) engine=innodb auto_increment=1 default charset=utf8 comment 'boss优惠券表';


create table `boss_favorite` (
	`id` int(11) primary key   not null auto_increment comment '主键',
	`created_time` datetime not null comment '创建时间',
  	`updated_time` datetime not null comment '修改时间',
	`login_user_id` int(11) not null comment '微信绑定信息表主键',
	`favorite_type` varchar(2) not null comment '收藏类型，01-商品，02-品牌',
	`relation_id` int(11) not null comment '关联主键'
	key `relation_id` (`relation_id`),
	key `login_user_id` (`login_user_id`)
) engine=innodb auto_increment=1 default charset=utf8 comment 'boss收藏表';
		

create table `boss_address` (
  `id` int(11) primary key   not null auto_increment comment '主键',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `login_user_id` int(11) not null comment '微信绑定信息表主键',
  `addressee` varchar(20) not null comment '收件人姓名',
  `phone_no` varchar(11) not null comment '手机号码',
  `provinces` varchar(6) not null comment '省',
  `city` varchar(6) not null comment '市',
  `county` varchar(6) not null comment '区、县',
  `detailed_address` varchar(100) not null comment '详细地址',
  `id_card_no` varchar(18) default null comment '身份证号码',
  `real_name` varchar(30) default null comment '真实姓名'
) engine=innodb auto_increment=1 default charset=utf8 comment '收件地址表';


create table `boss_my_coupon` (
  `id` int(11) primary key not null auto_increment comment '主键',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `login_user_id` int(11) not null comment '微信绑定信息表主键',
  `coupon_id` int(11) default null comment '优惠券表主键',
  `coupon_status` varchar(1) not null comment '优惠券状态，0-未使用，1-已使用',
   key `login_user_id` (`login_user_id`),
   key `coupon_id` (`coupon_id`)
) engine=innodb auto_increment=1 default charset=utf8 comment '用户优惠券表';


create table `boss_order` (
  `id` int(11) primary key   not null auto_increment comment '主键',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `order_no` varchar(20) not null comment '订单号',
  `login_user_id` int(11) not null comment '微信绑定信息表主键',
  `goods_id` int(11) not null comment '商品表主键',
  `address_id` int(11) not null comment '收件地址表主键',
  `my_coupon_id` int(11) default null comment '优惠券表主键',
  `order_amount` decimal(9,2) not null comment '订单金额',
  `agree_to_policy` varchar(1) not null comment '是否同意政策协议和退换货政策，0-不同意，1-同意',
  `order_status` varchar(2) not null comment '订单状态，01-待发货，02-配送中，03-已完成，04-已取消',
  `pay_status` varchar(2) not null comment '订单状态，01-待支付，02-已支付，03-已退款',
  `delete_time` datetime default null comment '删除时间',
   key `login_user_id` (`login_user_id`)
) engine=innodb auto_increment=1 default charset=utf8 comment 'boss订单表';


create table `boss_order_ext` (
  `id` int(11) primary key   not null auto_increment comment '主键',
  `created_time` datetime not null comment '创建时间',
  `updated_time` datetime not null comment '修改时间',
  `order_id` varchar(20) not null comment '订单号',
  `express_company` varchar(2) default null comment '快递公司，dist表express_company',
  `express_no` varchar(30) default null comment '快递公司，dist表express_company',
  `delivery_time` datetime default null comment '发货时间',
   key `order_id` (`order_id`)
) engine=innodb auto_increment=1 default charset=utf8 comment 'boss订单表';




