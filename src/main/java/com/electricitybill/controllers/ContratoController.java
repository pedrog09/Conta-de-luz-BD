package com.electricitybill.controllers;

import com.electricitybill.entity.Contrato;
import com.electricitybill.repository.ContratoRepository;
import com.electricitybill.service.impl.ContratoServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ContratoController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        ContratoRepository contratoRepository = new ContratoRepository();
        ContratoServiceImpl contratoService = new ContratoServiceImpl(contratoRepository);

        // TODO test methods
        var contrato = new Contrato();
        var timeStamp = new Timestamp(System.currentTimeMillis());

        System.out.println("1: CREATE contrato" + " / 2: UPDATE contrato" + " / 3: DELETE contrato" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int numero = scan.nextInt();

        switch (numero) {
            case 1 -> {
                contrato.setDescricao("Funcionando normalmente");
                contrato.setDataInicio(Date.valueOf(LocalDate.now()));
                contrato.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                contrato.setMedidorId(1);
                contrato.setClasseId(1);
                contrato.setTipoFase(1);
                contrato.setClienteId(1);
                System.out.println("Saved: " + contratoService.save(contrato));
            }
            case 2 -> {
                System.out.println("Qual ID deseja mudar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(contratoService.findById(idUpdate))) {
                    throw new NoResultException("Contract not found!");
                }
                contrato.setDescricao("Alterado.");
                contrato.setDataInicio(Date.valueOf(LocalDate.now()));
                contrato.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                contrato.setMedidorId(1);
                contrato.setClasseId(1);
                contrato.setTipoFase(1);
                contrato.setClienteId(1);
                System.out.println("Updated: " + contratoService.update(idUpdate, contrato));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(contratoService.findById(idDelete))) {
                    throw new NoResultException("Contract not found!");
                }
                System.out.println("Deleted: " + contratoService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(contratoService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + contratoService.findById(idSearch));
            }
            case 5 -> {
                if (contratoService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + contratoService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
