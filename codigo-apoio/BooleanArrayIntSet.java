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