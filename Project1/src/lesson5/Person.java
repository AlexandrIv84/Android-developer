package lesson5;

public class Person {

    private String firstName;
    private String surname;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Person(String firstName, String surname, String position, String email, String phoneNumber, int salary, int age) {
        this.firstName = firstName;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println(this);
    }


    public String toString() {

        return  "Имя: " + firstName + ", Фамилия: " + surname + ", Должность: " + position + ", email: " + email + ", телефон: " + phoneNumber + ", зарплата: " + salary + ", возраст: " + age;
    }
}


