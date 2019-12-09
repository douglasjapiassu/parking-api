INSERT INTO USERDB (id, username, name, password) values (1, 'admin', 'Admin 123456', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');
INSERT INTO client(id, document, name, phone) VALUES (1, 'DOC', 'Client1', '+5562119');
INSERT INTO vehicle(id, color, model, plate, client_id) VALUES (1, 1, 'VW Polo', 'ABC-1234', 1);
INSERT INTO parking_lot(id, description, hourly_rate, parking_spaces)  VALUES (1, 'Pátio 1', 2.5, 40);

SELECT setval('userdb_id_seq', 1, true);
SELECT setval('client_id_seq', 1, true);
SELECT setval('vehicle_id_seq', 1, true);
SELECT setval('parking_lot_id_seq', 1, true);