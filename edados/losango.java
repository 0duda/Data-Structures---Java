import java.util.Scanner;

public class losango {

   static void desenhalosango(int n){
    for(int i=1; i <= n; i+=2){
        for(int j = (n-i)/2; j > 0; j--){
            System.out.print(".");
        }
        for(int l = 1; l <= i; l++){
            System.out.print("#");
        }
        for(int j = (n-i)/2; j > 0; j--){
            System.out.print(".");
        }
        System.out.println(); 
    } 
    for(int i= n-2; i > 0; i-=2){
        for(int j = (n-i)/2; j > 0; j--){
            System.out.print(".");
        }
        for(int l = 1; l <= i; l++){
            System.out.print("#");
        }
        for(int j = (n-i)/2; j > 0; j--){
            System.out.print(".");
        }
        System.out.println();    
    }      
    }

    public static void main(String[] args) { 
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        desenhalosango(n);
   }
}