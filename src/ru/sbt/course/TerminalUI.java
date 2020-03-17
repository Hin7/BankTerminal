package ru.sbt.course;

import java.io.PrintStream;
import java.util.Scanner;

public class TerminalUI {
    private TerminalImpl server;

    public TerminalUI(TerminalImpl terminal) {
        server = terminal;
    }

    public void process() {
        Scanner keybIn = new Scanner(System.in);
        PrintStream out = System.out;
        String inputStr = "";
        while (!"выход".equals(inputStr)) {
            out.println("Выберите действие. Введите \"баланс\", \"снять\", \"пополнить\", \"выход\"");
            inputStr = keybIn.nextLine();
            if ("выход".equals(inputStr))
                break;
            out.println("Введите pin код.");
            String pin = keybIn.nextLine();
            long cash;
            try {
                switch (inputStr) {
                    case "баланс":
                        out.println(server.getBallance(pin));
                        inputStr="";
                        break;
                    case "снять":
                        out.println("Введите сумму для снятия");
                        cash = keybIn.nextLong();
                        keybIn.nextLine();
                        server.getCash(pin, cash);
                        out.println("Снтие выполнено");
                        inputStr="";
                        break;
                    case "пополнить":
                        out.println("Введите сумму для зачисления");
                        cash = keybIn.nextLong();
                        keybIn.nextLine();
                        server.addBallance(pin, cash);
                        out.println("Зачисление выполнено");
                        inputStr="";
                        break;
                    default:
                        out.println("Команда не распознана");
                        inputStr="";
                }
            } catch (WrongPinException e) {
                out.println("Ошибка пин");
                out.println(e.getMessage());
            } catch (TerminalException e) {
                out.println("Ошибка выполнения");
                out.println(e.getMessage());
            }
        }
    }
}
