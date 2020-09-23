/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaloneitor;

import static escaloneitor.Escaloneitor.cilindros;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Rosana
 */
public class Elevador {
    private String ordemCilindro = "";
    private int tempoTotal = 0;
    ArrayList<Integer> copia = null;
    
    public void elevador(int opt){
        copia = new ArrayList<>(Escaloneitor.cilindros);
        Collections.sort(copia);
        int binarySearch = Collections.binarySearch(copia, Escaloneitor.CILINDRO_INICIAL);
        int i,cAtual=0,cAnterior = Escaloneitor.CILINDRO_INICIAL;
        
        if(!copia.isEmpty()){
            if(binarySearch <0){
                if(copia.get(0)> Escaloneitor.CILINDRO_INICIAL){
                    cAtual = 0;
                    opt = 2;
                }
                if(copia.get(copia.size()-1) < Escaloneitor.CILINDRO_INICIAL){
                    cAtual = copia.size()-1;
                    opt = 3;
                }
            }else{
                cAtual = binarySearch;
            }
            
            while(!copia.isEmpty()){
                if(cAtual==0 && opt==3 ) opt = 2;
                if(cAtual==copia.size()-1 && opt==2) opt = 3;
                ordemCilindro = ordemCilindro + copia.get(cAtual) + " ";
                tempoTotal = tempoTotal + Math.abs(cAnterior - copia.get(cAtual));
                cAnterior = copia.get(cAtual);
                copia.remove(cAtual);
                if(opt==3) cAtual--;
            }
        }
        Escaloneitor.TEMPO_TOTAL = tempoTotal*Escaloneitor.TEMPO_SEEK;
        Escaloneitor.ORDEM_VISITA = ordemCilindro;
    
    }
}
