public class LinkedList<T> implements List<T>, Queue<T>{
    Node<T> head;
    Node<T> tail;
    LinkedList(){
        head = null;
        tail = null;
    }
    @Override
    public void add(int index, T data) {
        if (index < 0 || index > this.size() || data == null) {
            throw new IllegalArgumentException();
        } else {
            if (head == null && tail == null && index == 0) {
                tail = new Node(data, null);
                head = tail;
            } else {
                if (index == 0) {
                    Node<T> sub = head;
                    head = new Node<T>(data,sub);
                    return;
                }
                Node<T> current = head;
                for (int i = 1; i < index; i++) {
                    current = current.getNext();
                }
                Node<T> sub = current.getNext();
                Node<T> a = new Node<T>(data, sub);
                if (sub == null) {
                    tail = a;
                }
                current.setNext(a);
            }
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= this.size() || this.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            if (this.size() == 1 && index == 0) {
                T sub = head.getData();
                head = null;
                tail = null;
                return sub;
            }
            if (index == 0){
                Node<T> sub = head;
                head = head.getNext();
                return sub.getData();
            }
            Node<T> current = head;
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            Node<T> toBeRemoved = current.getNext();
            Node<T> toBeLinked = toBeRemoved.getNext();
            current.setNext(toBeLinked);
            return toBeRemoved.getData();
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > this.size() || this.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
    }

    @Override
    public List<T> subList(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else {
            LinkedList<T> subList = new LinkedList<>();
            if (n == 0) {
                return subList;
            }
            if ( n <= this.size()) {
                subList.add(0, this.head.getData());
                Node<T> current = head;
                for (int i = 1; i < n; i++) {
                    current = current.getNext();
                    subList.add(i,current.getData());
                }
                return subList;
            } else {
                subList.add(0, this.head.getData());
                Node<T> current = head;
                for (int i = 1; i < this.size(); i++) {
                    current = current.getNext();
                    subList.add(i, current.getData());
                }
                return subList;
            }
        }
    }

    @Override
    public int size() {
        if(head == null || tail == null) {
            return 0;
        }
        Node<T> sub = head;
        int count = 1;
        while(sub.getNext() != null) {
            sub = sub.getNext();
            count++;
        }
        return count;
    }

    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        } else {
            if (head == null && tail == null) {
                tail = new Node<>(data);
                head = tail;
            } else {
                Node<T> newTail = new Node<>(data);
                tail.setNext(newTail);
                tail = newTail;
            }
        }
    }

    @Override
    public T dequeue() {
        if(head == null && tail == null) {
            throw new IllegalArgumentException();
        }
        if(head == tail) {
            T sub = head.getData();
            head = null;
            tail = null;
            return sub;
        }
        T sub = head.getData();
        head = head.getNext();
        return sub;
    }
}
