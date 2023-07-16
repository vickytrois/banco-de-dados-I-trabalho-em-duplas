package br.edu.ifrs.restinga;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Filme {
    private int idFilme;
    private String nomePTBR;
    private String nomeOriginal;
    private String sinopse;
    private int anoLancamento;

    public Filme(int idFilme, String nomePTBR, String nomeOriginal, String sinopse, int anoLancamento) {
        this.idFilme = idFilme;
        this.nomePTBR = nomePTBR;
        this.nomeOriginal = nomeOriginal;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
    }

    public Filme() {

    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomePTBR() {
        return nomePTBR;
    }

    public void setNomePTBR(String nomePTBR) {
        this.nomePTBR = nomePTBR;
    }

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void insereFilme() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "INSERT INTO Filme (nomePTBR, nomeOriginal, sinopse, anoLancamento) VALUES (?, ?, ?, ?)";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeInsercao = gerenciadorBD.getConexao().prepareStatement(consulta);

            declaracaoDeInsercao.setString(1, this.nomePTBR);
            declaracaoDeInsercao.setString(2, this.nomeOriginal);
            declaracaoDeInsercao.setString(3, this.sinopse);
            declaracaoDeInsercao.setInt(4, this.anoLancamento);

            declaracaoDeInsercao.executeUpdate();

            System.out.println("Filme inserido com sucesso.");

        } catch (Exception excecao) {
            System.out.println("Falha ao inserir filme." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public void atualizaFilme() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "UPDATE Filme SET nomePTBR = ?, nomeOriginal = ? WHERE idFilme = ?";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeAtualizacao = gerenciadorBD.getConexao().prepareStatement(consulta);

            declaracaoDeAtualizacao.setString(1, this.nomePTBR);
            declaracaoDeAtualizacao.setString(2, this.nomeOriginal);
            declaracaoDeAtualizacao.setInt(3, this.idFilme);

            declaracaoDeAtualizacao.executeUpdate();

            declaracaoDeAtualizacao.close();
            gerenciadorBD.encerraConexao();
        } catch (Exception excecao) {
            System.out.println("Falha ao atualizar filme." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public void deletaFilme() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "DELETE FROM Filme WHERE idFilme = ?";

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeDelecao = gerenciadorBD.getConexao().prepareStatement(consulta);

            declaracaoDeDelecao.setInt(1, this.idFilme);
            declaracaoDeDelecao.executeUpdate();
            System.out.println("Filme deletado com sucesso.");

            declaracaoDeDelecao.close();
        } catch (Exception excecao) {
            System.out.println("Falha ao deletar filme." + excecao.getMessage());
        } finally {
            gerenciadorBD.encerraConexao();
        }
    }

    public List<Filme> selecionaFilme() {
        GerenciadorDeBancoDeDados gerenciadorBD = new GerenciadorDeBancoDeDados();
        String consulta = "SELECT * FROM Filme";
        List<Filme> lista = new ArrayList<>();

        gerenciadorBD.estabeleceConexao();

        try {
            PreparedStatement declaracaoDeSelecao = gerenciadorBD.getConexao().prepareStatement(consulta);

            ResultSet resultadoDaSelecao = declaracaoDeSelecao.executeQuery();

            if (resultadoDaSelecao.next()) {
                int id = resultadoDaSelecao.getInt("idFilme");
                String nomePTBR = resultadoDaSelecao.getString("nomePTBR");
                String nomeOriginal = resultadoDaSelecao.getString("nomeOriginal");
                int anoDeLancamento = resultadoDaSelecao.getInt("anoLancamento");
                String sinopse = resultadoDaSelecao.getString("sinopse");

                System.out.println("ID: " + id + "Título em português: " + nomePTBR);
                System.out.println("\tTítulo original: " + nomeOriginal);
                System.out.println("\tAno de lançamento: " + anoDeLancamento);
                System.out.println("\tSinopse: " + sinopse);
            } else {
                System.out.println("Nenhum filme encontrado.");
            }

            resultadoDaSelecao.close();
            declaracaoDeSelecao.close();
        } catch (Exception excecao) {
            System.out.println("Falha no banco de dados. Tente novamente mais tarde.");
        } finally {
            gerenciadorBD.encerraConexao();
        }

        return lista;
    }
}
