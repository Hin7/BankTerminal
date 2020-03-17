package ru.sbt.course;

/**
 * Lesson 5 SBT. Exeptions.
 * BankTerminal - имитатор банковского терминала.
 *
 * @author Hin7
 * @version 1.0 17.03.2020
 */

public class BankTerminal {

    public static void main(String[] args){
        TerminalImpl terminalServer = new TerminalImpl();
        TerminalUI terminalUI = new TerminalUI(terminalServer);
        terminalUI.process();

    }
}
