-- auto-generated definition
create table user_info
(
	user_id int(32) not null auto_increment
		primary key,
	user_name varchar(45) not null,
	sex varchar(2) null,
	phone_number varchar(11) not null,
	addr varchar(128) not null,
	age int(8) null,
	status varchar(2) not null,
	constraint user_id_UNIQUE
		unique (user_id)
)
;



create table catagory_info (
  id bigint not null auto_increment,
  createTime datetime(6),
  order bigint,
  status varchar(2),
  title varchar(64),
  primary key (id)
) ENGINE=InnoDB