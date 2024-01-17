package com.electricitybill.controllers;

import com.electricitybill.entity.Cobranca;
import com.electricitybill.repository.CobrancaRepository;
import com.electricitybill.service.impl.CobrancaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class CobrancaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        CobrancaRepository cobrancaRepository = new CobrancaRepository();
        CobrancaServiceImpl cobrancaService = new CobrancaServiceImpl(cobrancaRepository);

        // TODO test methods
        var cobranca = new Cobranca();

        System.out.println("1: CREATE cobranca" + " / 2: UPDATE cobranca" + " / 3: DELETE cobranca" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");

        int numero = scan.nextInt();

        switch (numero) {
            case 1 -> {
                cobranca.setMesReferencia(String.valueOf(LocalDate.now().getMonth()));
                cobranca.setAnoReferencia(String.valueOf(LocalDate.now().getYear()));
                cobranca.setTarifaId(1);
                cobranca.setMedicaoId(2);
                System.out.println("created " + cobrancaService.save(cobranca));
            }
            case 2 -> {
                System.out.println("Qual ID deseja mudar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(cobrancaService.findById(idUpdate))) {
                    throw new NoResultException("Billing not found!");
                }
                cobranca.setMesReferencia(String.valueOf(LocalDate.now().plusMonths(1).getMonth()));
                cobranca.setAnoReferencia(String.valueOf(LocalDate.now().getYear()));
                cobranca.setTarifaId(1);
                cobranca.setMedicaoId(2);
                System.out.println("Updated: " + cobrancaService.update(idUpdate, cobranca));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(cobrancaService.findById(idDelete))) {
                    throw new NoResultException("Billing not found!");
                }
                System.out.println("Deleted: " + cobrancaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID quer buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(cobrancaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + cobrancaService.findById(idSearch));
            }
            case 5 -> {
                if (cobrancaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + cobrancaService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
