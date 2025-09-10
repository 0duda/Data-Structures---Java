class ED195{
    public static boolean balanced(String s){
        MyStack<Character> pilha = new ArrayStack<Character>();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='(' || s.charAt(i)=='['){
                pilha.push(s.charAt(i));
            }
            if (pilha.isEmpty())
                return false;
            else{
                if((s.charAt(i)==')' && pilha.top()=='(')||(s.charAt(i)==']' && pilha.top()=='[')){
                    pilha.pop();
                }
            }
        }
        if(pilha.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(balanced("[[[()))"));
    }
}