package com.electricitybill.controllers;

import com.electricitybill.entity.TipoPessoa;
import com.electricitybill.repository.TipoPessoaRepository;
import com.electricitybill.service.impl.TipoPessoaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class TipoPessoaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        TipoPessoaRepository tipoPessoaRepository = new TipoPessoaRepository();
        TipoPessoaServiceImpl tipoPessoaService = new TipoPessoaServiceImpl(tipoPessoaRepository);

        // TODO test methods
        var tipoPessoa = new TipoPessoa();

        System.out.println("1: CREATE tipoPessoa" + " / 2: UPDATE tipoPessoa" + " / 3: DELETE tipoPessoa" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                tipoPessoa.setDescricao("Pessoa Física");
                System.out.println("Saved: " + tipoPessoaService.save(tipoPessoa));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(tipoPessoaService.findById(idUpdate))) {
                    throw new NoResultException("Type person type not found!");
                }
                tipoPessoa.setDescricao("Pessoa Juridica");
                System.out.println("Updated: " + tipoPessoaService.update(idUpdate, tipoPessoa));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(tipoPessoaService.findById(idDelete))) {
                    throw new NoResultException("Type person type not found!");
                }
                System.out.println("Deleted: " + tipoPessoaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(tipoPessoaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + tipoPessoaService.findById(idSearch));
            }
            case 5 -> {
                if (tipoPessoaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + tipoPessoaService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
