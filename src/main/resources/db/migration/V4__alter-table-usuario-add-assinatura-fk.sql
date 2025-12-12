ALTER TABLE usuarios
ADD COLUMN id_assinatura bigint;

ALTER TABLE usuarios
ADD CONSTRAINT fk_usuario_assinatura
FOREIGN KEY (id_assinatura) REFERENCES assinaturas(id_assinatura);