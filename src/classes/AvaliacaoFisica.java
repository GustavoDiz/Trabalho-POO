package classes;

import java.time.LocalDate;
import java.util.UUID;

public class AvaliacaoFisica {
    private String id = UUID.randomUUID().toString();
    private Pessoa user;
    private double peso;
    private double altura;
    private int idade ;
    private double pescoco;
    private double cintura;
    private double quadril;
    private double abdomen;

    private  double imc;
    private double tbm;
    private double massaGorda;
    private double massaMagra;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public String getId() {
        return id;
    }


    public Pessoa getUser() {
        return user;
    }

    public void setUser(Pessoa user) {
        this.user = user;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(double abdomen) {
        this.abdomen = abdomen;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getTbm() {
        return tbm;
    }

    public void setTbm(double tbm) {
        this.tbm = tbm;
    }

    public double getMassaGorda() {
        return massaGorda;
    }

    public void setMassaGorda(double massaGorda) {
        this.massaGorda = massaGorda;
    }

    public double getMassaMagra() {
        return massaMagra;
    }

    public void setMassaMagra(double massaMagra) {
        this.massaMagra = massaMagra;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public String toString() {
        return "AvaliacaoFisica{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", peso=" + peso +
                ", altura=" + altura +
                ", idade=" + idade +
                ", pescoco=" + pescoco +
                ", cintura=" + cintura +
                ", quadril=" + quadril +
                ", imc=" + imc +
                ", tbm=" + tbm +
                ", massaGorda=" + massaGorda +
                ", massaMagra=" + massaMagra +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }

    public void calculateIMC(){
        double imc = this.peso / Math.pow(this.altura,2);
        this.setImc(imc);
    }

    public void calculateTMB(double taxa){
        double result;
        if (user.getSexo() == 'M'){
            result = taxa * (66 + ((13.27 * this.peso) + (5 * this.altura) - (6.8 * this.idade)));
        }else{
            result = taxa * (655 + ((9.6 * this.peso) + (1.8 * this.altura) - (4.7 * this.idade)));
        }
        this.setTbm(result);
    }

    public void calculateBF(){
        double result;
        if(user.getSexo() == 'M'){
            result = 86.010 * Math.log(this.abdomen - this.pescoco) - 70.041 * Math.log(this.altura) + 36.76;
        }else{
            result = 163.205 * Math.log(this.cintura + this.quadril) - 97.684 * Math.log(this.altura) - 78.387;
        }
        this.setMassaGorda(result);
        this.setMassaMagra(this.peso - result);
    }


}
