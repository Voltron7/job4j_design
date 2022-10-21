create table club(
	id serial primary key,
	name varchar(255),
	rank int
);

create table player(
	id serial primary key,
	name varchar(255),
	number int,
	position text,
	club_id int references club(id)
);

insert into club(name, rank) values('Inter', 7);
insert into club(name, rank) values('Barca', 8);
insert into club(name, rank) values('Real', 9);

insert into player(name, number, position, club_id)
values('Julio', 1, 'GK', 1);
insert into player(name, number, position, club_id)
values('Javier', 4, 'DEF', 1);
insert into player(name, number, position, club_id)
values('Esteban', 5, 'MF', 1);
insert into player(name, number, position, club_id)
values('Diego', 9, 'FW', 1);
insert into player(name, number, position, club_id)
values('Ter', 1, 'GK', 2);
insert into player(name, number, position, club_id)
values('Dani', 2, 'DEF', 2);
insert into player(name, number, position, club_id)
values('Xavi', 6, 'MF', 2);
insert into player(name, number, position, club_id)
values('Samuel', 9, 'FW', 2);
insert into player(name, number, position, club_id)
values('Iker', 1, 'GK', 3);
insert into player(name, number, position, club_id)
values('Roberto', 3, 'DEF', 3);
insert into player(name, number, position, club_id)
values('Zinedine', 5, 'MF', 3);
insert into player(name, number, position, club_id)
values('Raul', 7, 'FW', 3);

select * from club inner
join player on player.club_id = club.id;

select p.name as Name_of_Player, c.name as Name_of_Club
from player as p join club as c on p.club_id = c.id;

select p.name as "Имя игрока", p.number as "Номер игрока",
p.position as "Позиция игрока", c.name Имя_клуба
from player p join club c on p.club_id = c.id;

