CREATE TABLE products (
    product_id int AUTO_INCREMENT,
    name varchar(50),
    category varchar(50),
    price decimal,
    PRIMARY KEY (product_id)
);
//int AUTO_INCREMENT
// product_id SERIAL,

CREATE TABLE users (
    user_id int AUTO_INCREMENT,
    name varchar(50),
    address varchar(200),
    email varchar(100),
    gender varchar(20),
    dateOfBirth date,
    PRIMARY KEY (user_id)
);

CREATE TABLE orders (
    user_id  int,
    product_id int,
    count int,
    status varchar(50),
    date date,
    FOREIGN KEY (user_id) references users (user_id)
    FOREIGN KEY (product_id) references products (product_id)
);

