// Interface que define o TAD conjunto de numeros inteiros
public interface IntSet {
    public boolean contains(int x);       // Retorna true se x esta no conjunto
    public boolean add(int x);            // Adiciona x ao conjunto (devolve true se conseguir)
    public boolean remove(int x);         // Remove x do conjunto (devolve true se conseguir)
    public int     size();                // Retorna o numero de elementos do conjunto
    public void    clear();               // Limpa o conjunto (torna-o vazio)

    // Metodos a adicionar (nao existentes na classe base)
    public boolean equals(IntSet s);      // Retorna true se ambos os conjuntos sao iguais
    public IntSet intersection(IntSet s); // devolve um novo conjunto: a intersecao de ambos
}

class ArrayListIntSet implements IntSet {
    private int size; // Numerodeelementosdoconjunto
    private int elem[]; // Arrayquecontemoselementosemsi

    // Construtor que recebe como argumento o número máximo de elementos
    ArrayListIntSet(int maxSize) {
        elem = new int[maxSize];
        size = 0;
    }
    
        public boolean contains(int x){
            for (int i=0; i<size; i++)
                if (elem[i] == x)
                    return true;
                return false;
        }       // Retorna true se x esta no conjunto


        public boolean add(int x){
            if (!contains(x)) {
                elem[size] = x;
                size++;
                return true;
            }
            return false;
        }     // Adiciona x ao conjunto (devolve true se conseguir)


        public boolean remove(int x){
            if (contains(x)) {
                int pos = 0;
                while (elem[pos] != x) pos++; // descobrir posicaodex
                size--;
                elem[pos] = elem[size]; // Trocarúltimoelemento
                return true; // comoqueseremoveu
            }
            return false;
            }         // Remove x do conjunto (devolve true se conseguir)


        public int size(){
            return size;
        }               // Retorna o numero de elementos do conjunto


        public void clear(){
            size = 0;
        }             // Limpa o conjunto (torna-o vazio)

        // Metodos a adicionar (nao existentes na classe base)
        public boolean equals(IntSet s){
            if (this.size == s.size()){
                for(int i = 0; i < this.size(); i++){
                    if (!(s.contains(this.elem[i]))){
                        return false;
                    }

                }
                return true;
            }
            return false;
        }     // Retorna true se ambos os conjuntos sao iguais


        public IntSet intersection(IntSet s){
            IntSet s4 = new ArrayListIntSet(this.size);
            for(int i=0; i<this.size();i++){
                if (s.contains(this.elem[i])){
                    s4.add(this.elem[i]);
                }
            }
            return s4;
        } // devolve um novo conjunto: a intersecao de ambos

    
}

public class TestED247 {
    public static void main(String[] args) {
	IntSet s1 = new ArrayListIntSet(100);
	IntSet s2 = new ArrayListIntSet(100);

	for (int i=1; i<=5; i++)
	    s1.add(i);
	System.out.println("s1 = " + s1 + " | tamanho = " + s1.size());

	for (int i=3; i<=7; i++)
	    s2.add(i);
	System.out.println("s2 = " + s2 + " | tamanho = " + s2.size());

	IntSet s3 = s1.intersection(s2);
	System.out.println("s3 = " + s3 + " | tamanho = " + s3.size());

	IntSet s4 = s2.intersection(s1);
	System.out.println("s4 = " + s4 + " | tamanho = " + s4.size());

	System.out.println("s1.equals(s2) = " + s1.equals(s2));
	System.out.println("s3.equals(s4) = " + s3.equals(s4));
    }
}
