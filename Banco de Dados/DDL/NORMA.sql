CREATE TABLE "NORMA" (
    "cd_norm"  SERIAL  NOT NULL,
    "num_norm" INT   NOT NULL,
    "ts_doc" TIMESTAMP   NOT NULL,
    "tx_asst" TEXT   NOT NULL,
    "tx_desc" TEXT   NOT NULL,
    "tx_resp" VARCHAR(50)   NULL,
    "tx_dou" VARCHAR(255)   NULL,
    "tx_ref" TEXT   NULL,
    "tx_att" TEXT   NULL,
    "cd_tipo_norm" SMALLINT   NOT NULL,
    CONSTRAINT "pk_NORMA" PRIMARY KEY (
        "cd_norm"
     )
);

COMMENT ON COLUMN "NORMA".cd_norm IS 'Código identificador da norma.';
COMMENT ON COLUMN "NORMA".num_norm IS 'Número da norma. Exemplo: n° 4.037.';
COMMENT ON COLUMN "NORMA".ts_doc IS 'Data/hora do documento.';
COMMENT ON COLUMN "NORMA".tx_asst IS 'Assunto da norma.';
COMMENT ON COLUMN "NORMA".tx_desc IS 'Descrição da norma.';
COMMENT ON COLUMN "NORMA".tx_resp IS 'Responsável pela norma.';
COMMENT ON COLUMN "NORMA".tx_dou IS 'Texto referente ao documento publicado no Diário Oficial da União. Exemplo: Publicada no DOU de 17/7/2020, Seção 1, p. 23/24.';
COMMENT ON COLUMN "NORMA".tx_ref IS 'Texto das referencias. Exemplo de referências: Base Legal e Regulamentar, Citações e Revogações.';
COMMENT ON COLUMN "NORMA".tx_att IS 'Texto com as atualizações da norma. Exemplo: Resolução CMN nº 4.721/2019 - Revogação do art. 2º, § 5º, inciso II.';
COMMENT ON COLUMN "NORMA".cd_tipo_norm IS 'Código identificador do tipo da norma.';

ALTER TABLE "NORMA" ADD CONSTRAINT "fk_NORMA_cd_tipo_norm" FOREIGN KEY("cd_tipo_norm")
REFERENCES "DOMINIO_TIPO_NORMA" ("cd_tipo_norm");