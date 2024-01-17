package com.electricitybill.controllers;

import com.electricitybill.entity.Cliente;
import com.electricitybill.repository.ClienteRepository;
import com.electricitybill.service.impl.ClienteServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class ClienteController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteServiceImpl clienteService = new ClienteServiceImpl(clienteRepository);

        // TODO test methods
        var cliente = new Cliente();

        System.out.println("1: CREATE cliente" + " / 2: UPDATE cliente" + " / 3: DELETE cliente" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int numero = scan.nextInt();

        switch (numero) {
            case 1 -> {
                cliente.setNumDocumento("0123.4567");
                cliente.setNumCliente("0001");
                cliente.setPessoaId(4);
                System.out.println("Saved: " + clienteService.save(cliente));
            }
            case 2 -> {
                System.out.println("Qual ID deseja mudar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(clienteService.findById(idUpdate))) {
                    throw new NoResultException("Client not found!");
                }
                cliente.setNumDocumento("4567.0123");
                cliente.setNumCliente("0002");
                cliente.setPessoaId(4);
                System.out.println("Updated: " + clienteService.update(idUpdate, cliente));
            }
            case 3 -> {
                System.out.println("Qual ID deseja deletar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(clienteService.findById(idDelete))) {
                    throw new NoResultException("Client not found!");
                }
                System.out.println("Deleted: " + clienteService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(clienteService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + clienteService.findById(idSearch));
            }
            case 5 -> {
                if (clienteService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + clienteService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
