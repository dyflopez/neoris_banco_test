use
banco;

create table person
(
    person_id      bigint  not null auto_increment,
    address        varchar(255),
    birthdate      date,
    gender         varchar(255),
    identification varchar(255),
    name           varchar(255),
    phone          varchar(255),
    email          varchar(255),
    primary key (person_id)
);

create table client
(
    client_id bigint       not null,
    password  varchar(255) not null,
    status    BOOLEAN          not null,
    primary key (client_id),
    CONSTRAINT person_fk FOREIGN KEY (client_id) REFERENCES person (person_id)
);

CREATE TABLE account
(
    account_id      bigint      NOT NULL AUTO_INCREMENT,
    client_id       bigint      NOT NULL,
    account_number  varchar(20) NOT NULL,
    account_type    VARCHAR(10) NOT NULL,
    initial_balance int DEFAULT 0,
    status          BOOLEAN     NOT NULL,
    creation_date   DATETIME    NOT NULL,
    PRIMARY KEY (`account_id`),
    CONSTRAINT client_fk FOREIGN KEY (client_id) REFERENCES client (client_id)
);

CREATE TABLE transactions
(
    transaction_id   bigint      NOT NULL AUTO_INCREMENT,
    account_id       bigint      NOT NULL,
    transaction_date DATETIME    NOT NULL,
    transaction_type VARCHAR(10) NOT NULL,
    amount            int         NOT NULL,
    balance          int         NOT NULL,
    PRIMARY KEY (`transaction_id`),
    CONSTRAINT account_fk FOREIGN KEY (account_id) REFERENCES account (account_id)
);