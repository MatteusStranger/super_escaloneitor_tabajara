# Super Escaloneitor Tabajara
Implementação dos algoritmos de escalonamento do braço no disco rígido FCFS (First-Come, First Served), Shortest Seek First (SSF) e Elevador.
Programa desenvolvido em Java com interface gráfica feito com Swing.

Execute o .jar com:
```
java -jar EscaloneitorFinal2.jar
```
Ou então, importe o código na IDE Netbeans e dê o comando build ```F6```.

# Execução

Entre com os **Dados** e depois com a sequência de cilindros. Ele irá retornar a ordem de escalonamento.

# Drivers de Disco – Escalonamento do braço

Quando o disco está muito carregado, é provável que, durante uma busca, outras requisições sejam geradas por outros processos. 
O driver de disco mantém uma tabela de requisições pendentes, indexada pelo número do cilindro, com todas as requisições pendentes em uma lista ligada. 
Cada entrada da tabela tem a lista de requisições para seu cilindro correspondente.
Dado um cilindro inicial e a sequência de outros cilindros na tabela, cabe ao escalonador decidir a ordem de atendimento.

## First-Come, First-Served (FCFS)

O driver aceita uma requisição por vez, e as executa nessa ordem. 
É uma fila, então pouco pode ser feito para otimização.

## Shortest Seek First (SSF)

Sempre atenda em seguida a requisição mais próxima. 
Minimiza o tempo de busca. 
Se o disco estiver carregado, tenderá a ficar no meio a maior parte do tempo.
Requisições nos extremos do disco demorarão a ser atendidas.

## Elevador

Requisições chegam continuamente e aleatoriamente
Os elevadores tentam conciliar eficiência e justiça: Continuam se movendo na mesma direção até não haver mais requisições pendentes naquela direção.
Então trocam de direção.
