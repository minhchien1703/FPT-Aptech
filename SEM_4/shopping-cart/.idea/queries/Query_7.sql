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

CREATE TABLE applicant (
    id int not null auto_increment,
    name nvarchar(100),
    status int,

    primary key (id)
);

create table winner (
    ticketId int,
    drawDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (ticketId) REFERENCES applicant(id)
);

# CREATE PROCEDURE
DELIMITER $$
CREATE PROCEDURE insert_applicants()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i <= 1200 DO
            INSERT INTO applicant (name, status)
            VALUES (CONCAT('Applicant Name ', i), FLOOR(RAND() * 3)); -- status ngẫu nhiên từ 0-2
            SET i = i + 1;
        END WHILE;
END$$
DELIMITER ;

CALL insert_applicants();
DROP PROCEDURE insert_applicants;


