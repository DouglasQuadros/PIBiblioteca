/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Livro;
import servicos.PessoaServicos;
import servicos.ServicosFactory;

/**
 *
 * @author jbferraz
 */
public class LivroDAO {

    public void cadastrarLivroDAO(Livro lVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "insert into carros values (null, ?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getIdLivro());
            pst.setString(2, lVO.getTitulo());
            pst.setInt(3, lVO.getAnoFab());
            pst.setString(4, lVO.getIsbn());
            pst.setString(5, lVO.getAutor());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Carro.\n"
                    + e.getMessage());
        }
    }

    public ArrayList<Livro> getLivros() {
        ArrayList<Livro> livros = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select c.*, p.cpf as cpf from carros c "
                    + "join pessoas p on c.proprietario = p.idPessoa";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Livro l = new Livro();
                l.setIdLivro(rs.getString("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAnoFab(rs.getInt("anoFab"));
                l.setIsbn(rs.getString("isbn"));
                l.setAutor(rs.getString("autor"));
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                livros.add(l);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Carro.\n"
                    + e.getMessage());
        }

        return livros;
    }//fim getCarros

    public Livro getLivroByDoc(String isbn) {
        Livro l = new Livro();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select l.*, p.cpf as cpf from carros l "
                    + "join pessoas p on l.Autor = p.idPessoa "
                    + "where isbn = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, isbn);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                l.setIdLivro(rs.getString("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAnoFab(rs.getInt("anoFab"));
                l.setIsbn(rs.getString("isbn"));
                l.setAutor(rs.getString("autor"));
                PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
                l.setAutor(pessoaS.getPessoaByDoc(rs.getString("cpf")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar placa.\n" + e.getMessage());
        }
        return l;
    }//fim getCarroByDoc

    public void atualizarLivro(Livro lVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update carros set cor = ?, tpCambio = ?, combustivel = ?, "
                    + "proprietario = ? where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lVO.getTitulo());
            pst.setInt(2, lVO.getAnoFab());
            pst.setString(3, lVO.getIsbn());
            pst.setString(4, lVO.getAutor());
            PessoaServicos pessoaS = ServicosFactory.getPessoaServicos();
            pst.setInt(5, 
                    pessoaS.getPessoaByDoc(lVO.getAutor()).getIdPessoa());
            pst.setString(6, lVO.getIsbn());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar placa.\n" + e.getMessage());
        }
    }//fim atualizarCarro
    
    public void deletarLivro(String isbn){
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from carros where placa = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, isbn);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar carro.\n" + e.getMessage());
        }
    }//fim deletarCarro

}//fim da classe
