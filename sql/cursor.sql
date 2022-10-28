BEGIN;
DECLARE
    cursor_products_backward cursor for
                        select * from products;
MOVE 20 FROM cursor_products_backward;
FETCH BACKWARD FROM cursor_products_backward;
 id |    name    | count | price
----+------------+-------+-------
 19 | product_19 |    19 |    95
FETCH backward 10 FROM cursor_products_backward;
id |    name    | count | price
----+------------+-------+-------
 18 | product_18 |    18 |    90
 17 | product_17 |    17 |    85
 16 | product_16 |    16 |    80
 15 | product_15 |    15 |    75
 14 | product_14 |    14 |    70
 13 | product_13 |    13 |    65
 12 | product_12 |    12 |    60
 11 | product_11 |    11 |    55
 10 | product_10 |    10 |    50
  9 | product_9  |     9 |    45
FETCH backward 9 FROM cursor_products_backward;
 id |   name    | count | price
----+-----------+-------+-------
  8 | product_8 |     8 |    40
  7 | product_7 |     7 |    35
  6 | product_6 |     6 |    30
  5 | product_5 |     5 |    25
  4 | product_4 |     4 |    20
  3 | product_3 |     3 |    15
  2 | product_2 |     2 |    10
  1 | product_1 |     1 |     5
CLOSE cursor_products_backward;
COMMIT;

