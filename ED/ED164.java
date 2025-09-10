import java.util.Scanner;

class ED164{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        BSTree<String> arvore = new BSTree<>();
        for(int i = 0; i< N; i++){
            arvore.insert(in.next());
        }
        System.out.println(arvore.numberNodes());
    }
}