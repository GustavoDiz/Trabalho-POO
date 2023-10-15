package classes;
import dao.AlimentoReceitaDao;
import classes.JMenu;
import javax.swing.*;
import java.time.LocalDate;

import static classes.JMenu.foods;
import static utils.Utils.*;

public class JmenuAlimentoReceita {
    static AlimentoReceita alimento2 = new AlimentoReceita();

    public static void jmenusRecipe() {
        int opcao, flag;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao menu de dietas, informe o que você deseja \n" +
                    "1 - Criar novo alimento \n" +
                    "2 - Verificar alimentos por nome \n" +
                    "3 - Atualizar alimentos\n" +
                    "4 - Excluir alimentos  \n" +
                    "5 - Verificar alimentos existentes \n" +
                    "6 - Sair \n"));

            String idName;
            switch (opcao) {
                case 6:
                    break;
                case 1:
                    createRecipe();
                    break;
                case 2:
                    idName = JOptionPane.showInputDialog("Por favor, informe o nome do alimento");
                    alimento2 = foods.searchNameFood(idName);
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
                    idName = JOptionPane.showInputDialog("Por favor, informe o nome desse alimento");
                    alimento2 = foods.searchNameFood(idName);

                    if (alimento2 != null) {
                        foods.deleteRecipe(idName);
                        JOptionPane.showMessageDialog(null, "Alimento excluído com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Alimento não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 5:
                    foodsExemples();
                    break;
            }
        } while (opcao != 6);
    }

    public static void foodsExemples(){
            AlimentoReceita[] alimentosPadroes = foods.getAlimentore();

            StringBuilder listaAlimentos = new StringBuilder("Alimentos:\n");

            for (AlimentoReceita alimentoPadrao : alimentosPadroes) {

                if (alimentoPadrao != null) {
                    System.out.println("abababab");
                    listaAlimentos.append(alimentoPadrao.toString()).append("\n\n");
                }
            }
            jConfirmation(listaAlimentos.toString());

        }
    private static void createRecipe() {
        AlimentoReceita newreceipss = new AlimentoReceita();
        {
            newreceipss.setNome(JOptionPane.showInputDialog("Insira o nome do novo alimento"));
            newreceipss.setCarboidratos(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de carboidratos desse alimento")));
            newreceipss.setProteinas(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de de proteinas desse alimento")));
            newreceipss.setGorduras(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de gorduras desse alimento")));
            newreceipss.setCalorias();
            newreceipss.setDataCriacao(LocalDate.now());
            newreceipss.setDataModificacao(LocalDate.now());

            foods.addAlPe(newreceipss);
            JOptionPane.showMessageDialog(null, "Alimento criado com sucesso");
        }
    }

    public static void jmenuUpdateFood(){
        int opc2 = 0;
        String id = JOptionPane.showInputDialog("Digite o nome do alimento que você deseja atualizar");
        alimento2 = foods.searchNameFood(id);
        do {
            if (alimento2 != null) {
                double valorcal = 0;
                int opc = Integer.parseInt(JOptionPane.showInputDialog("Qual campo deseja atualizar?\n" +
                        "1 - Nome do alimento\n" +
                        "2 - Quantidade de carboidratos\n" +
                        "3 - Quantidade de proteínas\n" +
                        "4 - Quantidade de gorduras\n" +
                        "5 - Sair\n"));
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
                        break;
                    case 5:
                        opc2 = 5;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
                alimento2.setCalorias();
            } else {
                JOptionPane.showMessageDialog(null, "Alimento ou receita não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }while(opc2 != 5);
    }
}
