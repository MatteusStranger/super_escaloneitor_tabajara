/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaloneitor;
import Telas.TelaInicial;
import java.util.ArrayList;
import java.util.Collections;

        
/**
 *
 * @author luiz
 */
public class Escaloneitor {

    public static ArrayList<Integer> cilindros = null;
    public static int CILINDRO_INICIAL = 0;
    public static int TEMPO_SEEK = 0;
    // Retornar os valores dos metodos atraves dessa variavel 
    public static int TEMPO_TOTAL = 0; // Nesta variavel que deve ser retornado o tempo total
    public static String ORDEM_VISITA = "TESTE";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        cilindros = new ArrayList<>();
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
    }
    
}
