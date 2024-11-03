INSERT INTO Movies (title, release_year, votes, rating, image_url) VALUES
('Inception', 2010, 2000000, 8.8, 'https://example.com/inception.jpg'),
('The Matrix', 1999, 1700000, 8.7, 'https://example.com/thematrix.jpg'),
('Interstellar', 2014, 1500000, 8.6, 'https://example.com/interstellar.jpg'),
('Parasite', 2019, 1000000, 8.6, 'https://example.com/parasite.jpg'),
('The Dark Knight', 2008, 2300000, 9.0, 'https://example.com/thedarkknight.jpg');


-------------------------------------------------------------------------------------------
-- HUBO QUE BORRAR EL CAMPO ID PORQUE CREABA CONFLICTO CON LA GENERACIÓN AUTOMATICA DE ID
-------------------------------------------------------------------------------------------
--INSERT INTO Movies (id, title, release_year, votes, rating, image_url) VALUES
--(1, 'Inception', 2010, 2000000, 8.8, 'https://example.com/inception.jpg'),
--(2, 'The Matrix', 1999, 1700000, 8.7, 'https://example.com/thematrix.jpg'),
--(3, 'Interstellar', 2014, 1500000, 8.6, 'https://example.com/interstellar.jpg'),
--(4, 'Parasite', 2019, 1000000, 8.6, 'https://example.com/parasite.jpg'),
--(5, 'The Dark Knight', 2008, 2300000, 9.0, 'https://example.com/thedarkknight.jpg');
