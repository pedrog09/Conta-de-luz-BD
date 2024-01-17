package com.electricitybill.controllers;

import com.electricitybill.entity.TarefaRota;
import com.electricitybill.repository.TarefaRotaRepository;
import com.electricitybill.service.impl.TarefaRotaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class TarefaRotaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        TarefaRotaRepository tarefaRotaRepository = new TarefaRotaRepository();
        TarefaRotaServiceImpl tarefaRotaService = new TarefaRotaServiceImpl(tarefaRotaRepository);

        // TODO test methods
        var tarefaRota = new TarefaRota();

        System.out.println("1: CREATE tarefaRota" + " / 2: UPDATE tarefaRota" + " / 3: DELETE tarefaRota" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                tarefaRota.setObservacao("Tarefa Incompleta");
                tarefaRota.setDataInicio(Date.valueOf(LocalDate.now()));
                tarefaRota.setDataFim(Date.valueOf(LocalDate.now().minusDays(7)));
                tarefaRota.setRotaId(1);
                System.out.println("Saved: " + tarefaRotaService.save(tarefaRota));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(tarefaRotaService.findById(idUpdate))) {
                    throw new NoResultException("Route task not found!");
                }
                tarefaRota.setObservacao("Tarefa Finalizada");
                tarefaRota.setDataInicio(Date.valueOf(LocalDate.now()));
                tarefaRota.setDataFim(Date.valueOf(LocalDate.now().minusDays(7)));
                tarefaRota.setRotaId(1);
                System.out.println("Updated: " + tarefaRotaService.update(idUpdate, tarefaRota));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(tarefaRotaService.findById(idDelete))) {
                    throw new NoResultException("Route task not found!");
                }
                System.out.println("Deleted: " + tarefaRotaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(tarefaRotaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + tarefaRotaService.findById(idSearch));
            }
            case 5 -> {
                if (tarefaRotaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + tarefaRotaService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
