CREATE TABLE IF NOT EXISTS Subscriber(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    reference VARCHAR(255)
);

INSERT INTO Subscriber (name, reference) VALUES ('John Doe', 'JD001');
INSERT INTO Subscriber (name, reference) VALUES ('Jane Doe', 'JD002');
INSERT INTO Subscriber (name, reference) VALUES ('Robert Smith', 'RS001');