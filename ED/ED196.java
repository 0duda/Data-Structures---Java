import java.util.LinkedList;
import java.util.Queue;
class ED196{
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b){
        int size=q.size();
        for(int i = 0; i < size; i+=2){
            String nome = q.dequeue();
            String letra = q.dequeue();
            if (letra.equals("A")){
                a.enqueue(nome);
            }
            else if (letra.equals("B")){
                b.enqueue(nome);
            }
            else if(letra.equals("X")){
                if (a.size()<b.size()){
                    a.enqueue(nome);
                }
                else if(b.size()<a.size()){
                    b.enqueue(nome);
                }
            }
        }
    }
    public static void main(String[] args) {
        MyQueue<String> q = new QueueAdapter<>();
        q.enqueue("Luis");
        q.enqueue("B");
        q.enqueue("Pedro");
        q.enqueue("A");
        q.enqueue("Luisa");
        q.enqueue("A");
        q.enqueue("Joao");
        q.enqueue("X");
        q.enqueue("Jose");
        q.enqueue("X");
        q.enqueue("Miguel");
        q.enqueue("B");
        System.out.println("Fila q (deve estar vazia): " + q);
        MyQueue<String> a = new QueueAdapter<>();
        MyQueue<String> b = new QueueAdapter<>();

        process(q, a, b);

        System.out.println("Fila q (deve estar vazia): " + q);
        System.out.println("Fila a: " + a);
        System.out.println("Fila b: " + b);
    }
}

class QueueAdapter<T> implements MyQueue<T> {
    private Queue<T> queue;

    public QueueAdapter() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T v) {
        queue.add(v);
    }

    public T dequeue() {
        return queue.poll();
    }

    public T first() {
        return queue.peek();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
