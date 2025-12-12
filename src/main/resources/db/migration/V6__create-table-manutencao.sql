CREATE TABLE manutencao (
    id_manutencao bigint AUTO_INCREMENT PRIMARY KEY,
    id_dispositivo bigint NOT NULL,
    tipo_manutencao ENUM('preventiva', 'corretiva', 'atualizacao') NOT NULL,
    descricao_problema TEXT,
    data_solicitacao DATETIME DEFAULT CURRENT_TIMESTAMP,
    status_manutencao ENUM('aberta', 'em_andamento', 'concluida', 'cancelada') DEFAULT 'aberta',
    FOREIGN KEY (id_dispositivo) REFERENCES dispositivos(id_dispositivo) ON DELETE CASCADE
);