-- USER_TYPE
TRUNCATE TABLE user_type RESTART IDENTITY CASCADE;
INSERT INTO user_type(name) VALUES ('EMPLEADO');
INSERT INTO user_type(name) VALUES ('CLIENTE');

-- USERS
TRUNCATE TABLE "users" RESTART IDENTITY CASCADE;
INSERT INTO "users"(user_type_id, lastname, name, document_type, document, is_affiliated, created_at) VALUES (1, 'RAMOS', 'JOHNNY', 'DNI', '72721759', false, TO_TIMESTAMP('01/03/2018 17:30:00', 'DD/MM/YYYY HH24:MI:SS'));
INSERT INTO "users"(user_type_id, lastname, name, document_type, document, is_affiliated, created_at) VALUES (2, 'CRUZADO', 'JUAN', 'DNI', '72721788', true, TO_TIMESTAMP('15/05/2019 17:30:00', 'DD/MM/YYYY HH24:MI:SS'));
INSERT INTO "users"(user_type_id, lastname, name, document_type, document, is_affiliated, created_at) VALUES (2, 'CAMPOS', 'KEVIN', 'DNI', '72721712', false, TO_TIMESTAMP('28/07/2021 17:30:00', 'DD/MM/YYYY HH24:MI:SS'));
INSERT INTO "users"(user_type_id, lastname, name, document_type, document, is_affiliated, created_at) VALUES (2, 'CUADROS', 'MIGUEL', 'DNI', '72721780', false, TO_TIMESTAMP('11/12/2017 17:30:00', 'DD/MM/YYYY HH24:MI:SS'));

-- CATEGORY
TRUNCATE TABLE category RESTART IDENTITY CASCADE;
INSERT INTO category(name) VALUES ('Comestibles');
INSERT INTO category(name) VALUES ('Tecnología');
INSERT INTO category(name) VALUES ('Vestimenta');
INSERT INTO category(name) VALUES ('Deportes');
INSERT INTO category(name) VALUES ('Electrodomésticos');
INSERT INTO category(name) VALUES ('Cuidado personal');

-- PRODUCT
TRUNCATE TABLE product RESTART IDENTITY CASCADE;
INSERT INTO product(name, price, currency, category_id) VALUES ('Limón', 30, 'USD', 1);
INSERT INTO product(name, price, currency, category_id) VALUES ('Arroz', 20, 'USD', 1);
INSERT INTO product(name, price, currency, category_id) VALUES ('Sal', 25, 'USD', 1);
INSERT INTO product(name, price, currency, category_id) VALUES ('Televisor LED', 300, 'USD', 2);
INSERT INTO product(name, price, currency, category_id) VALUES ('Equipo de sonido', 150, 'USD', 2);
INSERT INTO product(name, price, currency, category_id) VALUES ('Pantalones', 40, 'USD', 3);
INSERT INTO product(name, price, currency, category_id) VALUES ('Camisetas', 30, 'USD', 4);
INSERT INTO product(name, price, currency, category_id) VALUES ('Liquadora', 100, 'USD', 5);
INSERT INTO product(name, price, currency, category_id) VALUES ('Shampoo', 15, 'USD', 6);
INSERT INTO product(name, price, currency, category_id) VALUES ('Jabón de mano', 10, 'USD', 6);

-- DISCOUNT
TRUNCATE TABLE discount RESTART IDENTITY CASCADE;
INSERT INTO discount(code, amount) VALUES ('FIXED5', 5);
INSERT INTO discount(code, amount) VALUES ('FIXED10', 10);
INSERT INTO discount(code, amount) VALUES ('FIXED15', 15);
INSERT INTO discount(code, amount) VALUES ('FIXED20', 20);
INSERT INTO discount(code, amount) VALUES ('FIXED25', 25);
INSERT INTO discount(code, amount) VALUES ('PERCENTAGE5', 5);
INSERT INTO discount(code, amount) VALUES ('PERCENTAGE10', 10);
INSERT INTO discount(code, amount) VALUES ('PERCENTAGE15', 15);
INSERT INTO discount(code, amount) VALUES ('PERCENTAGE20', 20);
INSERT INTO discount(code, amount) VALUES ('PERCENTAGE25', 25);
INSERT INTO discount(code, amount) VALUES ('PERCENTAGE30', 30);
INSERT INTO discount(code, amount) VALUES ('PERCENTAGE35', 35);

-- INVOICE
TRUNCATE TABLE invoice RESTART IDENTITY CASCADE;
INSERT INTO invoice(client_id, amount, currency) VALUES (1, 125, 'USD');
INSERT INTO invoice(client_id, amount, currency) VALUES (2, 590, 'USD');
INSERT INTO invoice(client_id, amount, currency) VALUES (1, 900, 'USD');
INSERT INTO invoice(client_id, amount, currency) VALUES (3, 455, 'USD');
INSERT INTO invoice(client_id, amount, currency) VALUES (4, 760, 'USD');
INSERT INTO invoice(client_id, amount, currency) VALUES (4, 250, 'USD');

-- INVOICE PRODUCT
TRUNCATE TABLE invoice_product RESTART IDENTITY CASCADE;
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (1, 1, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (1, 2, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (1, 3, 1);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (2, 4, 1);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (2, 5, 1);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (2, 6, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (2, 7, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (3, 4, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (3, 5, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (4, 1, 5);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (4, 2, 4);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (4, 3, 5);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (5, 4, 1);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (5, 5, 1);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (5, 6, 3);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (5, 7, 3);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (5, 8, 1);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (6, 8, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (6, 9, 2);
INSERT INTO invoice_product(invoice_id, product_id, quantity) VALUES (6, 10, 2);
