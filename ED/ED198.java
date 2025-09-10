import java.util.Scanner;

class ED198{
    public static void soma(int v[],int n){
        int sum=v[0];
        int maxSoFar = v[0]; // porque é esta uma boa escolha para a melhor soma inicial?
        for (int i=1; i<n; i++){ // Todas as posicoes iniciais possiveis
            if (sum<0) sum=v[i];
            else sum +=v[i];
            if (sum > maxSoFar) maxSoFar = sum;
        }
        System.out.println(maxSoFar);
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N=stdin.nextInt();
        stdin.nextLine();
        int array[]=new int[N];
        for(int i = 0; i < N; i++){
            array[i]=stdin.nextInt();
        }
        soma(array,N);
    }
}