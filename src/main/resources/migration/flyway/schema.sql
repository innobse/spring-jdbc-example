create table my_table
(
    id serial
        constraint my_table_pk
            primary key,
    name varchar(16),
    model varchar(16)
);