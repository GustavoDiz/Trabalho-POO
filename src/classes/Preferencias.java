package classes;

import java.time.LocalDate;
import java.util.UUID;

public class Preferencias {
    private String id = UUID.randomUUID().toString();
    private Pessoa user;
    private AlimentoReceita food;
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
}
