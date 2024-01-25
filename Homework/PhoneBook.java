package Homework;
import java.util.*;

public class PhoneBook {
    public HashMap<String, HashSet<String>> book;

    public PhoneBook() {
        book = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        if (book.containsKey(name)) {
            book.get(name).add(phoneNumber);
        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            book.put(name, phoneNumbers);
        }
    }

    public void printContacts() {
        List<Map.Entry<String, HashSet<String>>> sortedContacts = new ArrayList<>(book.entrySet());
        sortedContacts.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
        Collections.reverse(sortedContacts);

        for (Map.Entry<String, HashSet<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Андрей", "12345678906");
        phoneBook.addContact("Саша", "88881234455");
        phoneBook.addContact("Маша", "9992325676");
        phoneBook.addContact("Андрей", "88005555555");

        phoneBook.printContacts();
    }
}