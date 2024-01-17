package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private int id;

    private String nome;

    private String cpf;

    private String cnpj;

    private TipoPessoa tipoPessoa;
}
