insert into USERS(name, email,password) values ('Вася','abc@abc.com','1234');
insert into USERS(name, email,password) values ('Петя','abc1@abc.com','1234');

insert into restaurants (name) VALUES ('Кафе');
insert into restaurants (name) VALUES ('Кафе1');
insert into restaurants (name) VALUES ('Кафе2');

insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки1', 100, 200000,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки2', 101, 200000,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки3', 102, 200001,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки4', 103, 200001,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки5', 104, 200002,current_date);
insert into DISHES (DESCRIPTION, PRICE, restaurant_id,DATE) values ('Помидорки6', 105, 200002,current_date);

insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-08-22', 100000,200000);
insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-08-22', 100001,200000);
insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-09-22', 100000,200002);
insert into VOTES (DATE, USER_ID, RESTAURANT_ID) VALUES ('2020-09-22', 100001,200002);

