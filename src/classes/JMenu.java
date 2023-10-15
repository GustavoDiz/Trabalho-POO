package classes;

import dao.*;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static classes.JmenuAlimentoReceita.*;
import static utils.Utils.*;

public class JMenu {
    PessoaDAO users = new PessoaDAO();
    AvaliacaoFisicaDAO physical = new AvaliacaoFisicaDAO();
    TipoDietaDAO dietType = new TipoDietaDAO();
    PreferenciasDAO preferences = new PreferenciasDAO();
    MensagemDAO msgs = new MensagemDAO();
    PostDAO psts = new PostDAO();
    RegistroDietaDAO diets = new RegistroDietaDAO();
    static AlimentoReceitaDao foods = new AlimentoReceitaDao();

    SeguirDAO follows = new SeguirDAO();
    Pessoa userlogged;

    public JMenu() {
        double valorcal2;
        TipoDieta[] array = dietType.getDietsDB();
        users.addUsers(new Pessoa("João", 'M', "10-05-1990", "joao123", "senha123", 1));
        users.addUsers(new Pessoa("Maria", 'F', "15-07-1985", "maria456", "senha456", 2));
        users.addUsers(new Pessoa("Carlos", 'M', "20-03-1978", "carlos789", "senha789", 1));
        users.addUsers(new Pessoa("Ana", 'F', "25-11-1995", "ana1011", "senha1011", 2));
        users.addUsers(new Pessoa("Paulo", 'M', "30-09-1980", "paulo1213", "senha1213", 1));

        dietType.addDiet(new TipoDieta("Equilibrada", 40.0, 30.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));
        dietType.addDiet(new TipoDieta("Low Carb", 30.0, 30.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));
        dietType.addDiet(new TipoDieta("Cetogênica", 60.0, 10.0, 30.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));
        dietType.addDiet(new TipoDieta("Atleta", 70.0, 10.0, 20.0, LocalDate.of(2023, 9, 23), LocalDate.of(2023, 9, 23)));

        /*msgs.addMessage(new Mensagem(users.getUserById(1), users.getUserById(2), "Teste 0"));
        msgs.addMessage(new Mensagem(users.getUserById(2), users.getUserById(1), "Teste 1"));
        msgs.addMessage(new Mensagem(users.getUserById(1), users.getUserById(2), "Teste 2"));
        msgs.addMessage(new Mensagem(users.getUserById(2), users.getUserById(1), "Teste 3"));*/

        foods.addAlPe(new AlimentoReceita("Frango Grelhado", 0.0, 31.0, 3.6, 100.0));
        foods.addAlPe(new AlimentoReceita("Arroz", 40.0, 31.0, 3.6, 100.0));
        foods.addAlPe(new AlimentoReceita("Alface", 2.0, 1.0, 0.0, 100.0));

        jMenuLogin();
    }

