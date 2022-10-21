create table devices(
    id serial primary key,
    name varchar(255),
    price float
);
create table people(
    id serial primary key,
    name varchar(255)
);
create table devices_people(
    id serial primary key,
    devices_id int references devices(id),
    people_id int references people(id)
);
insert into devices(name, price) values('Honor', 77777.99);
insert into devices(name, price) values('Huawei', 99999.99);
insert into devices(name, price) values('Xiaomi', 9999.99);
insert into people(name) values('Val');
insert into people(name) values('Stas');
insert into people(name) values('Boris');
insert into devices_people(devices_id, people_id) values(1, 1);
insert into devices_people(devices_id, people_id) values(3, 2);
insert into devices_people(devices_id, people_id) values(2, 2);
insert into devices_people(devices_id, people_id) values(3, 3);
insert into devices_people(devices_id, people_id) values(2, 3);
insert into devices_people(devices_id, people_id) values(1, 3);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as dp  
inner join devices as d on dp.devices_id = d.id
inner join people as p on dp.people_id = p.id
group by p.name;

select p.name, avg(d.price) from devices_people as dp  
inner join devices as d on dp.devices_id = d.id
inner join people as p on dp.people_id = p.id
group by p.name
having avg(d.price) > 5000;