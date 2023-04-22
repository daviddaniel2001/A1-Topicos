-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');
INSERT INTO estado (id, nome, sigla) VALUES
(1, 'São Paulo', 'SP'),
(2, 'Rio de Janeiro', 'RJ'),
(3, 'Minas Gerais', 'MG');

INSERT INTO municipio (nome, id_estado) VALUES
('São Paulo', 1),
('Rio de Janeiro', 2),
('Belo Horizonte', 3);

INSERT INTO endereco (id, lagradouro, bairro, numero, complemento, cep) VALUES
(100, 'Rua A', 'Bairro A', '123', 'Complemento A', '12345-678'),
(101, 'Rua B', 'Bairro B', '456', 'Complemento B', '98765-432'),
(102, 'Rua C', 'Bairro C', '354', 'Complemento C', '12334-432');

INSERT INTO endereco (id, lagradouro, bairro, numero, complemento, cep) VALUES
(103, 'Rua D', 'Bairro A', '123', 'Complemento A', '12345-678'),
(104, 'Rua E', 'Bairro B', '456', 'Complemento B', '98765-432'),
(105, 'Rua F', 'Bairro C', '354', 'Complemento C', '12334-432');

INSERT INTO criadordeconteudo (id, nome, idade, cpf, email, endereco_id) VALUES
(124,'Carlos', 25, '12345678901', 'carlos@example.com', 100),
(231,'Joana', 30, '23456789012', 'joana@example.com', 101),
(122,'Carla', 19,'12345456562','carla@example.com', 102);

INSERT INTO usuario (nome, idade, email,id_endereco) VALUES
('João', 25, 'joao@example.com', 103),
('Maria', 30, 'maria@example.com', 104),
('Pedro', 18, 'pedrindopneu@example.com', 105);