    public void jMenuLogin() {
        int op;
        String[] options = {"Login", "Cadastro", "Sair"};
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
        } while (op != 2);
    }

    public void jMenu() {

        String txt = "Bem-Vindo " + userlogged.getNome() + ", " +
                "\n O que deseja? " +
                "\n 1 - Ver Perfil " +
                "\n 2 - Atualizar Informações " +
                "\n 3 - Avaliação Física" +
                "\n 4 - Dieta/Alimentação" +
                "\n 5 - NutriSphere" +
                "\n 6 - Alimentos atuais" +
                "\n 0 - LogOut";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op) {
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
                case 4:
                    jDiet();
                    break;
                case 5:
                    jSocial();
                    break;
                case 6:
                    jmenusRecipe();
                default:
                    jError("Opção Inválida, Por favor insira novamente.");
                    break;
            }
        } while (op != 0);
    }

    private void jDiet() {
        int op;
        String txt = "O que deseja? " +
                "\n 1 - Tipo Dieta " +
                "\n 2 - Registro Dieta" +
                "\n 3 - Refeições" +
                "\n 4 - Alimentos" +
                "\n 5 - Preferencias " +
                "\n 0 - Sair";
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op) {
                case 1:
                    jTypeDiet();
                    break;
                case 2:
                    jRegisterDiet();
                    break;
                case 3:
                    break;
                case 4:
                    jmenusRecipe();
                    break;
                case 5:
                    jPreferences();
                    break;
            }
        } while (op != 0);
    }

    private void jRegisterDiet(){
        int op;
        StringBuilder txt = new StringBuilder();
        txt.append("Menu Dieta, Selecione a opção");
        txt.append("\n 1 - Ver Dieta Atual");
        txt.append("\n 2 - Adicionar Dieta");
        txt.append("\n 3 - Atualizar Dieta");
        txt.append("\n 0 - Sair");
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op){
                case 1:
                    RegistroDieta currentDiet = diets.getRegisterByUser(userlogged);
                    if (currentDiet == null){
                        jError("Você não possui nenhuma dieta.");
                    }else{
                        jConfirmation(currentDiet.toString());
                    }
                    break;
                case 2:
                    if (diets.getRegisterByUser(userlogged) == null){
                        RegistroDieta newDiet = new RegistroDieta();
                        newDiet.setUser(userlogged);
                        newDiet.setPhysicalAssessment(physical.getPhysicalByUser(userlogged));
                        String dietTypeName = JOptionPane.showInputDialog("Qual o Nome do Tipo de Dieta");
                        newDiet.setDiet(dietType.getDietByName(dietTypeName));
                        newDiet.setGoal(Integer.parseInt(JOptionPane.showInputDialog("Qual seu objetivo: \n 1 - Manter o Peso \n 2 - Perder Peso \n 3 - Ganhar Peso")));
                        double calories = (4 * newDiet.getDiet().getCarboidrato()) + (4 * newDiet.getDiet().getProteina()) + (9 * newDiet.getDiet().getGordura());
                        newDiet.setCalories(calories);
                        newDiet.setnMeals(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Refeições")));
                        newDiet.setDataCriacao(LocalDate.now());
                        newDiet.setDataModificacao(LocalDate.now());
                        diets.addRegister(newDiet);
                    }else{
                        jError("Ja adicioda a Dieta, se tiver alguma alteração Atualize as Informações");
                    }
                    break;
                case 3:
                    RegistroDieta dietUpdated = diets.getRegisterByUser(userlogged);
                    dietUpdated.setDiet(dietType.getDietByName(JOptionPane.showInputDialog("Qual o Nome do Tipo de Dieta")));
                    dietUpdated.setDataModificacao(LocalDate.now());
                    break;
                case 4:
                    for (int i = 0; i < diets.getRegisterDB().length; i++) {
                        if (diets.getRegisterDB()[i] != null){
                            System.out.println( diets.getRegisterDB()[i].toString());
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    jError("Opção Inválida,Insira novamente");
                    break;
            }
        }while (op != 0);
    }

    private void jPreferences() {
        int op;
        String txt = "O que deseja? " +
                "\n 1 - Criar Preferencias " +
                "\n 2 - Ver suas Preferencias";
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op) {
                case 1:
                    jCreatePreference();
                    break;
                case 2:
                    jMyPreferences();
                    break;
                default:
                    op = 3;
                    break;
            }
        } while (op != 3);
    }

    private void jMyPreferences() {
        Preferencias[] myPreferences = preferences.getPreferencesByUser(userlogged);
        for (Preferencias e :
                myPreferences) {
            if (e != null) {
                jConfirmation(e.toString());
            }
        }
    }

    private void jCreatePreference() {
        Preferencias newPreference = new Preferencias();
        String nameFood = JOptionPane.showInputDialog("Nome do Alimento");
        AlimentoReceita food = foods.searchNameFood(nameFood);
        if (food != null) {
            newPreference.setFood(food);
        } else {
            jError("Comida nao encontrada, Por favor Insira novamente");
        }
        newPreference.setUser(userlogged);
        newPreference.setDataCriacao(LocalDate.now());
        newPreference.setDataModificacao(LocalDate.now());
        preferences.addDiet(newPreference);
    }

    private void jTypeDiet() {
        int op;
        String txt = "O que deseja?" +
                "\n 1 - Criar Novo Tipo de Dieta" +
                "\n 2 - Ver Tipos de Dieta " +
                "\n 3 - Sair";
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op) {
                case 1:
                    jCreateTypeDiet();
                    break;
                case 2:
                    jShowTypesDiet();
                    break;
                default:
                    op = 3;
                    break;
            }
        } while (op != 3);
    }

    private void jShowTypesDiet() {
        TipoDieta[] array = dietType.getDietsDB();
        for (TipoDieta e :
                array) {
            if (e != null) {
                jConfirmation(e.toString());
            }
        }
    }

    private void jCreateTypeDiet() {
        TipoDieta newDietType = new TipoDieta();
        newDietType.setNome(JOptionPane.showInputDialog("Insira o nome"));
        newDietType.setCarboidrato(Double.parseDouble(JOptionPane.showInputDialog("Quantidade de Carboidrato")));
        newDietType.setProteina(Double.parseDouble(JOptionPane.showInputDialog("Quantidade de Proteina")));
        newDietType.setGordura(Double.parseDouble(JOptionPane.showInputDialog("Quantidade de Gordura")));
        newDietType.setDataCriacao(LocalDate.now());
        newDietType.setDataModificacao(LocalDate.now());
        dietType.addDiet(newDietType);
    }

    public Pessoa jLogin() {
        String username = JOptionPane.showInputDialog("Login");
        String password = JOptionPane.showInputDialog("Senha");
        for (Pessoa user :
                users.getUsers()) {
            if (user == null) {
                return null;
            }
            if (user.getLogin().equals(username) && user.getSenha().equals(password)) {
                jConfirmation("Login feito com Sucesso!");
                return user;
            }
        }
        return null;
    }

    public void jUpdate() {
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
        } while (op != 7);
    }

    public void jRegister() {
        Pessoa newUser = new Pessoa();
        newUser.setNome(JOptionPane.showInputDialog("Insira o nome"));
        newUser.setSexo(JOptionPane.showInputDialog("Insira o novo sexo \n M - Masculino \n F - Feminino").charAt(0));
        newUser.setNascimento(LocalDate.parse(JOptionPane.showInputDialog("Insira a nova data de nascimento Exemplo 25-09-1999"), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        newUser.setLogin(JOptionPane.showInputDialog("Insira o novo login"));
        newUser.setSenha(JOptionPane.showInputDialog("Insira o Novo Senha"));
        newUser.setTipoUsuario(Integer.parseInt(JOptionPane.showInputDialog("Insira o novo tipo de usuário")));
        newUser.setDataCriacao(LocalDate.now());
        newUser.setDataModicacao(LocalDate.now());
        users.addUsers(newUser);
    }

    public void jMenuPhysicalAssessment() {
        String msg = "O Que Gostaria de Fazer? " +
                "\n 1 - Fazer Avaliação Física" +
                "\n 2 - Ver Avaliações Antigas" +
                "\n 0 - Sair";
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(msg));
            switch (op) {
                case 1:
                    jPhysicalAssessment();
                    break;
                case 2:
                    String txt = "";
                    AvaliacaoFisica[] teste = physical.getPhysicalsByUser(userlogged);
                    for (AvaliacaoFisica avalicao :
                            teste) {
                        if (avalicao != null) {
                            txt += "\n " + avalicao.toString();
                        }
                    }
                    jConfirmation(txt);
                    break;
                case 3:
                    break;
                default:
                    jError("Opção Inválida, Por favor Insira novamente");
                    break;
            }
        } while (op != 0);
    }

    public void jPhysicalAssessment() {
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
        jPhysicalReport(newAssessment);
    }

    public void jPhysicalReport(AvaliacaoFisica avaliacaoFisica) {
        String type = avaliacaoFisica.idealBodyFat();
        String report = "Relatório Avaliação Física " +
                "\n Nome " + avaliacaoFisica.getUser().getNome() +
                "\n Idade " + avaliacaoFisica.getIdade() +
                "\n Altura " + avaliacaoFisica.getAltura() +
                "\n Peso " + avaliacaoFisica.getPeso() +
                "\n IMC " + avaliacaoFisica.getImc() +
                "\n TMB " + avaliacaoFisica.getTbm() +
                "\n Massa Magra " + avaliacaoFisica.getMassaMagra() +
                "\n Massa Gorda " + avaliacaoFisica.getMassaGorda() +
                "\n %BF " + avaliacaoFisica.getBf() +
                "\n Avalição Gordura Corporal " + type;
        jConfirmation(report);
    }

    public void jSocial() {
        StringBuilder txt = new StringBuilder();
        txt.append("Bem Vindo a NutriSphere, ").append(userlogged.getNome());
        txt.append("\n Seguidores: ").append(follows.followers(userlogged));
        txt.append("\n 1 - Ver Posts");
        txt.append("\n 2 - Criar Post");
        txt.append("\n 3 - Ver Mensagens").append("(2)");
        txt.append("\n 4 - Enviar Mensagem");
        txt.append("\n 5 - Adicionar Amigo");
        txt.append("\n 6 - Follows DEBUG");
        txt.append("\n 0 - Sair");
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(txt));
            switch (op) {
                case 1:
                    Pessoa[] seguidores = follows.getFollowers(userlogged);
                    Post[] myPosts = psts.getPostByUser(userlogged);
                    boolean verifyyme = false;

                    StringBuilder postText = new StringBuilder();

                    if (myPosts.length > 0) {
                        verifyyme = true;
                        postText.append("Meus posts ").append(":");
                        for (Post post : myPosts) {
                            postText.append("\n").append(post.getMsg());
                        }
                        postText.append("\n");
                    }
                    for (int x = 0; x < seguidores.length; x++) {
                        Post[] posts = psts.getPostByUser(seguidores[x]);
                        postText.append("\n");
                        if (posts.length != 0) {
                            postText.append("Posts de ").append(seguidores[x].getNome()).append(":");
                            for (Post post : posts) {
                                postText.append("\n").append(post.getMsg());
                            }
                            postText.append("\n");
                        }
                    }
                    if (verifyyme || postText.length() > 0) {
                        jConfirmation(postText.toString());
                    } else {
                        jError("Posts Vazios");
                    }
                    break;

                case 2:
                    String msgPost = JOptionPane.showInputDialog("Qual o post?");
                    Post newPost = new Post();
                    newPost.setUser(userlogged);
                    newPost.setMsg(msgPost);
                    psts.addPost(newPost);
                    break;
                case 3:
                    Mensagem[] msg = msgs.getMessagesByUser(userlogged.getNome());

                    StringBuilder messageee = new StringBuilder();

                    for (Mensagem mensagens : msg) {
                        if (mensagens != null) {
                            Pessoa sender = mensagens.getSender();
                            messageee.append("Mensagem de ").append(sender.getNome()).append("\n");
                            messageee.append("Conteúdo : ").append(mensagens.getMsg()).append("\n\n");
                        }
                    }
                    if (messageee.length() > 0) {
                        jConfirmation(messageee.toString());
                    } else {
                        jError("Nenhuma mensagem recebida, mas fique tranquilo, não é culpa sua.");
                    }
                    break;
                case 4:
                    String userName = JOptionPane.showInputDialog("Para Quem Gostaria de Enviar a Mensagem");
                    Pessoa user = users.getUser(userName);
                    if (user == null) {
                        jError("Usuario não encontrado, porfavor insira novamente");
                    } else {
                        String msgText = JOptionPane.showInputDialog("Qual é a mensagem");
                        Mensagem newMsg = new Mensagem();
                        newMsg.setSender(userlogged);
                        newMsg.setRecipient(user);
                        newMsg.setMsg(msgText);
                        msgs.addMessage(newMsg);
                    }
                    break;
                case 5:
                    String username = JOptionPane.showInputDialog("Quem Gostaria de Adicionar:>_");
                    if (username != null) {
                        Pessoa u;
                        u = users.getUser(username);
                        if (u != null) {
                            Seguir follow = new Seguir();
                            follow.setFollower(userlogged);
                            follow.setFollowed(u);
                            follow.setDataCriacao(LocalDate.now());
                            follow.setDataModificacao(LocalDate.now());
                            follows.addFollow(follow);
                            jConfirmation("Amigo adicionado com sucesso.");
                        } else {
                            jError("Error ao adicionar o amigo,Insira Novamente.");
                        }
                    } else {
                        jError("Error,Insira Novamente.");
                    }
                    break;
                case 6:
                    for (Seguir s:
                            follows.getFollowsDB()) {
                        if (s != null){
                            System.out.println(s);
                        }
                    }
                    break;
                default:
                    op = 0;
            }
        } while (op != 0);

    }
}

