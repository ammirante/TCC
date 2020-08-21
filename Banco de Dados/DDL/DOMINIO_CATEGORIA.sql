CREATE TABLE "DOMINIO_CATEGORIA" (
    "cd_cat" SMALLINT   NOT NULL,
    "tx_nome" VARCHAR(50)   NOT NULL,
    CONSTRAINT "pk_DOMINIO_CATEGORIA" PRIMARY KEY (
        "cd_cat"
     )
);

COMMENT ON COLUMN "DOMINIO_CATEGORIA".cd_cat IS 'Código identificador da categoria.';
COMMENT ON COLUMN "DOMINIO_CATEGORIA".tx_nome IS 'Nome da situação.';