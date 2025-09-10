import java.util.Scanner;

class sopa{
   private int lins, cols;
   private char data[][];
   private String palavras[];

   sopa(int l, int c){
        lins = l;
        cols = c;
        data = new char[lins][cols];
   }
   public void read(Scanner stdin){
    data = new char[lins][cols];
    for (int i = 0; i < lins; i++){
        data[i]=stdin.next().toCharArray();
    }
    
    int x = stdin.nextInt();
    palavras = new String[x];
    for(int l = 0; l < x; l++){
        palavras[l] = stdin.next();
    }
   }

   public void processar(){
       boolean[][] verifica = new boolean[lins][cols];
       for(int i = 0; i < lins; i++){
           for(int j = 0; j < cols; j++){
               verifica[i][j] = false;
           }
       }
       
       for (String palavra : palavras){
           procurar_palavra(palavra, verifica);
       }

       for(int i = 0; i < lins; i++){
           for(int j = 0; j < cols; j++){
               if (verifica[i][j] != true){
                   data[i][j] = '.';
               }
           }
       }
       
   }
    public void procurar_palavra(String palavra, boolean[][] verifica){
        //verificar na horizontal 
        int k = 0;
        for(int i = 0; i < lins; i++){
            for (int j = 0; j <= cols-palavra.length(); j++){ 
                if (palavra_encontrada_h(i, j, 1, palavra)){
                    for(k = 0; k < palavra.length(); k++){
                        verifica[i][j + k] = true;
                    }
                }

                if (palavra_encontrada_h(i, j + palavra.length() - 1, -1, palavra)){
                    for(k = 0; k < palavra.length(); k++){
                        verifica[i][j + k] = true;
                    }
                }
            }
        }

        //verificar na vertical
        for(int j = 0; j < cols; j++){
            for (int i = 0; i <= lins-palavra.length(); i++){ 
                if (palavra_encontrada_v(i, j, 1, palavra)){
                    for(k = 0; k < palavra.length(); k++){
                        verifica[i + k][j] = true;
                    }
                }


                if (palavra_encontrada_v(i + palavra.length() - 1, j, -1, palavra)){
                    for(k = 0; k < palavra.length(); k++){
                        verifica[i + k][j] = true;
                    }
                }
            }
        }
        
    }

    public boolean palavra_encontrada_h(int i, int j, int dir, String palavra){
        for(int k = 0; k < palavra.length(); k++){
            if (data[i][j + k * dir] != palavra.charAt(k))
                return false;
        }
        return true;
    }
    public boolean palavra_encontrada_v(int i, int j, int dir, String palavra){
        for(int g = 0; g < palavra.length(); g++){
            if (data[i + g * dir][j] != palavra.charAt(g))
                return false;
        }
        return true;
    }
    public void imprimir(int cont){
        System.out.println("Input #"+ cont);
        for (int i = 0; i < lins; i++){
            for(int j= 0; j < cols; j++){
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
   }
}
        
public class ED015{
   public static void main(String[] args){
       Scanner stdin = new Scanner(System.in);
       int lins = stdin.nextInt();
       int cols = stdin.nextInt();
       int cont = 1;
       while (lins!=0 && cols!=0){
           sopa s = new sopa(lins,cols);
           s.read(stdin);
           s.processar();
           s.imprimir(cont);
           cont++;
           lins = stdin.nextInt();
           cols = stdin.nextInt();
       }
   }
}
