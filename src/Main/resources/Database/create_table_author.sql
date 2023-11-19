CREATE TABLE IF NOT EXISTS Author(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sex CHAR(1) CHECK (sex IN ('M', 'F'))
);

INSERT INTO Author (name, sex) VALUES ('Sarina Bowen', 'F');
INSERT INTO Author (name, sex) VALUES ('Tanya Eby', 'F');
INSERT INTO Author (name, sex) VALUES ('Staci Hart', 'F');