import java.util.Scanner;

class ED202{
    static double min;

    static void permutations(int v[], double[][] data) {
        boolean used[] = new boolean[v.length]; // $i$ esta na permutacao?
        int perm[] = new int[v.length];         // permutacao actual
        goPerm(0, v, used, perm, data); // chamar funcao recursiva
        }

        // Gera todos os subconjuntos a partir da posicao 'cur'
        static void goPerm(int cur, int v[], boolean used[], int perm[],double[][] data) {
            if (cur == v.length) {  // Caso base: terminamos a permutacao
                double sum = 0.0;
                for (int i=0; i<v.length; i++) // Escrever a permutacao
                    sum+=data[perm[i]][perm[i+1]];
                sum += data[perm[v.length - 1]][perm[0]]; // Return to the starting point

            } else { // Se nao terminamos, continuar a gerar
                for (int i=0; i<v.length; i++) // Tentar todos os elementos
                if (!used[i]) { 
                    used[i] = true; 
                    perm[cur] = i;
                    goPerm(cur+1, v, used, perm,data);
                    used[i] = false;
                }
            }
            if (sum<min) min=sum;
        }
        
        public static void main(String[] args) {
            Scanner in=new Scanner(System.in);
            int N = in.nextInt();
            in.nextLine();
            String[] locais = in.nextLine().split(" ");
            double[][] data = new int[N-1][N-1];
            int[] numeros=new int[N];
            min=Double.MAX_VALUE;
            
            for (int i = 0; i < N; i++) {
                String[] temp = in.nextLine().trim().split("\\s+");
                for (int j = 0; j < N; j++) {
                    data[i][j] = Double.parseDouble(temp[j]); // Parse floating-point distances
                }
            }
            for(int i = 0; i<N;i++){
                numeros[i]=i;
            }
            permutations(numeros,data);
            System.out.printf("%.2f\n", min); // Print the minimum distance rounded to 2 decimal places
        }
}