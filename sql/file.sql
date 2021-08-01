DROP TABLE IF EXISTS file_path;
CREATE TABLE file_path (
  form_id int(14) not null COMMENT '表单号',
	phone_number varchar(11) not null comment '用户手机号',
  path varchar(200) DEFAULT NULL COMMENT '路径',
  deleted tinyint not null default 1 COMMENT '是否删除(1未删除；0已删除)',
	foreign key (phone_number) references author(writer_phone_number),
  PRIMARY KEY (form_id)
);

-- alter table file_path add phone_number varchar(11) not null comment '用户手机号';