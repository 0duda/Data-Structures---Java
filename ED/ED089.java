import java.util.Scanner;

class ED089{
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int flag = stdin.nextInt();
        stdin.nextLine();
        int[] areas = new int[N];
        int[] rendimentos = new int[N];
        for(int i = 0; i < N; i++){
            stdin.nextLine();
            stdin.nextLine();
            stdin.nextLine();
            areas[i]=stdin.nextInt();
            rendimentos[i]=stdin.nextInt();
            stdin.nextLine();
        }
        if (flag == 0){
            int cont = 0;
            for(int j = 0; j < N; j++){
                boolean igual = false;
                for(int l = 0; l < N; l++){
                    if(j != l && areas[j] == areas[l]){
                        igual = true;
                        break;
                    }
                }
                if(igual == false){
                    cont++;
                }
            }
            System.out.println(cont);
            return;
        }
        else{
            for(int p = 0; p < N; p++){
                for(int u = p+1; u < N; u++){
                    if (areas[p]>areas[u]){
                        int temp=areas[p];
                        areas[p]=areas[u];
                        areas[u]=temp;
                        temp=rendimentos[p];
                        rendimentos[p]=rendimentos[u];
                        rendimentos[u]=temp;
                    }
                }
            }
            int rendimento = rendimentos[0];
            int area=areas[0];
            for(int g = 1; g < N - 1 ; g++){
                if(area==areas[g]){
                    rendimento+=rendimentos[g];
                }
                else{
                    System.out.println(area + " " + rendimento);
                    rendimento = rendimentos[g];
                }
                area= areas[g];
            }
            System.out.println(area + " " + rendimento);
            }
        }
    
    }
