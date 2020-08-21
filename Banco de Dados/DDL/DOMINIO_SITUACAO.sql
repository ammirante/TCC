CREATE TABLE "DOMINIO_SITUACAO" (
    "cd_sit" SMALLINT   NOT NULL,
    "tx_nome" VARCHAR(50)   NOT NULL,
    CONSTRAINT "pk_DOMINIO_SITUACAO" PRIMARY KEY (
        "cd_sit"
     )
);

COMMENT ON COLUMN "DOMINIO_SITUACAO".cd_sit IS 'Código identificador da situação.';
COMMENT ON COLUMN "DOMINIO_SITUACAO".tx_nome IS 'Nome da situação.';