package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.util.Random;

public class Controller {
    Random random = new Random();
    public int attempt = 1;
    int randomNumber = 0;
    @FXML
    private TextField numberInputField;

    @FXML
    private Label LabelMessage;

    @FXML
    void genRandomNumber() {

        randomNumber = random.nextInt(99);
        LabelMessage.setText(" Новое число сгенерировано!   " + String.valueOf(randomNumber));
        attempt = 3;
    }

    @FXML
    void checkNumber() {

        String message = numberInputField.getText();
        numberInputField.clear();
        if (attempt > 0) {
            if (!message.isEmpty()) {

                try {
                    int number = Integer.parseInt(message);

                    if (randomNumber == number) {
                        LabelMessage.setText("Поздравляю вы угадали число " + String.valueOf(number));
                    } else if (randomNumber > number) {
                        attempt--;
                        LabelMessage.setText("Сгенерированное число больше, осталось попыток:    " + String.valueOf(attempt));

                    } else if (randomNumber < number) {
                        attempt--;
                        LabelMessage.setText("Сгенерированное число меньше, осталось попыток:    " + String.valueOf(attempt));

                    }


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ошибка ввода данных. Введите число!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Сгенерируйте новое число!");
        }
    }

}