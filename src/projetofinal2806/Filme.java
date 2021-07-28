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
public class Filme {
    private String nomeFilme;
    private String anoLancamento;
    private String classificacao;
    
    public Filme (String nomeFilme, String anoLancamento,String classificacao)
    {
        this.nomeFilme = nomeFilme;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
    }
    public String getNomeFilme() 
    {
        return nomeFilme;
    }
    public void setNomeFilme(String nomeFilme) 
    {
        this.nomeFilme = nomeFilme;
    }
    public String getAnoLancamento() 
    {
        return anoLancamento;
    }
    public void setAnoLancamento(String anoLancamento) 
    {
        this.anoLancamento = anoLancamento;
    }
    
    public String getClassificacao() 
    {
        return classificacao;
    }
    public void setClassificacao(String classificacao) 
    {
        this.classificacao = classificacao;
    }
}
