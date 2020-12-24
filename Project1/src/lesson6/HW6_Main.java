package lesson6;

// Сделал, как понял задание) Хотелось, что бы условия ДЗ были описаны конкретнее!
public class HW6_Main {

    public static int length1 = 300;        //Длина дистанции
    public static double height = 1.5;      //Высота препятствия
    public static int length2 = 1;          //Длина водоема

    public static void main(String[] args) {

        Cat cat = new Cat("Cat", 200, 2, 0);
        Dog dog = new Dog("Dog", 500, 0.5, 10);

        System.out.println("Задание №6");
        System.out.println("Длина дистанции: " + length1 + " Высота препятствия: " + height + " Длина водоема: " + length2);
        Animal[] animals = {cat, dog};

        for (Animal animal : animals) {
            System.out.println("");
            System.out.println(animal);
            if (animal.run > length1) {
                System.out.println(animal.name + "  Пробежал " + length1);
            } else {
                System.out.println(animal.name + "  Не пробежал " + length1);
            }

            if (animal.jump > height) {
                System.out.println("Перепрыгнул " + height);
            } else {
                System.out.println("Не перепрыгнул " + height);
            }

            if (animal.swim > length2) {
                System.out.println("Проплыл " + length2);
            } else if (animal.swim == 0) {
                System.out.println("Не умеет плавать");

            } else {
                System.out.println("Не проплыл " + length2);
            }


        }

    }


}
