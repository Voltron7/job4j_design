create table license(
	id serial primary key,
	seria int,
	number int
);

create table driver(
	id serial primary key,
	name varchar(255),
	license_id int references license(id) unique
);

insert into license(seria, number) values(77, 77777);
insert into driver(name, license_id) values('Val', 1);

select l.seria
from driver d, license l
where d.license_id=l.id


