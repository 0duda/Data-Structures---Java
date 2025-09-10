import java.util.Scanner;

class ED120{

    public static void desenhalosango(int N){
        for(int i = 1; i <= N; i+=2){
            for(int j = 0 ; j < (N-i)/2; j++){
                System.out.print('.');
            }
            for(int g=0; g<i;g++){
                System.out.print('#');
            }
            for(int w=0; w < (N-i)/2; w++){
                System.out.println('.');
            }
        }
        System.out.println();
        for(int i =N-2; i > 0; i-=2){
            for(int j = (N-i)/2 ; j > 0; j++){
                System.out.print('.');
            }
            for(int g=0; g<i;g++){
                System.out.print('#');
            }
            for(int w=(N-i)/2; w > 0; w++){
                System.out.println('.');
            }
        }
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        desenhalosango(N);
    }
}