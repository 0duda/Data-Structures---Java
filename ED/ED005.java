import java.util.Scanner;

class ED005{
    public static boolean isdigit(String m){
        for(int i = 0; i < m.length(); i++){
            if (!(Character.isDigit(m.charAt(i))))
                return false;
        }
        return true;
    }

    public static void process(String w){
        MyStack<Integer> s = new ArrayStack<Integer>();
        String[] p = w.split(" ");
        boolean c = true;
            for(int i = 0; i < p.length; i++){
              if(isdigit(p[i])){
                int numero=Integer.parseInt(p[i]);
                if(numero>=0){
                    s.push(numero);
                }
              }
              else{
                if (s.size()< 2){
                    c = false;
                    break;
                }
                int a = s.pop();
                int b = s.pop();
                if(p[i].equals("+")){
                    s.push(b+a);
                }
                else if(p[i].equals("*")){
                    s.push(b*a);
                }
                else if(p[i].equals("/")){
                    s.push(b/a);
                }
                else if(p[i].equals("-")){
                    s.push(b-a);
                }
            }
            }
            if (c && s.size()==1){
                System.out.println(s.pop());
            }
            else{
                System.out.println("Expressao incorreta");
            }
    }
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int N = stdin.nextInt();
        stdin.nextLine();
        for(int i = 0; i < N; i++){
            process(stdin.nextLine());
        }
    }
}