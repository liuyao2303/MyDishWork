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

