use banco;

create table persona (
                         persona_id bigint not null auto_increment,
                         direccion varchar(255),
                         edad integer not null,
                         fecha_nacimiento datetime(6),
                         genero varchar(255),
                         identificacion varchar(255),
                         nombre varchar(255),
                         telefono varchar(255),
                         primary key (persona_id)
);

create table cliente (
                         cliente_id bigint not null,
                         password varchar(255)  not null,
                         estado bit not null,
                         primary key (cliente_id),
                         CONSTRAINT persona_fk FOREIGN KEY (cliente_id) REFERENCES persona (persona_id)
);

CREATE TABLE cuenta (
                        cuenta_id       	bigint NOT NULL AUTO_INCREMENT,
                        cliente_id			bigint NOT NULL ,
                        numero_cuenta		varchar(20) NOT NULL,
                        tipo_cuenta 		VARCHAR(10) NOT NULL,
                        saldo_inicial    	int DEFAULT 0,
                        estado   		 	BOOLEAN NOT NULL,
                        PRIMARY KEY (`cuenta_id`),
                        CONSTRAINT cliente_fk FOREIGN KEY (cliente_id) REFERENCES cliente (cliente_id)
);

CREATE TABLE movimientos (
                             movimientos_id     bigint NOT NULL AUTO_INCREMENT,
                             cuenta_id			bigint NOT NULL,
                             Fecha				date NOT NULL,
                             tipo_movimiento 	VARCHAR(10) NOT NULL,
                             valor    			int NOT NULL,
                             saldo   		 	int NOT NULL,
                             PRIMARY KEY (`movimientos_id`),
                             CONSTRAINT cuenta_fk FOREIGN KEY (cuenta_id) REFERENCES cuenta (cuenta_id)
);