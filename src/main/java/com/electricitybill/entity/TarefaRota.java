package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaRota {

    private int id;

    private String observacao;

    private Date dataInicio;

    private Date dataFim;

    private int rotaId;
}
