DROP TABLE IF EXISTS pizza_orders;
DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  id SERIAL4 PRIMARY KEY
);

CREATE TABLE pizza_orders (
  id SERIAL4 PRIMARY KEY,
  quantity INT2,
  topping VARCHAR(255),
  customer_id INT4 REFERENCES customers(id)
);
