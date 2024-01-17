CREATE TABLE public.medicao
(
    id           serial      NOT NULL,
    mes          varchar(45)   NOT NULL,
    ano          varchar(45)   NOT NULL,
    data_medicao timestamp NULL,
    consumo      varchar(45) not null,
    medidor_id   int         NOT NULL,
    time_rota_id int         NOT NULL,
    CONSTRAINT medicao_pkey PRIMARY KEY (id)
);
ALTER TABLE public.medicao
    ADD CONSTRAINT medica_medidor_id_fkey FOREIGN KEY (medidor_id) REFERENCES public.medidor (id);
ALTER TABLE public.medicao
    ADD CONSTRAINT medica_time_rota_id_fkey FOREIGN KEY (time_rota_id) REFERENCES public.time_rota (id);