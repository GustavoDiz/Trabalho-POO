package classes;

import dao.PessoaDAO;

import javax.swing.*;
import java.time.LocalDate;

import static utils.Utils.*;

public class JMenu {
    static PessoaDAO users = new PessoaDAO();
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

    public static  Pessoa jLogin(){
        String username = JOptionPane.showInputDialog("Login");
        String password = JOptionPane.showInputDialog("Senha");
        for (Pessoa user:
                users.getUsers()) {
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

    public  static  void jUpdate(int id){
        int op;
        Pessoa updatedUser = users.getUserById(id);
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

    public static  void jError(String msg){
        JOptionPane.showMessageDialog(null,msg,"Alerta", JOptionPane.ERROR_MESSAGE);
    }

    public static  void jConfirmation(String msg){
        JOptionPane.showMessageDialog(null,msg,"Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

        public  static  void jRegister(){
        PessoaDAO users = new PessoaDAO();
        Pessoa newUser = new Pessoa();
        newUser.setNome(JOptionPane.showInputDialog("Insira o nome"));
        newUser.setSexo(JOptionPane.showInputDialog("Insira o novo sexo \n M - Masculino \n F - Feminino").charAt(0));
        newUser.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Insira a nova data de nascimento Exemplo 01/01/2001")));
        newUser.setLogin(JOptionPane.showInputDialog("Insira o novo login"));
        newUser.setSenha(JOptionPane.showInputDialog("Insira o Novo Senha"));
        newUser.setTipoUsuario(Integer.parseInt(JOptionPane.showInputDialog("Insira o novo tipo de usuário")));
        users.addUsers(newUser);
    }
}
