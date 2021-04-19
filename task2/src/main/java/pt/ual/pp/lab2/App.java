package pt.ual.pp.lab2;

import java.util.Random;

class Teller {
    private final int maximumWaitSeconds;
    private final int minimumWaitSeconds;
    private final int id;
    private final Random random;

    public Teller(final int id, final int minimumWaitSeconds, final int maximumWaitSeconds, final Random random) {
        this.id = id;
        this.random = random;
        this.maximumWaitSeconds = maximumWaitSeconds;
        this.minimumWaitSeconds = minimumWaitSeconds;
    }

    public void run() {
        try {
            int numWaitSeconds = Math.min(5, random.nextInt(this.maximumWaitSeconds) + this.minimumWaitSeconds);
            System.out.println("Teller "+this.id+" waiting for "+numWaitSeconds+" seconds.");
            Thread.sleep(1000 * numWaitSeconds);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Client on teller " + this.id + ".");
    }
}

public class App {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Teller teller1 = new Teller(1, 1, 5, random);

        while(true) {
            //Calcular o tempo de espera para cada caixa: 1-5, 3-8, 2-7

            teller1.run();

            Thread.sleep(1000 * Math.min(8, random.nextInt(8) + 3));
            System.out.println("Client on teller 2.");

            Thread.sleep(1000 * Math.min(7, random.nextInt(7) + 2));
            System.out.println("Client on teller 3.");
        }
    }
}
