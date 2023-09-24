package classes;

import dao.AvaliacaoFisicaDAO;
import dao.PessoaDAO;
import javax.swing.*;
import java.time.LocalDate;

public class JMenu {
    static PessoaDAO users = new PessoaDAO();
    static AvaliacaoFisicaDAO physical = new AvaliacaoFisicaDAO();
    static Pessoa userlogged;
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
                        userlogged = user;
                        jMenu();
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

    public static void jMenu(){

        String txt = "Bem-Vindo " + userlogged.getNome() + ", " +
                "\n O que deseja? " +
                "\n 1 - Ver Perfil " +
                "\n 2 - Atualizar Informações " +
                "\n 3 - Avaliação Física" +
                "\n 0 - LogOut";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op){
                case 0:
                    userlogged = null;
                    op = 0;
                    break;
                case 1:
                    jConfirmation(userlogged.toString());
                    break;
                case 2:
                    jUpdate();
                    break;
                case 3:
                    jMenuPhysicalAssessment();
                    break;
                default:
                    jError("Opção Inválida, Por favor insira novamente.");
                    break;
            }
        }while (op!=0);
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

    public  static  void jUpdate(){
        Pessoa[] teste = users.getUsers();
        int op;
        String menuUpdate = "Bem-Vindo " + userlogged.getNome()
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
                    userlogged.setNome(JOptionPane.showInputDialog("Insira o Novo nome"));
                    break;
                case 2:
                    userlogged.setSexo(JOptionPane.showInputDialog("Insira o novo sexo \n M - Masculino \n F - Feminino").charAt(0));
                    break;
                case 3:
                    userlogged.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Insira a nova data de nascimento Exemplo 01-01-2001")));
                    break;
                case 4:
                    userlogged.setLogin(JOptionPane.showInputDialog("Insira o novo login"));
                    break;
                case 5:
                    userlogged.setSenha(JOptionPane.showInputDialog("Insira o Novo Senha"));
                    break;
                case 6:
                    userlogged.setTipoUsuario(Integer.parseInt(JOptionPane.showInputDialog("Insira o novo tipo de usuário")));
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
        Pessoa newUser = new Pessoa();
        newUser.setNome(JOptionPane.showInputDialog("Insira o nome"));
        newUser.setSexo(JOptionPane.showInputDialog("Insira o novo sexo \n M - Masculino \n F - Feminino").charAt(0));
        newUser.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Insira a nova data de nascimento Exemplo 01/01/2001")));
        newUser.setLogin(JOptionPane.showInputDialog("Insira o novo login"));
        newUser.setSenha(JOptionPane.showInputDialog("Insira o Novo Senha"));
        newUser.setTipoUsuario(Integer.parseInt(JOptionPane.showInputDialog("Insira o novo tipo de usuário")));
        users.addUsers(newUser);
    }

    public static void jMenuPhysicalAssessment(){
        String msg = "O Que Gostaria de Fazer? " +
                "\n 1 - Fazer Avaliação Física" +
                "\n 2 - Ver Avaliações Antigas" +
                "\n 0 - Sair";
        int op;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(msg));
            switch (op){
                case 1:
                    jPhysicalAssessment();
                    break;
                case 2:
                    String txt = "";
                    AvaliacaoFisica[] teste = physical.getPhysicalsByUser(userlogged);
                    for (AvaliacaoFisica avalicao:
                         teste) {
                        if (avalicao != null) {
                            txt += avalicao.toString();
                        }
                    }
                    jConfirmation(txt);
                    break;
                default:
                    jError("Opção Inválida, Por favor Insira novamente");
                    break;
            }
        }while (op!=0);
    }

    public static  void jPhysicalAssessment(){
        String tax = "Qual é sua taxa de atividade: \n 1.2 - Sedentário (pouco ou nenhum exercicio)" +
                "\n 1,375: levemente ativo (exercício leve 1 a 3 dias por semana) " +
                "\n 1,55: moderadamente ativo (exercício moderado 6 a 7 dias por semana) " +
                "\n 1,725: muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia) " +
                "\n 1,9: extra ativo (exercício muito difícil, treinamento ou trabalho físico)";
        AvaliacaoFisica newAssessment = new AvaliacaoFisica();
        newAssessment.setUser(userlogged);
        newAssessment.setPeso(Double.parseDouble(JOptionPane.showInputDialog("Insira o Peso em kg: (Exemplo: 67.0)")));
        newAssessment.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Insira a altura em cm: (Exemplo: 180)")));
        newAssessment.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Insira a sua idade:")));
        newAssessment.setPescoco(Double.parseDouble(JOptionPane.showInputDialog("Insira a medida do seu Pescoço em cm: (Exemplo: 20.5)")));
        newAssessment.setCintura(Double.parseDouble(JOptionPane.showInputDialog("Insira a medida da sua Cintura em cm: (Exemplo: 20.5)")));
        newAssessment.setQuadril(Double.parseDouble(JOptionPane.showInputDialog("Insira a medida do seu Quadril em cm: (Exemplo: 20.5)")));
        newAssessment.setAbdomen(Double.parseDouble(JOptionPane.showInputDialog("Insira a medida do seu Abdomen em cm: (Exemplo: 20.5)")));
        newAssessment.calculateIMC();
        newAssessment.calculateTMB(Double.parseDouble(JOptionPane.showInputDialog(tax)));
        newAssessment.calculateBF();
        newAssessment.setDataCriacao(LocalDate.now());
        newAssessment.setDataModificacao(LocalDate.now());
        physical.addPhysical(newAssessment);
    }
}
