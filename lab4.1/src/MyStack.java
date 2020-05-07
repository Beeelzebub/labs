public class MyStack {
    private Object[] node;
    private int current;
    private int length;

    public MyStack(){
        current = 0;
        length = 0;
        node = new Object[100];
    }

    public void push(Object value){
        length++;
        node[current] = value;
        current++;
    }

    public Object pull(){
        if (length != 0){
            length--;
            current--;
            return node[current];
        } else return null;
    }

    public boolean isEmpty(){
        if (length == 0) return true;
        else return false;
    }

    public int getLength() {
        return current;
    }
}
