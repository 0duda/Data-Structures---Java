// Uma classe muito simples que usa um ciclo para imprimir numeros entre 1 e n

// O ficheiro tem de ter o mesmo nome da classe + a extensão '.java'
public class Numbers {
   public static void main(String[] args) {
   int n = 10; // limite dos numeros
   
   System.out.print("Numeros de 1 a " + n + ":"); // + é o operador de concatenação de strings
   System.out.print("1");
   for (int i=2; i<=n; i++){
       System.out.print(", ");
       System.out.print(i);
   }
   System.out.println();
   }
}