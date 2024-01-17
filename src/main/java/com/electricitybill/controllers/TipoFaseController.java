package com.electricitybill.controllers;

import com.electricitybill.entity.TipoFase;
import com.electricitybill.repository.TipoFaseRepository;
import com.electricitybill.service.impl.TipoFaseServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class TipoFaseController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        TipoFaseRepository repository = new TipoFaseRepository();
        TipoFaseServiceImpl tipoFaseService = new TipoFaseServiceImpl(repository);

        // TODO test methods
        var tipoFase = new TipoFase();

        System.out.println("1: CREATE tipoFase" + " / 2: UPDATE tipoFase" + " / 3: DELETE tipoFase" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                tipoFase.setDescricao("Teste");
                System.out.println("Saved: " + tipoFaseService.save(tipoFase));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(tipoFaseService.findById(idUpdate))) {
                    throw new NoResultException("Phase type not found!");
                }
                tipoFase.setDescricao("Teste Atualizado");
                System.out.println("Updated: " + tipoFaseService.update(idUpdate, tipoFase));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(tipoFaseService.findById(idDelete))) {
                    throw new NoResultException("Phase type not found!");
                }
                System.out.println("Deleted: " + tipoFaseService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(tipoFaseService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + tipoFaseService.findById(idSearch));
            }
            case 5 -> {
                if (tipoFaseService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + tipoFaseService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
