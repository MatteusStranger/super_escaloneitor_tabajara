/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escaloneitor;
/**
 *
 * @author luiz
 */
public class FCFS {
    
public void fcfs(){
    int somatorio;
    
    somatorio = Math.abs(Escaloneitor.CILINDRO_INICIAL - Escaloneitor.cilindros.get(0));
    
    String ordemCilindro = Escaloneitor.cilindros.get(0)+" ";
    
    
    for (int i = 0; i < Escaloneitor.cilindros.size()-1; i++) {
        somatorio += Math.abs(Escaloneitor.cilindros.get(i) - Escaloneitor.cilindros.get(i+1));
        ordemCilindro = ordemCilindro + Escaloneitor.cilindros.get(i+1) + " ";
    }
    Escaloneitor.TEMPO_TOTAL = Escaloneitor.TEMPO_SEEK * somatorio;
    Escaloneitor.ORDEM_VISITA = ordemCilindro;
    
}      
/*TESTE
public static void main(String[] args) {
    ArrayList<Integer> cilindros = new ArrayList(); 
    cilindros.add(10); cilindros.add(22); cilindros.add(20);
    cilindros.add(2); cilindros.add(40); cilindros.add(6); cilindros.add(38);
    System.out.println(cilindros);
    System.out.println(fcfs(cilindros, 20, 6));     
}*/   
}
