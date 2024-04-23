import java.util.HashMap;
import java.util.Map;

public class Main3 {
    private static final Map<String, String> rubrica = new HashMap<>();

    public static void main(String[] args) {
        addContacts(); // Inserimento contatti iniziali
        removeContact("Topolino de' Topolini"); // Rimozione contatto di esempio
        findContacts(); // Ricerche di esempio
        printList(); // Stampa dell'intera rubrica
    }

    // Aggiungo alcuni contatti iniziali alla rubrica
    private static void addContacts() {
        System.out.println("-------------------- FUNZIONE 1 ----------------------");
        addContact("Paperino da Paperopoli", "+39 0000000000");
        addContact("Topolino de' Topolini", "+39 1111111111");
        addContact("Archimede Pitagorico", "+39 2222222222");
        System.out.println("Aggiunti " + rubrica.size() + " contatti");
    }

    // Rimuovo un contatto per nome
    private static void removeContact(String name) {
        System.out.println("-------------------- FUNZIONE 2 ----------------------");
        if (rubrica.remove(name) != null) {
            System.out.println("Rimosso il contatto: " + name);
        } else {
            System.out.println("Contatto " + name + " non trovato.");
        }
    }

    // Eseguo ricerche di esempio per nome e numero
    private static void findContacts() {
        System.out.println("-------------------- FUNZIONE 3 ----------------------");
        findPersonByPhoneNumber("+39 1111111111");

        System.out.println("-------------------- FUNZIONE 4 ----------------------");
        findNumberByName("Topolino de' Topolini");
    }

    // Aggiungo un contatto alla rubrica
    private static void addContact(String name, String phone) {
        rubrica.put(name, phone);
    }

    // Trovo la persona in base al numero di telefono (versione ottimizzata)
    private static void findPersonByPhoneNumber(String phone) {
        // Iterare sui valori (numeri di telefono) è più efficiente
        String name = rubrica.entrySet().stream()
                .filter(entry -> phone.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(name != null ? "Numero trovato! Persona: " + name : "Contatto non trovato");
    }

    // Trovo il numero in base al nome
    private static void findNumberByName(String name) {
        String phone = rubrica.get(name);
        System.out.println(phone != null ? "Numero: " + phone : "Non trovato!");
    }

    // Stampo i contatti presenti nella rubrica
    private static void printList() {
        System.out.println("-------------------- FUNZIONE 5 ----------------------");
        if (rubrica.isEmpty()) {
            System.out.println("La rubrica è vuota.");
        } else {
            rubrica.forEach((name, phone) -> System.out.println("Nome: " + name + ", numero di telefono: " + phone));
        }
    }
}
