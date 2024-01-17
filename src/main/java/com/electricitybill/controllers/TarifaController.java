package com.electricitybill.controllers;

import com.electricitybill.entity.Tarifa;
import com.electricitybill.repository.TarifaRepository;
import com.electricitybill.service.impl.TarifaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class TarifaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        TarifaRepository tarifaRepository = new TarifaRepository();
        TarifaServiceImpl tarifaService = new TarifaServiceImpl(tarifaRepository);

        // TODO test methods
        var tarifa = new Tarifa();

        System.out.println("1: CREATE tarifa" + " / 2: UPDATE tarifa" + " / 3: DELETE tarifa" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                tarifa.setTaxa("Bandeira Amarela");
                tarifa.setClasseId(1);
                tarifa.setLei("Não");
                tarifa.setDataInicio(Date.valueOf(LocalDate.now()));
                tarifa.setDataFim(Date.valueOf(LocalDate.now().plusMonths(1)));
                tarifa.setAliquotaIcms("17%");
                System.out.println("Saved: " + tarifaService.save(tarifa));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(tarifaService.findById(idUpdate))) {
                    throw new NoResultException("Tax not found!");
                }
                tarifa.setTaxa("Bandeira Verde");
                tarifa.setClasseId(1);
                tarifa.setLei("Não");
                tarifa.setDataInicio(Date.valueOf(LocalDate.now().plusDays(7)));
                tarifa.setDataFim(Date.valueOf(LocalDate.now().plusDays(7).plusMonths(1)));
                tarifa.setAliquotaIcms("15%");
                System.out.println("Updated: " + tarifaService.update(idUpdate, tarifa));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(tarifaService.findById(idDelete))) {
                    throw new NoResultException("Tax not found!");
                }
                System.out.println("Deleted: " + tarifaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(tarifaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + tarifaService.findById(idSearch));
            }
            case 5 -> {
                if (tarifaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + tarifaService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
