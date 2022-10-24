create table departments(
	id serial primary key,
	name varchar(255)
);
create table employees(
	id serial primary key,
	name varchar(255),
	departments_id int references departments(id)
);
insert into departments(name) values('Accounting');
insert into departments(name) values('Sales');
insert into departments(name) values('Relations');
insert into departments(name) values('Financial');

insert into employees(name, departments_id) values('Samantha', 1);
insert into employees(name, departments_id) values('John', 2);
insert into employees(name, departments_id) values('Bob', 3);
insert into employees(name, departments_id) values('Carrie', 1);
insert into employees(name) values('Bill');
insert into employees(name) values(2);

select * from departments as d
left join employees as e on e.departments_id = d.id;

select * from departments as d
right join employees as e on e.departments_id = d.id;

select * from departments as d
full join employees as e on e.departments_id = d.id;

select * from departments as d cross join employees as e;

select d.name as "Department's_name"
from departments as d
left join employees as e on e.departments_id = d.id
where e.name is null;

select d.name, e.name from departments as d 
left join employees as e on e.departments_id = d.id;

select d.name, e.name from employees as e 
right join departments as d on e.departments_id = d.id;

