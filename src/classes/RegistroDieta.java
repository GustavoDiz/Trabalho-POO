package classes;

import java.time.LocalDate;
import java.util.UUID;

public class RegistroDieta {
    private static int baseId = 1;
    private int id;
    private Pessoa user;
    private  AvaliacaoFisica physicalAssessment;
    private TipoDieta diet;
    private int goal;
    private double calories;
    private int nMeals;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public RegistroDieta(){this.id = baseId++;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
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
