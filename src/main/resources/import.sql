insert into role (id, name) values(1, 'ADMIN');
insert into role (id, name) values(2, 'HOST');
insert into role (id, name) values(3, 'STUDENT');


insert into user (id, username, password, name, surname, active) values(1, 'admin', '$2a$10$csIVj5k8CB74npTTstUQuO3ObjmaM6y8cRMxvsKqpHmT3zNQxY/IK', 'Jan', 'Kowalski', 1);
insert into user (id, username, password, name, surname, active) values(2, 'host', '$2a$10$m7BBzoGFKzb8e3/q5AK/SuC.qNKnyh.GcHkKnJYXsvJGQREhZe0Zu', 'Zbigniew', 'Zawadzki', 1);
insert into user (id, username, password, name, surname, active) values(3, 'student', '$2a$10$m7BBzoGFKzb8e3/q5AK/SuC.qNKnyh.GcHkKnJYXsvJGQREhZe0Zu', 'Karolina', 'Pomysłowa', 1);

insert into host (id, user_id) values (1,2);

insert into user_role (user_id, role_id) values(1,1);
insert into user_role (user_id, role_id) values(2,2);
insert into user_role (user_id, role_id) values(3,3);