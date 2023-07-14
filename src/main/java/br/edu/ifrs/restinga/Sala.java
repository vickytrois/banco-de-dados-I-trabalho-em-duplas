package br.edu.ifrs.restinga;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sala {
    private String nomeSala;
    private int capacidade;

    public Sala(String nomeSala, int capacidade) {
        this.nomeSala = nomeSala;
        this.capacidade = capacidade;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void insereSala() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        // já que vamos ter que atualizar o script do banco para adicionar o idSala,
        // TODO: decidir se queremos refatorar os nomes das colunas para que todos comecem com letra minúscula
        String consulta = "INSERT INTO Sala (NomeSala, Capacidade) VALUES (?, ?)";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeInsercao = gerenciadorBD.getConexao().prepareStatement(consulta);
            declaracaoDeInsercao.setString(1, nomeSala);
            declaracaoDeInsercao.setInt(2, capacidade);

            declaracaoDeInsercao.executeUpdate();

            System.out.println("Sala inserida com sucesso.");
        } catch (Exception excecao) {
            System.out.println("Falha ao inserir sala." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public void atualizaSala() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "UPDATE Sala SET NomeSala = ? Capacidade = ? WHERE idSala = ?";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeAtualizacao = gerenciadorBD.getConexao().prepareStatement(consulta);
            declaracaoDeAtualizacao.setString(1, nomeSala);
            declaracaoDeAtualizacao.setInt(2, capacidade);
            // TODO: criar idSala no script do banco
            // declaracaoDeAtualizacao.setInt(3, idSala);

            declaracaoDeAtualizacao.executeUpdate();

            System.out.println("Sala atualizada com sucesso.");
        } catch (Exception excecao) {
            System.out.println("Falha ao atualizar sala." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public void deletaSala() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "DELETE FROM Sala WHERE idSala = ?";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeDelecao = gerenciadorBD.getConexao().prepareStatement(consulta);
            // TODO: criar idSala no script do banco
            // declaracaoDeDelecao.setInt(1, idSala);

            declaracaoDeDelecao.executeUpdate();

            System.out.println("Sala deletada com sucesso.");
        } catch (Exception excecao) {
            System.out.println("Falha ao deletar sala." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public void selecionaSala() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "SELECT * FROM Sala";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeSelecao = gerenciadorBD.getConexao().prepareStatement(consulta);
            // TODO: criar idSala no script do banco
            // declaracaoDeSelecao.setInt(1, idSala);

            ResultSet resultadoDaSelecao = declaracaoDeSelecao.executeQuery();

            if (resultadoDaSelecao.next()) {
                int id = resultadoDaSelecao.getInt("idSala");
                String nome = resultadoDaSelecao.getString("NomeSala");
                int capacidade = resultadoDaSelecao.getInt("capacidade");

                System.out.println("ID: " + id + ", Nome: " + nome);
            } else {
                // TODO: criar idSala no script do banco
                // System.out.println("Nenhuma sala encontrada com o ID: " + idSala);
            }

            resultadoDaSelecao.close();
            declaracaoDeSelecao.close();
        } catch (SQLException e) {
            System.out.println("Falha ao selecionar sala: " + e.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }
}
