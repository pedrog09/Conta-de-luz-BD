CREATE TABLE public.tarifa
(
    id            serial      NOT NULL,
    taxa          varchar(45) NOT NULL,
    classe_id     int         NOT NULL,
    lei           varchar(45) NOT NULL,
    data_inicio   timestamp   NULL,
    data_fim      timestamp   NULL,
    aliquota_ICMS varchar(45) NOT NULL,
    CONSTRAINT tarifa_pkey PRIMARY KEY (id)
);
ALTER TABLE public.tarifa
    ADD CONSTRAINT tarifa_classe_id_fkey FOREIGN KEY (classe_id) REFERENCES public.classe (id);