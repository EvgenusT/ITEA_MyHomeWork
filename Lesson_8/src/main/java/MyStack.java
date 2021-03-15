public class MyStack implements MyStackInterface {

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

    @Override
    public int pop() {
        int max = peek();
        deleteElement();
        return max;
    }

    @Override
    public void push(int element) {
        addElement(element);
        if (myStackArray.length == count) {
            increaseSizeMyStack(2 * myStackArray.length);
        }
    }

    @Override
    public boolean isEmpty() {
        return (high == -1);
    }

    private int peek() {
        return myStackArray[count - 1];
    }

    private void addElement(int element) {
        myStackArray[++high] = element;
        ++count;
    }

    private void deleteElement() {
        int[] myStackArrayNew = new int[myStackArray.length - 1];
        System.arraycopy(myStackArray, 0, myStackArrayNew, 0, fillingMyStack() - 1);
        myStackArray = myStackArrayNew;
        count--;
        high--;
    }

    private int fillingMyStack() {
        return count;
    }

    private void increaseSizeMyStack(int capacity) {
        int[] myStackArrayCopy = new int[capacity];

        for (int i = 0; i < myStackArray.length; i++) {
            myStackArrayCopy[i] = myStackArray[i];
        }
        myStackArray = myStackArrayCopy;
    }
}
