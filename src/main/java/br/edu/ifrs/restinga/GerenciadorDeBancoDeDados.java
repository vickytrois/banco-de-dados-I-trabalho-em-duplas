package br.edu.ifrs.restinga;

import java.sql.*;

public class GerenciadorDeBancoDeDados {
    private Connection conexao;
    private String url;
    private String usuario;
    private String senha;

    public GerenciadorDeBancoDeDados() {
        this.setUrl("jdbc:mysql://localhost:3306/cinema");
        this.setUsuario("root");
        this.setSenha("@Senh4mySQL");
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void estabeleceConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);
            System.out.println("Conexão ao banco ce dados estabelecida com sucesso.");
        } catch (Exception excecao) {
            System.out.println("Falha ao conectar ao banco de dados: " + excecao.getMessage());
        }
    }

    public void fechaConexao() {
        try {
            if (conexao != null) {
                conexao.close();
                System.out.println("Conexão com o banco encerrada.");
            }
        } catch (SQLException excecao) {
            System.out.println("Falha ao encerrar conexão com o banco de dados: " + excecao.getMessage());
        }
    }
}
