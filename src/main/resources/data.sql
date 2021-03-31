INSERT INTO OWNER (name) VALUES ('Rokas');
INSERT INTO OWNER (name) VALUES ('Rytis');
INSERT INTO OWNER (name) VALUES ('Lukas');

INSERT INTO PROPERTY (property_type, tax_rate) VALUES ('Apartment'  ,0.05 );
INSERT INTO PROPERTY (property_type, tax_rate) VALUES ('House'      ,0.089);
INSERT INTO PROPERTY (property_type, tax_rate) VALUES ('Industrial' ,0.153);
INSERT INTO PROPERTY (property_type, tax_rate) VALUES ('Loft'       ,0.124);


INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 110, 3000, 25 , 1, 1);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 143, 4700, 42 , 1, 1);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 37 , 1500, 73 , 2, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Vinco' , 13 , 1350, 12 , 2, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Vinco' , 47 , 3580, 34 , 2, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Vinco' , 62 , 3880, 40 , 1, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 21 , 4000, 50 , 1, 1);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 34 , 2500, 32 , 2, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 69 , 9999, 150, 2, 1);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Vinco' , 68 , 4000, 72 , 3, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Vinco' , 88 , 5000, 78 , 2, 3);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Kaunas' , 'Vinco' , 96 , 8000, 125, 2, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 35 , 3500, 75 , 1, 4);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 97 , 900 , 25 , 3, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Vinco' , 1  , 9000, 150, 1, 1);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 92 , 1000, 27 , 1, 2);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Vinco' , 98 , 6000, 75 , 2, 1);
INSERT INTO BUILDING (city, street, number, value, size, owner_id, property_id) VALUES ('Vilnius', 'Taikos', 91 , 5400, 74 , 1, 1);