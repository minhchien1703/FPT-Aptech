create database shopping_cart;

use shopping_cart;

create table product (
    id int NOT NULL auto_increment,
    name nvarchar(100),
    price decimal(10,2),
    description nvarchar(50),
    createdAt datetime default current_timestamp,
    primary key (id)
);

create table user (
    id int NOT NULL auto_increment,
    name nvarchar(100),
    createAt datetime default  current_timestamp,
    primary key (id)
);

ALTER TABLE user ADD COLUMN password nvarchar(255);

create table cart (
    id int not null auto_increment,
    user_id int not null ,
    createAt DATETIME default current_timestamp,
    primary key (id),
    constraint fk_cart_user foreign key (user_id) references user(id) on delete cascade
);

create table cart_item (
    id int not null auto_increment,
    cart_id int not null ,
    product_id int not null ,
    quantity int not null default 1,

    primary key (id),
    constraint fk_cartItem_cart foreign key (cart_id) references cart(id) on delete cascade,
    constraint fk_cartProduct foreign key  (product_id) references product(id) on delete cascade
);

