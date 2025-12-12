CREATE TABLE pedidos (
    id_pedido bigint AUTO_INCREMENT PRIMARY KEY,
    id_usuario bigint NOT NULL,
    valor_total DECIMAL(10,2) NOT NULL,
    status_pedido ENUM('pendente', 'pago', 'enviado', 'entregue', 'cancelado') DEFAULT 'pendente',
    data_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    metodo_pagamento ENUM('cartao', 'pix', 'boleto') NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);