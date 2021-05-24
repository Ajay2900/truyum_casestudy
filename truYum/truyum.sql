drop database if exists truyum;
create database if not exists truyum;
use truyum;

create table menu_items (
	item_id int primary key,
    item_name varchar(50),
    price decimal(5,2),
    active enum("Yes", "No"),
    date_of_launch date,
    category varchar(30),
    free_delivery enum("Yes", "No")
);
create table users (
	user_id int primary key,
    user_name varchar(60),
    address varchar(60)
);
create table cart (
	cart_id int primary key auto_increment,
    item_id int,
    user_id int,
    foreign key (user_id) references users(user_id),
    foreign key (item_id) references menu_items(item_id)
);

insert into menu_items values (1, 'Sandwich', 99.00,'Yes','2017-03-15','Main Course','Yes');
insert into menu_items values (2, 'Cake', 129.00, 'Yes','2017-12-23','Main Course','No');
insert into menu_items values  (3, 'Pizaa', 149.00, 'Yes','2017-08-21','Main Course','No');
insert into menu_items values  (4, 'French Fries', 57.00, 'No','2017-07-02','Starters','Yes');
insert into menu_items values  (5, 'Chocolate Brownie', 32.00, 'Yes','2017-11-02','Dessert','Yes');

select * from menu_items;

select * from menu_items where date_of_launch >= '2017-01-23' and active = 'Yes';

select item_name from menu_items where item_id = 5;

update menu_items set price = 150 where item_id = 2;

insert into users values (1, 'Rupesh1', 'ABC');
insert into users values (2, 'Rupesh2', 'ABC');

insert into cart values (1, 2, 1), (2, 3, 1), (3, 5, 1);

select a.item_name from menu_items as a join cart as b on a.item_id = b.item_id where b.user_id = 1;

select sum(a.price) from menu_items as a join cart as b on a.item_id = b.item_id where b.user_id = 1;

delete from cart where user_id = 1 and item_id = 3;
select* from cart;
