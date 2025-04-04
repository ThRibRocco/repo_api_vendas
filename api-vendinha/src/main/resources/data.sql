CREATE TABLE USERS(
ID INTEGER PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(255) NOT NULL,
EMAIL VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255) NOT NULL,
CPF_CNPJ VARCHAR(255) NOT NULL,
is_active BOOLEAN DEFAULT TRUE
);
create table produtos(
    id integer primary key auto_increment,
    preco FLOAT,
    quantidade integer,
    USER_ID INTEGER REFERENCES USERS (id)
);

create TABLE Vendas(
    id integer primary key auto_increment,
    total_compra float,
    user_id integer references users (id),
    produtos_id integer references produtos (id),
    quantidade integer
);