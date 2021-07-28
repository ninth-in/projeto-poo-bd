package projetofinal2806;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BancodeDados 
{
    
    /***************** CONEXÃO COM O BANCO DE DADOS ************************/
    
    // objeto responsável pela conexão com o servidor do banco de dados
    Connection con;
    // objeto responsável por preparar as consultas dinâmicas
    PreparedStatement pst;
    // objeto responsável por executar as consultas estáticas
    Statement st;
    // objeto responsável por referenciar a tabela resultante da busca
    ResultSet rs;

    // NOME DO BANCO DE DADOS
    String database = "finalBD";
    // URL: VERIFICAR QUAL A PORTA
    String url = "jdbc:mysql://127.0.0.2:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    // USUÁRIO
    String user = "root";
    // SENHA
    String password = "Ajol0918";

    boolean sucesso = false;
    
    // Conectar ao banco de dados
    public void connectToDb() 
    {
        try 
        {  
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão feita com sucesso!");
        } 
        catch (SQLException ex) 
        {
             System.out.println("Erro: " + ex.getMessage());
        }
                
    }
    
     
    /************************ INSERIR DADOS *********************************/
    public boolean inserirPessoa(Pessoa novaPessoa) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO pessoa (nome,cpf,anoNascimento) values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, novaPessoa.getNome()); //1- refere-se à primeira interrogação
            pst.setString(2, novaPessoa.getCpf());  //2- refere-se à segunda interrogação
            pst.setString(3, novaPessoa.getanoNascimento());
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean inserirConta(Conta novaConta) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO Conta (email,senha) values (?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, novaConta.getEmail()); //1- refere-se à primeira interrogação
            pst.setString(2, novaConta.getSenha());  //2- refere-se à segunda interrogação
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean inserirFilme(Filme novoFilme) 
    {
        connectToDb(); //Conecta ao banco de dados
        //Comando em SQL:
        String sql = "INSERT INTO filme (nomeFilme,anoLancamento,classificacao) values (?,?,?)";
        //O comando recebe paramêtros -> consulta dinâmica (pst)
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, novoFilme.getNomeFilme()); //1- refere-se à primeira interrogação
            pst.setString(2, novoFilme.getAnoLancamento());  //2- refere-se à segunda interrogação
            pst.setString(3, novoFilme.getClassificacao());
                                                       //e assim por diante....
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {   //Encerra a conexão
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    
    /************************ BUSCAR DADOS *********************************/
    public ArrayList<Pessoa> buscarPessoaSemFiltro() 
    {
        ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM pessoa";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de Pessoas: ");
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                Pessoa pessoaTemp = new Pessoa(rs.getString("nome"),rs.getString("Ano de Nascimento"),rs.getString("cpf"));
                System.out.println("Nome = "+pessoaTemp.getNome());
                System.out.println("CPF = "+pessoaTemp.getCpf());
                System.out.println("Ano de Nascimento= "+pessoaTemp.getanoNascimento());
                System.out.println("---------------------------------");
                listaDePessoas.add(pessoaTemp);
            }
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDePessoas;
    }
    
    public ArrayList<Conta> buscarContaSemFiltro() 
    {
        ArrayList<Conta> listaDeContas = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM Conta";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de Contas: ");
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                Conta contaTemp = new Conta(rs.getString("Email"),rs.getString("senha"));
                System.out.println("Email = "+contaTemp.getEmail());
                System.out.println("Senha = "+contaTemp.getSenha());
                System.out.println("---------------------------------");
                listaDeContas.add(contaTemp);
            }
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeContas;
    }
    
    public ArrayList<Filme> buscarFilmeSemFiltro() 
    {
        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        connectToDb();
        //Comando em SQL:
        String sql = "SELECT * FROM filme";
        //O comando NÃO recebe parâmetros -> consulta estática (st)
        try 
        {
            st = con.createStatement();
            rs = st.executeQuery(sql); //ref. a tabela resultante da busca
            System.out.println("Lista de Filmes: ");
            while(rs.next())
            {
                //System.out.println(rs.getString("nome"));
                Filme filmeTemp = new Filme(rs.getString("nomeFilme"),rs.getString("anoLancamento"),rs.getString("classificacao"));
                System.out.println("Nome = "+filmeTemp.getNomeFilme());
                System.out.println("Ano Lancamento = "+filmeTemp.getAnoLancamento());
                System.out.println("Classificacao= "+filmeTemp.getClassificacao());
                System.out.println("---------------------------------");
                listaDeFilmes.add(filmeTemp);
            }
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                st.close();
            } catch (SQLException ex) {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return listaDeFilmes;
    }
    
    /************************ DELETAR REGISTROS *******************************/
    public boolean deletarPessoa(String cpf) 
    {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM usuario WHERE CPF=?";
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean deletarConta(String email) 
    {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM usuario WHERE email=?";
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
    
    public boolean deletarFilme(String nomeFilme) 
    {
        connectToDb();
        //Comando em SQL:
        String sql = "DELETE FROM usuario WHERE nomeFilme=?";
        try 
        {
            pst = con.prepareStatement(sql);
            pst.setString(1, nomeFilme);
            pst.execute();
            sucesso = true;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro = " + ex.getMessage());
            sucesso = false;
        } 
        finally 
        {
            try 
            {
                con.close();
                pst.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println("Erro = " + ex.getMessage());
            }
        }
        return sucesso;
    }
}
