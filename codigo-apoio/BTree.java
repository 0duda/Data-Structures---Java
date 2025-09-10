import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTree<T> {   
    private BTNode<T> root; // raiz da arvore
 
    // Construtor
    BTree() {
       root = null;
    }
 
    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}
 
    // Verificar se arvore esta vazia
    public boolean isEmpty() {
       return root == null;
    }
 
    // --------------------------------------------------------
 
    // Numero de nos da arvore   
    public int numberNodes() {
       return numberNodes(root);
    }
 
    private int numberNodes(BTNode<T> n) {
       if (n == null) return 0;
       return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }
 
    // --------------------------------------------------------
 
    // Altura da arvore
    public int depth() {
       return depth(root);
    }
 
    private int depth(BTNode<T> n) {
       if (n == null) return -1;
       return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }
 
    // --------------------------------------------------------
    
    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
       return contains(root, value);
    }
 
    private boolean contains(BTNode<T> n, T value) {
       if (n==null) return false;
       if (n.getValue().equals(value)) return true;
       return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore em PreOrder
    public void printPreOrder() {
       System.out.print("PreOrder:");
       printPreOrder(root);
       System.out.println();
    }
 
    private void printPreOrder(BTNode<T> n) {
       if (n==null) return;
       System.out.print(" " + n.getValue() );
       printPreOrder(n.getLeft());
       printPreOrder(n.getRight());
    }
 
    // --------------------------------------------------------
    
    // Imprimir arvore em InOrder
    public void printInOrder() {
       System.out.print("InOrder:");
       printInOrder(root);
       System.out.println();
    }
 
    private void printInOrder(BTNode<T> n) {
       if (n==null) return;
       printInOrder(n.getLeft());
       System.out.print(" " + n.getValue());
       printInOrder(n.getRight());
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore em PostOrder
    public void printPostOrder() {
       System.out.print("PostOrder:");
       printPostOrder(root);
       System.out.println();
    }
 
    private void printPostOrder(BTNode<T> n) {
       if (n==null) return;
       printPostOrder(n.getLeft());
       printPostOrder(n.getRight());
       System.out.print(" " + n.getValue());
    }
 
    // --------------------------------------------------------
 
    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
       System.out.print("BFS:");
       
       MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
       q.enqueue(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.dequeue();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.enqueue(cur.getLeft());
             q.enqueue(cur.getRight());
          }
       }
       System.out.println();
    }
 
    // --------------------------------------------------------
    
    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
       System.out.print("DFS:");
       
       MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
       q.push(root);
       while (!q.isEmpty()) {
          BTNode<T> cur = q.pop();
          if (cur != null) {
             System.out.print(" " + cur.getValue());
             q.push(cur.getLeft());
             q.push(cur.getRight());
          }
       }
       System.out.println();
    }

    public int numberLeafs(){
        return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> node){
        if (node==null)
            return 0;

        if (node.getLeft()==null && node.getRight()==null)
            return 1;

        return numberLeafs(node.getLeft()) + numberLeafs(node.getRight());
    }

    /*public boolean strict(){
        return strict(root);
    }

    private boolean strict(BTNode<T> node){
        if (node==null)    //árvore nula(também é binária)
            return true;
        if(node.getLeft() == null && node.getRight() == null) //nó folha(nao tem filhos)
            return true;
        if (node.getLeft() != null && node.getRight() != null)   //tem 2 filhos e vai verificando recursivamente
            return strict(node.getLeft()) && strict(node.getRight());
        return false;  //caso em que o nó tem apenas um filho
    }*/

    public T path(String s){
        return path(s, root);
    }

    private T path(String s, BTNode<T> node){
      if (s.isEmpty()){
         return node.getValue();
      }
      if (s.equals("R")){
         return node.getValue();
      }
      
      if (s.charAt(0)=='D'){
         return path(s.substring(1),node.getRight());
      }
      else if(s.charAt(0)=='E'){
         return path(s.substring(1), node.getLeft());
      }
      return null; //caminho inválido
    }   

   public int nodesLevel(int k){
      return nodesLevel(k,root);
   }

   private int nodesLevel(int k, BTNode<T> node){
      if (node==null) 
         return 0;
      if (k==0)
         return 1;

      return nodesLevel(k-1,node.getLeft()) + nodesLevel(k-1,node.getRight());
   }

   public int internal(){
      return internal(root);
   }

   private int internal(BTNode<T> node){
      if (node == null){
         return 0;
      }

      if (node.getLeft()!=null || node.getRight()!=null){
         return 1 + internal(node.getLeft()) + internal(node.getRight());
      }
      return 0;
   }

   /*public void cut(int d){
      cut(root,d,0);
   }

   private void cut(BTNode<T> node, int d,int i){
      if (node==null){
         return;
      }
      if(i==d-1){
         node.setLeft(null);
         node.setRight(null);  
         return;       
      }
      i++;
      cut(node.getRight(),d,i);
      cut(node.getLeft(),d,i);
   }*/

   public int[] maxLevel(){
      return maxLevel(root);
   }

   private int[] maxLevel(BTNode<T> node){
      int[] contagem = new int[depth()];
      for(int k = 0; k < depth(); k++){
         contagem[k]=nodesLevel(k);
      }
      int max = contagem[0];
      int cont = 0;
      for(int j = 1; j < contagem.length;j++){
         if (contagem[j]>max){
            max = contagem[j];
            cont = 1;
         }
         else if (contagem[j]==max) cont++;
      }
      int[] result = {max,cont};
      return result;
   }
 

   public int count(){
      return count(root);
   }

   private int count(BTNode<T> node){
      if(node==null) return 0;
      if((node.getLeft()==null && node.getRight()!=null) || (node.getLeft()!=null && node.getRight()==null)){
         return 1 + count(node.getLeft()) + count(node.getRight());
      }
      return count(node.getLeft()) + count(node.getRight());
   }

   public int level(T v){
      return level(v,root,0);
   }

   private int level(T v,BTNode<T> node,int level){
      if(node==null)
         return -1;
      if(node.getValue().equals(v)){
         return level;
      }
      int leftlevel=level(v,node.getLeft(),level+1);
      int rightlevel=level(v,node.getRight(),level+1);
      if (leftlevel != -1 && rightlevel != -1) {
         if (leftlevel>rightlevel) return rightlevel; 
         else return leftlevel;
      }
      else if(leftlevel !=-1) return leftlevel;
      else return rightlevel;
   }

   public boolean strict(){
         return strict(root);
   }

   private boolean strict(BTNode<T> node){
         if(node==null) return true;
         if((node.getLeft()==null && node.getRight()!=null) || (node.getLeft()!=null && node.getRight()==null)){
            return false;
         }
         if (node.getLeft()==null && node.getRight()==null){
            return true;
         }
         return strict(node.getLeft()) && strict(node.getRight());
   }


   public int count(){
         
      if(node==null) return 0;
      if((n.getLeft()!=null && n.getRight()==null)||(n.getLeft()!=null && n.getRight()==null)){
         return 1 + count(node.getLeft()) +count(node.getRight());
      }
   }

   public void cut(int d){
      cut(d,root);
   }
   private void cut(int d, BTNode<T> node){
      if (node==null) return;
      if(d==1){
         node.setLeft(null);
         node.setRight(null);
      }
      if(d>1){
         cut(d-1,node.getLeft());
         cut(d-1,node.getRight());
      }
   }
}

