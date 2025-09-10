import java.util.Scanner;

class ED007{

    public static void verifica(String n, MyStack<Character> pilha){
        boolean concluido = false;
        for(int j = 0; j < n.length(); j++){                
            if(n.charAt(j)=='(' || n.charAt(j)=='['){
                pilha.push(n.charAt(j));
            }
            else {
                if(n.charAt(j)==')' || n.charAt(j)==']'){
                    if (pilha.size() == 0){
                        System.out.println("Erro na posicao "+ j);
                        concluido = true;
                        break;
                    }
                    if((n.charAt(j)==')' && pilha.top()=='(') || (n.charAt(j)==']' && pilha.top()=='['))
                        pilha.pop();
                    else{
                        System.out.println("Erro na posicao "+ j);
                        concluido = true;
                        break;
                    }
                }
            }
        }
        if(concluido == false){
            if(pilha.size()==0){
                System.out.println("Expressao bem formada");
            }
            else{
                System.out.println("Ficam parenteses por fechar");
            }
        }
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        stdin.nextLine();
        for(int i=0; i < N; i++){
            MyStack<Character> pilha = new LinkedListStack<Character>(); 
            String n = stdin.nextLine();
            verifica(n,pilha);
        }
    }
}