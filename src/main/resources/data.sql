insert into customer(id, name) values (1000, 'Tom');
insert into customer(id, name) values (1001, 'Josa');
insert into customer(id, name) values (1002, 'Nancy');

insert into my_transaction(id, description, total, save_date, customer_id) values (1001, 'Purchase 1', 100, '2022-10-17 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1002, 'Purchase 2', 50, '2022-10-01 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1003, 'Purchase 3', 120, '2022-10-10 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1004, 'Purchase 10', 175.32, '2022-10-07 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1005, 'Purchase 20', 65.75, '2022-10-05 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1006, 'Purchase 30', 210.50, '2022-10-03 10:20:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1009, 'Purchase 31', 42.80, '2022-10-18 17:10:10', 1000);
insert into my_transaction(id, description, total, save_date, customer_id) values (1200, 'Purchase 200', 25.60, '2022-10-01 12:20:10', 1002);
insert into my_transaction(id, description, total, save_date, customer_id) values (1201, 'Purchase 201', 80.50, '2022-10-05 15:00:10', 1002);
insert into my_transaction(id, description, total, save_date, customer_id) values (1202, 'Purchase 202', 116.14, '2022-10-10 11:30:10', 1002);
insert into my_transaction(id, description, total, save_date, customer_id) values (1008, 'Purchase 5', 200, '2022-10-17 10:20:10', 1001);