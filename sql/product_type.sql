create table type(
	id serial primary key,
	name varchar (255)
);
create table product(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);
insert into type(name) values ('fish'); 
insert into type(name) values ('meat');
insert into type(name) values ('chicken');
insert into type(name) values ('cheese');
insert into type(name) values ('bakery'); 
insert into type(name) values ('grocery');
insert into type(name) values ('dairy');
insert into type(name) values ('milk');
insert into product(name, type_id, expired_date, price) values ('salmon', 1, '2022-12-24', 99.99);
insert into product(name, type_id, expired_date, price) values ('beef', 2, '2022-12-25', 111.99);
insert into product(name, type_id, expired_date, price) values ('fillet', 3, '2022-10-31', 49.99);
insert into product(name, type_id, expired_date, price) values ('swiss_cheese', 4, '2022-10-23', 114.99);
insert into product(name, type_id, expired_date, price) values ('mozarella_cheese', 4, '2022-12-30', 119.99);
insert into product(name, type_id, expired_date, price) values ('parmesan_cheese', 4, '2022-09-28', 149.99);
insert into product(name, type_id, expired_date, price) values ('ricotta_cheese', 4, '2022-12-28', 199.99);
insert into product(name, type_id, expired_date, price) values ('bread', 5, '2022-10-31', 49.99);
insert into product(name, type_id, expired_date, price) values ('tea', 6, '2023-10-24', 69.99);
insert into product(name, type_id, expired_date, price) values ('soap', 6, '2024-10-24', 9.99);
insert into product(name, type_id, expired_date, price) values ('vanilla_icecream', 7, '2022-10-30', 19.99); 
insert into product(name, type_id, expired_date, price) values ('cow_milk', 8, '2022-10-22', 4.99);

select t.name, p.name from product as p
inner join type as t on p.type_id = t.id
where t.name = 'cheese';

select * from product where name like  '%icecream%';

select * from product where expired_date < current_date;

select name, price from product as p
where price = (select max(price) from product);

select t.name as "Product''s_type",
count(p.name) as "Amount" from product as p
inner join type as t on p.type_id = t.id
group by t.name;

select p.name as "Product''s name",
t.name as "Product''s_type" from product as p
inner join type as t on p.type_id = t.id
where t.name = 'cheese' or t.name ='milk';

select t.name as "Product''s_type",
count(t.name) as "Amount" from product as p
inner join type as t on p.type_id = t.id
group by t.name
having count(t.name) < 10;

select p.name as "Product''s_name", t.name as "Product''s_type"
from product p, type t
where p.type_id = t.id;


