import java.util.Scanner;

class ED241{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int F = in.nextInt();
        int N = in.nextInt();
        if(F==1){
            BSTree<String> arvore= new BSTree<>();
            for(int i = 0;i < N;i++){
                String nome = in.next();
                in.next();
                in.next();
                arvore.insert(nome);
            }
            System.out.println(arvore.numberNodes());
        }
        else{
            BSTMap<String,Integer> mapa2= new BSTMap<>();
            BSTMap<String,Integer> mapa3= new BSTMap<>();
            BSTMap<String,BSTree<String>> mapa4= new BSTMap<>();
            int max=0;
            String maximo="";
            for(int j = 0; j < N; j++){
                String aluno = in.next();
                String problema = in.next();
                String result = in.next();
                if(mapa2.get(problema)==null){
                    mapa2.put(problema,1);
                }
                else{
                    mapa2.put(problema,mapa2.get(problema)+1);
                }
                if(result.equals("Accepted")){
                    if(mapa3.get(problema)==null){
                        mapa3.put(problema,1);
                    }
                    else{
                        mapa3.put(problema,mapa3.get(problema)+1);
                    }
                    if(mapa4.get(aluno)==null){
                        BSTree<String> arvore= new BSTree<>();
                        arvore.insert(problema);
                        mapa4.put(aluno,arvore);
                    }
                    else{
                        BSTree<String> temporaria = mapa4.get(aluno);
                        temporaria.insert(problema);
                        mapa4.put(aluno,temporaria);
                    }
                }
                if(mapa2.get(problema)>max){ 
                    maximo=problema;
                    max=mapa2.get(problema);
                }
            }
            if(F==2) System.out.println(maximo+ " "+ max);
            if(F==3){
                for(String n : mapa3.keys()){
                    if(mapa3.get(n)/(double)mapa2.get(n)>=0.5) 
                        System.out.println(n);
                }
            }
            if(F==4){
                for(String n : mapa4.keys()){
                    if(mapa4.get(n).numberNodes()==mapa2.size())
                        System.out.println(n);
                }
            }
        }
    }
}