create table teens (
	id serial primary key,
	name varchar(256),
	gender varchar(256)
);
insert into teens(name, gender) values ('Dee', 'Female');
insert into teens(name, gender) values ('Mija', 'Female');
insert into teens(name, gender) values ('Cindy', 'Female');
insert into teens(name, gender) values ('Melissa', 'Female');
insert into teens(name, gender) values ('Kim', 'Female');
insert into teens(name, gender) values ('Lucy', 'Female');
insert into teens(name, gender) values ('Sam', 'Female');
insert into teens(name, gender) values ('Feel', 'Male');
insert into teens(name, gender) values ('Stan', 'Male');
insert into teens(name, gender) values ('John', 'Male');
insert into teens(name, gender) values ('Peter', 'Male');
insert into teens(name, gender) values ('Rob', 'Male');
insert into teens(name, gender) values ('Pete', 'Male');
insert into teens(name, gender) values ('Bill', 'Male');

select t1.name, t2.name from teens as t1 cross join teens as t2
where t1.gender != t2.gender;