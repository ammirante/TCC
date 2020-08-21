CREATE TABLE "POSTAGEM" (
    "cd_post"  SERIAL  NOT NULL,
    "tx_titu" VARCHAR(50)   NOT NULL,
    "ts_inic" TIMESTAMP   NOT NULL,
    "ts_fim" TIMESTAMP   NULL,
    "tx_desc" TEXT   NOT NULL,
    "tx_ref_link_img_capa" VARCHAR(100)   NOT NULL,
    "cd_sit" SMALLINT   NOT NULL,
    "cd_pss" INT   NOT NULL,
    CONSTRAINT "pk_POSTAGEM" PRIMARY KEY (
        "cd_post"
     ),
    CONSTRAINT "uc_POSTAGEM_tx_titu" UNIQUE (
        "tx_titu"
    )
);

COMMENT ON COLUMN "POSTAGEM".cd_post IS 'Código identificador da postagem.';
COMMENT ON COLUMN "POSTAGEM".tx_titu IS 'Título da postagem.';
COMMENT ON COLUMN "POSTAGEM".ts_inic IS 'Data/hora da postagem.';
COMMENT ON COLUMN "POSTAGEM".ts_fim IS 'Data/hora da inativação da postagem.';
COMMENT ON COLUMN "POSTAGEM".tx_desc IS 'Descrição da postagem.';
COMMENT ON COLUMN "POSTAGEM".tx_ref_link_img_capa IS 'Referência para a imagem da postagem.';
COMMENT ON COLUMN "POSTAGEM".cd_sit IS 'Código identificador da situação da postagem.';
COMMENT ON COLUMN "POSTAGEM".cd_pss IS 'Código identificador da pessoa responsável pela postagem.';

ALTER TABLE "POSTAGEM" ADD CONSTRAINT "fk_POSTAGEM_cd_sit" FOREIGN KEY("cd_sit")
REFERENCES "DOMINIO_SITUACAO" ("cd_sit");

ALTER TABLE "POSTAGEM" ADD CONSTRAINT "fk_POSTAGEM_cd_pss" FOREIGN KEY("cd_pss")
REFERENCES "PESSOA" ("cd_pss");