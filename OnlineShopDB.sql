create database online_shop;
use online_shop;

CREATE TABLE categories 
	(category_id INT(6) NOT NULL
    , category_name VARCHAR(30) NOT NULL
    , main_category_id INT(6)
    , PRIMARY KEY (category_id)
    , FOREIGN KEY (main_category_id)
		REFERENCES categories(category_id));

CREATE TABLE products 
	(product_id INT(6) NOT NULL
	, category_id INT(6)
    , product_name VARCHAR(30) NOT NULL
    , price FLOAT(8,2) NOT NULL
    , PRIMARY KEY (product_id)
    , FOREIGN KEY (category_id)
		REFERENCES categories(category_id));

CREATE TABLE customers 
	(customer_id INT(6) NOT NULL
	, customer_name VARCHAR(30) NOT NULL
    , address VARCHAR(30) NOT NULL
    , phone_number INT(11)
    , PRIMARY KEY (customer_id));
    
CREATE TABLE orders 
	(order_id INT(6) NOT NULL 
    , customer_id INT(6) NOT NULL 
    , product_id INT(6) NOT NULL
    , quantity INT(6)
    , PRIMARY KEY (order_id)
    , FOREIGN KEY (customer_id)
		REFERENCES customers(customer_id)
	, FOREIGN KEY (product_id)
		REFERENCES products(product_id));


