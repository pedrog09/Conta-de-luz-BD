CREATE TABLE public.pessoa
(
    id              serial      NOT NULL,
    nome            varchar(255) NOT NULL,
    cpf             varchar(14) NULL,
    cnpj            varchar(18) NULL,
    tipo_pessoa_id int NULL,
    CONSTRAINT pessoal_cnpj_key UNIQUE (cnpj),
    CONSTRAINT pessoal_cpf_key UNIQUE (cpf),
    CONSTRAINT pessoal_pkey PRIMARY KEY (id)
);
ALTER TABLE public.pessoa ADD CONSTRAINT pessoa_tipo_pessoa_id_fkey FOREIGN KEY (tipo_pessoa_id) REFERENCES public.tipo_pessoa (id);