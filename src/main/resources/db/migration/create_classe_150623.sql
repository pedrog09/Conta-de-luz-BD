CREATE TABLE public.classe
(
    id           serial NOT NULL,
    descricao    varchar(255) NULL,
    tipo_fase_id int NULL,
    CONSTRAINT classe_pkey PRIMARY KEY (id)
);
ALTER TABLE public.classe ADD CONSTRAINT classe_tipo_fase_id_fkey FOREIGN KEY (tipo_fase_id) REFERENCES public.tipo_fase (id);