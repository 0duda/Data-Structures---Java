import java.util.Scanner;


public class ED006 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();

        for(int i = 0; i < N; i++){
            stdin.nextLine(); //quebra de linha
            String linha = stdin.nextLine();
            String[] frase = linha.split(" ");

            int n = stdin.nextInt();
            CircularLinkedList<String> jogadores = new CircularLinkedList<>();
            for (int w = 0; w < n; w++){
                jogadores.addLast(stdin.next());
            }  
             
            while (jogadores.size() > 1){
                for(int h = 0; h < frase.length ; h++){
                    jogadores.rotate();
                }
                jogadores.removeLast();
            } 
            if (jogadores.getFirst().equals("Carlos")){
                System.out.println("O Carlos nao se livrou");
            }
            else{
                System.out.println("O Carlos livrou-se (coitado do "+ jogadores.getFirst() +"!)");
            }
        }
    }
}
