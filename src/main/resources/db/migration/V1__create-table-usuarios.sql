create table usuarios (

    id_usuario bigint AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    tipo_def_visual ENUM('cegueira_total', 'baixa_visao') NOT NULL

);