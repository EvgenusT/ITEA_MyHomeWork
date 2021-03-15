package Queue;

public class Main {


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);

        System.out.println("Очередь пустая? : "+myQueue.IsEmpty());
        System.out.println("Очередь полная? : "+myQueue.isFull());

        System.out.println("Добавляем елементы");
        myQueue.add(2);
        myQueue.add(5);
        myQueue.add(12);
        myQueue.add(28);

        myQueue.remove();

        myQueue.add(29);
        myQueue.add(60);

        System.out.println("Размер очереди после добавления элементов : "+myQueue.getSize());

        while (!myQueue.IsEmpty()) {
            int n = myQueue.remove();
            System.out.println("Elem: " + n);
        }

        System.out.println("Размер очереди после удаления элементов  : "+myQueue.getSize());
    }
}
