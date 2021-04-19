package pt.ual.pp.lab2;

import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            //Calcular o tempo de espera para cada caixa: 1-5, 3-8, 2-7
            Random random = new Random();

            // 1-5
            Thread.sleep(1000 * Math.min(5, random.nextInt(5) + 1));
            System.out.println("Client on teller 1.");
            Thread.sleep(1000 * Math.min(8, random.nextInt(8) + 3));
            System.out.println("Client on teller 2.");
            Thread.sleep(1000 * Math.min(7, random.nextInt(7) + 2));
            System.out.println("Client on teller 3.");
        }
    }
}
