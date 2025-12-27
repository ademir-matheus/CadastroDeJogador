-- V3: Migration que implementa a coluna status_atividade na tabela tb_cadastro
ALTER TABLE TB_CADASTRO
ADD COLUMN STATUS_ATIVIDADE VARCHAR(20);