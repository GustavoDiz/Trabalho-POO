package trabalhopoo;

import Classes.AlimentoReceita;
import classes.Pessoa;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author gusta
 *
 */
public class TrabalhoPOO {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Pessoa> users = new ArrayList<>();
    static ArrayList<AlimentoReceita> receitas = new ArrayList<>(4);

    public static void main(String[] args) {
        try {
            Pessoa pessoa1 = new Pessoa("João", 'M', "10/05/1990", "joao123", "senha123", 1);
            Pessoa pessoa2 = new Pessoa("Maria", 'F', "15/07/1985", "maria456", "senha456", 2);
            Pessoa pessoa3 = new Pessoa("Carlos", 'M', "20/03/1978", "carlos789", "senha789", 1);
            Pessoa pessoa4 = new Pessoa("Ana", 'F', "25/11/1995", "ana1011", "senha1011", 2);
            Pessoa pessoa5 = new Pessoa("Paulo", 'M', "30/09/1980", "paulo1213", "senha1213", 1);

            users.add(pessoa1);
            users.add(pessoa2);
            users.add(pessoa3);
            users.add(pessoa4);
            users.add(pessoa5);

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

        menuLogin();
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
  
    public static Pessoa criarPessoa() {
        Pessoa p = new Pessoa();
        System.out.println("Digite seu nome :>_");
        p.setNome(scanner.nextLine());
        System.out.println("Digite seu Sexo (M - Masculino F - Feminino) :>_");
        p.setSexo(scanner.nextLine().charAt(0));
        System.out.println("Digite sua data de nascimento (Exemplo: 02/12/2023) :>_");
        p.setNascimento(converterStringParaData(scanner.nextLine()));
        System.out.println("Digite seu Login :>_");
        p.setLogin(scanner.nextLine());
        System.out.println("Digite sua Senha :>_");
        p.setSenha(scanner.nextLine());
        System.out.println("Digite seu Tipo de Usuario :>_");
        p.setTipoUsuario(Integer.parseInt(scanner.nextLine()));
        p.setDataCriacao(LocalDate.now());
        p.setDataModicacao(LocalDate.now());
        return p;

    }

    public static Date converterStringParaData(String dataString) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        try {
            data = formato.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
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

    public static void mostrarPessoas() {
        for (Pessoa user : users) {
            System.out.println(user.toString());
        }
    }

    public static boolean deletarPorId(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean atualizarPorId(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                menuUpdate(i);
                users.get(i).setDataModicacao(LocalDate.now());
                return true;
            }
        }
        return false;
    }

    public static boolean atualizarPorIdReceita(int id) {
        for (int i = 0; i < receitas.size(); i++) {
            if (receitas.get(i).getId() == id) {
                AlimentoReceita receita = receitas.get(i);
                receita.setDataModificacao(LocalDate.now());
                menuUpdate(i);
                return true;
            }
        }
        return false;
    }      
    

    public static void menuUpdateFood(int index) {

        AlimentoReceita d1 = new AlimentoReceita();

        System.out.println("Digite ");
        System.out.println("1 - Nome ");
        System.out.println("2 - Carboídratos ");
        System.out.println("3 - Proteínas ");
        System.out.println("4 - Gorduras ");
        System.out.println("5 - Calorias ");
        System.out.println("6 - Porção ");
        System.out.println("7 - Tipo do usuario ");
        int flag = Integer.parseInt(scanner.nextLine());

        switch (flag) {
            case 1:
                System.out.println("Digite o novo nome >>");
                receitas.get(index).setNome(scanner.nextLine());

                break;
            case 2:
                System.out.println("Digite a quantidade de carboidratos da dieta");
                receitas.get(index).setCarboidratos(Double.parseDouble(scanner.nextLine()));
                break;

            case 3:
                System.out.println("Digite a quantidade de proteinas da dieta");
                receitas.get(index).setProteinas(Double.parseDouble(scanner.nextLine()));
                break;

            case 4:
                System.out.println("Digite a quantidade de gorduras da dieta");
                receitas.get(index).setGorduras(Double.parseDouble(scanner.nextLine()));
                break;
            case 5:
                System.out.println("Digite a quantidade de calorias da dieta");
                receitas.get(index).setCalorias(Double.parseDouble(scanner.nextLine()));
                break;
            case 6:
                System.out.println("Digite a Porção da dieta>>");
                receitas.get(index).setPorcao(Double.parseDouble(scanner.nextLine()));
                break;
            case 7:
                System.out.println("Digite o tipo de usuario da dieta");
                receitas.get(index).setTipoUsuario(scanner.nextLine());
                break;
        }
    }
    public static void menuUpdate(int index) {
        String menu = "Qual seria o campo a ser atualizado? "
                + "\n 1- Nome "
                + "\n 2 - Sexo "
                + "\n 3 - Nascimento "
                + "\n 4 - login "
                + "\n 5 - senha "
                + "\n 6 - tipo de usuario \n";
        System.out.println(menu);
        int op = Integer.parseInt(scanner.nextLine());
        switch (op) {
            case 1:
                System.out.println("O Novo valor do Campo Nome");
                users.get(index).setNome(scanner.nextLine());
                break;
            case 2:
                System.out.println("O Novo valor do Campo Sexo");
                users.get(index).setSexo(scanner.nextLine().charAt(0));
                break;
            case 3:
                System.out.println("O Novo valor do Campo Nascimento");
                users.get(index).setNascimento(converterStringParaData(scanner.nextLine()));
                break;
            case 4:
                System.out.println("O Novo valor do Campo Login");
                users.get(index).setLogin(scanner.nextLine());
                break;
            case 5:
                System.out.println("O Novo valor do Campo Senha");
                users.get(index).setLogin(scanner.nextLine());
                break;
            case 6:
                System.out.println("O Novo valor do Campo Tipo de Usuario");
                users.get(index).setTipoUsuario(Integer.parseInt(scanner.nextLine()));
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void menu(){
        String menu = "Bem Vindo a Nutrisoft! ";
    }

    public static void menuLogin(){
        int op;
        do{
            String menu = "Bem Vindo a Nutrisoft! Digite " +
                    "\n 1 -  para login " +
                    "\n 2  - fazer cadastro  " +
                    "\n 3 - Sair " +
                    "\n Digite sua opção:>_";
            System.out.println(menu);
            op = Integer.parseInt(scanner.nextLine());
            switch(op){
                case 1:
                    Pessoa user = login();
                    if(user == null){
                        System.out.println("Username ou Senha não encontrado!");
                    }else{
                        menuUpdate(user.getId());
                    }
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    op = 3;
                    break;
                default:
                    System.out.println("Opção não válida Digite novamente");
                    break;
            }
        }while(op != 3);
    }

    public static void register(){
        Pessoa newUser = criarPessoa();
        users.add(newUser);
        System.out.println("Usuario Criado com Sucesso");
        menuLogin();
    }

    public static  Pessoa login(){
        System.out.println("Digite seu login >:_");
        String username = scanner.nextLine();
        System.out.println("Digite sua senha >:_");
        String password = scanner.nextLine();
        for (Pessoa user:
             users) {
            if (user.getLogin().equals(username) && user.getSenha().equals(password)){
                System.out.println("Login feito com Sucesso!");
                return user;
            }
        }
        return null;
    }
}
