create table trainer(
	id serial primary key,
	name varchar(255)
);

create table footballer(
	id serial primary key,
	name varchar(255)	
);

create table training_course(
	id serial primary key,
	trainer_id int references trainer(id),
	footballer_id int references footballer(id)
);

insert into trainer(name) values('Alex');
insert into trainer(name) values('Jose');
insert into footballer(name) values('Ronaldo');
insert into footballer(name) values('Ronaldinho');

insert into training_course(trainer_id, footballer_id) values(1,1);
insert into training_course(trainer_id, footballer_id) values(1,2);
insert into training_course(trainer_id, footballer_id) values(2,1);
insert into training_course(trainer_id, footballer_id) values(2,2);

select * from training_course;