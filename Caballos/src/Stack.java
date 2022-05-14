public class Stack<T> {
    private Node<T> p;
    private int size;

    public Stack(){
        p = null;
        size = 0;
    }

    public void push(T o){
        Node<T> aux = new Node<>(o);
        aux.next = p;
        p = aux;
        size ++;
    }

    public void pop(){
        p = p.next;
        size--;
    }

    public T peek() {
        return p.element;
    }

    public boolean isEmpty() {
        return (p == null);
    }

    public int size(){
        return size;
    }

}


