import java.util.Scanner;

public class crivoeratostenes{

    static void primo(int a, int b){
        boolean[] isPrime = new boolean[ b + 1]; //array de boleanos 
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i<= b;i++){
            isPrime[i]=true;
        }
        for (int i = 2; i * i <= b; i++){
          if(isPrime[i]){
            for (int j = i * i; j <= b; j+=i){
                isPrime[j]=false;
            }
          }
        }
        int cont = 0;
        for(int l = a; l <= b; l++){
            if (isPrime[l])
                cont+=1;
        }
        System.out.println(cont);
    }

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        primo(a,b);
    }
}


/*for (int i = 2; i <= b; i++){
            for (int j = i; i * j <= b; j++){
                if(isPrime[j*i])
                    isPrime[j*i]=false;
            }
*/