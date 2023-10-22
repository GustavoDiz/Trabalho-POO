package model;

import java.time.LocalDate;
import java.util.UUID;

public class TipoDieta {
    private static int baseId = 1;
    private int id;
    private String nome;
    private double carboidrato;
    private double proteina;
    private double gordura;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public TipoDieta(){this.id = baseId++;}

    public TipoDieta(String nome, double carboidrato, double proteina, double gordura, LocalDate dataCriacao, LocalDate dataModificacao) {
        this.id = baseId++;
        this.nome = nome;
        this.carboidrato = carboidrato;
        this.proteina = proteina;
        this.gordura = gordura;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "TipoDieta{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", carboidrato=" + carboidrato +
                ", proteina=" + proteina +
                ", gordura=" + gordura +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
