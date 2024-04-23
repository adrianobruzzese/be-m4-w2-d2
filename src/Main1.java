import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creo un set per memorizzare le parole distinte
        Set<String> words = new HashSet<>();

        // Richiedo all'utente di inserire il numero di elementi da aggiungere
        System.out.println("Inserisci il numero di elmenti seguito dal tasto Invio. Inserisci 0 per uscire");
        int numElementi = Integer.parseInt(scanner.nextLine());

        // Se il numero di elementi è maggiore di 0, procedo con l'inserimento delle parole
        if (numElementi > 0) {
            int duplicatesCount = 0; // Contatore parole duplicate

            // Ciclo per leggere numElementi parole dall'utente
            while (numElementi-- > 0) {
                System.out.println("Aggiungi una parola al set");
                String word = scanner.nextLine();

                // Tento di aggiungere la parola al set. Se la parola è già presente, incrementa il contatore delle duplicate e stampa un messaggio all'utente
                if (!words.add(word)) {
                    duplicatesCount++;
                    System.out.println(word + " è già nell'elenco");
                }
            }

            // Stampo il numero di parole distinte, l'elenco delle parole distinte e il numero di parole duplicate
            System.out.println("Numero di parole distinte: " + words.size());
            System.out.println("Elenco delle parole distinte: " + words);
            System.out.println("Numero di parole duplicate: " + duplicatesCount);
        } else {
            // Se il numero di elementi è minore o uguale a 0, stampo un messaggio di errore
            System.err.println("Non va bene un numero minore uguale a zero");
        }

        // Chiudo lo scanner per liberare le risorse
        scanner.close();
    }
}
