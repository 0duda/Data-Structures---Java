import java.util.Scanner;

class cardinais{
    char data[][]; 
    int rows;     
    int cols;

    cardinais(int r, int c) {
      data = new char[r][c];
      rows = r;
      cols = c;
   }

   public String search() {
      int max = 0;
      int cont = 0;
      for (int i = 0; i < rows; i++) { //avaliar as linhas
        int comp = 0;
        for (int j = 0; j < cols; j++){
          if (data[i][j] == '#'){
            comp+=1;
            if(comp>1){
                if (comp == max){
                    cont+=1;
                }
                else if(comp > max){
                    max = comp;
                    cont = 1;
                }
            }
          }
          else{
            comp=0;
        }
     }
    }
      for (int i = 0; i < cols; i++) { //avaliar as colunas
      int comp = 0;
      for (int j = 0; j < rows; j++){
        if (data[j][i] == '#'){
            comp += 1;
            if(comp > 1){
                if (comp == max){
                    cont+=1;
                }
                else if(comp > max){
                    max = comp;
                    cont = 1;
                }
            }
        }
        else{
            comp=0;
        }
     }
    }
      return max +" "+ cont;
   }

   public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int rows = stdin.nextInt();
        int cols = stdin.nextInt();
        stdin.nextLine();  // Consumir a nova linha após os números

        // Criar a matriz
        cardinais m2 = new cardinais(rows, cols); 

        for (int i = 0; i < rows; i++) {
            String linha = stdin.nextLine();
            for (int j = 0; j < cols; j++) {
                m2.data[i][j] = linha.charAt(j);
            }
        }  
        System.out.println(m2.search());
   
   }
}
