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

create table cart (
	user_id int,
    item_id int,
    foreign key (item_id) references menu_items(item_id)
);

insert into menu_items values (1, 'Sandwich', 99.00,'Yes','2017-03-15','Main Course','Yes');
insert into menu_items values (2, 'Cake', 129.00, 'Yes','2017-12-23','Main Course','No');
insert into menu_items values  (3, 'Pizaa', 149.00, 'Yes','2017-08-21','Main Course','No');
insert into menu_items values  (4, 'French Fries', 57.00, 'No','2017-07-02','Starters','Yes');
insert into menu_items values  (5, 'Chocolate Brownie', 32.00, 'Yes','2017-11-02','Dessert','Yes');

select * from menu_items;

select item_name from menu_items where item_id = 5;

update menu_items set price = 150 where item_id = 2;
select * from cart;

