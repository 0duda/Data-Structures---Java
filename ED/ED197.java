class ED197{
    public static MyQueue<Integer> merge(MyQueue<Integer> a, MyQueue<Integer> b){
        MyQueue<Integer> q = new LinkedListQueue<Integer>();
        int size= a.size() + b.size();
        for(int i = 0; i < size; i++){
            while(!a.isEmpty() && !b.isEmpty()){
                if(a.first()<b.first()){
                    q.enqueue(a.dequeue());
                }
                else if(b.first()<a.first()){
                    q.enqueue(b.dequeue());
                } 
                else{
                    q.enqueue(a.dequeue());
                    q.enqueue(b.dequeue());
                }
            }
            while(!a.isEmpty()){
                q.enqueue(a.dequeue());
            }
            while(!b.isEmpty()){
                q.enqueue(b.dequeue());
            }
        }
        return q;
    }
}