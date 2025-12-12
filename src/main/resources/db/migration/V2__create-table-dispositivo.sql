CREATE TABLE dispositivos (
    id_dispositivo bigint AUTO_INCREMENT PRIMARY KEY,
    id_usuario bigint NOT NULL,
    numero_serie VARCHAR(50) UNIQUE NOT NULL,
    modelo_cor VARCHAR(50) NOT NULL,
    data_ativacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    status_dispositivo ENUM('ativo', 'inativo', 'manutencao') DEFAULT 'ativo',
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);
