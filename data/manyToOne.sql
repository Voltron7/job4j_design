create table club(
	id serial primary key,
	name varchar(255)
);

create table footballer(
	id serial primary key,
	name varchar(255),
	id_club int references club(id)
);

insert into club(name) values('Dynamo');
insert into footballer(name, id_club) values('Leo', 1);
insert into footballer(name, id_club) values('Ibra', 1);

select * from footballer;