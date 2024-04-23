import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il numero di elementi seguito dal tasto Invio");
        int n = scanner.nextInt();

        List<Integer> randomIntegers = getRandomList(n);
        printList(randomIntegers, "Lista random originale");

        List<Integer> mirrored = mirrorList(randomIntegers);
        printList(mirrored, "Lista concatenata ed invertita");

        printOddEven(mirrored, false, "Numeri in posizione dispari");
        printOddEven(mirrored, true, "Numeri in posizione pari");

        scanner.close();
    }

    // Genera una lista ordinata di 'n' numeri casuali da 0 a 100
    public static List<Integer> getRandomList(int n) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            numbers.add(random.nextInt(101)); // Range da 0 a 100
        }

        Collections.sort(numbers);
        return numbers;
    }

    // Crea una lista speculare (concatenata con la stessa lista invertita)
    public static List<Integer> mirrorList(List<Integer> list) {
        List<Integer> mirrored = new ArrayList<>(list);

        // Iterazione in ordine inverso e aggiunta alla lista mirrored
        for (int i = list.size() - 1; i >= 0; i--) {
            mirrored.add(list.get(i));
        }

        return mirrored;
    }

    // Stampa una lista generica, aggiungendo un titolo descrittivo
    public static void printList(List<Integer> list, String title) {
        System.out.println("---------- " + title + " ----------");
        System.out.println("Stampo lista lunga " + list.size());

        for (int index = 0; index < list.size(); index++) {
            System.out.println("Posizione [" + index + "]: " + list.get(index));
        }
    }

    // Stampa numeri agli indici pari o dispari
    public static void printOddEven(List<Integer> list, boolean even, String title) {
        System.out.println("---------- " + title + " ----------");
        System.out.println("Stampo lista lunga " + list.size());

        for (int index = 0; index < list.size(); index++) {
            if ((index % 2 == 0) == even) { // Verifica parità/disparità in base al flag 'even'
                System.out.println("Posizione [" + index + "]: " + list.get(index));
            }
        }
    }
}
