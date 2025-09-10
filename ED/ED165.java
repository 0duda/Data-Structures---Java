//com ajuda

import java.util.Scanner;

class ED165{
    static int a = 0;

    public static void listar(int[] lista, BSTNode<Integer> node){
        if(node==null){
            return;
        }
        lista[a++]=node.getValue();
        listar(lista, node.getLeft());
        listar(lista, node.getRight());
    }

    public static BSTree<Integer> sum(BSTree<Integer> tree){
        BSTree<Integer> sumtree = new BSTree<Integer>();
        int n = tree.numberNodes();
        BSTNode<Integer> node = tree.getRoot();
        int[] lista = new int[n];
        listar(lista,node);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sumtree.insert(lista[i]+lista[j]);
            }
        }
    return sumtree;
    }
    public static void main(String[] args){
        BSTree<Integer> tree = new BSTree<Integer>();
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        for(int i = 0; i < N; i++){
            tree.insert(stdin.nextInt());
        }
        BSTree<Integer> sumtree = new BSTree<Integer>();
        sumtree=sum(tree);
        int P = stdin.nextInt();
        for(int j = 0; j < P; j++){
            int w = stdin.nextInt();
            if (sumtree.contains(w)){
                System.out.println(w + ": sim");
            }
            else System.out.println(w + ": nao");
        }
    stdin.close();
    }
}

/*ou uma melhor solução
import java.util.Scanner;

class teste{

    public static BSTree<Integer> sum(int[] conjunto,int N){
        BSTree<Integer> arvoresomas=new BSTree<>();
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                arvoresomas.insert(conjunto[i]+conjunto[j]);
            }
        }
        return arvoresomas;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] conjunto=new int[N];
        for(int i = 0; i < N; i++){
            conjunto[i]=in.nextInt();
        }
        BSTree<Integer> arvoresomas= sum(conjunto,N);
        int P = in.nextInt();
        for(int j = 0; j < P; j++){
            int n = in.nextInt();
            if(arvoresomas.contains(n)){
                System.out.println(n + ": sim");
            }
            else{
                System.out.println(n + ": nao");
            }
        }
    }
}*/