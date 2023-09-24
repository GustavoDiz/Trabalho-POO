package classes;

import java.time.LocalDate;
import java.util.UUID;

public class Refeicao {
    private String id = UUID.randomUUID().toString();
    private  String nome;
    private  Pessoa user;
    private TipoDieta dietType;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public String getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getUser() {
        return user;
    }

    public void setUser(Pessoa user) {
        this.user = user;
    }

    public TipoDieta getDietType() {
        return dietType;
    }

    public void setDietType(TipoDieta dietType) {
        this.dietType = dietType;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
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
        return "Refeicao{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", user=" + user +
                ", dietType=" + dietType +
                ", carboidrato=" + carboidrato +
                ", proteina=" + proteina +
                ", gordura=" + gordura +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
