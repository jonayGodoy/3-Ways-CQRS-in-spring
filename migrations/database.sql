CREATE TABLE pizza1
(
	id SERIAL,
	name VARCHAR(255) NOT NULL,
	img VARCHAR(255) NOT NULL,
	priceInEuros Float NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO pizza1 (name, img, priceInEuros) VALUES ('bbq', 'bbq.png', 3.99);
INSERT INTO pizza1 (name, img, priceInEuros) VALUES ('4Cheeses', '4Cheeses.png', 4.99);
INSERT INTO pizza1 (name, img, priceInEuros) VALUES ('carbonara', 'carbonara.png', 2.99);
INSERT INTO pizza1 (name, img, priceInEuros) VALUES ('Cesar', 'Cesar.png', 5.99);
INSERT INTO pizza1 (name, img, priceInEuros) VALUES ('hawaiana', 'hawaiana.PNG', -3.99);
INSERT INTO pizza1 (name, img, priceInEuros) VALUES ('nachos', 'nachos.png', -30.99);


CREATE TABLE pizza2
(
	id SERIAL,
	name VARCHAR(255) NOT NULL,
	img VARCHAR(255) NOT NULL,
	priceInEuros Float NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO pizza2 (name, img, priceInEuros) VALUES ('bbq', 'bbq.png', 3.99);
INSERT INTO pizza2 (name, img, priceInEuros) VALUES ('4Cheeses', '4Cheeses.png', 4.99);
INSERT INTO pizza2 (name, img, priceInEuros) VALUES ('carbonara', 'carbonara.png', 2.99);
INSERT INTO pizza2 (name, img, priceInEuros) VALUES ('Cesar', 'Cesar.png', 5.99);
INSERT INTO pizza2 (name, img, priceInEuros) VALUES ('hawaiana', 'hawaiana.PNG', -3.99);
INSERT INTO pizza2 (name, img, priceInEuros) VALUES ('nachos', 'nachos.png', -30.99);



CREATE TABLE pizza3
(
	id SERIAL,
	name VARCHAR(255) NOT NULL,
	img VARCHAR(255) NOT NULL,
	priceInEuros Float NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO pizza3 (name, img, priceInEuros) VALUES ('bbq', 'bbq.png', 3.99);
INSERT INTO pizza3 (name, img, priceInEuros) VALUES ('4Cheeses', '4Cheeses.png', 4.99);
INSERT INTO pizza3 (name, img, priceInEuros) VALUES ('carbonara', 'carbonara.png', 2.99);
INSERT INTO pizza3 (name, img, priceInEuros) VALUES ('Cesar', 'Cesar.png', 5.99);
INSERT INTO pizza3 (name, img, priceInEuros) VALUES ('hawaiana', 'hawaiana.PNG', -3.99);
INSERT INTO pizza3 (name, img, priceInEuros) VALUES ('nachos', 'nachos.png', -30.99);