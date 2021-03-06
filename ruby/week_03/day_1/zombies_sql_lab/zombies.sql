DROP TABLE bitings;
DROP TABLE zombies;
DROP TABLE victims;

CREATE TABLE zombies
(
  id SERIAL8 PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  type VARCHAR(255)
);

CREATE TABLE victims
(
  id SERIAL8 PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  run_speed INT2
);

CREATE TABLE bitings
(
  id SERIAL8 PRIMARY KEY,
  victim_id INT8 REFERENCES victims(id),
  zombie_id INT8 REFERENCES zombies(id),
  infected_on DATE NOT NULL
);

INSERT INTO victims (name, run_speed) VALUES ('Dave', 12);
INSERT INTO victims (name, run_speed) VALUES ('Ross',11);
INSERT INTO victims (name, run_speed) VALUES ('Amy',15);
INSERT INTO victims (name, run_speed) VALUES ('Robert',30);

INSERT INTO zombies (name, type) VALUES ('John', 'crawler');
INSERT INTO zombies (name, type) VALUES ('Alex', 'runner');
INSERT INTO zombies (name, type) VALUES ('Craig', 'witch');
INSERT INTO zombies (name, type) VALUES ('Zsolt', 'tank');

INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (1, 1, 'March 27 2017');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (2, 2,'March 29 2017');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (4, 3, 'March 30 2017');
INSERT INTO bitings (zombie_id, victim_id, infected_on) VALUES (1, 3, 'March 30 2017');

-- First, find out the ID of John.
SELECT * FROM zombies WHERE name = 'John';

-- We just want the victim_id for our purposes.
SELECT victim_id FROM bitings WHERE zombie_id = 1;

-- Now we can get the people's names from the person_ids. Note that (2,3) is kind of like an array.
SELECT name FROM victims WHERE id IN (1,3);