package pt.ual.pp.lab2;

import java.util.Scanner;

class PingResponse extends Thread {
    @Override
    public void run() {
        // Espera 1 segundo
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pong");
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine(); // "ping", "quit"
            switch(line) {
                case "ping":
                    // Responder ao ping
                    PingResponse pingResponse = new PingResponse();
                    pingResponse.start();
                    break;
                case "quit":
                    System.exit(0);
            }
        }
    }
}

