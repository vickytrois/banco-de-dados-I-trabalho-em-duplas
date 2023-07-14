/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.restinga;

import br.edu.ifrs.Clubes;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author SAMSUNG
 */
public class Main {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String args[]) {
        int opcao = 0;
        
        do {
            geraMenu();

            System.out.println("Digite uma opção válida: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0 -> {
                    System.out.println("Programa encerrado.");
                }
                case 1 -> {
                    insereFilme();
                }
                case 2 -> {
                    atualizaFilme();
                }
                case 3 -> {
                    deletaFilme();
                }
                case 4 -> {
                    selecionaFilme();
                }
                case 5 -> {
                    insereAtor();
                }
                case 6 -> {
                    atualizaAtor();
                }
                case 7 -> {
                    deletaAtor();
                }
                case 8 -> {
                    selecionaAtor();
                }
                case 9 -> {
                    insereSala();
                }
                case 10 -> {
                    atualizaSala();
                }
                case 11 -> {
                    deletaSala();
                }
                case 12 -> {
                    selecionaSala();
                }
                default -> {
                    System.out.println("Opção Inválida!!!");
                }
            }
        } while (opcao != 0);
    }


    private static void geraMenu() {
        System.out.println("----------- Cinema El Paradiso -----------");
        System.out.println("1 - Inserir Filme");
        System.out.println("2 - Atualizar Filme");
        System.out.println("3 - Deletar Filme");
        System.out.println("4 - Listar Filmes");
        System.out.println("5 - Inserir Ator(iz)");
        System.out.println("6 - Atualizar Ator(iz)");
        System.out.println("7 - Deletar Ator(iz)");
        System.out.println("8 - Listar Ator(iz)");
        System.out.println("9 - Inserir Sala");
        System.out.println("10 - Atualizar Sala");
        System.out.println("11 - Deletar Sala");
        System.out.println("12 - Listar Sala");
        System.out.println("0 - Sair do Programa");
        System.out.println("-------------------------------------------");
    }

    private static void insereFilme() {
        Filme filme = new Filme();

        System.out.print("Digite o título do filme em português: ");
        filme.setNomePTBR(entrada.nextLine());

        System.out.print("Digite o título do filme no idioma original: ");
        filme.setNomeOriginal(entrada.nextLine());

        System.out.print("Digite o ano de lançamento do filme: ");
        filme.setAnoLancamento(entrada.nextInt());
        entrada.nextLine();

        System.out.print("Digite a sinopse do filme: ");
        filme.setSinopse(entrada.nextLine());

        filme.insereFilme();
    }

    private static void atualizaFilme() {
        Filme filme = new Filme();

        System.out.print("Digite o id do filme que deseja atualizar: ");
        filme.setIdFilme(entrada.nextInt());
        entrada.nextLine();

        System.out.print("Digite o título do filme em português: ");
        filme.setNomePTBR(entrada.nextLine());

        System.out.print("Digite o título do filme no idioma original: ");
        filme.setNomeOriginal(entrada.nextLine());

        System.out.print("Digite o ano de lançamento do filme: ");
        filme.setAnoLancamento(entrada.nextInt());
        entrada.nextLine();

        System.out.print("Digite a sinopse do filme: ");
        filme.setSinopse(entrada.nextLine());

        filme.atualizaFilme();
    }

    private static void deletaFilme() {
        Filme filme = new Filme();

        System.out.println("Digite o id do filme a ser excluído: ");
        filme.setIdFilme(entrada.nextInt());
        entrada.nextLine();

        filme.deletaFilme();
    }

    private static void selecionaFilme() {
        Filme filme = new Filme();

        List<Filme> lista = filme.selecionaFilme();
        // TODO: conferir quais informações vamos listar na opção de seleção
        // Opções disponíveis:
        // int idFilme, String nomePTBR, String nomeOriginal, String sinopse, int anoLancamento

        // TODO: conferir se o método de seleção já não imprime as informações buscadas
        // TODO: ver com o GPT uma forma interessante de exibir essas informações
        System.out.println("ID Filme | Nome PTBR | Nome Original");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getIdFilme() + " | " + lista.get(i).getNomePTBR() + " | " + lista.get(i).getNomeOriginal());
        }
    }

    private static void insereAtor() {
        // TODO: implementar método para o menu.
    }
    private static void atualizaAtor() {
        // TODO: implementar método para o menu.
    }
    private static void deletaAtor() {
        // TODO: implementar método para o menu.
    }
    private static void selecionaAtor() {
        // TODO: implementar método para o menu.
    }
    private static void insereSala() {
        // TODO: implementar método para o menu.
    }
    private static void atualizaSala() {
        // TODO: implementar método para o menu.
    }
    private static void deletaSala() {
        // TODO: implementar método para o menu.
    }
    private static void selecionaSala() {
        // TODO: implementar método para o menu.
    }
}
