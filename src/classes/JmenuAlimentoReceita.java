package classes;
import dao.AlimentoReceitaDao;
import classes.JMenu;
import javax.swing.*;
import java.time.LocalDate;

import static classes.JMenu.jConfirmation;

public class JmenuAlimentoReceita {
    static AlimentoReceitaDao alimento = new AlimentoReceitaDao();
    static AlimentoReceita alimento2 = new AlimentoReceita();

    public static void jmenusRecipe() {
        int opcao, flag;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao menu de dietas, informe o que você deseja \n" +
                    "1 - Criar nova dieta \n" +
                    "2 - Verificar alimentos e receitas por nome \n" +
                    "3 - Atualizar alimentos e receitas \n" +
                    "4 - Excluir alimentos e receitas  \n" +
                    "5 - verificar alimentos exemplares \n" +
                    "6 - Sair \n"));

            String idName;
            switch (opcao) {
                case 6:
                    break;
                case 1:
                    createRecipe();
                    break;

                case 2:
                    idName = JOptionPane.showInputDialog("Por favor, informe o nome do alimento ou receita");
                    alimento2 = alimento.searchNameFood(idName);
                    if (alimento2 != null) {
                        jConfirmation("Dados do Alimento \n\n" + alimento2.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Alimento ou receita não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    jmenuUpdateFood();
                    break;

                case 4:
                    idName = JOptionPane.showInputDialog("Por favor, informe o ID do alimento ou receita");
                    alimento2 = alimento.getRecipeByIDFood(idName);

                    if (alimento2 != null) {
                        alimento.deleteRecipe(idName);
                        JOptionPane.showMessageDialog(null, "Alimento ou receita excluído com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Alimento ou receita não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:
                    foodsExemple();
            }
        }while (opcao != 6);
    }

    public static void foodsExemple(){
        AlimentoReceita[] alimentosPadroes = alimento.getAlimentore();

        StringBuilder listaAlimentos = new StringBuilder("Alimentos Padrões:\n");

        for (AlimentoReceita alimentoPadrao : alimentosPadroes) {
            if (alimentoPadrao != null) {
                listaAlimentos.append(alimentoPadrao.toString()).append("\n\n");
            }
        }

        jConfirmation(listaAlimentos.toString());
    }
    private static void createRecipe() {
        AlimentoReceita newreceipss = new AlimentoReceita();
        {
            newreceipss.setNome(JOptionPane.showInputDialog("Insira o nome do alimento para a dieta"));
            newreceipss.setCarboidratos(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de carboidratos desse alimento")));
            newreceipss.setProteinas(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de de proteinas desse alimento")));
            newreceipss.setGorduras(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de gorduras desse alimento")));
            double valorcal = 4 * newreceipss.getCarboidratos() + 4 * newreceipss.getProteinas() + 9 * newreceipss.getGorduras();
            newreceipss.setCalorias(valorcal);
            newreceipss.setTipoUsuario(JOptionPane.showInputDialog("Digite o tipo de usuário da dieta"));
            newreceipss.setDataCriacao(LocalDate.now());
            newreceipss.setDataModificacao(LocalDate.now());

            alimento.addAlPe(newreceipss);
            JOptionPane.showMessageDialog(null, "Alimento criado com sucesso");
        }
    }

    public static void jmenuUpdateFood(){
        String id = JOptionPane.showInputDialog("Digite o ID do alimento ou receita que deseja atualizar");
        alimento2 = alimento.getRecipeByIDFood(id);

        if (alimento2 != null){
            int opc = Integer.parseInt(JOptionPane.showInputDialog("Qual campo deseja atualizar?\n" +
                    "1 - Nome do alimento\n" +
                    "2 - Quantidade de carboidratos\n" +
                    "3 - Quantidade de proteínas\n" +
                    "4 - Quantidade de gorduras\n" +
                    "6 - Tipo de usuário\n"));

            switch (opc) {
                case 1:
                    alimento2.setNome(JOptionPane.showInputDialog("Digite o novo nome"));
                    break;
                case 2:
                    alimento2.setCarboidratos(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de carboidratos")));
                    break;
                case 3:
                    alimento2.setProteinas(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de proteínas")));
                    break;
                case 4:
                    alimento2.setGorduras(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de gorduras")));
                    double valorcal = 4 * alimento2.getCarboidratos() + 4 * alimento2.getProteinas() + 9 * alimento2.getGorduras();
                    alimento2.setCalorias(valorcal);
                    break;
                case 5:
                    alimento2.setTipoUsuario(JOptionPane.showInputDialog("Digite o novo tipo de usuário"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Alimento ou receita não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
