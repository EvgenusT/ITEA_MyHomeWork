package Queue;

public class MyQueue {

    private int[] queue;
    private int maxSize;
    private int currentNumber;
    private int front;
    private int rear;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[maxSize];
        rear = -1;
        front = 0;
        currentNumber = 0;
    }

    public void add(int elem) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queue[++rear] = elem;
        currentNumber++;
    }

    public int remove() {
        int temp = queue[front++];
        if (front == maxSize) {
            front = 0;
        }
        currentNumber--;
        return temp;
    }

    public boolean IsEmpty() {
        return currentNumber == 0;
    }

    public boolean isFull() {
        return (currentNumber == maxSize - 1);
    }

    public int getSize() {
        return currentNumber;
    }

    public int getFront() {
        return queue[front];
    }

    public int getRear() {
        return queue[rear];
    }

}
