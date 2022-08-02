create table if not exists restaurants
(
    id          bigint auto_increment primary key,
    name        varchar(20) not null,
    phoneNumber varchar(15) not null,
    email       varchar(30) not null,
    description varchar(255),
    creationDate date
);

insert into restaurants (name, phoneNumber, email, description, creationDate)
values ('Astoria', '+79998888888', 'astoria@astoria.com', 'Test description 1', '2015-04-17'),
       ('Praga', '+79999999999', 'praga@praga.com', 'Test description 2', '2010-03-15'),
       ('KFC', '+79997777777', 'kfc@kfc.com', 'Test description 3', '2012-02-02'),
       ('Donald Duck', '+79991111111', 'dduck@donaldduck.com', 'Test description 4', '2005-05-27');