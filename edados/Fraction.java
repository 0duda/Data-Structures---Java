class Fraction{
    int num;
    int denom;

    Fraction(int a, int b){
        num = a;
        denom = b;
    }

    public String toString(){
        int u = 0;
        while (num > denom){
            num -= denom;
            u+=1;
        }
        if (num == denom){
            u+=1;
            return(u);
        }
        return (u + "+" + num + "/" + denom);
    }

    public Fraction add(Fraction f){
        Fraction frac = new Fraction(0,0);
        if (f.denom == denom){
            frac.num = f.num + num;
            frac.denom = denom;
        }
        else{
            frac.num = f.num*denom + num*f.denom;
            frac.denom = f.denom * denom;
        }
        return frac;

    }

    public Fraction multiply(Fraction f){
        Fraction frac = new Fraction(0,0);
        frac.num = f.num * num;
        frac.denom = f.denom*denom;
        return frac;
    }

    public void simplify(){
        int a = num;
        int b = denom;
        int r;
        while (b!=0){
            r = a % b;
            a = b;
            b = r;
        }
        num = num / a;
        denom = denom / a;
    }

}