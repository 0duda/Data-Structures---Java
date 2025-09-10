import java.util.Scanner;

public class palindromos2{

    static boolean ispalindrome(String arg){
        String arg2 = arg.toLowerCase();
        String arg3 = arg2.replaceAll("[\\p{Punct}\\s]","");
        int j = arg3.length() - 1;
        for (int i = 0; i < j; i++){ 
            if (arg3.charAt(i) != arg3.charAt(j))
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