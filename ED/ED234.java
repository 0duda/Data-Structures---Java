import java.util.Scanner;

class ED234{
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        int P = stdin.nextInt();
        if (N==1){
            BSTMap<String,Integer> mapa1= new BSTMap<>();
            for(int i = 0; i < P; i++){
                mapa1.put(stdin.next(),stdin.nextInt());
            }
            System.out.println(mapa1.size());
        }
        else{ 
            BSTMap<String,Integer> mapa2= new BSTMap<>();
            BSTMap<String,Integer> mapa3= new BSTMap<>();
            int max = 0;
            String maximo = "";
            for(int j = 0; j < P; j++){
                String n = stdin.next();
                int m = stdin.nextInt();
                if (mapa2.get(n)!=null){
                    mapa2.put(n,mapa2.get(n)+1);
                    mapa3.put(n,mapa3.get(n)+m);
                    if (mapa2.get(n)>max){ 
                        maximo = n;
                        max = mapa2.get(n);
                    }
                }
                else{
                     mapa2.put(n,1);
                     mapa3.put(n,m);
                }
            }
            if(N==2) System.out.println(maximo +" "+ max);
            if(N==3){
                for(String n : mapa2.keys()){
                    if((mapa3.get(n)/mapa2.get(n))>=5)
                        System.out.println(n);
                }
            }

        }
    }
}