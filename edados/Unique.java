import java.util.Scanner;
import java.io.File;

public class Unique{
    public static void main(String[] args){
        //Inicializa o conjunto com uma capacidade grande(até 1 milhão de elementos)
        IntSet s = new ArrayListIntSet(1000000);

        int unicos = 0;

        //Lê os números do arquivo
        Scanner stdin = new Scanner(new File(args[0]));
        while (stdin.hasNextInt()){
            int num = stdin.nextInt();
            if (!(s.contains(num)))
                unicos += 1;
            s.add(num);
        }
        System.out.println(unicos +"números únicos");
    }
}