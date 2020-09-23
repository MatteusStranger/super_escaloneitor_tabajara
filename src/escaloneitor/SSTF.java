/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaloneitor;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author matteus
 */
public class SSTF extends Escaloneitor {

    ArrayList<Integer> c = null;
    private String ordemCilindro = "";

    public void SSTF() {
        c = new ArrayList<>(Escaloneitor.cilindros);
        Collections.sort(c);
        int cilindroEscolhido = Collections.binarySearch(c, Escaloneitor.CILINDRO_INICIAL);
        int escolhido;
        if (!c.isEmpty()) {
            if (cilindroEscolhido < 0) {
                escolhido = Escaloneitor.CILINDRO_INICIAL;
                for (int i = 0; i < c.size(); i++) {
                    if (Math.abs(Escaloneitor.CILINDRO_INICIAL - c.get(i)) < escolhido) {
                        escolhido = Math.abs(Escaloneitor.CILINDRO_INICIAL - c.get(i));
                        cilindroEscolhido = i;
                    }
                }
                Escaloneitor.TEMPO_TOTAL = Escaloneitor.TEMPO_TOTAL + escolhido;
            }
            escolhido = 0;
            int j = 0;
            while (!c.isEmpty()) {
                j++;
                if ((cilindroEscolhido - 1 >= 0) && (cilindroEscolhido + 1 <= c.size() - 1)) {
                    int antes = Math.abs(c.get(cilindroEscolhido - 1) - c.get(cilindroEscolhido));
                    int depois = Math.abs(c.get(cilindroEscolhido + 1) - c.get(cilindroEscolhido));
                    if (antes > depois) {
                        Escaloneitor.TEMPO_TOTAL = Escaloneitor.TEMPO_TOTAL + depois;
                        escolhido = c.get(cilindroEscolhido + 1);
                        ordemCilindro = ordemCilindro + c.get(cilindroEscolhido) + " ";
                        c.remove(cilindroEscolhido);
                        cilindroEscolhido = c.indexOf(escolhido);
                    } else {
                        Escaloneitor.TEMPO_TOTAL = Escaloneitor.TEMPO_TOTAL + antes;
                        escolhido = c.get(cilindroEscolhido - 1);
                        ordemCilindro = ordemCilindro + c.get(cilindroEscolhido) + " ";
                        c.remove(cilindroEscolhido);
                        cilindroEscolhido = c.indexOf(escolhido);
                    }
                } else if ((cilindroEscolhido - 1 >= 0) && (cilindroEscolhido + 1 >= c.size())) {
                    int antes = Math.abs(c.get(cilindroEscolhido - 1) - c.get(cilindroEscolhido));
                    Escaloneitor.TEMPO_TOTAL = Escaloneitor.TEMPO_TOTAL + antes;
                    escolhido = c.get(cilindroEscolhido - 1);
                    ordemCilindro = ordemCilindro + c.get(cilindroEscolhido) + " ";
                    c.remove(cilindroEscolhido);
                    cilindroEscolhido = c.indexOf(escolhido);
                } else if ((cilindroEscolhido - 1 < 0) && (cilindroEscolhido + 1 <= c.size() - 1)) {
                    int depois = Math.abs(c.get(cilindroEscolhido + 1) - c.get(cilindroEscolhido));
                    Escaloneitor.TEMPO_TOTAL = Escaloneitor.TEMPO_TOTAL + depois;
                    escolhido = c.get(cilindroEscolhido + 1);
                    ordemCilindro = ordemCilindro + c.get(cilindroEscolhido) + " ";
                    c.remove(cilindroEscolhido);
                    cilindroEscolhido = c.indexOf(escolhido);
                } else {
                    ordemCilindro = ordemCilindro + c.get(cilindroEscolhido) + " ";
                    c.remove(cilindroEscolhido);
                }
            }
            Escaloneitor.TEMPO_TOTAL = Escaloneitor.TEMPO_TOTAL * Escaloneitor.TEMPO_SEEK;
        }
        Escaloneitor.ORDEM_VISITA = ordemCilindro;
    }
}