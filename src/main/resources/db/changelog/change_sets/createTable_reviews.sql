drop table if exists reviews;
create table if not exists reviews
(
    id            bigint auto_increment primary key,
    restaurant_id bigint not null references restaurants (id),
    review        varchar(255),
    rating        int    not null check (rating <= 5 and rating > 0)
);

insert into reviews (restaurant_id, review, rating)
values (1, 'Good restaurant', 3),
       (1, 'Good restaurant', 3),
       (4, 'Test review', 1);