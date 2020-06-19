public class MyQueue<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        private T value;
        private Node<T> next;

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        public T getValue(){
            return value;
        }

        public Node<T> getNext(){
            return next;
        }
    }

    public MyQueue(){
        length = 0;
        head = null;
        tail = null;
    }

    public void push(T value){
        Node<T> temp = new Node<T>();
        temp.setValue(value);
        if (head == null){
            head = temp;
        } else {
            tail.setNext(temp);
        }
        tail = temp;
        length++;
    }

    public T pull(){
        if (length == 0){
            return null;
        }
        T temp = head.getValue();
        head = head.getNext();
        if (head == null){
            tail = null;
        }
        length--;
        return temp;
    }

    public boolean isEmpty(){
        if (length == 0) return true;
        else return false;
    }

    public int getLength() {
        return length;
    }
}
