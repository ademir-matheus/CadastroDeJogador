-- V2: Migration que implementa a coluna cor de pele na tabela tb_cadastro

ALTER TABLE TB_CADASTRO
ADD COLUMN cor_de_pele VARCHAR(10);