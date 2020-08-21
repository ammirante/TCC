CREATE TABLE "RELACAO_NORMA" (
    "cd_norm" INT   NOT NULL,
    "cd_norm2" INT   NOT NULL,
    CONSTRAINT "pk_RELACAO_NORMA" PRIMARY KEY (
        "cd_norm","cd_norm2"
     )
);

COMMENT ON COLUMN "RELACAO_NORMA".cd_norm IS 'Código identificador da norma.';
COMMENT ON COLUMN "RELACAO_NORMA".cd_norm2 IS 'Código identificador da segunda norma.';

ALTER TABLE "RELACAO_NORMA" ADD CONSTRAINT "fk_RELACAO_NORMA_cd_norm" FOREIGN KEY("cd_norm")
REFERENCES "NORMA" ("cd_norm");

ALTER TABLE "RELACAO_NORMA" ADD CONSTRAINT "fk_RELACAO_NORMA_cd_norm2" FOREIGN KEY("cd_norm2")
REFERENCES "NORMA" ("cd_norm");