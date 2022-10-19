create table persons(
	id serial primary key,
	name varchar(255),
	nickname text,
	age int
);
insert into persons(name, nickname, age) values('Val', 'Voltron', 39);
update persons set name = 'Valeri';
select * from persons;
delete from persons;