use bookcity;
drop table if exists t_order;
create table t_order(
    `orderId` varchar(50) primary key,
    `createTime` datetime,
    `price` decimal(11,2),
    `status` int,
    `userId` int,
    foreign key(`userId`) references t_user(`id`)
);
drop table if exists t_order_item;
create table t_order_item(
    `id` int primary key auto_increment,
    `name` varchar(100),
    `count` int,
    `price` decimal(11,2),
    `totalPrice` decimal(11,2),
    `orderId` varchar(50),
    foreign key(`orderId`) references t_order(`orderId`)
);