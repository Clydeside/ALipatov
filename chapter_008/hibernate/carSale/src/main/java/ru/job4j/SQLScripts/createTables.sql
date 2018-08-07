CREATE TABLE engine(
  id SERIAL PRIMARY KEY,
  name VARCHAR(256)
);
INSERT INTO engine(name) VALUES('бензиновые'), ('дизельные'), ('газовые');

CREATE TABLE gearbox(
  id SERIAL PRIMARY KEY,
  name VARCHAR(256)
);
INSERT INTO gearbox(name) VALUES('механическая'), ('автоматическая'), ('роботизированная'), ('вариативная');

CREATE TABLE transmission(
  id SERIAL PRIMARY KEY,
  name VARCHAR(256)
);
INSERT INTO transmission(name) VALUES('механическая'), ('электрическая');

CREATE TABLE car(
  id SERIAL PRIMARY KEY,
  name VARCHAR(256),
  engine INT REFERENCES engine(id),
  gearbox INT REFERENCES gearbox(id),
  transmission INT REFERENCES transmission(id)
);
INSERT INTO car(name, engine, gearbox, transmission) VALUES
  ('Reno', 1, 1, 1),
  ('Mazda', 1, 2, 1),
  ('Hundai', 3, 1, 2),
  ('Opel', 1, 1, 2);
