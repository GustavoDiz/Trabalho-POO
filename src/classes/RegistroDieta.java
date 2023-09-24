package classes;

import java.time.LocalDate;
import java.util.UUID;

public class RegistroDieta {
    private String id = UUID.randomUUID().toString();
    private Pessoa user;
    private  AvaliacaoFisica physicalAssessment;
    private  TipoDieta diet;
    private String goal;
    private double calories;
    private int nMeals;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pessoa getUser() {
        return user;
    }

    public void setUser(Pessoa user) {
        this.user = user;
    }

    public AvaliacaoFisica getPhysicalAssessment() {
        return physicalAssessment;
    }

    public void setPhysicalAssessment(AvaliacaoFisica physicalAssessment) {
        this.physicalAssessment = physicalAssessment;
    }

    public TipoDieta getDiet() {
        return diet;
    }

    public void setDiet(TipoDieta diet) {
        this.diet = diet;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public int getnMeals() {
        return nMeals;
    }

    public void setnMeals(int nMeals) {
        this.nMeals = nMeals;
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
        return "RegistroDieta{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", physicalAssessment=" + physicalAssessment +
                ", diet=" + diet +
                ", goal='" + goal + '\'' +
                ", calories=" + calories +
                ", nMeals=" + nMeals +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
