CREATE TABLE IF NOT EXISTS items  (
  key SERIAL PRIMARY KEY,
  id VARCHAR(256),
  name VARCHAR(256),
  description VARCHAR(256),
  created BIGINT
);