public class MyStack {

    private int maxSize;
    private static int[] myStackArray;
    private int high;
    private int count;

    public MyStack(int maxSizeMyStack) {
        this.maxSize = maxSizeMyStack;
        myStackArray = new int[maxSize];
        high = -1;
        count = 0;
    }

    public void addElement(int element) {
        myStackArray[++high] = element;
        ++count;
        push();
    }


    public void deleteElement() {
        int[] myStackArrayNew = new int[myStackArray.length - 1];
        System.arraycopy(myStackArray, 0, myStackArrayNew, 0, fillingMyStack() - 1);
        myStackArray = myStackArrayNew;
        count--;
        high--;

    }

    public int readTop() {
        return myStackArray[high];
    }

    public boolean isEmpty() {
        return (high == -1);
    }

    public int sizeMyStack() {
        return myStackArray.length;
    }

    public int fillingMyStack() {
        return count;
    }

    public void push() {
        if (myStackArray.length == count) {
            increaseSizeMyStack(2 * myStackArray.length);
        }
    }

    public void increaseSizeMyStack(int capacity) {
        int[] myStackArrayCopy = new int[capacity];

        for (int i = 0; i < myStackArray.length; i++) {
            myStackArrayCopy[i] = myStackArray[i];
        }
        myStackArray = myStackArrayCopy;
    }

    public void conclusion() {
        for (int i : myStackArray)
            System.out.println(i);

    }

}
