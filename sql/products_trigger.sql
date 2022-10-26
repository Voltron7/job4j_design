create table products (
    id serial primary key,
    name varchar(50),
    producer varchar(50),
    count integer default 0,
    price integer
);

create or replace function tax_after()
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.2
	where id = (select id from inserted);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_row_after
    after insert on products
    referencing new table as inserted
    for each statement
    execute procedure tax_after();
	
insert into products (name, producer, count, price) VALUES ('product_5', 'producer_7', 10, 223);
insert into products (name, producer, count, price) VALUES ('product_6', 'producer_8', 5, 576);

create or replace function tax_before()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price * 1.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_row_before
    before insert on products
    for each row
    execute procedure tax_before();

insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 115);
insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 3, 50);


create table history_of_price (
    id serial primary key,
    name varchar(50),
    price integer,
    date timestamp
);

create or replace function history_trigger()
    returns trigger as
$$
    BEGIN
      insert into history_of_price(name, price, date)
      values(NEW.name, NEW.price, current_date);
      return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger update
   after insert on products
   for each row
   execute procedure history_trigger();

insert into products (name, producer, count, price) VALUES ('product_7', 'producer_7', 7, 777);