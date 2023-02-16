CREATE TABLE IF NOT EXISTS tbl_transactionType (
                                                id LONG NOT NULL,
                                                name VARCHAR2,
                                                description VARCHAR2,
                                                PRIMARY KEY (id)

);

delete FROM tbl_transactionType WHERE id >= '1';

INSERT INTO tbl_transactionType (id, name, description) VALUES ( 1 , 'CHARGE' , 'Function of increasing a cost to the credit card');
INSERT INTO tbl_transactionType (id, name, description) VALUES ( 2 , 'PAY' , 'Function of paying for the service of a credit product');

select * from tbl_transactionType;

CREATE TABLE IF NOT EXISTS tbl_creditType (
                                                   id LONG NOT NULL,
                                                   name VARCHAR2,
                                                   description VARCHAR2,
                                                   PRIMARY KEY (id)

);

delete FROM tbl_creditType WHERE id >= '1';

INSERT INTO tbl_credittype (id, name, description) VALUES ( 1,'PERSONAL', 'Personal credit belonging to a person identified by their ID or passport' );
INSERT INTO tbl_credittype (id, name, description) VALUES ( 2,'BUSINESS', 'Business credit that belongs to a company identified by its RUC' );

Select * from tbl_creditType;

CREATE TABLE IF NOT EXISTS tbl_credit (
                                                   id LONG NOT NULL,
                                                   creditType_id LONG NOT NULL,
                                                   customer_id LONG NOT NULL,
                                                   amountMax VARCHAR2,
                                                   PRIMARY KEY (id)

);

delete FROM tbl_credit WHERE id >= '1';

CREATE TABLE IF NOT EXISTS tbl_transaction (
                                                   id LONG NOT NULL,
                                                   credit_id LONG NOT NULL,
                                                   transactionType_id LONG NOT NULL,
                                                   amount VARCHAR2,
                                                   PRIMARY KEY (id)

);

delete FROM tbl_transactionType WHERE id >= '1';