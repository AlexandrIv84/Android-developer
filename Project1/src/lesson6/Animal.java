package lesson6;

public class Animal {
    String name;
    int run;
    double jump;
    int swim;


    public Animal(String name, int run, double jump, int swim) {
        this.name = name;
        this.run = run;
        this.jump = jump;
        this.swim = swim;

    }

    public Animal(String name) {
        this(name, 0, 0, 0);
    }

    public Animal() {
        this(null);
    }

    @Override
    public String toString() {
        return "Характеристики животного {" +
                "Имя='" + name + '\'' +
                ", Бег=" + run +
                ", Прыжок=" + jump +
                ", Плавание=" + swim +
                '}';
    }


}
