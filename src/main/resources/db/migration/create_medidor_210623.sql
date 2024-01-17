CREATE TABLE public.medidor
(
    id        serial      NOT NULL,
    descricao varchar(255) NOT NULL,
    id_poste  int NULL,
    id_rota   int NULL,
    CONSTRAINT medidor_descricao_key UNIQUE (descricao),
    CONSTRAINT medidor_pkey PRIMARY KEY (id)
);

ALTER TABLE public.medidor ADD CONSTRAINT medidor_id_poste_fkey FOREIGN KEY (id_poste) REFERENCES public.poste (id);
ALTER TABLE public.medidor ADD CONSTRAINT medidor_id_rota_fkey FOREIGN KEY (id_rota) REFERENCES public.rota (id);