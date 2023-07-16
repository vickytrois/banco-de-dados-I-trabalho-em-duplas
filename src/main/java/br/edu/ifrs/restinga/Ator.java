package br.edu.ifrs.restinga;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ator {
    private int idAtor;
    private String nomeAtor;

    public Ator(int idAtor, String nomeAtor) {
        this.idAtor = idAtor;
        this.nomeAtor = nomeAtor;
    }

    public Ator(){

    }

    public int getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(int idAtor) {
        this.idAtor = idAtor;
    }

    public String getNomeAtor() {
        return nomeAtor;
    }

    public void setNomeAtor(String nomeAtor) {
        this.nomeAtor = nomeAtor;
    }

    public void insereAtor() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "INSERT INTO Ator (nomeAtor) VALUES (?)";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeInsercao = gerenciadorBD.getConexao().prepareStatement(consulta);
            declaracaoDeInsercao.setString(1, nomeAtor);

            declaracaoDeInsercao.executeUpdate();

            System.out.println("Ator(iz) inserido(a) com sucesso.");
        } catch (Exception excecao) {
            System.out.println("Falha ao inserir ator(iz)." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public void atualizaAtor() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "UPDATE Ator SET nomeAtor = ? WHERE idAtor = ?";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeAtualizacao = gerenciadorBD.getConexao().prepareStatement(consulta);
            declaracaoDeAtualizacao.setString(1, nomeAtor);
            declaracaoDeAtualizacao.setInt(2, idAtor);

            declaracaoDeAtualizacao.executeUpdate();

            System.out.println("Ator(iz) atualizado(a) com sucesso.");
        } catch (Exception excecao) {
            System.out.println("Falha ao atualizar ator(iz)." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public void deletaAtor() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "DELETE FROM Ator WHERE idAtor = ?";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeDelecao = gerenciadorBD.getConexao().prepareStatement(consulta);
            declaracaoDeDelecao.setInt(1, idAtor);

            declaracaoDeDelecao.executeUpdate();

            System.out.println("Ator(iz) deletado(a) com sucesso.");
        } catch (Exception excecao) {
            System.out.println("Falha ao deletar ator(iz)." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public List<Ator> selecionaAtor() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "SELECT * FROM Ator";
        List<Ator> lista = new ArrayList<>();

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeSelecao = gerenciadorBD.getConexao().prepareStatement(consulta);
            declaracaoDeSelecao.setInt(1, idAtor);

            ResultSet resultadoDaSelecao = declaracaoDeSelecao.executeQuery();

            if (resultadoDaSelecao.next()) {
                int id = resultadoDaSelecao.getInt("idAtor");
                String nome = resultadoDaSelecao.getString("nomeAtor");

                System.out.println("ID: " + id + ", Nome: " + nome);
            } else {
                System.out.println("Nenhum ator(iz) encontrado(a) com o ID: " + idAtor);
            }

            resultadoDaSelecao.close();
            declaracaoDeSelecao.close();
        } catch (SQLException e) {
            System.out.println("Falha ao selecionar ator(iz): " + e.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }

        return lista;
    }
}
