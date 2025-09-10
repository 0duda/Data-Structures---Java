import java.util.Scanner;

class ED183{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int n = stdin.nextInt(); 
        int max = n;
        int min = n;
        double media = n;
        for(int i = 1 ; i < N ; i++){
            n = stdin.nextInt(); 
            if (n > max){
                max = n;
            }
            else if (n < min){
                min = n;
            }
            media += n;
        }
        media /= N;
        int amplitude = max - min;
        System.out.println(media + " " + amplitude);
    }
}