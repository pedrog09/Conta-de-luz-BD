package com.electricitybill.controllers;

import com.electricitybill.entity.Medidor;
import com.electricitybill.repository.MedidorRepository;
import com.electricitybill.service.impl.MedidorServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class MedidorController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        MedidorRepository repository = new MedidorRepository();
        MedidorServiceImpl medidorService = new MedidorServiceImpl(repository);

        // TODO test methods
        var medidor = new Medidor();

        System.out.println("1: CREATE medidor" + " / 2: UPDATE medidor" + " / 3: DELETE medidor" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int numero = scan.nextInt();

        switch (numero) {
            case 1 -> {
                medidor.setDescricao("inválida");
                medidor.setIdPoste(1);
                medidor.setIdRota(1);
                System.out.println("Saved: " + medidorService.save(medidor));
            }
            case 2 -> {
                System.out.println("Qual ID deseja mudar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(medidorService.findById(idUpdate))) {
                    throw new NoResultException("Measurer not found!");
                }
                medidor.setDescricao("válida");
                medidor.setIdPoste(1);
                medidor.setIdRota(1);
                System.out.println("Updated: " + medidorService.update(idUpdate, medidor));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(medidorService.findById(idDelete))) {
                    throw new NoResultException("Measurer not found!");
                }
                System.out.println("Deleted: " + medidorService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(medidorService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + medidorService.findById(idSearch));
            }
            case 5 -> {
                if (medidorService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + medidorService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
