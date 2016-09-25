import java.util.Arrays;

public class MyStack {
    private int[] array;
    private int index;

    public MyStack(int size) {
        array = new int[size];
        index = 0;
    }

    public void push(int data) {
        if(index == array.length - 1) resize();
        array[index++] = data;
    }

    public Integer pop() {
        if(isEmpty()) return null;
        return array[--index];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        for(int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}