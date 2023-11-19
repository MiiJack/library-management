CREATE TYPE Topic AS ENUM ('COMEDY', 'ROMANCE', 'OTHER');

CREATE TABLE IF NOT EXISTS Book(
    id SERIAL PRIMARY KEY,
    bookName VARCHAR(255) NOT NULL,
    pageNumbers INT NOT NULL,
    releaseDate DATE NOT NULL,
    idAuthor INT REFERENCES Author(id),
    topic Topic NOT NULL
);

INSERT INTO Book (bookName, pageNumbers, releaseDate, idAuthor, topic) VALUES ('Man Hands', 200, '2023-01-01', 1, 'COMEDY');
INSERT INTO Book (bookName, pageNumbers, releaseDate, idAuthor, topic) VALUES ('Pride and Papercuts', 300, '2023-02-01', 2, 'ROMANCE');
INSERT INTO Book (bookName, pageNumbers, releaseDate, idAuthor, topic) VALUES ('Related Book Lists', 400, '2023-03-01', 3, 'OTHER');
