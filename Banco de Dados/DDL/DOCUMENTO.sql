CREATE TABLE "DOCUMENTO" (
    "cd_doc"  SERIAL  NOT NULL,
    "tx_nome" VARCHAR(50)   NOT NULL,
    "by_doc" BYTEA   NOT NULL,
    CONSTRAINT "pk_DOCUMENTO" PRIMARY KEY (
        "cd_doc"
     )
);

COMMENT ON COLUMN "DOCUMENTO".cd_doc IS 'Código identificador do documento.';
COMMENT ON COLUMN "DOCUMENTO".tx_nome IS 'Nome do documento.';
COMMENT ON COLUMN "DOCUMENTO".by_doc IS 'Documento em binário.';