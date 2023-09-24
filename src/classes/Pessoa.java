/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author gusta
 */
public class Pessoa {
    private static int baseId = 1;
    private int id;
    private String nome;
    private char sexo;
    private LocalDate birthday;
    private String login;
    private String senha;
    private int tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;
    
    public Pessoa(){
        this.id = baseId++;
    }
    
    public Pessoa(String nome,char sexo,String dataNascimento, String login, String senha, int tipoUsuario){
        this.id = baseId++;
        this.nome = nome;
        this.sexo = sexo;

        // Convertendo as datas de String para Date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.birthday = LocalDate.parse(dataNascimento,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }
    
    public int getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public char getSexo(){
        return sexo;
    }
    
    public void setSexo(char sexo){
        this.sexo = sexo;
    }
    
    public LocalDate getNascimento(){
        return birthday;
    }
    
    public void setNascimento(LocalDate nascimento){
        this.birthday = nascimento;
    }
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public int getTipoUsuario(){
        return tipoUsuario;
    }
    
    public void setTipoUsuario(int tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    
    public LocalDate getDataCriacao(){
        return dataCriacao;
    }
    
    public void setDataCriacao(LocalDate dataCriacao){
        this.dataCriacao = dataCriacao;
    }
    
    public LocalDate getDataModicacao(){
        return dataModificacao;
    }
    
    public void setDataModicacao(LocalDate dataModicao){
        this.dataModificacao = dataModicao;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", nascimento=" + birthday + ", login=" + login + ", senha=" + senha + ", tipoUsuario=" + tipoUsuario + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id == pessoa.id && sexo == pessoa.sexo && tipoUsuario == pessoa.tipoUsuario && Objects.equals(nome, pessoa.nome) && Objects.equals(birthday, pessoa.birthday) && Objects.equals(login, pessoa.login) && Objects.equals(senha, pessoa.senha) && Objects.equals(dataCriacao, pessoa.dataCriacao) && Objects.equals(dataModificacao, pessoa.dataModificacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sexo, birthday, login, senha, tipoUsuario, dataCriacao, dataModificacao);
    }
}
