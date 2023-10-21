package classes;
import dao.AlimentoReceitaDao;
import classes.JMenu;
import javax.swing.*;
import java.time.LocalDate;

import static classes.JMenu.foods;
import static utils.Utils.*;

public class JmenuAlimentoReceita {

    public static void jmenusRecipe() {
        int opcao, flag;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao menu de dietas, informe o que você deseja \n" +
                    "1 - Criar novo alimento \n" +
                    "2 - Verificar alimentos por nome \n" +
                    "3 - Atualizar alimentos\n" +
                    "4 - Excluir alimentos  \n" +
                    "5 - Verificar alimentos existentes \n" +
                    "0 - Sair \n"));

            String idName;
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    createRecipe();
                    break;
                case 2:
                    idName = JOptionPane.showInputDialog("Por favor, informe o nome do alimento");
                    AlimentoReceita alimento2  = foods.searchNameFood(idName);
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
                default:
                    jError("Opção Inválida, Por favor insira novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    public static void foodsExemples(){
            AlimentoReceita[] alimentosPadroes = foods.getAlimentore();

            StringBuilder listaAlimentos = new StringBuilder("Alimentos:\n");

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
        AlimentoReceita alimento3  = foods.searchNameFood(id);
        do {
            if (alimento3 != null) {
                double valorcal = 0;
                int opc = Integer.parseInt(JOptionPane.showInputDialog("Qual campo deseja atualizar?\n" +
                        "1 - Nome do alimento\n" +
                        "2 - Quantidade de carboidratos\n" +
                        "3 - Quantidade de proteínas\n" +
                        "4 - Quantidade de gorduras\n" +
                        "5 - Sair\n"));
                switch (opc) {
                    case 1:
                        do{
                            String foodInput = JOptionPane.showInputDialog("Digite o novo nome do alimento (mínimo 2 letras)");
                            if (foodInput != null && foodInput.length() >= 2){
                                alimento3.setNome(foodInput);
                                break;
                            }else{
                                JOptionPane.showMessageDialog(null, "Campo vazio, digite novamente o nome do alimento");
                            }
                        }while(true);
                        break;
                    case 2:
                            String input1 = (JOptionPane.showInputDialog("Digite a nova quantidade de carboidratos"));

                            if (input1 != null) {
                                try {
                                    double carboInput = Double.parseDouble(input1);
                                    alimento3.setCarboidratos(carboInput);
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "Entrada inválida. Digite uma quantidade validade carboidratos.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Entrada vazia, informe corretamente.");
                            }
                            break;

                    case 3:

                        String input2 = (JOptionPane.showInputDialog("Digite a nova quantidade de proteínas"));

                        if (input2 != null) {
                            try {
                                double proteinInput = Double.parseDouble(input2);
                                alimento3.setProteinas(proteinInput);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Entrada invalida, digite uma quantidade valida de proteinas.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Entrada vazia, informe corretamente.");
                        }
                        break;
                    case 4:
                        String input3 = (JOptionPane.showInputDialog("Digite a nova quantidade de proteínas"));

                        if (input3 != null) {
                            try {
                                double fatInput = Double.parseDouble(input3);
                                alimento3.setGorduras(fatInput);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Entrada invalida, digite uma quantidade valida de gorduras.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Entrada vazia, informe corretamente.");
                        }
                        break;
                    case 5:
                        opc2 = 5;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, 
                                "Opção inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
                        break;
                }
                alimento3.setCalorias();
            } else {
                JOptionPane.showMessageDialog(null, "Alimento ou receita não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }while(opc2 != 5);
    }
}
