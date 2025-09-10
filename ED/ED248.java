// Interface que define o TAD conjunto de numeros inteiros
interface IntSet {
    public boolean contains(int x);       // Retorna true se x esta no conjunto
    public boolean add(int x);            // Adiciona x ao conjunto (devolve true se conseguir)
    public boolean remove(int x);         // Remove x do conjunto (devolve true se conseguir)
    public int     size();                // Retorna o numero de elementos do conjunto
    public void    clear();               // Limpa o conjunto (torna-o vazio)
    public boolean equals(IntSet s);      // Retorna true se ambos os conjuntos sao iguais
    public IntSet intersection(IntSet s); // devolve um novo conjunto: a intersecao de ambos
}

class BooleanArrayIntSet implements IntSet {
    private int size; // Numerodeelementosdoconjunto
    private boolean isElem[]; //Array de valores booleanos

    // Construtorquerecebecomoargumentoonúmeromáximodeelementos
    public BooleanArrayIntSet(int maxSize) {
        isElem = new boolean[maxSize + 1];
        size = 0;
    }
    
    public boolean contains(int x){
        return isElem[x];
    }       // Retorna true se x esta no conjunto


    public boolean add(int x){
        if (!(isElem[x])) {
            size++;
            isElem[x]=true;
            return true;
        }
        return false;
    }     // Adiciona x ao conjunto (devolve true se conseguir)


    public boolean remove(int x){
        if (isElem[x]) {
            isElem[x] = false;
            size--;
            return true; // comoqueseremoveu
        }
        return false;
        }         // Remove x do conjunto (devolve true se conseguir)


    public int size(){
        return size;
    }               // Retorna o numero de elementos do conjunto


    public void clear(){
        for (int i = 0; i < isElem.length; i++){
            isElem[i] = false;
        }
        size = 0;
    }             // Limpa o conjunto (torna-o vazio)

    // Metodos a adicionar (nao existentes na classe base)
    public boolean equals(IntSet s){
        if (this.size == s.size()){
            for(int i = 0; i < isElem.length; i++){
                if (this.isElem[i] != (s.contains(i))){
                    return false;
                }

            }
            return true;
        }
        return false;
    }     // Retorna true se ambos os conjuntos sao iguais


    public IntSet intersection(IntSet s){
        IntSet s4 = new BooleanArrayIntSet(isElem.length - 1);
        for(int i = 0; i < isElem.length; i++){
            if (this.isElem[i] && s.contains(i)){
                s4.add(i);
            }
        }
        return s4;
    } // devolve um novo conjunto: a intersecao de ambos

    
}

public class ED248 {
    public static void main(String[] args) {
	int n = 1000000;                      
	IntSet s = new BooleanArrayIntSet(n); // Criar array de booleanos para numeros no intervalo [1,n]
	boolean tmp;
		
	System.out.println("Adicionando todos os numeros entre 1 e " + n + "...");
	for (int i=1; i<=n; i++)
	    tmp = s.add(i);

	System.out.println("Adicionando novamente todos os numeros entre 1 e " + n + "...");
	for (int i=1; i<=n; i++)
	    tmp = s.add(i);

	System.out.println("Verificando se todos os numeros entre 1 e " + n + " existem...");
	for (int i=1; i<=n; i++)
	    tmp = s.contains(i);

	System.out.println("Removendo todos os numeros entre 1 e " + n + "...");
	for (int i=1; i<=n; i++)
	    tmp = s.remove(i);
    }
}