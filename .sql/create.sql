CREATE TABLE authors (
    id BIGINT auto_increment PRIMARY KEY,
    firstname VARCHAR(100),
    lastname VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE posts (
    id BIGINT auto_increment PRIMARY KEY,
    title VARCHAR(100) not null,
    body varchar(100) not null,
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

CREATE TABLE comments (
    id BIGINT auto_increment PRIMARY KEY,
    email VARCHAR(100) not null,
    body VARCHAR(200) not null,
    date CHAR(8),
    post_id BIGINT,
    FOREIGN KEY (post_id) REFERENCES posts(id)
);