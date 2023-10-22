// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phone {
    public static void addNumber(String key, String value, Map<String, ArrayList<String>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
        public static void main(String[] args) {
        HashMap<String, ArrayList<String>> bookPhone = new HashMap<>();
        addNumber("Ivanov", "89172256521", bookPhone);
        addNumber("Petrov", "82569954236", bookPhone);
        addNumber("Petrov", "84521145569", bookPhone);
        addNumber("Sidorov", "89965521145", bookPhone);
        addNumber("Sidorov", "128500", bookPhone);
        addNumber("Sidorov", "88005553535", bookPhone);
        showBook(bookPhone);
       }

    public static void showBook(HashMap<String, ArrayList<String>> ist) {

        ArrayList< Map.Entry < String, ArrayList > > list = new ArrayList(ist.entrySet());
        list.sort((o1, o2) -> (o2.getValue().size() - o1.getValue().size()));
        for (Map.Entry< String, ArrayList > entry : list) {
            System.out.println((entry.getKey() + " : " + entry.getValue()).replace('[', ' ').replace(']', ' '));
        }
    }
}

