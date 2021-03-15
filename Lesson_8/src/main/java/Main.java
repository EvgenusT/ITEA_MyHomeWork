public class Main {
    public static void main(String[] args) {
        goMyStack(new MyStack(6));
    }

    private static void goMyStack(MyStack myStack) {

        myStack.push(10);
        myStack.push(20);
        myStack.push(33);
        myStack.push(40);
        myStack.push(50);

        System.out.println("Проверка пустой ли стек: " + myStack.isEmpty());
        System.out.println("MyStack содержит: ");
        System.out.println("Максимальный элемент в стеке 1 запрос: " + myStack.pop());
        System.out.println("Максимальный элемент в стеке 2 запрос: " + myStack.pop());
        System.out.println("Максимальный элемент в стеке 3 запрос: " + myStack.pop());
    }

    private static void print() {

    }

}
