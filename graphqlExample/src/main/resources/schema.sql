CREATE TABLE author
(
    id        INTEGER      NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(128) NOT NULL,
    lastName  VARCHAR(128) NOT NULL,
    createdDate timestamp not null,
    lastModifiedDate timestamp not null,
    PRIMARY KEY (id)
);
