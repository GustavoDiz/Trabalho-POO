package classes;
import dao.AlimentoReceitaDao;
import classes.JMenu;
import javax.swing.*;
import java.time.LocalDate;

import static classes.JMenu.jConfirmation;

public class JmenuAlimentoReceita {
    static AlimentoReceitaDao alimento = new AlimentoReceitaDao();
    static AlimentoReceita alimento2 = new AlimentoReceita();

    public static void jmenusRecipe(){
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao menu de dietas, informe o que você deseja \n" +
                    "1- Criar nova dieta \n" +
                    "2- Verificar alimentos e receitas por ID \n" +
                    "3 - Atualizar alimentos e receitas \n" +
                    "4 - Excluir alimentos e receitas  \n" +
                    "5 - Sair \n"));

            String idName;
            switch (opcao) {
                case 5:
                    break;
                case 1:
                    createRecipe();
                    break;

                case 2:
                    idName = JOptionPane.showInputDialog("Por favor, informe o nome do alimento ou receita");
                    alimento2 = alimento.searchNameFood(idName);
                    if (alimento2 != null) {
                        jConfirmation("Login feito com Sucesso!" + alimento2.toString());
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
            }
        } while (opcao != 5);
    }

    private static void createRecipe() {
        AlimentoReceita newreceipss = new AlimentoReceita();

        newreceipss.setNome(JOptionPane.showInputDialog("Insira o nome"));

        newreceipss.setCarboidratos(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de carboidratos da dieta")));
        newreceipss.setProteinas(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de proteínas da dieta")));
        newreceipss.setGorduras(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de gorduras da dieta")));
        newreceipss.setCalorias(Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de calorias da dieta")));
        newreceipss.setPorcao(Double.parseDouble(JOptionPane.showInputDialog("Digite a porção da dieta")));
        newreceipss.setTipoUsuario(JOptionPane.showInputDialog("Digite o tipo de usuário da dieta"));

        newreceipss.setDataCriacao(LocalDate.now());
        newreceipss.setDataModificacao(LocalDate.now());

        alimento.addAlPe(newreceipss);
        JOptionPane.showMessageDialog(null, "Dieta criada com sucesso");
    }

    public static void jmenuUpdateFood() {
        String id = JOptionPane.showInputDialog("Digite o ID do alimento ou receita que deseja atualizar");
        alimento2 = alimento.getRecipeByIDFood(id);

        if (alimento2 != null) {
            int opc = Integer.parseInt(JOptionPane.showInputDialog("Qual campo deseja atualizar?\n" +
                    "1 - Nome\n" +
                    "2 - Quantidade de carboidratos\n" +
                    "3 - Quantidade de proteínas\n" +
                    "4 - Quantidade de gorduras\n" +
                    "5 - Quantidade de calorias\n" +
                    "6 - Porção da dieta\n" +
                    "7 - Tipo de usuário\n"));

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
                    alimento2.setCalorias(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova quantidade de calorias")));
                    break;
                case 6:
                    alimento2.setPorcao(Double.parseDouble(JOptionPane.showInputDialog("Digite a nova porção")));
                    break;
                case 7:
                    alimento2.setTipoUsuario(JOptionPane.showInputDialog("Digite o novo tipo de usuário"));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Alimento ou receita não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
