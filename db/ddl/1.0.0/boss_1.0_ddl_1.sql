
create table `boss_login_user` (
	`id` int(11) primary key not null auto_increment comment '主键',
	`created_time` datetime not null comment '创建时间',
    `updated_time` datetime not null comment '修改时间',
	`open_id` varchar(50) not null comment '登陆微信账号',
	`wechat_user_info` varchar(1000) default null comment '微信用户信息',
	`login_phone_number` varchar(11) default null comment '登录手机号',
	key `open_id` (`open_id`)
) engine=innodb auto_increment=1 default charset=utf8  comment '微信绑定信息表';

create table `boss_common_dist` (
  `id` int(11) primary key   not null auto_increment comment '记录id',
  `pid` int(22) default null comment '父id',
  `data_type` varchar(50) default null comment '数据类别',
  `data_code` varchar(50) default null comment '数据编码',
  `data_value` varchar(200) default null comment '数据名称/值',
  `sort_no` int(22) unsigned default null comment '顺序',
  `status` int(22) default null comment '状态',
  `data_desc` varchar(400) default null comment '数据类别说明',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  key `idx_dc_dt` (`data_type`,`data_code`),
  key `data_type` (`data_type`),
  key `data_code` (`data_code`)
) engine=innodb auto_increment=1 default charset=utf8 comment '基础信息表';

