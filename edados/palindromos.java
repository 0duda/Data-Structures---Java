import java.util.Scanner;

public class palindromos{

    static boolean ispalindrome(String arg){
        int j = arg.length() - 1;
        for (int i = 0; i < j; i++){ 
            do{
                ++i;
            }
            while(i < arg.length() / 2 && !Character.isLetter(arg.charAt(i))); //verificação de espaços/pontuação
            do{
                --j;
            }
            while(j > arg.length() / 2 && !Character.isLetter(arg.charAt(j)));

            if (Character.toLowerCase(arg.charAt(i)) != Character.toLowerCase(arg.charAt(j)))
                return false;
            j--;
        }
        return true;
    }
        

    public static void main(String[] args){
        Scanner stdin = new Scanner (System.in);
        int n = stdin.nextInt(); //apenas lê o número inteiro
        stdin.nextLine();  //lê a quebra de linha
        System.out.println(n);
        for(int i = 0; i < n;i++){
            String frase = stdin.nextLine(); //lê a linha toda mas exclui a quebra de linha
            if (ispalindrome(frase))
                System.out.println("sim");
            else 
                System.out.println("nao");
        }
    }
}