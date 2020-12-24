package lesson7;

import java.util.Random;

public class Cat {

    private String name;
    private int appetite;
    private boolean satiety = false;

    private Random random = new Random();

    public Cat(String name, int appetite, boolean satiety){
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;

    }

    public Cat(String name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    public Cat(String name) {
        this.name = name;
    }

    public void eat(Plate plate) {
        plate.decreaseFood(this.appetite);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Имя кота='" + name + '\'' +
                ", Аппетит=" + appetite +
                '}';
    }
}