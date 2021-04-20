package pt.ual.pp.lab2;

import java.util.ArrayList;
import java.util.Scanner;

class Counter extends Thread {
    private final int limit;

    public Counter(final int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        // Opção A
//        int i = limit;
//        while(i > 0){
//            try {
//                Thread.sleep(1000);
//            } catch(InterruptedException e) {
//                e.printStackTrace();
//            }
//            i--;
//        }
        // Opção B
        try {
            Thread.sleep(limit * 1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // Opção C
//        try {
//            TimeUnit.SECONDS.sleep(limit);
//        } catch(InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(limit + " second timer done.");
    }
}

public class App {
    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var counters = new ArrayList<Counter>();

        while(true) {
            final var line = scanner.nextLine();
            final var commands = line.split(" "); // SC 10 // START

            switch(commands[0]) {
                case "SC":
                    final var counterLimit = Integer.parseInt(commands[1]);
                    // Inicializar um counter com o limite indicado (ele não começa)
                    final var counter = new Counter(counterLimit);
                    // Adicionar à coleção de Counters
                    counters.add(counter);
                    break;
                case "START":
                    // Começar todos os counters registados na coleção de Counters
                    for(final var c : counters) {
                        c.start();
                    }
                    System.out.println("END");
//                    System.exit(0);
            }
        }
    }
}
