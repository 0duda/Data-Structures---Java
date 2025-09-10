import java.util.*;


class ED242{
    static int rows;            // Numero de linhas
    static int cols;            // Numero de colunas   
    static char m[][];          // Matriz de celulas
    static boolean visited[][]; // Saber se uma dada posicao ja foi visitada
    static boolean touchesedge;

   // Tamanho da mancha que inclui posicao (y,x)
   static int t(int y, int x) {
      if (y<0 || y>=rows || x<0 || x>=cols) return 0; // Caso base: fora dos limites
      if (visited[y][x]) return 0;  // Caso base: celula ja visitada
      if (m[y][x] == '#') return 0; // Caso base: celula vazia
      if(y==0 || y==rows-1 || x==0 || x==cols-1){
        touchesedge=true;
        return 0; // É borda
        }//celula é oceano está na ponta
      int count = 1;        // celula nao vazia
      visited[y][x] = true; // marcar como visitada
      count += t(y-1, x);   // Adicionando celulas nao vizinhas
      count += t(y+1, x);
      count += t(y, x+1);
      count += t(y, x-1);
      if(touchesedge) return 0;
      return count;
   }
   
   // -----------------------------------------------------------
   
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      List<Integer> lista=new LinkedList<>();
      List<String> lines=new ArrayList<>(); 
      int K=in.nextInt();
      in.nextLine();
      while(in.hasNextLine()){
        String line=in.nextLine();
        if (line.isEmpty()) break;
        lines.add(line);
      }
      rows = lines.size();
      cols = lines.get(0).length();
      m=new char[rows][cols];
      for(int a= 0; a < rows;a++){
        m[a]=lines.get(a).toCharArray();
      }
      visited = new boolean[rows][cols]; 
      for(int y = 0; y < rows; y++){
        for(int x = 0; x < cols; x++){
            touchesedge=false;
            int tama=t(y,x);
            if(tama>0){
                lista.add(tama);}
        }
      } 
      int lagos=lista.size();
      int[] tamanhos=new int[lagos];
      for(int h=0;h<lagos;h++){
        tamanhos[h]=lista.get(0);
        lista.remove(0);
      }
      mergeSort(tamanhos,0,lagos-1); 
      int sum = 0;
      for(int q = 0; q < lagos-K;q++){
        sum+=tamanhos[q];
      }  
      System.out.println(sum);
   }

     // Ordenar array v entre posicoes start e end
    static void mergeSort(int v[], int start, int end) {
       if (start == end) return;        // caso base (tamanho 1)
       int middle = (start + end) / 2;  // ponto medio
       mergeSort(v, start, middle);     // chamada recursiva a metade esquerda
       mergeSort(v, middle+1, end);     // chamada recursiva a metade direita
       merge(v, start, middle, end);    // combinar resultados
    }
 
    // Juntar duas metadas ja ordenadas
    static void merge(int v[], int start, int middle, int end) {
       int aux[] = new int[end-start+1]; // Novo array temporario
       
       int p1 = start;    // "Apontador" do array da metade esquerda
       int p2 = middle+1; // "Apontador" do array da metade direita
       int cur = 0;       // "Apontador" do array aux[] a conter juncao
       while (p1 <= middle && p2 <= end) { // Enquanto der para comparar
          if (v[p1] <= v[p2]) aux[cur++] = v[p1++]; // Escolher menor
          else aux[cur++] = v[p2++];                // e adicionar
       }
       while (p1<=middle) aux[cur++] = v[p1++]; // Adicionar o que resta
       while (p2<=end)    aux[cur++] = v[p2++];
       
       // Copiar array aux[] para v[]
       for (int i=0; i<cur; i++) v[start+i] = aux[i];
    }
    
 }