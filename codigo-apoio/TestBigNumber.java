class BigNumber{
    private int size;
    private int numeros[];

    public BigNumber(String n){
        size = n.length();
        numeros = new int[size];
        for(int i = 0; i < size; i++){
            numeros[i] = n.charAt(size - 1 - i) - '0';
        }
    }

    //devolve true caso o numero seja igual a n, ou false caso contrario 
    public boolean equals(BigNumber n){
        if (size != n.size){
            return false;
        }
        for(int i = 0; i < size; i++){
            if (numeros[i] != n.numeros[i]){
                return false;
            }
        }
        return true;
    }

    //devolve uma String representando o numero (os digitos em si)
    public String toString(){
        String res = " ";
        for(int i = 0; i < size; i++){
            res += numeros[size - 1 - i];
        }
        return res;
    }

    //devolve um novo BigNumber igual a soma de n com o proprio objecto (this + n)
    public BigNumber add(BigNumber n){
        int soma = 0;
        int max = 0;
        if (size > n.size){
            max = size;
        }
        else{ max = n.size;
        }
        char[] result = new char[max + 1];
        for(int i = 0; i < max; i++){
            if (i < size){
                soma += numeros[i];
            }
            if (i < n.size){
                soma += n.numeros[i];
            }
            if (soma > 9){
                result[i] = (char)((soma - 10) + '0');
                soma = 1;
            }
            else{
                result[i] = (char)(soma + '0');
                soma = 0;
            }
        }
        if (soma > 0){
            result[max] = '1';
        }
        String resultado = new String(result);
        BigNumber novo = new BigNumber(resultado);
        return novo;
    }

    public BigNumber multiply(BigNumber n){
        int max = 0;
        if (size > n.size){
            max = size;
        }
        else{ max = n.size;
        }
        int[] result = new int[max + 1];
        int multi = 0;
        int incremento = 0;
        for(int i = 0; i < max; i++){
            for(int j = 0;  j < max; j++){
                multi = (n.numeros[i] * numeros[j]) + incremento;
                if (multi > 9){
                    result[j] += multi % 10;
                    incremento = multi / 10;
                }
                else{
                    result[j] = multi;
                    incremento = 0;
                }
            }
        }
        if (incremento > 0){
            result[max] = incremento; 
            max += 1;
        }
        char[] resultado = new char[max];
        for (int l = 0; l < max; l++){
            if (result[l] > 9){
                result [l + 1] += result[l] / 10;
                result[l] = result[l] % 10;
            }
            resultado[l] = (char)(result[l] + '0');
        }
        String str = new String(resultado);
        BigNumber novo = new BigNumber(str);
        return novo;
    }
}

class TestBigNumber {
    public static void main(String[] args) {
       BigNumber n1 = new BigNumber("1234567890");
       System.out.println(n1); // Escreve "1234567890"
 
       BigNumber n2 = new BigNumber("42");
       BigNumber n3 = new BigNumber("1234567890");
       System.out.println(n1.equals(n2)); // Escreve "false"
       System.out.println(n1.equals(n3)); // Escreve "true"
       
       BigNumber n4 = new BigNumber("46711237126582920746212");
       BigNumber n5 = new BigNumber("8765432110");
       BigNumber n6 = n1.add(n3);
       System.out.println(n6); // Escreve "2469135780"
       BigNumber n7 = n1.add(n4);
       System.out.println(n7); // Escreve "46711237126584155314102"
       BigNumber n8 = n1.add(n5);
       System.out.println(n8); // Escreve "10000000000"
 
       BigNumber n9 = n1.multiply(n3);
       System.out.println(n9); // Escreve "1524157875019052100"
       BigNumber n10 = n1.multiply(n4);
       System.out.println(n10); // Escreve "57668193458655139375688174332680"
    }
 }