import java.util.Scanner;

class ED172{

    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        BSTMap<String,Integer> map = new BSTMap<String,Integer>();
        while(stdin.hasNext()){
            String n = stdin.next();
            if (map.get(n)==null){
                map.put(n, 1);}
            else 
                map.put(n, map.get(n) + 1);
       }

       for(String key : map.keys()){
        System.out.println(key + ": " + map.get(key));
       }
    }
}