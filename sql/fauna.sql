create database fauna;

create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('piranha', 77777, '1907-01-01');
insert into fauna(name, avg_age, discovery_date) values ('clownfish', 996, '1983-01-01');
insert into fauna(name, avg_age, discovery_date) values ('discusfish', 729, '1946-01-01');
insert into fauna(name, avg_age, discovery_date) values ('swordfish', 364, '1917-01-01');
insert into fauna(name, avg_age, discovery_date) values ('lion', 33000, '1933-01-01');
insert into fauna(name, avg_age, discovery_date) values ('turtle', 11000, '1911-01-01');
insert into fauna(name, avg_age, discovery_date) values ('puma', 20000, '1922-01-01');
insert into fauna(name, avg_age, discovery_date) values ('tiger', 44000, '1944-01-01');
insert into fauna(name, avg_age, discovery_date) values ('jackal', 55000, null);

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';

