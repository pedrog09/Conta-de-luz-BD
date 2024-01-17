package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contrato {

    private int id;

    private String descricao;

    private Date dataInicio;

    private Date dataFim;

    private int medidorId;

    private int classeId;

    private int tipoFase;

    private int clienteId;
}
