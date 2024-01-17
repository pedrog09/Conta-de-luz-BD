package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medicao {

    private int id;

    private String mes;

    private String ano;

    private Date dataMedicao;

    private String consumo;

    private int medidorId;

    private int timeRotaId;
}
