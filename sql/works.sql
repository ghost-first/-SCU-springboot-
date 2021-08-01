DROP TABLE IF EXISTS works;
CREATE TABLE works (
	id int(14) not null COMMENT '作品表ID',
	phone_number varchar(11) not null comment '用户手机号',
	type varchar(12) default null comment '推荐类别',
	title varchar(15) default '' comment '作品标题',
	link varchar(100) default null comment '作品链接',
	platform varchar(25) default null comment '首发平台',
	author_introduce text  default null comment '作者简介',
	work_introduce text  default null comment '作品简介',
	social_result text  default null comment '社会效果',
	work_view text  default null comment '单位意见',
  PRIMARY KEY (id),
	foreign key (phone_number) references author(writer_phone_number)
);

-- alter table works add phone_number varchar(11) not null comment '用户手机号';