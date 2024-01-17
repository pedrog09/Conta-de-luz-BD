CREATE TABLE public.cliente
(
    id            serial     NOT NULL,
    num_documento varchar(45) NULL,
    num_cliente   varchar(45) NULL,
    pessoa_id    int        NULL,
    CONSTRAINT cliente_pkey PRIMARY KEY (id)
);

ALTER TABLE public.cliente ADD CONSTRAINT cliente_pessoa_id_fkey FOREIGN KEY (pessoa_id) REFERENCES public.pessoa (id);