-- 用户信息表
-- deleted:1代表可用，0代表删除
DROP TABLE IF EXISTS login_user;
CREATE TABLE login_user (
  phone_number varchar(18) not null,
  name varchar(10) DEFAULT NULL COMMENT '姓名',
  password varchar(60) DEFAULT NULL COMMENT '密码',
  person_id varchar(18) DEFAULT NULL COMMENT '身份证号码',
  deleted tinyint not null default 1 COMMENT '是否删除(1未删除；0已删除)',
  PRIMARY KEY (phone_number)
);

-- 测试数据
insert into login_user values
('13724522542','小红','12345','530323222200002323',1);

insert into login_user values
('13724522543','小蓝','12345','530323222200002323',0);

-- 作者信息-自主申报表
-- DROP TABLE IF EXISTS author_self;
-- CREATE TABLE author_self (
-- 	id int(5) not null COMMENT '表单ID' auto_increment,
-- 	form_type varchar(5) not null COMMENT '表单类型',
-- 	writer_phone_number varchar(18) not null COMMENT '填写人手机号',
--   name varchar(10) DEFAULT NULL COMMENT '作者姓名',
--   peison_id varchar(18) DEFAULT NULL COMMENT '身份证号码',
-- 	sex  tinyint DEFAULT null COMMENT '性别,1男,0 女',
--   phone varchar(11) DEFAULT NULL COMMENT '手机号码',
--   email varchar(20) DEFAULT NULL COMMENT '邮箱',
-- 	work_palce text default null COMMENT '工作单位',
-- 	work_type varchar(12) default null COMMENT '单位类型',
-- 	work_province varchar(5) default null COMMENT '工作省份',
-- 	work_city varchar(5) default null COMMENT '工作城市',
-- 	work_area varchar(5) default null COMMENT '工作区',
-- 	asso_province varchar(5) default null COMMENT '联系省份',
-- 	asso_city varchar(5) default null COMMENT '联系城市',
-- 	asso_area varchar(5) default null COMMENT '联系区',
-- 	asso_detail_palce text default null COMMENT '详细地址',
-- 	sec_phone varchar(11) default null COMMENT '紧急联系人',
--   deleted tinyint default 1 COMMENT '是否删除(1未删除；0已删除)',
-- -- 	img longblob default null COMMENT '头像',
-- 	star_name varchar(20) default null comment '榜样名称',
--   PRIMARY KEY (id)
-- );


/*
文字-组织-表单号 id int，
作者身份证号，作者表
申报方式 tinyint，（0 组织推荐，1 自主申报）
推荐组织 varchar，
组织类型 varchar，
组织所在地 varchar，
联系电话（区号+联系电话）
联系地址 ？？
详细地址 text，
*/
-- 文字申报表（组织）
-- 文字申报表（组织）

-- DROP TABLE IF EXISTS author_org;
-- CREATE TABLE author_org (
-- 	id int(5) not null COMMENT '表单ID' ,
-- 	writer_phone_number varchar(18) not null COMMENT '填写人手机号',
-- 	form_type varchar(5) not null COMMENT '表单类型',
--   name varchar(10) DEFAULT NULL COMMENT '作者姓名',
--   peison_id varchar(18) DEFAULT NULL COMMENT '身份证号码',
-- 	sex  tinyint DEFAULT null COMMENT '性别,1男,0 女',
--   phone varchar(11) DEFAULT NULL COMMENT '手机号码',
--   email varchar(20) DEFAULT NULL COMMENT '邮箱',
-- 	rec_org varchar(12) default null COMMENT '推荐组织',
-- 	org_type varchar(12) default null COMMENT '组织类型',
-- 	org_province varchar(5) default null COMMENT '组织省份',
-- 	org_city varchar(5) default null COMMENT '组织城市',
-- 	org_area varchar(5) default null COMMENT '组织所在区',
-- 	org_detail_palce text default null COMMENT '组织详细地址',
-- 	org_phone varchar(11) default null COMMENT '组织联系电话',
--   deleted tinyint default 1 COMMENT '是否删除(1未删除；0已删除)',
-- 	img longblob default null COMMENT '头像',
-- 	star_name varchar(20) default null comment '榜样名称',
--   PRIMARY KEY (id)
-- );

DROP TABLE IF EXISTS author;
CREATE TABLE author (
	id int(14) not null COMMENT '表单ID' auto_increment,
	writer_phone_number varchar(18) not null COMMENT '填写人手机号',
	form_type varchar(12) default null COMMENT '表单类型',
	writer_type tinyint default 0 comment '申报类别，0组织，1个人',
  name varchar(10) DEFAULT NULL COMMENT '作者姓名',
  person_id varchar(18) DEFAULT NULL COMMENT '身份证号码',
	sex  tinyint DEFAULT null COMMENT '性别,1男,0 女',
  phone varchar(11) DEFAULT NULL COMMENT '手机号码',
  email varchar(20) DEFAULT NULL COMMENT '邮箱',
-- 	组织
	rec_org varchar(12) default null COMMENT '推荐组织',
-- 	个人
	work_palce text default null COMMENT '工作单位',
-- 	共同
	work_type varchar(12) default null COMMENT '单位/组织类型',
	province varchar(8) default null COMMENT '联系省份',
	city varchar(8) default null COMMENT '联系城市',
	area varchar(8) default null COMMENT '联系区',

	asso_detail_place text default null COMMENT '详细地址',
	sec_phone varchar(11) default null COMMENT '紧急联系人/组织联系电话',
  deleted tinyint default 1 COMMENT '是否删除(1未删除；0已删除)',
-- 	仅榜样
-- 	img longblob default null COMMENT '头像',
	star_name varchar(20) default null comment '榜样名称',
	commit_state tinyint default 0 comment '0未提交，1已提交',
	identity_type varchar(15) default null comment '证件类型',
  PRIMARY KEY (id)
);
-- -- 添加字段 提交
-- alter table author add commit_state tinyint default 0 comment '0未提交，1已提交';
-- -- 添加字段 证件类型
-- alter table author add identity_type varchar(15) default null comment '证件类型';

-- 连接
select * from author a join author_img ai on a.id = ai.form_id
where a.form_type='榜样';

DROP TABLE IF EXISTS author_img;
CREATE TABLE author_img (
-- 	id int(14) not null COMMENT '图片ID' auto_increment,
	form_id int(14) not null COMMENT '表单ID',
	img_path varchar(200) default null COMMENT '头像',
  PRIMARY KEY (form_id)
);