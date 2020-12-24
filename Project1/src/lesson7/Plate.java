package lesson7;

public class Plate {

    private int food;

    public void addFood(int food) {
        this.food += food;
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void decreaseFood(int food) {
        if (this.food >food){
            this.food -= food;
            System.out.println("Кот наелся");
        } else System.out.println("В миске не хватает корма");


    }

    @Override
    public String toString() {
        return "Корма в миске:" + food;
    }
}