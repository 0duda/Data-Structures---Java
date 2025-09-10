import java.util.Scanner;

class ED0052 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();

        for (int i=0; i<N; i++) {
            String exp = in.nextLine();
            String[] parts = exp.split(" ");
            boolean p = true;
            MyStack<Integer> s = new ArrayStack<Integer>();
            for (int j=0; j<parts.length; j++) {
                if (Character.isDigit(parts[j].charAt(0))) {
                    int number = Integer.parseInt(parts[j]);
                    s.push(number);
                }
                else {
                    if (s.size()<2) {
                        p = false;
                        break;
                    }
                    else {
                        int a=s.pop();
                        int b= s.pop();
                        switch (parts[j]) {
                            case "+":
                                s.push(a+b);
                                break;
                            case "*":
                                s.push(a*b);
                                break;
                            case "-":
                                s.push(b-a);
                                break;
                            case "/":
                                s.push(b/a);
                                break;
                        }
                    }
                }
            }
            if (p && s.size()==1) {
                System.out.println(s.pop());
            }
            else {
                System.out.println("Expressao Incorrecta");
            }
        }
        in.close();
    }
}