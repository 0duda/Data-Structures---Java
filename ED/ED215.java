import java.util.Scanner;

class Person implements Comparable<Person>{
    String nome;
    int preco;

    Person(String nome, int preco){
        this.nome=nome;
        this.preco=preco;
    }

    //com ajuda
    @Override
    public int compareTo(Person other) {
    return Integer.compare(other.preco, this.preco); // Inverte a comparação
    }
}

class ED215{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        MinHeap<Person> compras = new MinHeap<>(N);
        for(int i = 0; i < N; i++){
            if(stdin.next().equals("OFERTA")){
                Person p = new Person(stdin.next(), stdin.nextInt());
                compras.insert(p);
            }
            else{
                Person n = compras.removeMin();
                System.out.println(n.preco + " " + n.nome);
            }
        }
    }
}