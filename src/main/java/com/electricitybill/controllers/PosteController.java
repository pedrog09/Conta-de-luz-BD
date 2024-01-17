package com.electricitybill.controllers;

import com.electricitybill.entity.Poste;
import com.electricitybill.repository.PosteRepository;
import com.electricitybill.service.impl.PosteServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class PosteController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        PosteRepository repository = new PosteRepository();
        PosteServiceImpl posteService = new PosteServiceImpl(repository);

        // TODO test methods
        var poste = new Poste();

        System.out.println("1: CREATE poste" + " / 2: UPDATE poste" + " / 3: DELETE poste" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                poste.setLatitude("-142.4093");
                poste.setLongitude("-37.4479");
                poste.setCodigo("647326349");
                poste.setObservacao("Save");
                System.out.println("Saved: " + posteService.save(poste));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(posteService.findById(idUpdate))) {
                    throw new NoResultException("Post not found!");
                }
                poste.setLatitude("58.3731");
                poste.setLongitude("-86.7386");
                poste.setCodigo("647326349");
                poste.setObservacao("Update");
                System.out.println("Updated: " + posteService.update(idUpdate, poste));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(posteService.findById(idDelete))) {
                    throw new NoResultException("Post not found!");
                }
                System.out.println("Deleted: " + posteService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(posteService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + posteService.findById(idSearch));
            }
            case 5 -> {
                if (posteService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + posteService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
