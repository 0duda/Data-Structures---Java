import java.util.Scanner;

// Classe para representar um jogo
class Game {
    final char DEAD  = '.';  // Constante que indica uma celula morta
    final char ALIVE = 'O';  // Constante que indica uma celula viva
    private int rows, cols;  // Numero de linhas e colunas
    private char data[][];      // Matriz para representar o estado do jogo

    // Construtor: inicializa as variaveis tendo em conta a dimensao dada
    Game(int r, int c) {
	rows = r;
	cols = c;
	data = new char[r][c];
    }

    // Metodo para ler o estado inicial para a matriz data[][]
    public void read(Scanner stdin) {
	for (int i=0; i<rows; i++)
	    data[i] = stdin.next().toCharArray();
    }
    
    // Metodo para escrever a matriz m[][]
    public void write() {
        for(int i=0; i<rows; i++){
            for (int j=0; j < cols; j++){
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }

    // Deve devolver o numero de celulas vivas que sao vizinhas de (y,x)
    private int countAlive(int y, int x) {
        int count = 0;
        for(int i=y-1;i<=y+1;i++){
            for(int j=x-1;j<=x+1;j++){
              if (i>=0 && i<rows && j>=0 && j<cols){
                if (!(i==y && j==x) && data[i][j]==ALIVE){
                    count += 1;
                }
              }
            }
        }
        return count;
    }

    // Deve fazer uma iteracao: cria nova geracao a partir da actual
    public void iterate() {
        char[][] data2 = new char[rows][cols];

        for (int i=0;i<rows;i++){
            for(int j =0;j<cols;j++){
                int f = countAlive(i,j);
                if (data[i][j]==ALIVE){
                    if (f<=1 || f>=4)
                        data2[i][j]=DEAD;
                    else
                        data2[i][j]=ALIVE;
                }
                else{ 
                    if (f==3)
                        data2[i][j]=ALIVE;
                    else
                        data2[i][j]=DEAD;
                }
            }
        }

        //copiar o conteúdo de data2 para data
        for(int g = 0;g<rows;g++){
            for(int y=0;y<cols;y++){
                data[g][y]=data2[g][y];
            }
        }
    }

}

// Classe principal com o main()
public class ED088 {
    public static void main(String[] args) {
	Scanner stdin = new Scanner(System.in);

	// Ler linhas, colunas e numero de iteracoes
	int rows = stdin.nextInt();
	int cols = stdin.nextInt();
	int n = stdin.nextInt();

	// Criar objecto para conter o jogo e ler estado inicial
	Game g = new Game(rows, cols);
	g.read(stdin);
    for(int d=0;d<n;d++){
        g.iterate();
    }
    g.write();
    }
}