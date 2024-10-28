import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HorseRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inserimento della lunghezza della gara
        System.out.println("Inserisci la lunghezza della gara in metri:");
        int distance = scanner.nextInt();

        // Inserimento del numero di cavalli
        System.out.println("Inserisci il numero di cavalli:");
        int numHorses = scanner.nextInt();
        scanner.nextLine();  // Consuma il newline rimasto

        // Creazione e avvio dei thread per ogni cavallo
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < numHorses; i++) {
            System.out.println("Inserisci il nome del cavallo " + (i + 1) + ":");
            String horseName = scanner.nextLine();
            Horse horse = new Horse(horseName, distance);
            horses.add(horse);
        }

        // Avvio della gara
        System.out.println("La gara è iniziata!");
        for (Horse horse : horses) {
            horse.start();
        }

        // Aspetta la fine della gara
        for (Horse horse : horses) {
            try {
                horse.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("La gara è finita!");
        scanner.close();
    }
}
