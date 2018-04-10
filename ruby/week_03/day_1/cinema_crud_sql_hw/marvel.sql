DROP TABLE attendances;
DROP TABLE movies;
DROP TABLE people;

CREATE TABLE movies (
	id SERIAL8 PRIMARY KEY,
	title VARCHAR(255),
	year INT2,
	show_time VARCHAR(255)
);

CREATE TABLE people (
	id SERIAL8 PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE attendances (
	id SERIAL8 PRIMARY KEY,
	person_id INT REFERENCES people(id) ON DELETE CASCADE,
	movie_id INT REFERENCES movies(id) ON DELETE CASCADE
);

INSERT INTO people (name) VALUES ('Dave Ellis');
INSERT INTO people (name) VALUES ('Joe Ryan');
INSERT INTO people (name) VALUES ('Richard Allison');
INSERT INTO people (name) VALUES ('Alison Wood');
INSERT INTO people (name) VALUES ('Olga Maunsell');
INSERT INTO people (name) VALUES ('Graeme Brown');
INSERT INTO people (name) VALUES ('Eric Carles');
INSERT INTO people (name) VALUES ('David Rawson');
INSERT INTO people (name) VALUES ('Ross Hill');
INSERT INTO people (name) VALUES ('Mark Blanford');
INSERT INTO people (name) VALUES ('Douglas Sangster');
INSERT INTO people (name) VALUES ('Giuseppe Ibba');
INSERT INTO people (name) VALUES ('Kris Anderson');
INSERT INTO people (name) VALUES ('Vishal Sharma');
INSERT INTO people (name) VALUES ('Manny Chita');
INSERT INTO people (name) VALUES ('Amy Morrison');
INSERT INTO people (name) VALUES ('Joe Plevin');
INSERT INTO people (name) VALUES ('Robert Henderson');
INSERT INTO people (name) VALUES ('Max Robson');
INSERT INTO people (name) VALUES ('Lorna Nobel-Prize');
INSERT INTO people (name) VALUES ('Alex Bazlinton');

INSERT INTO movies (title, year, show_time) VALUES ('Iron Man', 2008, '17:30');
INSERT INTO movies (title, year, show_time) VALUES ('The Incredible Hulk', 2008, '17:10');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 2', 2010, '20:05');
INSERT INTO movies (title, year, show_time) VALUES ('Thor', 2011, '21:05');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The First Avenger', 2011, '12:05');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers Assemble', 2012, '13:05');
INSERT INTO movies (title, year, show_time) VALUES ('Iron Man 3', 2013, '22:00');
INSERT INTO movies (title, year, show_time) VALUES ('Thor: The Dark World', 2013, '19:30');
INSERT INTO movies (title, year, show_time) VALUES ('Batman Begins', 2005, '14:25');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: The Winter Soldier', 2014, '20:15');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy', 2014, '17:55');
INSERT INTO movies (title, year, show_time) VALUES ('Avengers: Age of Ultron', 2015, '21:10');
INSERT INTO movies (title, year, show_time) VALUES ('Ant-Man', 2015, '20:40');
INSERT INTO movies (title, year, show_time) VALUES ('Captain America: Civil War', 2016, '13:50');
INSERT INTO movies (title, year, show_time) VALUES ('Doctor Strange', 2016, '21:30');
INSERT INTO movies (title, year, show_time) VALUES ('Guardians of the Galaxy 2', 2017, '15:50');

INSERT INTO attendances (person_id, movie_id) VALUES (21, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (15, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (1, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (11, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (5, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (18, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (10, 9);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 15);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 10);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (6, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (17, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 13);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (12, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 4);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (19, 12);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 11);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (7, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (15, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (4, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (8, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (20, 7);
INSERT INTO attendances (person_id, movie_id) VALUES (15, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 3);
INSERT INTO attendances (person_id, movie_id) VALUES (16, 6);
INSERT INTO attendances (person_id, movie_id) VALUES (15, 1);
INSERT INTO attendances (person_id, movie_id) VALUES (2, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (21, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 2);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 8);
INSERT INTO attendances (person_id, movie_id) VALUES (13, 14);
INSERT INTO attendances (person_id, movie_id) VALUES (14, 16);
INSERT INTO attendances (person_id, movie_id) VALUES (9, 5);
INSERT INTO attendances (person_id, movie_id) VALUES (3, 4);