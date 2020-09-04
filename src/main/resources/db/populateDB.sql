insert into USERS(name, email,password,LASTTIMEVOTE) values ('Вася','abc@abc.com','{noop}user','1800-01-01 00:00:00');
insert into USERS(name, email,password,LASTTIMEVOTE) values ('Петя','abc1@abc.com','{noop}admin','1800-01-01 00:00:00');

insert into USER_ROLES(role, USER_ID) values ('USER', 100000), ('ADMIN', 100001), ('USER', 100001);

insert into restaurants (name) VALUES ('Кафе');
insert into restaurants (name) VALUES ('Кафе1');
insert into restaurants (name) VALUES ('Кафе2');

insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки1', 100, 100002,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки2', 101, 100002,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки3', 102, 100003,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки4', 103, 100003,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки5', 104, 100004,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки6', 105, 100004,current_date);

insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-08-22', 100000,100002);
insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-08-22', 100001,100002);
insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-09-22', 100000,100004);
insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-09-22', 100001,100004);

