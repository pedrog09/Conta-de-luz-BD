package com.electricitybill.controllers;

import com.electricitybill.entity.TimeRota;
import com.electricitybill.repository.TimeRotaRepository;
import com.electricitybill.service.impl.TimeRotaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class TimeRotaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        TimeRotaRepository timeRotaRepository = new TimeRotaRepository();
        TimeRotaServiceImpl timeRotaService = new TimeRotaServiceImpl(timeRotaRepository);

        // TODO test methods
        var timeRota = new TimeRota();

        System.out.println("1: CREATE cobranca" + " / 2: UPDATE timeRota" + " / 3: DELETE timeRota" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                timeRota.setFuncionarioId(1);
                timeRota.setTarefaRotaId(1);
                System.out.println("Saved: " + timeRotaService.save(timeRota));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(timeRotaService.findById(idUpdate))) {
                    throw new NoResultException("Team route not found!");
                }
                timeRota.setFuncionarioId(1);
                timeRota.setTarefaRotaId(1);
                System.out.println("Updated: " + timeRotaService.update(idUpdate, timeRota));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(timeRotaService.findById(idDelete))) {
                    throw new NoResultException("Team route not found!");
                }
                System.out.println("Deleted: " + timeRotaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(timeRotaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + timeRotaService.findById(idSearch));
            }
            case 5 -> {
                if (timeRotaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + timeRotaService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
