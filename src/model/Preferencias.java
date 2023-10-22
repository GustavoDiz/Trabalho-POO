package model;

import java.time.LocalDate;

public class Preferencias {
    private static int baseId = 1;
    private int id;
    private Pessoa user;
    private AlimentoReceita food;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Preferencias(){this.id = baseId++;}

    public int getId() {
        return id;
    }

    public Pessoa getUser() {
        return user;
    }

    public void setUser(Pessoa user) {
        this.user = user;
    }

    public AlimentoReceita getFood() {
        return food;
    }

    public void setFood(AlimentoReceita food) {
        this.food = food;
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
        return "Preferencias{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", food=" + food +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
