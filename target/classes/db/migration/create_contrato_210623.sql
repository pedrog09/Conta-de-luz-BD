CREATE TABLE public.contrato
(
    id          serial NOT NULL,
    descricao   varchar(255) NULL,
    data_inicio timestamp NULL,
    data_fim    timestamp NULL,
    medidor_id  int NULL,
    classe_id   int NULL,
    tipo_fase   int NULL,
    cliente_id  int NULL,
    CONSTRAINT contrato_pkey PRIMARY KEY (id)
);

ALTER TABLE public.contrato ADD CONSTRAINT contrato_classe_id_fkey FOREIGN KEY (classe_id) REFERENCES public.classe (id);
ALTER TABLE public.contrato ADD CONSTRAINT contrato_cliente_id_fkey FOREIGN KEY (cliente_id) REFERENCES public.cliente (id);
ALTER TABLE public.contrato ADD CONSTRAINT contrato_medidor_id_fkey FOREIGN KEY (medidor_id) REFERENCES public.medidor (id);
ALTER TABLE public.contrato ADD CONSTRAINT contrato_tipo_fase_fkey FOREIGN KEY (tipo_fase) REFERENCES public.tipo_fase (id);