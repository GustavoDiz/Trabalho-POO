package model;

import java.time.LocalDate;

public class Mensagem {
    private static int baseId = 1;
    private int id;
    private Pessoa sender;
    private Pessoa recipient;
    private String msg;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public Mensagem(){this.id = baseId++;}

    public Mensagem(Pessoa sender, Pessoa recipient, String msg) {
        this.sender = sender;
        this.recipient = recipient;
        this.msg = msg;
        this.dataCriacao = LocalDate.now();
        this.dataModificacao = LocalDate.now();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getSender() {
        return sender;
    }

    public void setSender(Pessoa sender) {
        this.sender = sender;
    }

    public Pessoa getRecipient() {
        return recipient;
    }

    public void setRecipient(Pessoa recipient) {
        this.recipient = recipient;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
        return "Mensagem{" +
                "id='" + id + '\'' +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", msg='" + msg + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
