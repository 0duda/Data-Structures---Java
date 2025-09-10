import java.util.Scanner;

public class ED201 {

   static int max;
   
    // Escrever todos os subconjuntos do array v[]
    static void sets(int v[],int D) {
       // array de booleanos para representar o conjunto
       boolean used[] = new boolean[v.length];
       goSets(0, v, used, D); // chamar funcao recursiva
    }
 
    // Gera todos os subconjuntos a partir da posicao 'cur'
   static void goSets(int cur, int v[], boolean used[],int D) {
      if (cur == v.length) {  // Caso base: terminamos o conjunto
         int subconjunto=0;
          // Escrever conjunto
         for (int i=0; i<v.length; i++){ 
            if (used[i]){ 
               subconjunto+=v[i];}}

         if (subconjunto>max && subconjunto<=D){ 
            max=subconjunto;}
      } 
      else {                  // Se nao terminamos, continuar a gerar
         used[cur] = true;      // Subconjuntos que incluem o elemento actual
         goSets(cur+1, v, used,D);// Chamada recursiva
         used[cur] = false;     // Subconjuntos que nao incluem o el. actual
         goSets(cur+1, v, used,D);// Chamada recursiva
      }
   }
 
    
    
    public static void main(String[] args) {
      Scanner stdin = new Scanner(System.in);
      int D = stdin.nextInt();
      int N = stdin.nextInt();
      int v[]=new int[N];
      for(int i = 0; i < N; i++){
         v[i] = stdin.nextInt(); 
      }
      max = 0;
      sets(v,D);
      System.out.println(max);
    }
 }