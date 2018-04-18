CREATE TABLE person
(
  id integer NOT NULL,
  name character varying,
  company_id integer REFERENCES company(id),
  CONSTRAINT person_key PRIMARY KEY (id)
);