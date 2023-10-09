package classes;
import javax.swing.*;
import java.time.LocalDate;

import dao.RegistroDietaDAO;


/* public class JMenuRegistroDieta {
    static RegistroDietaDAO diets = new RegistroDietaDAO();
    static RegistroDieta dietss2 = new RegistroDieta();
    private static void createDiet() {
        RegistroDieta newDiet = new RegistroDieta();
        {
            newDiet.setDiet(JOptionPane.showInputDialog("Insira o nome da dieta"));
            newDiet.setGoal(Integer.parseInt(JOptionPane.showInputDialog("Digite sua meta")));
            newDiet.setnMeals(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de refeições")));
            newDiet.setDataCriacao(LocalDate.now());
            newDiet.setDataModificacao(LocalDate.now());
            diets.addRegister(newDiet);
            JOptionPane.showMessageDialog(null, "Dieta criada com sucesso");
        }
    }
    public static void jmenuUpdateDiet(){
        int opc2 = 0;
        String id = JOptionPane.showInputDialog("Digite o ID do alimento ou receita que deseja atualizar");
        dietss2 = diets.getRegisterByIdDiet(id);
        do {
            if (dietss2 != null){
                int opc = Integer.parseInt(JOptionPane.showInputDialog("Qual campo deseja atualizar?\n" +
                        "1 - Nome do alimento\n" +
                        "2 - Quantidade de carboidratos\n" +
                        "3 - Quantidade de proteínas\n" +
                        "4 - Quantidade de gorduras\n" +
                        "6 - Tipo de usuário\n"));

                switch (opc){
                    case 1:
                        dietss2.setDiet(JOptionPane.showInputDialog("Digite a nova dieta"));
                        break;
                    case 2:
                        dietss2.setGoal(Integer.parseInt(JOptionPane.showInputDialog("Digite a nova meta")));
                        break;
                    case 3:
                        dietss2.setnMeals(Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade de refeições")));
                        break;
                    case 4:
                        opc2 = 4;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida", "Alerta", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Alimento ou receita não encontrado", "Alerta", JOptionPane.ERROR_MESSAGE);
            }
        }while(opc2 != 4);
    }
} */
