/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetofinal2806;

/**
 *
 * @author CeciliadeFigueiredoF
 */
public class Pessoa {
    
    private String nome;
    private String anoNascimento;
    private String cpf;
    
    public Pessoa (String nome, String anoNascimento,String cpf)
    {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.cpf = cpf;
    }
    
    public String getNome() 
    {
        return nome;
    }
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    public String getanoNascimento() 
    {
        return anoNascimento;
    }
    public void setanoNascimento(String anoNascimento) 
    {
        this.anoNascimento = anoNascimento;
    }
    
    public String getCpf() 
    {
        return cpf;
    }
    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }
    
}
