CREATE TABLE public.time_rota
(
    id             serial NOT NULL,
    funcionario_id int    NOT NULL,
    tarefa_rota_id int    NOT NULL,
    CONSTRAINT time_rota_pkey PRIMARY KEY (id)
);
ALTER TABLE public.time_rota
    ADD CONSTRAINT time_rota_funcionario_id_fkey FOREIGN KEY (funcionario_id) REFERENCES public.funcionario (id);
ALTER TABLE public.time_rota
    ADD CONSTRAINT time_rota_tarefa_rota_id_fkey FOREIGN KEY (tarefa_rota_id) REFERENCES public.tarefa_rota (id);