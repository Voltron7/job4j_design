create table car_bodies (
    id serial primary key,
    name varchar(255)
);
create table car_engines (
    id serial primary key,
    name varchar(255)
);
create table car_transmissions (
    id serial primary key,
    name varchar(255)
);
create table cars (
    id serial primary key,
    name varchar(255),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);
insert into car_bodies (name) values ('SUV');
insert into car_bodies (name) values ('sedan');
insert into car_bodies (name) values ('hatchback');
insert into car_bodies (name) values ('pickup');

insert into car_engines (name) values ('gas_engine');
insert into car_engines (name) values ('electro_engine');
insert into car_engines (name) values ('hybrid_engine');
insert into car_engines (name) values ('diesel_engine');
insert into car_engines (name) values (null);

insert into car_transmissions (name) values ('Manual');
insert into car_transmissions (name) values ('Automatic');
insert into car_transmissions (name) values ('Robot');
insert into car_transmissions (name) values (null);
insert into car_transmissions (name) values ('DSG');

insert into cars (name, body_id, engine_id, transmission_id) values ('BMW', 1, 1, 1);
insert into cars (name, body_id, engine_id, transmission_id) values ('Tesla', 2, 2, 2);
insert into cars (name, body_id, engine_id, transmission_id) values ('Audi', 3, 3, 3);
insert into cars (name, engine_id, transmission_id) values ('Honda', 1, 1);
insert into cars (name, body_id, transmission_id) values ('Toyota', 2, 2);
insert into cars (name, body_id, engine_id) values('Ford', 2, 1);

select c.name as car_name, b.name as body_name, e.name as engine_name, 
t.name as transmission_name from cars as c
left join car_bodies as b on c.body_id = b.id
left join car_engines as e on c.engine_id = e.id
left join car_transmissions as t on c.transmission_id = t.id;

select b.name as body_is_null from car_bodies as b
left join cars as c on c.body_id = b.id
where c.body_id is null;

select e.name as engine_is_null from car_engines as e
left join cars as c on c.engine_id = e.id
where c.engine_id is null;

select t.name as transmission_is_null from car_transmissions as t
left join cars as c on c.transmission_id = t.id
where c.transmission_id is null;

