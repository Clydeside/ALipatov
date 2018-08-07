DROP TABLE IF EXISTS engine CASCADE;

CREATE TABLE IF NOT EXISTS engine(
  id SERIAL PRIMARY KEY,
  name VARCHAR(100)
);

INSERT INTO engine(name) VALUES ('бензиновый');
INSERT INTO engine(name) VALUES ('дизельный');
INSERT INTO engine(name) VALUES ('газовый');