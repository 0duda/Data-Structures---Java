import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

   // Representacao em String da matrix
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }

   public static Matrix identity(int n){
    Matrix identity = new Matrix(n,n);
    for (int i=0; i<n; i++){
         for (int j=0; j<n; j++){
            if(i==j)
                identity.data[i][j]= 1;
            else
                identity.data[i][j] = 0;
         }
    }
    return identity;
   }

   public Matrix transpose(){
    Matrix transpose = new Matrix(cols,rows);
        for(int i=0; i<cols;i++){
            for(int j=0; j<rows;j++){
                transpose.data[i][j]=data[j][i];
            }
        }
        return transpose;
   }

   public Matrix sum(Matrix m){
      Matrix sum= new Matrix(m.rows,m.cols);
      for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
            sum.data[i][j]= m.data[i][j]+data[i][j];
         }
      }
      return sum;
   }

   public Matrix multiply(Matrix m){
      Matrix matriz = new Matrix(rows,m.cols);
         for(int i=0;i<rows;i++){  //i é as linhas, j as colunas, e o k é o incremento da primeira matriz para as colunas e na segunda matriz para as linhas
            for(int j=0;j<m.cols;j++){
               for(int k=0;k<cols;k++){
               matriz.data[i][j]+= data[i][k]* m.data[k][j];
               }
            }
         }
      return matriz;
   }
}