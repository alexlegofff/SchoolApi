INSERT INTO eleves (id, name, email, gender_type, created_at) VALUES (1001, 'Alexis LE GOFF', 'alexis-legoff@brest-opencampus.com', 'HOMME', now());
INSERT INTO eleves (id, name, email,  gender_type, created_at) VALUES (1002, 'Julie LE DU', 'julie@gmail.com', 'FEMME', now());



INSERT INTO prof (id, name, email, gender_type, created_at) VALUES (2001, 'Soumaila Abdoulaye DIARRA', 'diarra176@gmail.com', 'HOMME', now());



INSERT INTO addresses (id, name, user_id) VALUES (3001, '45 chemin du moulin', 1001);
INSERT INTO addresses (id, name, user_id) VALUES (3002, '355 rue de eau blanche', 1002);

