drop table if exists restaurants;
create table if not exists restaurants
(
    id          bigint auto_increment primary key,
    name        varchar(20) not null,
    phoneNumber varchar(15) not null,
    email       varchar(30) not null,
    description varchar(255)
);

insert into restaurants (name, phoneNumber, email, description)
values ('Astoria', '+78888888888', 'astoria@astoria.com', 'Test description 1'),
       ('Praga', '+79999999999', 'praga@praga.com', 'Test description 2'),
       ('KFC', '+77777777777', 'kfc@kfc.com', 'Test description 3'),
       ('Donald Duck', '+71111111111', 'dduck@donaldduck.com', 'Test description 4');