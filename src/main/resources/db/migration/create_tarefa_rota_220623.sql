CREATE TABLE public.tarefa_rota
(
    id           serial NOT NULL,
    observacao    varchar(255) NULL,
    data_inicio timestamp NULL,
    data_fim    timestamp NULL,
    rota_id  int NULL,
    CONSTRAINT tarefa_rota_pkey PRIMARY KEY (id)
);
ALTER TABLE public.tarefa_rota ADD CONSTRAINT tarefa_rota_rota_id_fkey FOREIGN KEY (rota_id) REFERENCES public.rota (id);