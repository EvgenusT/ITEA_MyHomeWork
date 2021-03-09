package task_2;

public class Packer {

    public static void main(String[] args) {
        Packer packer = new Packer();

        Box<Food> foodBox = new Box<>();

        Cake cake = new Cake();
        Box<Cake> cakeBox = new Box<>();
        cakeBox.put(cake);

        Tart tart = new Tart();
        Box<Tart> tartBox = new Box<>();
        tartBox.put(tart);

        Pie pie = new Pie();
        Box<Pie> pieBox = new Box<>();
        pieBox.put(pie);

        Bakery bakery = new Bakery();
        Box<Bakery> bakeryBox = new Box<>();
        bakeryBox.put(bakery);

        packer.repackage(foodBox, cakeBox);
        System.out.println("запихнули в Box - cake: " + foodBox.get());

        packer.repackage(foodBox, tartBox);
        System.out.println("запихнули в Box - tart: " + foodBox.get());

        packer.repackage(foodBox, pieBox);
        System.out.println("запихнули в Box - pie: " + foodBox.get());

        packer.repackage(foodBox, bakeryBox);
        System.out.println("запихнули в Box - bakery: " + foodBox.get());

    }

    public void repackage(Box<? super Food> to, Box<? extends Bakery> from) {
        to.put(from.get());
    }
}

