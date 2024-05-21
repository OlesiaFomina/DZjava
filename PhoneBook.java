import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

    
        String[][] entries = {
            {"Анциферов", "89123456789"},
            {"Иванушкина", "89234567891"},
            {"Семченкова", "89345678912"},
            {"Кулешев", "89456789123"},
            {"Анциферов", "89567891234"}
        };

        // Заполнение телефонной книги
        for (String[] entry : entries) {
            String name = entry[0];
            String phone = entry[1];

            if (phoneBook.containsKey(name)) {
                phoneBook.get(name).add(phone);
            } else {
                Set<String> phones = new HashSet<>();
                phones.add(phone);
                phoneBook.put(name, phones);
            }
        }

        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));


        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
