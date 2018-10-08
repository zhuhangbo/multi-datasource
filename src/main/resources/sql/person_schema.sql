/*
 * 创建person数据库
 */	
create database person;
use person;
create table if not exists user(
	id int auto_increment not null  COMMENT '编号',
	first_name 	varchar(50) not null COMMENT '名',
	last_name 	varchar(50) not null COMMENT '姓',
	primary key(id)
) engine=InnoDB default character set utf8 COMMENT '用户信息';

insert into user(id, first_name, last_name)
	values(1, 'Tom', 'Green');
