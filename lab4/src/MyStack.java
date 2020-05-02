public class MyStack {
    private Object[] node;
    private int current;
    private boolean empty;

    public MyStack(){
        current = 0;

        node = new Object[100];
    }

    public void push(Object value){
        if (!empty){
            empty = false;
        }
        node[current] = value;
        current++;
    }

    public Object pull(){
        if (current == 0){
            empty = true;
            return node[current];
        } else {
            current--;
            return node[current];
        }
    }

    public boolean isEmpty(){
        return empty;
    }

    public int getLength() {
        return current;
    }
}
