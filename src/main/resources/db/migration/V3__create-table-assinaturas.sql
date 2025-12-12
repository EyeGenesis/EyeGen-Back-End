CREATE TABLE assinaturas (
    id_assinatura bigint AUTO_INCREMENT PRIMARY KEY,
    plano ENUM('origin', 'infinity', 'guardian') NOT NULL,
    valor_mensal DECIMAL(10,2) NOT NULL,
    data_inicio DATETIME DEFAULT CURRENT_TIMESTAMP,
    data_vencimento DATETIME NOT NULL,
    status_assinatura ENUM('ativa', 'cancelada', 'suspensa') DEFAULT 'ativa'
);