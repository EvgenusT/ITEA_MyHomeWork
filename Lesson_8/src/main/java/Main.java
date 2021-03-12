public class Main {
    public static void main(String[] args) {
        goMyStack(new MyStack(5));


    }

    private static void goMyStack(MyStack myStack) {

        myStack.addElement(10);
        myStack.addElement(20);
        myStack.addElement(33);
        myStack.addElement(40);
        myStack.addElement(50);

        System.out.println("Проверка пустой ли стек: " + myStack.isEmpty());
        System.out.println("MyStack содержит: ");
        myStack.conclusion();

        System.out.println("Максимальный элемент в стеке: " + myStack.readTop());
        System.out.println("Размер стека: " + myStack.sizeMyStack());
        System.out.println("Количество элементов в стеке: " + myStack.fillingMyStack());
        System.out.println("удаляю 1 элемент");
        myStack.deleteElement();
        System.out.println("Размер стека: " + myStack.sizeMyStack());
        System.out.println("Количество элементов в стеке после удаления: " + myStack.fillingMyStack());
        System.out.println("Максимальный элемент в стеке после удаления: " + myStack.readTop());
        myStack.conclusion();
    }
}
