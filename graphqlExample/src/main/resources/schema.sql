CREATE TABLE author
(
    id        INTEGER      NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    last_name  VARCHAR(128) NOT NULL,
    created_date timestamp not null,
    last_modified_date timestamp not null,
    PRIMARY KEY (id)
);
