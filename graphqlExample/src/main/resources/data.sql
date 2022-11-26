
-- CREATE TABLE author|
-- (
--     id        INTEGER      NOT NULL AUTO_INCREMENT,
--     firstName VARCHAR(128) NOT NULL,
--     lastName  VARCHAR(128) NOT NULL,
--     createdDate timestamp not null,
--     lastModifiedDate timestamp not null,
--     PRIMARY KEY (id)
-- );


-- ImmutableMap.of("id", "book-1",
--                     "name", "Harry Potter and the Philosopher's Stone",
--                     "pageCount", "223",
--                     "authorId", "author-1"),
--             ImmutableMap.of("id", "book-2",
--                     "name", "Moby Dick",
--                     "pageCount", "635",
--                     "authorId", "author-2"),
--             ImmutableMap.of("id", "book-3",
--                     "name", "Interview with the vampire",
--                     "pageCount", "371",
--                     "authorId", "author-3")

-- private static List<Map<String, String>> authors = Arrays.asList(
--             ImmutableMap.of("id", "author-1",
--                     "firstName", "Joanne",
--                     "lastName", "Rowling"),
--             ImmutableMap.of("id", "author-2",
--                     "firstName", "Herman",
--                     "lastName", "Melville"),
--             ImmutableMap.of("id", "author-3",
--                     "firstName", "Anne",
--                     "lastName", "Rice")
--     );

insert into author (firstname, lastname, createddate, lastmodifieddate) values ('Joanne', 'Rowling', now(), now());