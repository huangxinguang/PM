create database pm;
use pm;

create table pm.User
(
	id int auto_increment
		primary key,
	username varchar(20) null,
	password varchar(20) null
)
;

create table pm.demand
(
	ID int auto_increment comment '自增ID'
		primary key,
	PROJECT_ID int not null,
	DEMAND_NAME varchar(20) not null comment '需求名',
	DEMAND_DESCRIBE varchar(255) not null comment '需求描述',
	PUT_TIME varchar(20) not null comment '提出时间',
	PUT_USERID varchar(20) not null comment '提出人',
	VERSION varchar(20) not null comment '版本号',
	EXCEPT_END_TIME varchar(20) not null comment '预期完工日',
	ACTUAL_END_TIME varchar(20) null comment '实际完工日',
	COMPLETE_USERID varchar(20) null comment '完成人',
	DEMAND_STATUS int(10) not null comment '需求状态'
)
;

create table pm.modle
(
	id int auto_increment comment '设置主键自增'
		primary key,
	project_id int not null comment '项目主键关联',
	modle_name varchar(20) not null comment '项目模块名称',
	modle_describe varchar(500) not null comment '项目模块描述、说明',
	modle_state varchar(2) not null comment '项目模块状态，0：修改完，1：修改中'
)
;

create index m_fk
	on modle (project_id)
;

create table pm.modle_demand
(
	id int auto_increment comment '设置主键自增'
		primary key,
	modle_id int not null comment '项目模块表主键，关联模块表',
	demand_id int not null comment '需求表主键,关联需求表'
)
;

create index m_d_fk1
	on modle_demand (modle_id)
;

create index m_d_fk2
	on modle_demand (demand_id)
;

create table pm.modle_prototype
(
	id int auto_increment comment '设置主键自增'
		primary key,
	modle_prototype_name varchar(20) not null comment '模块原型名称',
	modle_prototype_describe varchar(500) not null comment '模块原型描述、说明',
	operate_time varchar(20) not null comment '操作时间'
)
;

create table pm.project
(
	ID int auto_increment comment '自增ID'
		primary key,
	PROJECT_NAME varchar(20) not null comment '名称',
	PROJECT_LEADER varchar(20) not null comment '项目负责人',
	PHONE varchar(20) not null comment '负责人电话',
	QQ varchar(20) null comment '负责人QQ',
	EMAIL varchar(100) not null comment '负责人邮箱',
	OPERATE_TIME varchar(20) not null comment '操作时间',
	PROJECT_STATUS varchar(10) not null comment '项目状态 0(开发中)/1(升级中)/2(已完成)'
)
;

create table pm.project_info
(
	id int auto_increment comment '设置主键自增'
		primary key,
	project_id int not null comment '项目主键关联',
	server_ip varchar(20) not null comment '服务器IP',
	db_server_ip varchar(20) not null comment '数据库服务器IP地址',
	db_port int not null comment '数据库端口号',
	db_user varchar(20) not null comment '数据库用户名',
	db_pwd varchar(20) not null comment '数据库密码',
	host_name varchar(50) not null comment '项目域名',
	ssh varchar(500) not null comment '其中包括：服务器用户名、密码、端口号、连接方式、防火墙等'
)
;

create index p_fk
	on project_info (project_id)
;

create table pm.version
(
	id int auto_increment comment '设置主键自增'
		primary key,
	version varchar(20) not null comment '申请的版本号',
	modle_id int not null comment '关联模块表',
	up_userid varchar(20) null comment '版本升级人',
	up_time varchar(20) null comment '版本完成时间',
	version_id int null comment '前一个版本的版本ID',
	demand_id int null comment '升级对应需求ID',
	version_state int not null comment '版本状态，0：已升级，1：升级中'
)
;

create index v_fk
	on version (modle_id)
;

INSERT INTO pm.User (username, password) VALUES ('admin', '123456');

