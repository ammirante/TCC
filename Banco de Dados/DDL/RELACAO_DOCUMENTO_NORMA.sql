CREATE TABLE "RELACAO_DOCUMENTO_NORMA" (
    "cd_norm" INT   NOT NULL,
    "cd_doc" INT   NOT NULL,
    CONSTRAINT "pk_RELACAO_DOCUMENTO_NORMA" PRIMARY KEY (
        "cd_norm","cd_doc"
     )
);

COMMENT ON COLUMN "RELACAO_DOCUMENTO_NORMA".cd_norm IS 'Código identificador da norma.';
COMMENT ON COLUMN "RELACAO_DOCUMENTO_NORMA".cd_doc IS 'Código identificador do documento.';

ALTER TABLE "RELACAO_DOCUMENTO_NORMA" ADD CONSTRAINT "fk_RELACAO_DOCUMENTO_NORMA_cd_norm" FOREIGN KEY("cd_norm")
REFERENCES "NORMA" ("cd_norm");

ALTER TABLE "RELACAO_DOCUMENTO_NORMA" ADD CONSTRAINT "fk_RELACAO_DOCUMENTO_NORMA_cd_doc" FOREIGN KEY("cd_doc")
REFERENCES "DOCUMENTO" ("cd_doc");