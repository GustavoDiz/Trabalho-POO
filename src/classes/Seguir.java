package classes;

import java.time.LocalDate;
import java.util.UUID;

public class Seguir {
    private String id = UUID.randomUUID().toString();
    private Pessoa follower;
    private Pessoa followed;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public String getId() {
        return id;
    }

    public Pessoa getFollower() {
        return follower;
    }

    public void setFollower(Pessoa follower) {
        this.follower = follower;
    }

    public Pessoa getFollowed() {
        return followed;
    }

    public void setFollowed(Pessoa followed) {
        this.followed = followed;
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
        return "Seguir{" +
                "id='" + id + '\'' +
                ", follower=" + follower +
                ", followed=" + followed +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
