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