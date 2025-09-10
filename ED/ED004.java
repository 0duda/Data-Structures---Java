import java.util.Scanner;

class jogo{
    int N;
    char data[][];

    jogo(int Nume){
        N = Nume;
        data = new char[N][N];
    }

    public void read(Scanner stdin){
        for (int i = 0; i < N; i++){
            data[i]=stdin.next().toCharArray();
        }
    }

    public String verifica(){
        for (int i = 0; i < N; i++){
           if (verificalinha(i,'X') || verificacoluna(i,'X'))
            return("Ganhou o X");
           if (verificalinha(i,'O') || verificacoluna(i,'O'))
            return("Ganhou o O");
        }
        if (verificadiagonal1('X') || verificadiagonal2('X'))
            return("Ganhou o X");
        if (verificadiagonal1('O') || verificadiagonal2('O'))
            return("Ganhou o O");
        for (int l = 0; l < N; l++){
            for (int k = 0; k < N; k++){
                if (data[l][k] == '.')
                return("Jogo incompleto");
            }
        }
        return("Empate");
    }

    boolean verificalinha(int j, char s){
        for (int i = 0; i < N; i++){
            if (data[j][i] != s)
                return false;
        }
        return true;
    }

    boolean verificacoluna(int j, char s){
        for (int i = 0; i < N; i++){
            if (data[i][j] != s)
                return false;
        }
        return true;
    }

    boolean verificadiagonal1(char s){
        for (int i = 0; i < N; i++){
            if (data[i][i] != s)
                return false;
        }
        return true;
    }

    boolean verificadiagonal2(char s){
        for (int i = 0; i < N; i++){
            if (data[N - i - 1][i] != s)
                return false;
        }
        return true;
    }
}

class ED004{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        jogo j = new jogo(N);
        j.read(stdin);
        System.out.println(j.verifica());
    }
}
