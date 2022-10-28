begin transaction;
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_6', 77, 777);
savepoint first_savepoint;
delete from products where price = 45;
savepoint second_savepoint;
insert into products (name, producer, count, price) VALUES ('product_7', 'producer_7', 33, 333);
select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
  4 | product_4 | producer_4 |    11 |    64
  7 | product_6 | producer_6 |    77 |   777
  8 | product_7 | producer_7 |    33 |   333
rollback to second_savepoint;
select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
  4 | product_4 | producer_4 |    11 |    64
  6 | product_6 | producer_6 |    77 |   777
rollback to first_savepoint;
select * from products;
 id |   name    |  producer  | count | price
----+-----------+------------+-------+-------
  1 | product_1 | producer_1 |     3 |    50
  2 | product_2 | producer_2 |    15 |    32
  3 | product_3 | producer_3 |     8 |   115
  4 | product_4 | producer_4 |    11 |    64
  5 | product_5 | producer_5 |    17 |    45
  6 | product_6 | producer_6 |    77 |   777
commit;
