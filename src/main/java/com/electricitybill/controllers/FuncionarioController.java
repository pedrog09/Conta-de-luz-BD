package com.electricitybill.controllers;

import com.electricitybill.entity.Funcionario;
import com.electricitybill.entity.Pessoa;
import com.electricitybill.repository.FuncionarioRepository;
import com.electricitybill.service.impl.FuncionarioServiceImpl;
import jakarta.persistence.NoResultException;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class FuncionarioController {

    public static void main(String[] args) throws SQLException {

        // TODO Call the service layer to use methods
        Scanner scan = new Scanner(System.in);
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        FuncionarioServiceImpl funcionarioService = new FuncionarioServiceImpl(funcionarioRepository);

        // TODO test methods
        var funcionario = new Funcionario();
        var pessoa = new Pessoa();

        System.out.println("1: CREATE funcionario" + " / 2: UPDATE funcionario" + " / 3: DELETE funcionario" + " / 4: FIND_BY_ID" +
                " / 5: FINDALL");
        int numero = scan.nextInt();

        switch (numero) {
            case 1 -> {
                funcionario.setCodigoFuncional("0123.4567");
                pessoa.setId(4);
                funcionario.setPessoa(pessoa);
                System.out.println("Saved: " + funcionarioService.save(funcionario));
            }
            case 2 -> {
                System.out.println("Qual ID deseja atualizar: ");
                int idUpdate = scan.nextInt();
                if (Objects.isNull(funcionarioService.findById(idUpdate))) {
                    throw new NoResultException("Employee not found!");
                }
                funcionario.setCodigoFuncional("4567.0123");
                pessoa.setId(7);
                funcionario.setPessoa(pessoa);
                System.out.println("Updated: " + funcionarioService.update(idUpdate, funcionario));
            }
            case 3 -> {
                System.out.println("Qual ID deseja apagar: ");
                int idDelete = scan.nextInt();
                if (Objects.isNull(funcionarioService.findById(idDelete))) {
                    throw new NoResultException("Employee not found!");
                }
                System.out.println("Deleted: " + funcionarioService.delete(idDelete));
            }
            case 4 -> {
                System.out.println("Qual ID deseja buscar: ");
                int idSearch = scan.nextInt();
                if (Objects.isNull(funcionarioService.findById(idSearch))) {
                    throw new NoResultException("Individual search not found!");
                }
                System.out.println("Individual search: " + funcionarioService.findById(idSearch));
            }
            case 5 -> {
                if (funcionarioService.findFuncionarioHasPessoa().isEmpty()) {
                    throw new NoResultException("Search not found!");
                }
                System.out.println("Search: " + funcionarioService.findFuncionarioHasPessoa());
            }
            default -> System.out.println("Invalid option, Err!");
        }
    }
}
