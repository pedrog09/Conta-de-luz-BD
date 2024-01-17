CREATE TABLE public.poste
(
    id         serial NOT NULL,
    latitude   varchar(45) NULL,
    longitude  varchar(45) NULL,
    codigo     varchar(45) NULL,
    observacao varchar(45) NULL,
    CONSTRAINT poste_pkey PRIMARY KEY (id)
);
