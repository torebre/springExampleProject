
-- changeset test:1
create table tasks
(
    task_id      int,
    title        varchar(100),
    last_updated timestamp
);


-- changeset test:2
insert into tasks(task_id, title, last_updated) values (1, 'Test10', now());
insert into tasks(task_id, title, last_updated) values (2, 'Test11', now());
