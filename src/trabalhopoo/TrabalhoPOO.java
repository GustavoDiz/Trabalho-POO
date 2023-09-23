package trabalhopoo;

import classes.*;
import dao.PessoaDAO;

import javax.swing.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

import static classes.JMenu.*;


/**
 * @author gusta
 *
 */
public class TrabalhoPOO {
    static Scanner scanner = new Scanner(System.in);
    static TipoDieta[] tiposDeDieta = new TipoDieta[5];
    static ArrayList<AlimentoReceita> receitas = new ArrayList<>(4);

    public static void main(String[] args) {
        PessoaDAO users = new PessoaDAO();
        users.addUsers(new Pessoa("João", 'M', "10-05-1990", "joao123", "senha123", 1));
        users.addUsers(new Pessoa("Maria", 'F', "15-07-1985", "maria456", "senha456", 2));
        users.addUsers(new Pessoa("Carlos", 'M', "20-03-1978", "carlos789", "senha789", 1));
        users.addUsers(new Pessoa("Ana", 'F', "25-11-1995", "ana1011", "senha1011", 2));
        users.addUsers(new Pessoa("Paulo", 'M', "30-09-1980", "paulo1213", "senha1213", 1));

        tiposDeDieta[0] = new TipoDieta("Dieta 1", 50.0, 20.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23));
        tiposDeDieta[1] = new TipoDieta("Dieta 2", 40.0, 30.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23));
        tiposDeDieta[2] = new TipoDieta("Dieta 3", 60.0, 10.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23));
        tiposDeDieta[3] = new TipoDieta("Dieta 4", 70.0, 10.0, 20.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23));
        tiposDeDieta[4] = new TipoDieta("Dieta 5", 30.0, 40.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23));

      
      for (int i = 0; i < receitas.size(); i++) {
            AlimentoReceita novaReceita = criarDieta();
            receitas.add(novaReceita);
        }

        //boolean b = deletarPorId(4);
        atualizarPorIdReceita(4);

        for (AlimentoReceita receita : receitas) {
            System.out.println(receita.toString());
        }

        jMenuLogin();
    }
  
  private static AlimentoReceita criarDieta() {

        AlimentoReceita d1 = new AlimentoReceita();

        System.out.println("Digite o nome da dieta");
        d1.setNome(scanner.nextLine());

        System.out.println("Digite a quantidade de carboidratos da dieta");
        d1.setCarboidratos(Double.parseDouble(scanner.nextLine()));

        System.out.println("Digite a quantidade de proteinas da dieta");
        d1.setProteinas(Double.parseDouble(scanner.nextLine()));

        System.out.println("Digite a quantidade de gorduras da dieta");
        d1.setGorduras(Double.parseDouble(scanner.nextLine()));

        System.out.println("Digite a quantidade de calorias da dieta");
        d1.setCalorias(Double.parseDouble(scanner.nextLine()));

        System.out.println("Digite a Porcao da dieta>>");
        d1.setPorcao(Double.parseDouble(scanner.nextLine()));

        System.out.println("Digite o tipo de usuario da dieta");
        d1.setTipoUsuario(scanner.nextLine());

        d1.setDataCriacao(LocalDate.now());
        d1.setDataModificacao(LocalDate.now());

        return d1;
}

    public static boolean deletarPorIdReceitas(int id) {
        for (int i = 0; i < receitas.size(); i++) {
            if (receitas.get(i).getId() == id) {
                receitas.remove(i);
                return  true;
            }
        }
        return false;
    }


    public static boolean atualizarPorIdReceita(int id) {
        for (int i = 0; i < receitas.size(); i++) {
            if (receitas.get(i).getId() == id) {
                AlimentoReceita receita = receitas.get(i);
                receita.setDataModificacao(LocalDate.now());
//                menuUpdate(i);
                return true;
            }
        }
        return false;
    }      
    

    public static void menuUpdateFood(int index) {

        int opc = Integer.parseInt(JOptionPane.showInputDialog("Qual seria o campo a ser atualizado? Digite o número  \n" +
                "                1-  Nome \n" +
                "                2 - Quantidade de carboidratos \n" +
                "                3 - Quantidade de proteinas \n" +
                "                4 - Quantidade de gorduras \n" +
                "                5 - Quantidade de calorias \n" +
                "                6 - Porção da dieta \n" +
                "                6 - Tipo de usuário \n\n" +
                ""));

        switch (opc) {
            case 1:
                receitas.get(index).setNome(JOptionPane.showInputDialog("Digite o novo nome \n"));

                break;
            case 2:
                receitas.get(index).setCarboidratos(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de carboidratos \n")));
                break;
            case 3:
                receitas.get(index).setProteinas(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de proteinas \n")));
                break;
            case 4:
                receitas.get(index).setGorduras(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de gorduras \n")));
                break;
            case 5:
                receitas.get(index).setCalorias(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de calorias \n")));
                break;
            case 6:
                receitas.get(index).setPorcao(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova porção \n")));
                break;
            case 7:
                receitas.get(index).setTipoUsuario((JOptionPane.showInputDialog("Digite o novo tipo de usuario \n")));
                break;
        }
    }


    /*public void menuEscolha{
        int red = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Cadastrar Dieta \n" +
                                                "                2 - Atualizar dieta \n" +
                                                "                3 - Verificar dieta atual \n\n" +
                                                "                4 - Mudar usuario \n" +
                                                "                5 - Sair \n" +
                                                "                6 - Tipo de usuario \n\n" +
                                                ""));
    }*/






    // -------- UTILS ------ //


}
