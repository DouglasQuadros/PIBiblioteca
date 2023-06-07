/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicos;

import dao.LivroDAO;
import dao.DAOFactory;
import java.util.ArrayList;
import model.Livro;

/**
 *
 * @author jbferraz
 */
public class LivroServicos {

    public void cadastroLivro(Livro lVO) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.cadastrarLivroDAO(lVO);
    }

    public ArrayList<Livro> getLivros() {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getLivros();
    }

    public Livro getLivroByDoc(String isbn) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        return lDAO.getLivroByDoc(isbn);
    }

    public void atualizarLivro(Livro lVO) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.atualizarLivro(lVO);
    }

    public void deletarLivro(String isbn) {
        LivroDAO lDAO = DAOFactory.getLivroDAO();
        lDAO.deletarLivro(isbn);
    }

}
