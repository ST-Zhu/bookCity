use bookcity;
drop table if exists t_user;
create table t_user(
	`id` int primary key auto_increment,
	`username` varchar(20) not null unique,
	`password` varchar(32) not null,
	`email` varchar(200)
);
insert into t_user(`username`,`password`,`email`) values('admin','admin','admin@123.com');
select * from t_user;