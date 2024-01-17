CREATE TABLE public.funcionario
(
    id               serial NOT NULL,
    codigo_funcional varchar(45) NULL,
    pessoa_id       int NULL,
    CONSTRAINT funcionario_pkey PRIMARY KEY (id)
);
ALTER TABLE public.funcionario ADD CONSTRAINT funcionario_pessoa_id_fkey FOREIGN KEY (pessoa_id) REFERENCES public.pessoa (id);