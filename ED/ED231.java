import java.util.Scanner;
class ED231{

    public static void flagone(int[] numeros, int N){
        int max = numeros[1]-numeros[0];
        int min = numeros[1]-numeros[0];

        for(int i = 1; i < N-1; i++){
            int n = numeros[i+1]-numeros[i];
            if (n> max){
                max = n;
            }
            if (n < min){
                min = n;
            }
        }
        System.out.println(min + " " + max);
    }

        public static void flagtwo(int[] numeros, int N){
        int cont=0;
        int maxcont=0;
        int periodos = 0;
        boolean periodo=false;

        for(int i = 1; i < N; i++){
            double n = ((numeros[i]-numeros[i-1])*100.0/numeros[i-1]);
            if (n <=5.0){
                if(!periodo){
                    periodos++;
                    periodo=true;
                }
                cont++;
                if(cont>maxcont){
                    maxcont = cont;
                }
            }
            else{
                periodo=false;
                cont=0;
            }
        }
        System.out.println(periodos + " " + maxcont);
    }

    public static void flagthree(int[] numeros, int N){
        int max = 0;
        for(int i = 0; i < N; i++){
            numeros[i] /= 100;
            if(numeros[i]>max){
                max= numeros[i];
            } 
        }
        for(int j = max; j > 0; j--){
            for(int i=0; i < N ; i++){
                if (numeros[i]>=j){
                    System.out.print("#");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        stdin.nextLine();
        int[] numeros = new int[N];
        for( int i = 0; i < N; i++){
            numeros[i] = stdin.nextInt();
        }
        stdin.nextLine();
        int flag= stdin.nextInt();
        if (flag == 1){
            flagone(numeros,N);
        }
        else if (flag==2){
            flagtwo(numeros,N);
        }
        else if(flag==3){
            flagthree(numeros,N);
        }
    }
}