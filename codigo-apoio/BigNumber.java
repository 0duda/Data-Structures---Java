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
        String res = "";
        for(int i = size - 1; i >= 0; i--){
            res += numeros[i];
        }
        return res;
    }

    //devolve um novo BigNumber igual a soma de n com o proprio objecto (this + n)
    public BigNumber add(BigNumber n){
        int soma = 0;
        int max = 0;
        int result = 0;
        String str = "";

        if (size > n.size){
            max = size;
        }
        else{ max = n.size;
        }

        for(int i = 0; i < max; i++){
            if (i < size){
                soma += numeros[i];
            }
            if (i < n.size){
                soma += n.numeros[i];
            }
            if (soma > 9){
                result = soma % 10;
                soma = soma /10;
            }
            else{
                result = soma;
                soma = 0;
            }
            str = result + str;
        }
        if (soma > 0){
            str = soma + str;
        }
        BigNumber novo = new BigNumber(str);
        return novo;
    }

    public BigNumber multiply(BigNumber n){
        int[] result = new int[size + n.size];
        for(int i = 0; i < size; i++){
            int incremento = 0;
            for(j = 0;  j < n.size; j++){
                int multi = (n.numeros[i] * numeros[j]) + result[i + j] + incremento;
                    result[i][w] += multi % 10;
                    incremento = multi / 10;
                }
               
                if (j == max - 1 && incremento > 0){
                    result[i][i + w] = incremento;
                }
                w++;
            }
        }
        int resultado[] = new int[max * 2 + 1];
        for (int l = 0; l < max; l++){
            for(int k = 0; k < max * 2 + 1; k++){
                resultado[k] += result[l][k];
            }
        }

        String str="";
        for (int l = 0; l < max; l++){
            if (resultado[l] > 9){
                resultado [l + 1] += resultado[l] / 10;
                resultado[l] = resultado[l] % 10;
            }
            str = result[l] + str;
        }
        BigNumber novo = new BigNumber(str);
        return novo;
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