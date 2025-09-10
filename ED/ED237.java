import java.util.Scanner;

class Process{
    String name;
    int time;

    Process(String name, int time){
        this.name=name;
        this.time=time;
    }
}

class ED237{

    public static void rr(MyQueue<Process> fila, int T){
        int tempo=0;
        int iteracoes = 0;
        while(fila.size()>0){
            iteracoes++;
            Process p = fila.dequeue();
            if(p.time-T<=0){
                tempo +=p.time;
                System.out.println(p.name + " "+ tempo + " " + iteracoes);
            }
            else{
                p.time-=T;
                tempo +=T;
                fila.enqueue(p);
            }
        }
    }
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        int T = stdin.nextInt();
        int N = stdin.nextInt();
        MyQueue<Process> fila = new LinkedListQueue<Process>();       
        for(int i = 0; i < N; i++){
            stdin.nextLine();
            String name= stdin.next();
            int time = stdin.nextInt();
            Process p = new Process(name,time);
            fila.enqueue(p);
        }
        rr(fila,T);
        }
}
