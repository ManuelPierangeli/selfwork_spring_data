-- INSERT INTO authors(firstname, lastname, email)
-- value ("Mario","Rossi","mario@test.it");

-- INSERT INTO authors(firstname, lastname, email)
-- value ("Luigi","Neri","luigi@test.it");

-- INSERT INTO authors(firstname, lastname, email)
-- value ("Franco","Verdi","franco@test.it");


-- INSERT INTO posts (title, body, author_id)
-- SELECT 'Il mio primo post', 'Contenuto del primo post', id
-- FROM authors
-- WHERE firstname = 'Mario' AND lastname = 'Rossi';

-- INSERT INTO posts (title, body, author_id)
-- SELECT 'Benvenuti nel blog', 'Contenuto del post di Luigi', id
-- FROM authors
-- WHERE firstname = 'Luigi' AND lastname = 'Neri';

-- INSERT INTO posts (title, body, author_id)
-- SELECT 'SQL e database', 'Contenuto del post di Franco', id
-- FROM authors
-- WHERE firstname = 'Franco' AND lastname = 'Verdi';


INSERT INTO comments(email,body,date,post_id)
value("luigi@test.it","Lorem inpsum lorem","08011997",1),
    ("luigi@test.it","Lorem inpsum asd","0801997",2),
    ("luigi@test.it","Lorem inpsum jojo","0801997",3)