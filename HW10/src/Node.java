public class Node<T> {

    T data;
    Node next;

    Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(T data){
        this(data, null);
    }
    public T getData() {
        return data;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next){
        this.next = next;
    }
}
