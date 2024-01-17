package com.electricitybill.controllers;

import com.electricitybill.entity.Medicao;
import com.electricitybill.repository.MedicaoRepository;
import com.electricitybill.service.impl.MedicaoServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class MedicaoController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        MedicaoRepository medicaoRepository = new MedicaoRepository();
        MedicaoServiceImpl medicaoService = new MedicaoServiceImpl(medicaoRepository);
        // TODO test methods
        var medicao = new Medicao();

        System.out.println("1: CREATE medicao" + " / 2: UPDATE medicao" + " / 3: DELETE medicao" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                medicao.setMes(String.valueOf(LocalDate.now().getMonth()));
                medicao.setAno(String.valueOf(LocalDate.now().getYear()));
                medicao.setDataMedicao(Date.valueOf(LocalDate.now()));
                medicao.setConsumo("152,2 kWh");
                medicao.setMedidorId(1);
                medicao.setTimeRotaId(1);
                System.out.println("Saved: " + medicaoService.save(medicao));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(medicaoService.findById(idUpdate))) {
                    throw new NoResultException("Measurement not found!");
                }
                medicao.setMes(String.valueOf(LocalDate.now().getMonth()));
                medicao.setAno(String.valueOf(LocalDate.now().getYear()));
                medicao.setDataMedicao(Date.valueOf(LocalDate.now()));
                medicao.setConsumo("187,1 kWh");
                medicao.setMedidorId(1);
                medicao.setTimeRotaId(1);
                System.out.println("Updated: " + medicaoService.update(idUpdate, medicao));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(medicaoService.findById(idDelete))) {
                    throw new NoResultException("Measurement not found!");
                }
                System.out.println("Deleted: " + medicaoService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(medicaoService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + medicaoService.findById(idSearch));
            }
            case 5 -> {
                if (medicaoService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + medicaoService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
