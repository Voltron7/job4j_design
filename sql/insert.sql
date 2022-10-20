insert into role(name) values ('junior');
insert into role(name) values ('middle');
insert into role(name) values ('senior');

insert into users(name, role_id) values ('Alex', 1);
insert into users(name, role_id) values ('Bob', 2);
insert into users(name, role_id) values ('Max', 3);

insert into rules(name) values ('learn');
insert into rules(name) values ('code');
insert into rules(name) values ('manage');
insert into rules(name) values ('mentoring');

insert into role_rules(role_id, rules_id) values (1, 1);
insert into role_rules(role_id, rules_id) values (1, 2);
insert into role_rules(role_id, rules_id) values (2, 2);
insert into role_rules(role_id, rules_id) values (2, 4);
insert into role_rules(role_id, rules_id) values (3, 2);
insert into role_rules(role_id, rules_id) values (3, 3);
insert into role_rules(role_id, rules_id) values (3, 4);

insert into category(name) values ('web application');
insert into category(name) values ('site');
insert into category(name) values ('desktop application');

insert into state(name) values ('under construction');
insert into state(name) values ('released');

insert into item(name, users_id, category_id, state_id) values ('project', 1, 2, 1);
insert into item(name, users_id, category_id, state_id) values ('project 2', 2, 3, 2);
insert into item(name, users_id, category_id, state_id) values ('project 3', 3, 1, 2);

insert into comments(name, item_id) values ('minimum priority', 3);
insert into comments(name, item_id) values ('medium priority', 1);
insert into comments(name, item_id) values ('maximum priority', 2);

insert into attachs(name, item_id) values('File1', 1);
insert into attachs(name, item_id) values('File2', 2);
insert into attachs(name, item_id) values('File3', 3);