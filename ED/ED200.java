/*import java.util.Scanner;

public class ED200 {
   static int rows;            // Numero de linhas
   static int cols;            // Numero de colunas   
   static char m[][];          // Matriz de celulas
   static boolean visited[][]; // Saber se uma dada posicao ja foi visitada
   

   // Tamanho da mancha que inclui posicao (y,x)
   static int t(int y, int x) {
      if (y<0 || y>=rows || x<0 || x>=cols || visited[y][x] || m[y][x] == '.') return 0; // Caso base: fora dos limites
      int count = 1;        // celula nao vazia
      visited[y][x] = true; // marcar como visitada
      count += t(y-1, x);   // Adicionando celulas nao vizinhas
      count += t(y+1, x);
      count += t(y, x+1);
      count += t(y, x-1);
      count += t(y-1, x-1);
      count += t(y+1, x+1);
      count += t(y+1, x-1);
      count += t(y-1, x+1);
      return count;
   }
   
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);

      int N = in.nextInt();
  
      for(int l = 0; l <N; l++){

         // Leitura de uma matriz de caracteres
         rows = in.nextInt();
         cols = in.nextInt();
         m = new char[rows][cols];
         visited = new boolean[rows][cols];
         for (int i=0; i<rows; i++)
            m[i] = in.next().toCharArray();

         int max=0;
         for (int y = 0; y < rows; y++){
            for (int x = 0 ; x < cols; x++){
               if(!visited[y][x] && m[y][x]=='#'){
                  int n = t(y,x);
                  if (n>max)
                     max=n;
               }
            }
         }

         System.out.println(max); 
      }
   }
   
}*/

import java.util.Scanner;

class ED200{
    static int rows;            // Numero de linhas
    static int cols;            // Numero de colunas   
    static char m[][];          // Matriz de celulas
    static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

    public static void max(){
        int max=0;
        for(int y=0; y<rows;y++){
            for(int x=0; x<cols;x++){
                int tamanho=t(y,x);
                if (tamanho>max){
                    max=tamanho;
                }
            }
        }
        System.out.println(max);
    }
    // Tamanho da mancha que inclui posicao (y,x)
    static int t(int y, int x) {
    if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
    if (visited[y][x]) return 0;  // Caso base: celula ja visitada
    if (m[y][x] == '.') return 0; // Caso base: celula vazia
    int count = 1;        // celula nao vazia
    visited[y][x] = true; // marcar como visitada
    count += t(y-1, x);   // Adicionando celulas nao vizinhas
    count += t(y+1, x);
    count += t(y, x+1);
    count += t(y, x-1);
    count += t(y-1, x-1);  
    count += t(y+1, x+1);
    count += t(y-1, x+1);  
    count += t(y+1, x-1);
    return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i = 0; i < N; i++){
            rows = in.nextInt();
            cols = in.nextInt();
            in.nextLine();
            m=new char[rows][cols];
            visited= new boolean[rows][cols];
            for(int j = 0; j < rows; j++){
                m[j]=in.nextLine().toCharArray();
            }
            int max=0;
            for(int y=0; y<rows;y++){
                for(int x=0; x<cols;x++){
                    int tamanho=t(y,x);
                    if (tamanho>max){
                        max=tamanho;
                    }
                }
            }
            System.out.println(max);
            }
    }
}