CREATE TABLE produtos(
    id_produto bigint AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(100) NOT NULL,
    preco_atual DECIMAL(10,2) NOT NULL,
    tipo_produto ENUM('servico', 'fisico') NOT NULL
);