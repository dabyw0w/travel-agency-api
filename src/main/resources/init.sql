create table hotel (
id integer auto_increment primary key, 
libelle varchar(500), 
adresse varchar(250), 
prix integer);

insert into hotel (libelle, adresse, prix) values
('hotel royal', '92 strasse maj, frankfurt auf main 60306 deutshland', 50),
('hotel ahtsou', '16 rue des héros, mechtras 15440 algerie', 3),
('hotel frerot', '29 A quai de la prévalaye, 35000 Rennes', 20),
('hotel X', '35 rue larbi ben mhdi, 16000 Alger, Algerie', 7),
('hotel abane', '08 rue abane ramdane, ouargla 30000 algerie', 8);
