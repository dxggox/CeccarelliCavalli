public class Horse extends Thread {
    private String name;
    private int distance;  // Lunghezza del percorso
    private int progress = 0;  // Metri percorsi finora
    private final int step = 10;  // Metri percorsi in ogni step

    public Horse(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public void run() {
        while (progress < distance) {
            try {
                Thread.sleep((int)(Math.random() * 500));  // Ritardo casuale tra uno step e l'altro
                progress += step;
                if (progress > distance) {
                    progress = distance;  // Evita di superare la distanza
                }
                System.out.println(name + " ha percorso " + progress + " metri.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " ha completato la gara!");
    }
}
