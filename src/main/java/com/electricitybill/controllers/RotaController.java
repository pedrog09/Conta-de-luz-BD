package com.electricitybill.controllers;

import com.electricitybill.entity.Rota;
import com.electricitybill.repository.RotaRepository;
import com.electricitybill.service.impl.RotaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class RotaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        RotaRepository repository = new RotaRepository();
        RotaServiceImpl rotaService = new RotaServiceImpl(repository);

        // TODO test methods
        var rota = new Rota();

        System.out.println("1: CREATE rota" + " / 2: UPDATE rota" + " / 3: DELETE rota" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                rota.setDescricao("Parque 2 Irmaos");
                System.out.println("Saved: " + rotaService.save(rota));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(rotaService.findById(idUpdate))) {
                    throw new NoResultException("Route not found!");
                }
                rota.setDescricao("Passare");
                System.out.println("Updated: " + rotaService.update(idUpdate, rota));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(rotaService.findById(idDelete))) {
                    throw new NoResultException("Route not found!");
                }
                System.out.println("Deleted: " + rotaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(rotaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + rotaService.findById(idSearch));
            }
            case 5 -> {
                if (rotaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + rotaService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
