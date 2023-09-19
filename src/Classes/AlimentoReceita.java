package Classes;

import java.time.LocalDate;
import java.util.Date;

public class AlimentoReceita {

    private static int fixid = 1;
    private int id;
    private String nome;
    private double carboidratos;
    private double proteinas;
    private double gorduras;
    private double calorias;
    private double porcao;
    private String tipoUsuario;
    private LocalDate dataCriacao;
    private LocalDate dataModificacao;

    public AlimentoReceita(){
        this.id = fixid++;
    }
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public double getCarboidratos(){
        return carboidratos;
    }
    public double getProteinas(){
        return proteinas;
    }
    public double getGorduras(){
        return gorduras ;
    }
    public double getCalorias(){
        return calorias;
    }
    public double getPorcao(){
        return porcao;
    }
    public String getipoUsuario(){
        return tipoUsuario;
    }

    public LocalDate getDataCriacao(LocalDate now) {
        return dataCriacao;
    }

    public LocalDate getDataModificacao(LocalDate now) {
        return dataModificacao;
    }
    ///////////////////////////////////////////////////////////

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDate dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
    @Override
    public String toString() {
        return "AlimentoReceita{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", carboidratos=" + carboidratos +
                ", proteinas=" + proteinas +
                ", gorduras=" + gorduras +
                ", calorias=" + calorias +
                ", porcao=" + porcao +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                '}';
    }
}
