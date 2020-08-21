-- ATENÇÃO OS COMANDOS LISTADOS ABAIXO DELETARÃO TODO O BANCO --
/*
DROP TABLE IF EXISTS "PESSOA" CASCADE;
DROP TABLE IF EXISTS "NORMA" CASCADE;
DROP TABLE IF EXISTS "DOCUMENTO" CASCADE;
DROP TABLE IF EXISTS "POSTAGEM" CASCADE;
DROP TABLE IF EXISTS "RELACAO_DOCUMENTO_NORMA" CASCADE;
DROP TABLE IF EXISTS "RELACAO_NORMA" CASCADE;
DROP TABLE IF EXISTS "RELACAO_POSTAGEM_NORMA" CASCADE;
DROP TABLE IF EXISTS "RELACAO_POSTAGEM_CATEGORIA" CASCADE;
DROP TABLE IF EXISTS "DOMINIO_TIPO_NORMA" CASCADE;
DROP TABLE IF EXISTS "DOMINIO_CATEGORIA" CASCADE;
DROP TABLE IF EXISTS "DOMINIO_SITUACAO" CASCADE;
*/

-- CRIAÇÃO DAS TABELAS --
CREATE TABLE "PESSOA" (    
    "cd_pss"  SERIAL  NOT NULL, 
    "tx_nome" VARCHAR(100)   NOT NULL,    
    "dt_nsc" DATE   NULL,   
    "dt_cad" DATE   NOT NULL,    
    "tx_mail" VARCHAR(100)   NULL,    
    "tx_nome_usr" VARCHAR(30)   NOT NULL,    
    "tx_snh" VARCHAR(64)   NOT NULL,    
    "dt_atlc" TIMESTAMP   NOT NULL,
    CONSTRAINT "pk_PESSOA" PRIMARY KEY (
        "cd_pss"
     ),
    CONSTRAINT "uc_PESSOA_tx_nome_usr" UNIQUE (
        "tx_nome_usr"
    )
);

COMMENT ON COLUMN "PESSOA".cd_pss IS 'Código identificador da pessoa.';
COMMENT ON COLUMN "PESSOA".cd_pss IS ' Data de nascimento da pessoa.';
COMMENT ON COLUMN "PESSOA".cd_pss IS 'Data de cadastro da pessoa.';
COMMENT ON COLUMN "PESSOA".cd_pss IS 'E-mail da pessoa.';
COMMENT ON COLUMN "PESSOA".cd_pss IS 'Nome do usuário da pessoa. Exemplo: douglas.cunha';
COMMENT ON COLUMN "PESSOA".cd_pss IS 'Hash da senha.';
COMMENT ON COLUMN "PESSOA".cd_pss IS 'Data/hora da atualização da pessoa.';

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

CREATE TABLE "RELACAO_DOCUMENTO_NORMA" (
    "cd_norm" INT   NOT NULL,
    "cd_doc" INT   NOT NULL,
    CONSTRAINT "pk_RELACAO_DOCUMENTO_NORMA" PRIMARY KEY (
        "cd_norm","cd_doc"
     )
);

COMMENT ON COLUMN "RELACAO_DOCUMENTO_NORMA".cd_norm IS 'Código identificador da norma.';
COMMENT ON COLUMN "RELACAO_DOCUMENTO_NORMA".cd_doc IS 'Código identificador do documento.';

CREATE TABLE "RELACAO_NORMA" (
    "cd_norm" INT   NOT NULL,
    "cd_norm2" INT   NOT NULL,
    CONSTRAINT "pk_RELACAO_NORMA" PRIMARY KEY (
        "cd_norm","cd_norm2"
     )
);

COMMENT ON COLUMN "RELACAO_NORMA".cd_norm IS 'Código identificador da norma.';
COMMENT ON COLUMN "RELACAO_NORMA".cd_norm2 IS 'Código identificador da segunda norma.';

CREATE TABLE "RELACAO_POSTAGEM_NORMA" (
    "cd_post" INT   NOT NULL,
    "cd_norm" INT   NOT NULL,
    CONSTRAINT "pk_RELACAO_POSTAGEM_NORMA" PRIMARY KEY (
        "cd_post","cd_norm"
     )
);

COMMENT ON COLUMN "RELACAO_POSTAGEM_NORMA".cd_post IS 'Código identificador do post.';
COMMENT ON COLUMN "RELACAO_POSTAGEM_NORMA".cd_norm IS 'Código identificador da norma.';

CREATE TABLE "RELACAO_POSTAGEM_CATEGORIA" (
    "cd_post" INT   NOT NULL,
    "cd_cat" SMALLINT   NOT NULL,
    CONSTRAINT "pk_RELACAO_POSTAGEM_CATEGORIA" PRIMARY KEY (
        "cd_post","cd_cat"
     )
);

