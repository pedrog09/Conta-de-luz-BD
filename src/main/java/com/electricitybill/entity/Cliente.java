package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {


    private int id;

    private String numDocumento;

    private String numCliente;

    private int pessoaId;
}
