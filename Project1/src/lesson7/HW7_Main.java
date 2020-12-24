package lesson7;

public class HW7_Main {

    public static void main(String[] args) {

        System.out.println("Задание №7");

        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Мартин", 5);
        catArray[1] = new Cat("Пушок", 10);
        catArray[2] = new Cat("Барсик", 7);
        catArray[3] = new Cat("Ральф", 8);
        catArray[4] = new Cat("Васька", 4);

        Plate plate = new Plate();

        plate.addFood(29); // Добавление еды в миску
        plate.printInfo();
        for (Cat cat : catArray) {
            System.out.println("");
            System.out.println(cat);
            cat.eat(plate);
            plate.printInfo();
        }

    }


}