COMMENT ON COLUMN "RELACAO_POSTAGEM_CATEGORIA".cd_post IS 'Código identificador da postagem.';
COMMENT ON COLUMN "RELACAO_POSTAGEM_CATEGORIA".cd_cat IS 'Código identificador da categoria.';

CREATE TABLE "DOMINIO_TIPO_NORMA" (
    "cd_tipo_norm" SMALLINT   NOT NULL,
    "tx_nome" VARCHAR(50)   NOT NULL,
    CONSTRAINT "pk_DOMINIO_TIPO_NORMA" PRIMARY KEY (
        "cd_tipo_norm"
     )
);

COMMENT ON COLUMN "DOMINIO_TIPO_NORMA".cd_tipo_norm IS 'Código identificador do tipo da norma.';
COMMENT ON COLUMN "DOMINIO_TIPO_NORMA".tx_nome IS 'Nome do tipo da norma.';

CREATE TABLE "DOMINIO_CATEGORIA" (
    "cd_cat" SMALLINT   NOT NULL,
    "tx_nome" VARCHAR(50)   NOT NULL,
    CONSTRAINT "pk_DOMINIO_CATEGORIA" PRIMARY KEY (
        "cd_cat"
     )
);

COMMENT ON COLUMN "DOMINIO_CATEGORIA".cd_cat IS 'Código identificador da categoria.';
COMMENT ON COLUMN "DOMINIO_CATEGORIA".tx_nome IS 'Nome da situação.';

CREATE TABLE "DOMINIO_SITUACAO" (
    "cd_sit" SMALLINT   NOT NULL,
    "tx_nome" VARCHAR(50)   NOT NULL,
    CONSTRAINT "pk_DOMINIO_SITUACAO" PRIMARY KEY (
        "cd_sit"
     )
);

COMMENT ON COLUMN "DOMINIO_SITUACAO".cd_sit IS 'Código identificador da situação.';
COMMENT ON COLUMN "DOMINIO_SITUACAO".tx_nome IS 'Nome da situação.';

-- ALTERAÇÕES DE ESTRUTURA --
ALTER TABLE "NORMA" ADD CONSTRAINT "fk_NORMA_cd_tipo_norm" FOREIGN KEY("cd_tipo_norm")
REFERENCES "DOMINIO_TIPO_NORMA" ("cd_tipo_norm");

ALTER TABLE "POSTAGEM" ADD CONSTRAINT "fk_POSTAGEM_cd_sit" FOREIGN KEY("cd_sit")
REFERENCES "DOMINIO_SITUACAO" ("cd_sit");

ALTER TABLE "POSTAGEM" ADD CONSTRAINT "fk_POSTAGEM_cd_pss" FOREIGN KEY("cd_pss")
REFERENCES "PESSOA" ("cd_pss");

ALTER TABLE "RELACAO_DOCUMENTO_NORMA" ADD CONSTRAINT "fk_RELACAO_DOCUMENTO_NORMA_cd_norm" FOREIGN KEY("cd_norm")
REFERENCES "NORMA" ("cd_norm");

ALTER TABLE "RELACAO_DOCUMENTO_NORMA" ADD CONSTRAINT "fk_RELACAO_DOCUMENTO_NORMA_cd_doc" FOREIGN KEY("cd_doc")
REFERENCES "DOCUMENTO" ("cd_doc");

ALTER TABLE "RELACAO_NORMA" ADD CONSTRAINT "fk_RELACAO_NORMA_cd_norm" FOREIGN KEY("cd_norm")
REFERENCES "NORMA" ("cd_norm");

ALTER TABLE "RELACAO_NORMA" ADD CONSTRAINT "fk_RELACAO_NORMA_cd_norm2" FOREIGN KEY("cd_norm2")
REFERENCES "NORMA" ("cd_norm");

ALTER TABLE "RELACAO_POSTAGEM_NORMA" ADD CONSTRAINT "fk_RELACAO_POSTAGEM_NORMA_cd_post" FOREIGN KEY("cd_post")
REFERENCES "POSTAGEM" ("cd_post");

ALTER TABLE "RELACAO_POSTAGEM_NORMA" ADD CONSTRAINT "fk_RELACAO_POSTAGEM_NORMA_cd_norm" FOREIGN KEY("cd_norm")
REFERENCES "NORMA" ("cd_norm");

ALTER TABLE "RELACAO_POSTAGEM_CATEGORIA" ADD CONSTRAINT "fk_RELACAO_POSTAGEM_CATEGORIA_cd_post" FOREIGN KEY("cd_post")
REFERENCES "POSTAGEM" ("cd_post");

ALTER TABLE "RELACAO_POSTAGEM_CATEGORIA" ADD CONSTRAINT "fk_RELACAO_POSTAGEM_CATEGORIA_cd_cat" FOREIGN KEY("cd_cat")
REFERENCES "DOMINIO_CATEGORIA" ("cd_cat");

