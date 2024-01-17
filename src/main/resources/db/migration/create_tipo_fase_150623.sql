CREATE TABLE public.tipo_fase
(
    id        serial       NOT NULL,
    descricao varchar(255) NOT NULL,
    CONSTRAINT tipo_fase_descricao_key UNIQUE (descricao),
    CONSTRAINT tipo_fase_pkey PRIMARY KEY (id)
);