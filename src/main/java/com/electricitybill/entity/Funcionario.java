package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Funcionario {

    private int id;

    private String codigoFuncional;

    private Pessoa pessoa;
}
