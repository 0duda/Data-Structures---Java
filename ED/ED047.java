class ArrayListIntSet implements IntSet {
    private int size; // Numerodeelementosdoconjunto
    private int elem[]; // Arrayquecontemoselementosemsi

    // Construtorquerecebecomoargumentoonúmeromáximodeelementos
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

        } // devolve um novo conjunto: a intersecao de ambos

    
}