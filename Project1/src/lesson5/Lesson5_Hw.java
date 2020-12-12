package lesson5;

public class Lesson5_Hw {

    private static final int MIN_AGE = 40;

    public static void main(String[] args) {

        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivan", "Ivanov", "Engineer", "ivivan@mailbox.com", "89871234567", 80000, 36);
        persArray[1] = new Person("Petr", "Petrov", "Director", "pepetr@mailbox.com", "89872345678", 100000, 42);
        persArray[2] = new Person("Sidr", "Sidorov", "Watchman", "sisidor@mailbox.com", "89873456789", 20000, 55);
        persArray[3] = new Person("Semen", "Semenov", "Accountant", "sesemen@mailbox.com", "89874567890", 90000, 60);
        persArray[4] = new Person("Igor", "Igorev", "Driver", "igigor@mailbox.com", "89875678901", 30000, 25);

        System.out.println("Список сотрудников, старше 40 лет:");

        for (Person person : persArray) {
            if (person.getAge() > MIN_AGE) {
                person.printInfo();
            }

        }

    }
}
