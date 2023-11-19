CREATE TABLE IF NOT EXISTS Visitor(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    reference VARCHAR(255)
);

INSERT INTO Visitor (name, reference) VALUES ('John Doe', 'JD001');
INSERT INTO Visitor (name, reference) VALUES ('Jane Doe', 'JD002');
INSERT INTO Visitor (name, reference) VALUES ('Robert Smith', 'RS001');