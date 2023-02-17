
CREATE TABLE IF NOT EXISTS type_account(
                                           id INT NOT NULL,
                                           type VARCHAR(30),
                                           PRIMARY KEY(id)
);

INSERT INTO type_account(id,type) VALUES (100,'SAVING');
INSERT INTO type_account(id,type) VALUES (200,'CURRENT');
INSERT INTO type_account(id,type) VALUES (300,'FIXEDTERM');

CREATE TABLE IF NOT EXISTS account(
                                      id INT NOT NULL AUTO_INCREMENT,
                                      number VARCHAR(30) UNIQUE,
                                      amount FLOAT,
                                      id_customer INT,/*idCustomer*/
                                      id_type_account_id INT NOT NULL,/*idTypeAccount*/
                                      PRIMARY KEY(id),
                                      FOREIGN KEY (id_type_account_id) REFERENCES type_account(id)
);

CREATE TABLE IF NOT EXISTS type_authorized(
                                              id INT NOT NULL,
                                              type VARCHAR(30),
                                              PRIMARY KEY(id)
);

INSERT INTO type_authorized(id,type) VALUES (11,'OWNER');
INSERT INTO type_authorized(id,type) VALUES (99,'SIGNATORY');

CREATE TABLE IF NOT EXISTS authorized(
                                         id INT NOT NULL AUTO_INCREMENT,
                                         name VARCHAR(30),
                                         id_type_id INT NOT NULL, /*idType*/
                                         id_account_id INT NOT NULL,/*idAccount*/
                                         PRIMARY KEY(id),
                                         FOREIGN KEY (id_type_id) REFERENCES type_authorized(id),
                                         FOREIGN KEY (id_account_id) REFERENCES account(id)
);

CREATE TABLE IF NOT EXISTS type_movement(
                                            id INT NOT NULL,
                                            type VARCHAR(30),
                                            PRIMARY KEY(id)
);

INSERT INTO type_movement(id,type) VALUES (111,'DEPOSIT');
INSERT INTO type_movement(id,type) VALUES (999,'WITHDRAWAL');

CREATE TABLE IF NOT EXISTS movement(
                                       id INT NOT NULL AUTO_INCREMENT,
                                       amount FLOAT NOT NULL,
                                       id_type_id INT NOT NULL,/*idType*/
                                       id_account_id INT NOT NULL,/*idAccount*/
                                       PRIMARY KEY(id),
                                       FOREIGN KEY (id_type_id) REFERENCES type_movement(id),
                                       FOREIGN KEY (id_account_id) REFERENCES account(id)
);

SELECT * FROM type_account;
SELECT * FROM account;
SELECT * FROM type_movement;
SELECT * FROM movement;




