CREATE TABLE if not exists category
(
    id integer not null primary key,
    description varchar(255),
    name varchar(255)
);

CREATE TABLE if not exists product
(
    id integer not null primary key,
        description varchar(255),
        name varchar(255),
        available_quantity double precision not null,
        price numeric (38, 2),
        category_id integer
            constraint fk1 references category
);

CREATE SEQUENCE if not exists category_seq increment by 50;
CREATE SEQUENCE if not exists product_seq increment by 50;