package com.electricitybill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Poste {

    private int id;

    private String latitude;

    private String longitude;

    private String codigo;

    private String observacao;
}
