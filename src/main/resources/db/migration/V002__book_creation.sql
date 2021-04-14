CREATE TABLE book (
    id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    title VARCHAR(30) NOT NULL,
    description VARCHAR(100) NOT NULL,
    author VARCHAR(25) NOT NULL,
    pages INTEGER NOT NULL,
    publisher INTEGER NOT NULL,

    CONSTRAINT FKPublisher FOREIGN KEY (publisher)
    REFERENCES publisher(sid)
);