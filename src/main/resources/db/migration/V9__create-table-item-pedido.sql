CREATE TABLE item_pedidos (
    id_item bigint AUTO_INCREMENT PRIMARY KEY,
    id_pedido bigint NOT NULL,
    id_produto bigint NOT NULL,
    preco_unitario DECIMAL(19, 2),
    quantidade INT,

    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    FOREIGN KEY (id_produto) REFERENCES produtos(id_produto)
);