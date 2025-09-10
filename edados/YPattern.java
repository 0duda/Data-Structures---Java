import java.util.Scanner;

class YPattern {
    public static void desenharY(int N) {
        int meio = N / 2; // Calcula a linha central onde os braços do Y convergem

        // Parte superior do "Y" (os dois braços que se unem no meio)
        for (int i = 0; i < meio; i++) {
            for (int j = 0; j < N; j++) {
                if (j == i || j == (N - i - 1)) { // Caracteres '#' na posição dos braços
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        // Parte inferior do "Y" (o "tronco" abaixo do meio)
        for (int i = meio; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == meio) { // Coloca '#' na posição central
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        if (N % 2 == 0) {
            System.out.println("Por favor, insira um número ímpar."); // Validação para garantir que N é ímpar
        } else {
            desenharY(N);
        }

        scanner.close();
    }
}   