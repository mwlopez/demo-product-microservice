CREATE KEYSPACE ecommerce WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
USE ecommerce;
CREATE TABLE product (
  id text PRIMARY KEY,
  sku text,
  productname text,
  imagepath text
);
CREATE TABLE category(
  id text PRIMARY KEY,
  name text,
  description text,
  image text,
  type text
);

INSERT INTO product (id, sku, productname, imagepath)
  VALUES ('abcd1234','12345', 'TV','');

INSERT INTO product (id, sku, productname, imagepath)
  VALUES ('efgh1234','23456', 'Phone','');