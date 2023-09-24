package trabalhopoo;
import classes.*;
import dao.PessoaDAO;
import dao.TipoDietaDAO;
import java.time.LocalDate;

import static classes.JmenuAlimentoReceita.jmenusRecipe;


public class TrabalhoPOO {
    public static void main(String[] args) {
        PessoaDAO usersDAO = new PessoaDAO(); // Renomeie a variável para evitar conflito com a classe
        TipoDietaDAO dietsDB = new TipoDietaDAO(); // Renomeie a variável para evitar conflito com a classe
        TipoDieta[] array = dietsDB.getDietsDB();
        usersDAO.addUsers(new Pessoa("João", 'M', "10-05-1990", "joao123", "senha123", 1));
        usersDAO.addUsers(new Pessoa("Maria", 'F', "15-07-1985", "maria456", "senha456", 2));
        usersDAO.addUsers(new Pessoa("Carlos", 'M', "20-03-1978", "carlos789", "senha789", 1));
        usersDAO.addUsers(new Pessoa("Ana", 'F', "25-11-1995", "ana1011", "senha1011", 2));
        usersDAO.addUsers(new Pessoa("Paulo", 'M', "30-09-1980", "paulo1213", "senha1213", 1));

        dietsDB.addDiet(new TipoDieta("Dieta 1", 50.0, 20.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));
        dietsDB.addDiet(new TipoDieta("Dieta 2", 40.0, 30.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));
        dietsDB.addDiet(new TipoDieta("Dieta 3", 60.0, 10.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));
        dietsDB.addDiet(new TipoDieta("Dieta 4", 70.0, 10.0, 20.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));
        dietsDB.addDiet(new TipoDieta("Dieta 5", 30.0, 40.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));

        jmenusRecipe();
    }
}
