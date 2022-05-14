public class Node<T> {
    public T element;
    Node<T> next;

    public Node(T element) {
        this.element = element;
    }
    public Node(){
        next = null;
    }
}
