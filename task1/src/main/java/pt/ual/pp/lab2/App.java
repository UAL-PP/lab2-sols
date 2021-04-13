package pt.ual.pp.lab2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine(); // "ping", "quit"
            switch(line) {
                case "ping":
                    // Espera 1 segundo
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("pong");
                    break;
                case "quit":
                    System.exit(0);
            }
        }
    }
}
