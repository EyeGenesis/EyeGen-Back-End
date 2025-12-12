ALTER TABLE dispositivos
ADD COLUMN id_produto bigint;

ALTER TABLE dispositivos
ADD CONSTRAINT fk_dispositivo_produto
FOREIGN KEY (id_produto) REFERENCES produtos(id_produto);

ALTER TABLE assinaturas
ADD COLUMN id_produto bigint;

ALTER TABLE assinaturas
ADD CONSTRAINT fk_assinatura_produto
FOREIGN KEY (id_produto) REFERENCES produtos(id_produto);