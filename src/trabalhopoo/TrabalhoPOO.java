package trabalhopoo;

import classes.AlimentoReceita;
import classes.Pessoa;

import javax.swing.*;
import java.text.ParseException;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author gusta
 *
 */
public class TrabalhoPOO {
    static Scanner scanner = new Scanner(System.in);
    static Pessoa[] users = new Pessoa[10];
    static ArrayList<AlimentoReceita> receitas = new ArrayList<>(4);

    public static void main(String[] args) {
        try {
            Pessoa pessoa1 = new Pessoa("João", 'M', "10-05-1990", "joao123", "senha123", 1);
            Pessoa pessoa2 = new Pessoa("Maria", 'F', "15-07-1985", "maria456", "senha456", 2);
            Pessoa pessoa3 = new Pessoa("Carlos", 'M', "20-03-1978", "carlos789", "senha789", 1);
            Pessoa pessoa4 = new Pessoa("Ana", 'F', "25-11-1995", "ana1011", "senha1011", 2);
            Pessoa pessoa5 = new Pessoa("Paulo", 'M', "30-09-1980", "paulo1213", "senha1213", 1);

            Pessoa[] addPessoas = {pessoa1,pessoa2,pessoa3,pessoa4,pessoa5};

            for (int i = 0; i < addPessoas.length; i++) {
                users[i] = addPessoas[i];
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
      
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

    public static  Pessoa jLogin(){
        String username = JOptionPane.showInputDialog("Login");
        String password = JOptionPane.showInputDialog("Senha");
        for (Pessoa user:
                users) {
            if (user == null){
                return  null;
            }
                if (user.getLogin().equals(username) && user.getSenha().equals(password)) {
                    jConfirmation("Login feito com Sucesso!");
                    return user;
                }

        }
        return null;
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
    public  static void jMenuLogin(){
        int op;
        String[] options = {"Login","Cadastro","Sair"};
        do {
            op = JOptionPane.showOptionDialog(null, "Bem Vindo a Nutrisoft!", "Boas Vindas!", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            System.out.println(op);
            switch (op) {
                case 0:
                    Pessoa user = jLogin();
                    if (user == null) {
                        jError("Username ou Senha não encontrado!");
                    } else {
                        jUpdate(user.getId());
                    }
                    break;
                case 1:
                    jRegister();
                    break;
                default:
                    op = 2;
                    break;
            }
        }while (op != 2);
    }

    public static  void jError(String msg){
        JOptionPane.showMessageDialog(null,msg,"Alerta", JOptionPane.ERROR_MESSAGE);
    }

    public static  void jConfirmation(String msg){
        JOptionPane.showMessageDialog(null,msg,"Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    public  static  void jRegister(){
        int emptyIndex = findEmptyPosition();
        Pessoa newUser = new Pessoa();
        newUser.setNome(JOptionPane.showInputDialog("Insira o nome"));
        newUser.setSexo(JOptionPane.showInputDialog("Insira o novo sexo \n M - Masculino \n F - Feminino").charAt(0));
        newUser.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Insira a nova data de nascimento Exemplo 01/01/2001")));
        newUser.setLogin(JOptionPane.showInputDialog("Insira o novo login"));
        newUser.setSenha(JOptionPane.showInputDialog("Insira o Novo Senha"));
        newUser.setTipoUsuario(Integer.parseInt(JOptionPane.showInputDialog("Insira o novo tipo de usuário")));
        users[emptyIndex] = newUser;
    }

    public  static  void jUpdate(int id){
        int op;
        Pessoa updatedUser = findUser(id);
        String menuUpdate = "Bem-Vindo " + updatedUser.getNome()
                + "\n Qual seria o campo a ser atualizado? "
                + "\n 1 - Nome "
                + "\n 2 - Sexo "
                + "\n 3 - Nascimento "
                + "\n 4 - login "
                + "\n 5 - senha "
                + "\n 6 - tipo de usuario"
                + "\n 7 - Sair ";
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menuUpdate));
            switch (op) {
                case 1:
                    updatedUser.setNome(JOptionPane.showInputDialog("Insira o Novo nome"));
                    break;
                case 2:
                    updatedUser.setSexo(JOptionPane.showInputDialog("Insira o novo sexo \n M - Masculino \n F - Feminino").charAt(0));
                    break;
                case 3:
                    updatedUser.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Insira a nova data de nascimento Exemplo 01-01-2001")));
                    break;
                case 4:
                    updatedUser.setLogin(JOptionPane.showInputDialog("Insira o novo login"));
                    break;
                case 5:
                    updatedUser.setSenha(JOptionPane.showInputDialog("Insira o Novo Senha"));
                    break;
                case 6:
                    updatedUser.setTipoUsuario(Integer.parseInt(JOptionPane.showInputDialog("Insira o novo tipo de usuário")));
                    break;
                case 7:
                    op = 7;
                    break;
                default:
                    jError("Opção Invalida, Por favor insira novamente.");
                    break;
            }
        }while (op != 7);
    }

    public static void jMenu(Pessoa pessoa){
        String txt = "Bem-Vindo " + pessoa.getNome() + ", " +
                "\n O que deseja? " +
                "\n 1 - Ver Perfil";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op){

            }
        }while (op!=7);
    }

    // -------- UTILS ------ //
    public static Pessoa findUser(int id){
        for (int i = 0; i < users.length; i++) {
            if(users[i].getId() == id){
                return users[i];
            }
        }
        return null;
    }

    public static int  findEmptyPosition(){
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null){
                return i;
            }
        }
        return -1;
    }

}
