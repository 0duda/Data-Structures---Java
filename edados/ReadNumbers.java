import java.util.Scanner;

public class ReadNumbers {

   /*static void writeArray(int v[]) {
      for (int i=0; i<v.length; i++)          
         System.out.println("v[" + i + "] = " + v[i]);      
   }*/

   static void maxmindiff(int v[]) {
      int max = v[0];
      int min = v[0];
      for (int i=0; i < v.length; i++){       
        if (v[i]>max)
            max = v[i];
        if (v[i]<min)
            min = v[i];
      }
         System.out.println(max-min);  
   }
   
   static void media(int v[]){
        double soma = 0;
        int i = 0;
        while(i < v.length){
            soma += v[i];
            ++i;
        }
        soma /= i;
        System.out.printf("%.2f\n", soma);
    }

   public static void main(String[] args) {

      Scanner stdin = new Scanner(System.in);
           
      int n = stdin.nextInt();   // Ler a quantidade de numeros que se seguem
      int v[] = new int[n]; 
      
      for (int i=0; i<n; i++)    // Ler os numeros a partir do stdin
         v[i] = stdin.nextInt();
      
      media(v);
      maxmindiff(v);
   }
}