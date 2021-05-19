create table products
(
    id         bigserial primary key,
    title      varchar(255),
    price      numeric(10, 2),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

insert into products (title, price)
values
('Banana', 50),
('Bread', 40),
('Meat', 500);
