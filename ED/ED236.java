public SinglyLinkedList<T> cut (int a, int b){
    SinglyLinkedList<T> nova = new SinglyLinkedList<>();
    Node<T> cur = first;
    int i = 0;
    while(i <a){
        cur=cur.getNext();
        i++;
    }
    while(i<=b){
        nova.addLast(cur.getValue());
        i++;
        cur = cur.getNext();
    }
    return nova;
}

public void shift(int k){
    for(int i = 0; i < k; i++){
        addFirst(getLast());
        removeLast();
    }
}