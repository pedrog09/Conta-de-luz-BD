package com.electricitybill.controllers;

import com.electricitybill.entity.Classe;
import com.electricitybill.repository.ClasseRepository;
import com.electricitybill.service.impl.ClasseServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class ClasseController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        ClasseRepository classeRepository = new ClasseRepository();
        ClasseServiceImpl classeService = new ClasseServiceImpl(classeRepository);

        // TODO test methods
        var classe = new Classe();

        System.out.println("1: CREATE classe" + " / 2: UPDATE classe" + " / 3: DELETE classe" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int numero = scan.nextInt();

        switch (numero) {
            case 1 -> {
                classe.setDescricao("Saved Class");
                classe.setTipoFaseId(1);
                System.out.println("Saved: " + classeService.save(classe));
            }
            case 2 -> {
                System.out.println("Qual ID deseja mudar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(classeService.findById(idUpdate))) {
                    throw new NoResultException("Class not found!");
                }
                classe.setDescricao("Updated Class");
                classe.setTipoFaseId(1);
                System.out.println("Updated: " + classeService.update(idUpdate, classe));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(classeService.findById(idDelete))) {
                    throw new NoResultException("Class not found!");
                }
                System.out.println("Deleted: " + classeService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(classeService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + classeService.findById(idSearch));
            }
            case 5 -> {
                if (classeService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + classeService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
