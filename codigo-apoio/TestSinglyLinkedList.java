// ------------------------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// ------------------------------------------------------------------------
// Exemplo de utilizacao da lista ligada simples (Pedro Ribeiro @ DCC-FCUP) 
// ------------------------------------------------------------------------

import java.util.Arrays;

public class TestSinglyLinkedList {
    public static void main(String[] args) {
 
       // Criacao de lista de inteiros
       SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
       SinglyLinkedList<Integer> lista = new SinglyLinkedList<Integer>();

       // Escrevendo lista (no inicio esta vazia)
       System.out.println(list);
 
       // Verificando se esta vazia
       System.out.println("isEmpty? " + list.isEmpty());     
       
       // Adicionando numeros de 1 a 5 ao final da lista
       for (int i=1; i<=5; i++)
          list.addLast(i);
       System.out.println(list);
 
       // Adicionando numeros de 6 a 10 ao inicio da lista
       for (int i=6; i<=10; i++)
          list.addFirst(i);
       System.out.println(list);
 
       // Verificando o tamanho da lista
       System.out.println("size = " + list.size());
 
       // Retirando o primeiro elemento
       list.removeFirst();
       System.out.println(list);
 
       // Retirando o ultimo elemento
       list.removeLast();
       System.out.println(list);
 
       // Verificando se esta vazia
       System.out.println("isEmpty? " + list.isEmpty());
 
       // Escreve o primeiro e ultimo elementos
       System.out.println("getFirst() = " + list.getFirst());
       System.out.println("getLast() = " + list.getLast());

       for (int i=2; i<=8; i+=2)
         lista.addLast(i);
      System.out.println(lista);
      System.out.println("reverse = " + lista.reverse());

      SinglyLinkedList<Integer> lis = new SinglyLinkedList<>();
      lis.addLast(2);
      lis.addLast(5);
      lis.addLast(1);
      lis.addLast(1);
      lis.addLast(2);
      lis.addLast(1);

      // Testa o método occurrences
      System.out.println(Arrays.toString(lis.ocorrences(1))); // [2, 3, 5]
      System.out.println(Arrays.toString(lis.ocorrences(2))); // [0, 4]
      System.out.println(Arrays.toString(lis.ocorrences(3))); // null
      
      SinglyLinkedList<Integer> listaremover = new SinglyLinkedList<>();
      listaremover.addLast(42);
      listaremover.addLast(22);
      listaremover.addLast(42);
      listaremover.addLast(42);
      listaremover.addLast(22);
      listaremover.addLast(42);
      listaremover.insert(5,2);
      System.out.println(listaremover);

   }
 }