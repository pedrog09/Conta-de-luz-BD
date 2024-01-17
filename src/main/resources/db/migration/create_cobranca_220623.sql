CREATE TABLE public.cobranca
(
    id           serial      NOT NULL,
    mes_referencia          varchar(45)   NOT NULL,
    ano_referencia          varchar(45)   NOT NULL,
    tarifa_id int         NOT NULL,
    medicao_id   int         NOT NULL,
    CONSTRAINT cobranca_pkey PRIMARY KEY (id)
);
ALTER TABLE public.cobranca
    ADD CONSTRAINT cobranca_tarifa_id_fkey FOREIGN KEY (tarifa_id) REFERENCES public.tarifa (id);
ALTER TABLE public.cobranca
    ADD CONSTRAINT cobranca_medicao_id_fkey FOREIGN KEY (medicao_id) REFERENCES public.medicao (id);