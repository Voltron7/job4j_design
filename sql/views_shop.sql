create table buyers (
    id serial primary key,
    name varchar(50)
);
insert into buyers (name) values ('Nick');
insert into buyers (name) values ('Mike');

create table producers (
    id serial primary key,
    name varchar(50)
);
insert into producers (name) values ('Asics');
insert into producers (name) values ('Mizuno');

create table sneakers (
    id serial primary key,
    name varchar(200),
    producer_id integer references producers(id)
);
insert into sneakers (name, producer_id) values ('Nimbus', 1);
insert into sneakers (name, producer_id) values ('Kayano', 1);
insert into sneakers (name, producer_id) values ('Ziruss', 1);
insert into sneakers (name, producer_id) values ('Wave_rider_3', 2);
insert into sneakers (name, producer_id) values ('Wave_rider_7', 2);

create table orders (
    id serial primary key,
    active boolean default true,
    sneaker_id integer references sneakers(id),
    buyer_id integer references buyers(id)
);

insert into orders (sneaker_id, buyer_id) values (1, 1);
insert into orders (sneaker_id, buyer_id) values (3, 1);
insert into orders (sneaker_id, buyer_id) values (5, 2);
insert into orders (sneaker_id, buyer_id) values (4, 1);
insert into orders (sneaker_id, buyer_id) values (2, 2);

select b.name, count(p.name), p.name from buyers as b
    join orders o on b.id = o.buyer_id
    join sneakers s on o.sneaker_id = s.id
    join producers p on s.producer_id = p.id
    group by (b.name, p.name) having count(p.name) >= 2;

create view show_buyers_with_2_or_more_sneakers
    as select b.name as buyer, count(p.name), p.name as producer from buyers as b
    	join orders o on b.id = o.buyer_id
    	join sneakers s on o.sneaker_id = s.id
    	join producers p on s.producer_id = p.id
    	group by (b.name, p.name) having count(p.name) >= 2;

select * from show_buyers_with_2_or_more_sneakers;