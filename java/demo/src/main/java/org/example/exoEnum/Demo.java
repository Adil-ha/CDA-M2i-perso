package org.example.exoEnum;

import java.util.Scanner;


public class Demo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MessageType messageType = null;

        while (messageType == null) {
            System.out.print("Entrez le type de message (A, B, C, D) : ");
            String userInput = scanner.nextLine().toUpperCase();

            try {
                messageType = MessageType.valueOf(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Type de message invalide. Veuillez réessayer.");
            }
        }

        Priority priority = messageType.getPriority();
        System.out.println(priority);
    }
}
