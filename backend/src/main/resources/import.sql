-- Inserindo categorias para o PDV da lanchonete
INSERT INTO tb_category (name, description) VALUES ('Pastéis', 'Diversos sabores de pastéis salgados');
INSERT INTO tb_category (name, description) VALUES ('Bebidas', 'Bebidas variadas como refrigerantes, sucos e água');
INSERT INTO tb_category (name, description) VALUES ('Bebidas Alcoólicas', 'Cervejas e outras bebidas alcoólicas');
INSERT INTO tb_category (name, description) VALUES ('Acompanhamentos', 'Acompanhamentos como batata frita e porções');

-- Inserindo métodos de pagamento na tabela tb_payment_method
INSERT INTO tb_payment_method (name) VALUES ('Dinheiro');
INSERT INTO tb_payment_method (name) VALUES ('Cartão de Crédito');
INSERT INTO tb_payment_method (name) VALUES ('Cartão de Débito');
INSERT INTO tb_payment_method (name) VALUES ('PIX');
