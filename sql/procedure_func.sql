create or replace procedure delete_data(d_id integer)
language 'plpgsql'
as 
$$
   BEGIN
      if d_id > 10 THEN
          delete from products where price > 10000;
      end if;
   END;
$$;

call delete_data(777);

create or replace function f_delete_data(d_count integer, d_price integer)
returns void
language 'plpgsql'
as
$$
    begin
        if d_count > 333 THEN
             delete from products where count = 7;
        end if;
		if d_price > 1000 THEN
             delete from products where id = 6;
        end if;
		return result;
    end;
$$;

select f_delete_data(334, 1001);