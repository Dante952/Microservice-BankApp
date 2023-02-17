CREATE TABLE IF NOT EXISTS tbl_documenttype (
                                                 id LONG NOT NULL,
                                                 name VARCHAR2,
                                                 description VARCHAR2,
                                                 PRIMARY KEY (id)

);

delete FROM tbl_documenttype WHERE id >= '1';

INSERT INTO tbl_documenttype (id, name, description) VALUES ( 1,'DNI', 'The National Identity Document of Peru constitutes the only personal identity card recognized by the State for all civil, commercial, administrative, judicial acts and, in general, for all those cases in which, by legal mandate, it must be presented.' );
INSERT INTO tbl_documenttype (id, name, description) VALUES ( 2,'passport', 'A passport is a document with international validity issued by the authorities of its respective country, which accredits a permit or legal authorization to leave or enter it.' );
INSERT INTO tbl_documenttype (id, name, description) VALUES ( 3,'RUC', 'RUC is the unique eleven-digit number that identifies you as a taxpayer, whether you are a legal entity or a natural person. In addition, it contains the identification data of your economic activity and is mandatory in any declaration or procedure that you carry out before the Sunat.' );

select * FROM tbl_documenttype;

CREATE TABLE IF NOT EXISTS tbl_customertype (
                                                 id LONG NOT NULL,
                                                 name VARCHAR2,
                                                 description VARCHAR2,
                                                 PRIMARY KEY (id)

);

delete FROM tbl_customertype WHERE id >= '1';

INSERT INTO tbl_customertype (id, name, description) VALUES ( 1,'PERSONAL', 'Personal account belonging to a person identified by their ID or passport' );
INSERT INTO tbl_customertype (id, name, description) VALUES ( 2,'BUSINESS', 'Personal account that belongs to a company identified by its RUC' );

select * FROM tbl_customertype;

CREATE TABLE IF NOT EXISTS tbl_customer (
                                                 id LONG NOT NULL,
                                                 document VARCHAR2,
                                                 documenttype_id LONG NOT NULL,
                                                 name VARCHAR2,
                                                 status VARCHAR2,
                                                 phoneNumber INT,
                                                 customertype_id LONG NOT NULL,
                                                 PRIMARY KEY (id)
);