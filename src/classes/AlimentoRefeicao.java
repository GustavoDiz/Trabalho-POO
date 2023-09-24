package classes;

import java.time.LocalDate;
import java.util.UUID;

public class AlimentoRefeicao {
    private String id = UUID.randomUUID().toString();
    private Refeicao meal;
    private AlimentoRefeicao food;
    private double portion;
    private double protein;
    private double fat;
    private double calories;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public String getId() {
        return id;
    }

    public Refeicao getMeal() {
        return meal;
    }

    public void setMeal(Refeicao meal) {
        this.meal = meal;
    }

    public AlimentoRefeicao getFood() {
        return food;
    }

    public void setFood(AlimentoRefeicao food) {
        this.food = food;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
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
        return "AlimentoRefeicao{" +
                "id='" + id + '\'' +
                ", meal=" + meal +
                ", food=" + food +
                ", portion=" + portion +
                ", protein=" + protein +
                ", fat=" + fat +
                ", calories=" + calories +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
