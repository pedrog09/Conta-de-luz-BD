package com.electricitybill.controllers;

import com.electricitybill.entity.Pessoa;
import com.electricitybill.entity.TipoPessoa;
import com.electricitybill.repository.PessoaRepository;
import com.electricitybill.service.impl.PessoaServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class PessoaController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        PessoaRepository pessoaRepository = new PessoaRepository();
        PessoaServiceImpl pessoaService = new PessoaServiceImpl(pessoaRepository);

        // TODO test methods
        var pessoa = new Pessoa();
        var tipoPessoa = new TipoPessoa();

        System.out.println("1: CREATE pessoa" +
                " / 2: UPDATE pessoa" +
                " / 3: DELETE pessoa" +
                " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int numero = scan.nextInt();

        switch (numero) {
            case 1 -> {
                pessoa.setNome("Pedro Guilherme");
                pessoa.setCpf("099.149.543-83");
                pessoa.setCnpj("54.734.874/0001-66");
                tipoPessoa.setId(1);
                pessoa.setTipoPessoa(tipoPessoa);
                System.out.println("Saved: " + pessoaService.save(pessoa));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(pessoaService.findById(idUpdate))) {
                    throw new NoResultException("Person not found!");
                }
                pessoa.setNome("Pedro Guilherme de Sousa Olegário");
                pessoa.setCpf("553.764.903-34");
                pessoa.setCnpj("21.365.875/0001-78");
                tipoPessoa.setId(2);
                pessoa.setTipoPessoa(tipoPessoa);
                System.out.println("Updated: " + pessoaService.update(idUpdate, pessoa));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(pessoaService.findById(idDelete))) {
                    throw new NoResultException("Person not found!");
                }
                System.out.println("Deleted: " + pessoaService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(pessoaService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + pessoaService.findById(idSearch));
            }
            case 5 -> {
                if (pessoaService.findAll().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + pessoaService.findAll());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
