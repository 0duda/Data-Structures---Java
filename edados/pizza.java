import java.util.Scanner;

public class pizza{

    static boolean pizzaok(int numero, int[] ingredientes, int[] pizza){
        for(int i = 0; i < numero; i++){
            for(int j = 0; j < pizza.length; j++){
                if(ingredientes[i] == pizza[j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int numero = stdin.nextInt();
        int[] ingredientes = new int[numero];
        for (int i = 0; i < numero; i++){
            ingredientes[i] = stdin.nextInt();
        }
        int pizzas =stdin.nextInt();
        int cont = 0;
        for (int i = 0; i < pizzas; i++){
            int k = stdin.nextInt();
            int[] pizza = new int[k];
            for(int p = 0;p < k;p++){
                pizza[p] = stdin.nextInt();
            }
            if(pizzaok(numero, ingredientes, pizza))
                cont+=1;
        }
        System.out.println(cont);

    }
}