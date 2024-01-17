package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tarifa {

    private int id;

    private String taxa;

    private int classeId;

    private String lei;

    private Date dataInicio;

    private Date dataFim;

    private String aliquotaIcms;
}
