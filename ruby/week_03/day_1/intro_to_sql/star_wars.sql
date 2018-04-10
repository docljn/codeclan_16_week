DROP TABLE lightsabers;
DROP TABLE jedis;

CREATE TABLE jedis (
  name VARCHAR(255),
  age INT,
  darkside BOOLEAN,
  id SERIAL PRIMARY KEY
);

CREATE TABLE lightsabers (
  id SERIAL PRIMARY KEY,
  colour VARCHAR(255),
  hilt_metal VARCHAR(255) NOT NULL,
  owner_id INT REFERENCES jedis(id)
);

-- Creating:

INSERT INTO jedis (name, age, darkside)
VALUES ('luke', 22, false);

INSERT INTO jedis (name, darkside)
VALUES ('yoda', false);

-- Reading:

-- SELECT * FROM jedis;

-- SELECT name FROM jedis;

-- SELECT COUNT(*) FROM jedis;

-- Updating:

-- SELECT * FROM jedis;

UPDATE jedis SET darkside = true;

UPDATE jedis SET darkside = false
WHERE name = 'yoda' AND darkside = true;

SELECT * FROM jedis;

INSERT INTO jedis (
  name, age, darkside
) VALUES (
  'Anakin', 12, false
);

UPDATE jedis SET age = 22
WHERE name = 'Anakin';

UPDATE jedis SET darkside = true
WHERE name = 'Anakin';

-- UPDATE jedis
-- SET
-- age = 22,
-- darkside = true
-- WHERE name = 'Anakin';
--
-- UPDATE jedis
-- SET (age, darkside)
-- = (22, true)
-- WHERE name = 'Anakin';

DELETE FROM jedis
WHERE name = 'luke';

SELECT * FROM jedis;

-- INSERT INTO lightsabers (
--   colour,
--   hilt_metal,
--   owner
-- ) VALUES (
--   'green',
--   'stainless steel',
--   'yoda'
-- );
--
-- INSERT INTO lightsabers (colour, owner, hilt_metal)
-- VALUES ('blue', 'luke', 'gold');

-- Primary key prevents this working:
-- UPDATE lightsabers SET id = 50;


INSERT INTO lightsabers
(colour, hilt_metal, owner_id)
VALUES
('green', 'gold', 2);

SELECT * FROM jedis;
SELECT * FROM lightsabers;
