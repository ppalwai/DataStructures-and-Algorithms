package ds;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] myArray;
    private static final int DEFAULT_SIZE = 128;
    private int size;

    public MyArrayList() {
        new MyArrayList(DEFAULT_SIZE);
    }

    public MyArrayList(int size) {
        myArray = new Object[size];
    }

    public boolean add(T t) {
        if(size == myArray.length){
            myArray = Arrays.copyOf(myArray, myArray.length * 2);
        }
        myArray[size++] = t;
        return true;
    }

    public T get(int i) {
        if(i < myArray.length) return (T) myArray[i];
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public T remove(int index) {
        T rv = null;
        if (index >= myArray.length) throw new ArrayIndexOutOfBoundsException(index);
        for(int i = 0; i < myArray.length - 1; i++) {
            if(i >= index) {
                if(i == index) rv = (T) myArray[i];
                myArray[i] = myArray[i + 1];
            }
        }
        return rv;
    }

    public void add(int index, T value) {
        if (index >= myArray.length) throw new ArrayIndexOutOfBoundsException(index);

        //If array is full, double up
        if(size == myArray.length || index == myArray.length - 1){
            myArray = Arrays.copyOf(myArray, myArray.length * 2);
        }

        for(int i = myArray.length - 1; i >= 0; i--) {
            if(i > index) {
                T temp = (T) myArray[i];
                myArray[i] = myArray[i - 1];
                myArray[i - 1] = temp;
            } else if(i == index) myArray[i] = value;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String args[]) {
        MyArrayList<String> myList = new MyArrayList<>(5);

        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");
        myList.add("five");

        try {
            myList.get(5);
        } catch (Exception e) {
            assert e.getMessage().contains("Array index out of range");
        }

        assert myList.myArray.length == 5;

        myList.add("six");
        System.out.println(Arrays.toString(myList.myArray));
        assert myList.myArray.length == 10;

        myList.remove(0);
        System.out.println(Arrays.toString(myList.myArray));

        myList.add(0, "one");
        System.out.println(Arrays.toString(myList.myArray));

        myList.add(9, "ten");
        System.out.println(Arrays.toString(myList.myArray));

        myList.add(9, "nine");
        System.out.println(Arrays.toString(myList.myArray));
    }
}