// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Lista ligada simples (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class SinglyLinkedList<T> {
    private Node<T> first;    // Primeiro no da lista
    private int size;         // Tamanho da lista
 
    // Construtor (cria lista vazia)
    SinglyLinkedList() {
       first = null;
       size = 0;
    }
 
    // Retorna o tamanho da lista
    public int size() {
       return size;
    }

    public SinglyLinkedList<T> reverse(){
      SinglyLinkedList<T> nova = new SinglyLinkedList<>();
      Node<T> cur = first;
      while(cur != null){
         nova.addFirst(cur.getValue());
         cur = cur.getNext();
      }
      return nova;
  }

  public int[] ocorrences (T elem){
   int[] ocorrences = new int[size()];
   Node <T> cur = first;
   int i = 0;
   int j = 0;
   while(cur!=null){
       if(cur.getValue().equals(elem)){
           ocorrences[j++] = i;
       }
       cur = cur.getNext();
       i++;
   }
   if (j==0) return null;
   int[] ocorrences2 = new int[j];
   for(int l = 0; l < j;l++){
       ocorrences2[l] = ocorrences[l];
   } 
   return ocorrences2;
}
 
    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
       return (size == 0);
    }
    
    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
       Node<T> newNode = new Node<T>(v, first); 
       first = newNode;
       size++;
    }
 
    // Adiciona v ao final da lista
    public void addLast(T v) {
       Node<T> newNode = new Node<T>(v, null); 
       if (isEmpty()) {
          first = newNode;
       } else {
          Node<T> cur = first;
          while (cur.getNext() != null)
             cur = cur.getNext();
          cur.setNext(newNode);         
       }
       size++;
    }
 
    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
       if (isEmpty()) return null;
       return first.getValue();
    }
 
    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
       if (isEmpty()) return null;
       Node<T> cur = first;
       while (cur.getNext() != null)
          cur = cur.getNext();
       return cur.getValue();      
    }
 
    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
       if (isEmpty()) return;
       first = first.getNext();
       size--;
    }
 
    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
       if (isEmpty()) return;
       if (size == 1) {
          first = null;
       } else {
          // Ciclo com for e uso de de size para mostrar alternativa ao while
          Node<T> cur = first;
          for (int i=0; i<size-2; i++)
             cur = cur.getNext();
          cur.setNext(cur.getNext().getNext());
       }
       size--;
    }

    //Retorna o valor do nó na posição pos
    public T get(int pos){
        Node<T> cur = first;
        for (int i = 0; i < size; i++){
            if(i == pos)
                return cur.getValue();
            cur = cur.getNext();
        }
        return null; 
    }

    //Remover elemento numa dada posição
    public T remove(int pos){
        Node<T> cur = first;
        if (pos < 0 || pos >= size())
            return null;
        T removed_value = first.getValue();
        if (pos == 0)
            first = first.getNext();
        else{
            for(int i = 0; i < pos - 1; i++){
                cur = cur.getNext();
            }
            removed_value = cur.getNext().getValue();
            cur.setNext(cur.getNext().getNext());
            }
        size--;
        return removed_value;
    }

    public void toremove(SinglyLinkedList<T> toRemove){
      Node <T> curremove = toRemove.first;
  
      while (curremove!=null){
          while(first!=null && first.getValue().equals(curremove.getValue())){
              first = first.getNext();
              size--;
          }
          Node <T> cur = first;
          while(cur!=null && cur.getNext()!=null){
              if(cur.getNext().getValue().equals(curremove.getValue())){
                  cur.setNext(cur.getNext().getNext());
                  size--;
              }
              else{
                  cur = cur.getNext();}
          }
          curremove = curremove.getNext();
      }
  }

    //Copia de uma nova lista
    public SinglyLinkedList<T> copy(){
        SinglyLinkedList<T> newlist = new SinglyLinkedList<T>();
        Node<T> cur = first;
        while(cur != null){
            newlist.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return newlist;
    }

    public void duplicate(){
        Node<T> cur = first;
        while (cur != null){
            Node<T> n = new Node<>(cur.getValue(),cur.getNext());
            cur.setNext(n);
            cur = n.getNext();
            size++;
        }
    }

    public void insert(T v,int pos){
        if (pos==0){
            Node<T> novo = new Node<T>(v,first);
            first=novo;
            size++;
            return;
        }
        Node<T> cur = first;
        for(int i  = 1; i < pos; i++){
            cur=cur.getNext();
        }
        Node<T> novo = new Node<>(v, cur.getNext());
        cur.setNext(novo);
        size++;
    }

    public SinglyLinkedList<T> remove(int[] pos){
        SinglyLinkedList<T> novalista = new SinglyLinkedList<>();
        Node<T> cur = first;
        int i = 0;
        int posicao=0;
        while(cur.getNext() != null){
            if(posicao < pos.length && i ==pos[posicao]){
                    posicao++;
                }
            else{
                novalista.addLast(cur.getValue());
            }
            cur = cur.getNext();
            posicao++;
        }
        return novalista;
    }

    public int count(T value){
        Node<T> cur = first;
        int cont = 0;
        while (cur != null){
            if (cur.getValue().equals(value)){
                cont++;
            }
            cur =  cur.getNext();
        }
        return cont;
    }
    
    // Converte a lista para uma String
    public String toString() {
       String str = "{";      
       Node<T> cur = first;
       while (cur != null) {
          str += cur.getValue();
          cur = cur.getNext();
          if (cur != null) str += ",";                     
       }      
       str += "}";
       return str;
    }

    public void removeAll(T value){
      while (first != null && first.getValue().equals(value)){
         removeFirst();
      }
      Node<T> ant = first;
      if(ant == null){
         return;
      }
      Node<T> cur = ant.getNext();
      while (cur != null){
         if(cur.getValue().equals(value)){
            ant.setNext(cur.getNext());
            size--;
            cur = ant.getNext();

         }
         else{
            ant = cur;
            cur = cur.getNext();}
      }

    }
 }

