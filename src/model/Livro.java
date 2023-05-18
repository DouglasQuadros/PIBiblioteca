/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 181910101
 */
public class Livro {
    private String idLivros;
    private String titulo;
    private int anoFab;
    private String isbn;
    private String autor; //agregação da classe model Pessoa com Carro

    public Livro(String idLivros, String titulo, int anoFab, String isbn, String autor) {
        this.idLivros = idLivros;
        this.titulo = titulo;
        this.anoFab = anoFab;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getIdLivros() {
        return idLivros;
    }

    public void setIdLivros(String idLivros) {
        this.idLivros = idLivros;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(int anoFab) {
        this.anoFab = anoFab;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "\n---" + "\nidLivros:\t" + idLivros + "\ntitulo:\t" + titulo + "\nanoFab:\t" + anoFab + "\nisbn:\t" + isbn + "\nautor:\t" + autor;
    }
   
}//fim Classe Carro
