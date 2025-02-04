/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfacegrafica3.model;

/**
 *
 * @author joaol
 */
public class Fornecedor extends PessoaJuridica{
    
    private String categoria;
    private String razaoSocial;
    private int id;
    
    public Fornecedor() {
        super("", "", "", "", "", "", "", 0);
    }    
    public Fornecedor (int id, String categoria, String cnpj, String inscricaoEstadual, String nomeFantasia, 
                          String nome, String email, String endereco, 
                          String telefone){
        super(cnpj, inscricaoEstadual, nomeFantasia, nome, email, endereco, telefone, id);
        this.categoria = categoria;
        this.razaoSocial = razaoSocial;
        
    }

    public Fornecedor(String categoria, String cnpj, String inscricaoEstadual, String nomeFantasia, String nome, String email, String endereco, String telefone, int id) {
        super(cnpj, inscricaoEstadual, nomeFantasia, nome, email, endereco, telefone, id);
        this.categoria = categoria;
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
        @Override
    public String toString() {
        return "Fornecedor{" + 
               "categoria="          + categoria        + 
               ", cnpj="             + getCnpj()        +
               ", inscricaoEstadual=" + getInscricaoEstadual() +
               ", nomeFantasia="      + getNomeFantasia() +
               ", nome="             + getNome()        +
               ", email="            + getEmail()       +
               ", endereco="         + getEndereco()    +
               ", telefone="         + getTelefone()    +
               ", id="               + getId()          +
               '}';
    }    
}
