CREATE TABLE "DOMINIO_TIPO_NORMA" (
    "cd_tipo_norm" SMALLINT   NOT NULL,
    "tx_nome" VARCHAR(50)   NOT NULL,
    CONSTRAINT "pk_DOMINIO_TIPO_NORMA" PRIMARY KEY (
        "cd_tipo_norm"
     )
);

COMMENT ON COLUMN "DOMINIO_TIPO_NORMA".cd_tipo_norm IS 'Código identificador do tipo da norma.';
COMMENT ON COLUMN "DOMINIO_TIPO_NORMA".tx_nome IS 'Nome do tipo da norma.';