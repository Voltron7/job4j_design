CREATE TABLE company (
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);
CREATE TABLE person (
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);
INSERT INTO company (id, name) VALUES (1, 'Apple');
INSERT INTO company (id, name) VALUES (2, 'Samsung');
INSERT INTO company (id, name) VALUES (3, 'Huawei');
INSERT INTO company (id, name) VALUES (4, 'Xiaomi');
INSERT INTO company (id, name) VALUES (5, 'Vivo');
INSERT INTO person (id, name, company_id) VALUES (1, 'Alex', 1);
INSERT INTO person (id, name, company_id) VALUES (2, 'Bob', 2);
INSERT INTO person (id, name, company_id) VALUES (3, 'Chris', 3);
INSERT INTO person (id, name, company_id) VALUES (4, 'Dennis', 4);
INSERT INTO person (id, name, company_id) VALUES (5, 'Elon', 5);
INSERT INTO person (id, name, company_id) VALUES (6, 'Frank', 1);
INSERT INTO person (id, name, company_id) VALUES (7, 'Glen', 2);
INSERT INTO person (id, name, company_id) VALUES (8, 'Harry', 3);
INSERT INTO person (id, name, company_id) VALUES (9, 'Ian', 4);
INSERT INTO person (id, name, company_id) VALUES (10, 'Jack', 5);
INSERT INTO person (id, name, company_id) VALUES (11, 'Kevin', 1);
INSERT INTO person (id, name, company_id) VALUES (12, 'Lucas', 2);
INSERT INTO person (id, name, company_id) VALUES (13, 'Mandy', 3);
INSERT INTO person (id, name, company_id) VALUES (14, 'Nick', 4);
INSERT INTO person (id, name, company_id) VALUES (15, 'Oscar', 5);
INSERT INTO person (id, name, company_id) VALUES (16, 'Patrick', 1);
INSERT INTO person (id, name, company_id) VALUES (17, 'Rick', 3);

SELECT p.name person, c.name company 
FROM person as p
JOIN company as c
ON p.company_id = c.id
WHERE c.id != 5

SELECT c.name company, count(p.company_id) persons
FROM person as p
JOIN company as c
ON p.company_id = c.id
GROUP BY c.name
HAVING count(p.company_id) = (
    SELECT count(company_id)
    FROM person
    GROUP BY company_id
    ORDER BY count(company_id) desc
    LIMIT 1
);