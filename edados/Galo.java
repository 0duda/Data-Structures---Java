import java.util.Scanner;

class programa{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        Jogo j = new Jogo(n);
        j.read(in);
        j.check()
    }
}

class Jogo{
    int n;
    char data[][];

    Jogo(int n){
        data = new char[n][n];
        }

    read(Scanner stdin){ 
        for (int i=0;i<n;i++){
            String s = in.next();
            for(int j=0;j<n;j++);
                data[i][j] = s.charAt(j);
            }
        }

    check(){
        for(int i=0;)
    }

}