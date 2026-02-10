import java.util.*;

public class MyCollectionsPractice {

    public static void main(String[] args) {

        // 1. Удаление дубликатов
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 4, 5);
        Set<Integer> noDuplicates = new HashSet<>(numbers);
        System.out.println("1) Unique numbers: " + noDuplicates);

        // 2. Проверка доступа
        Set<String> users = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie"));
        System.out.println("2) Bob allowed: " + checkAccess(users, "Bob"));
        System.out.println("2) David allowed: " + checkAccess(users, "David"));

        // 3. Размер и очистка множества
        Set<Integer> values = new HashSet<>(Arrays.asList(10, 20, 30));
        System.out.println("3) Size: " + values.size());
        values.clear();
        System.out.println("3) Is empty: " + values.isEmpty());

        // 4. Удаление элемента
        Set<String> people = new HashSet<>(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"));
        boolean wasRemoved = people.remove("Charlie");
        System.out.println("4) Removed Charlie: " + wasRemoved + " -> " + people);

        // 5. Объединение множеств
        Set<Integer> firstSet = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> secondSet = new HashSet<>(Arrays.asList(3, 4, 5));
        firstSet.addAll(secondSet);
        System.out.println("5) Union: " + firstSet);

        // 6. Разность множеств
        Set<Integer> mainSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> removeSet = new HashSet<>(Arrays.asList(2, 4));
        mainSet.removeAll(removeSet);
        System.out.println("6) Difference: " + mainSet);

        // 7. Пересечение
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> b = new HashSet<>(Arrays.asList(2, 3, 4));
        a.retainAll(b);
        System.out.println("7) Intersection: " + a);

        // 8. Подмножество
        Set<Integer> bigSet = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> smallSet = new HashSet<>(Arrays.asList(2, 3));
        System.out.println("8) Contains all: " + bigSet.containsAll(smallSet));

        // 9. Уникальные слова
        String text = "apple banana apple orange banana";
        Set<String> words = new HashSet<>(Arrays.asList(text.split(" ")));
        System.out.println("9) Unique words: " + words);

        // 10. Без учета регистра
        String[] rawWords = {"Apple", "apple", "APPLE", "Banana"};
        Set<String> lowerWords = new HashSet<>();
        for (String w : rawWords) {
            lowerWords.add(w.toLowerCase());
        }
        System.out.println("10) Case insensitive: " + lowerWords);

        // 11. Очередь (FIFO)
        ArrayDeque<Integer> fifoQueue = new ArrayDeque<>();
        fifoQueue.add(1);
        fifoQueue.add(2);
        fifoQueue.add(3);
        System.out.println("11) First element: " + fifoQueue.peek());
        while (!fifoQueue.isEmpty()) {
            System.out.println("11) Removed: " + fifoQueue.poll());
        }

        // 12. Стек (LIFO)
        ArrayDeque<String> lifoStack = new ArrayDeque<>();
        lifoStack.push("a");
        lifoStack.push("b");
        lifoStack.push("c");
        while (!lifoStack.isEmpty()) {
            System.out.println("12) Pop: " + lifoStack.pop());
        }

        // 13. Deque (двусторонняя очередь)
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("13) Deque: " + deque);

        // 14. offerFirst / offerLast
        ArrayDeque<Integer> dequeOffer = new ArrayDeque<>();
        dequeOffer.offerFirst(10);
        dequeOffer.offerLast(20);
        System.out.println("14) Deque: " + dequeOffer);

        // 15. Peek
        ArrayDeque<Integer> peekDeque = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        System.out.println("15) Peek: " + peekDeque.peek());
        System.out.println("15) Peek first: " + peekDeque.peekFirst());
        System.out.println("15) Peek last: " + peekDeque.peekLast());// 16. Poll
        ArrayDeque<Integer> pollDeque = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        while (!pollDeque.isEmpty()) {
            System.out.println("16) Poll: " + pollDeque.poll());
        }

        // 17. Удаление первого и последнего вхождения
        ArrayDeque<String> letters = new ArrayDeque<>(Arrays.asList("a", "b", "c", "b", "a"));
        letters.removeFirstOccurrence("b");
        letters.removeLastOccurrence("a");
        System.out.println("17) Result: " + letters);

        // 18. Размер и пустота
        ArrayDeque<Integer> sizeDeque = new ArrayDeque<>();
        sizeDeque.add(5);
        System.out.println("18) Size: " + sizeDeque.size());
        sizeDeque.remove();
        System.out.println("18) Empty: " + sizeDeque.isEmpty());

        // 19. Очистка
        ArrayDeque<Integer> clearDeque = new ArrayDeque<>(Arrays.asList(1, 2, 3));
        clearDeque.clear();
        System.out.println("19) Cleared, peek: " + clearDeque.peek());

        // 20. Проверка палиндрома
        String word = "radar";
        ArrayDeque<Character> charDeque = new ArrayDeque<>();
        for (char ch : word.toCharArray()) {
            charDeque.add(ch);
        }

        boolean isPalindrome = true;
        while (charDeque.size() > 1) {
            if (!charDeque.removeFirst().equals(charDeque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("20) Palindrome: " + isPalindrome);

        // 21. Планировщик задач
        SimpleScheduler scheduler = new SimpleScheduler();
        scheduler.add("Task1", false);
        scheduler.add("Urgent1", true);
        scheduler.add("Task2", false);
        scheduler.add("Urgent2", true);

        while (!scheduler.isEmpty()) {
            System.out.println("21) Execute: " + scheduler.next());
        }
    }

    static boolean checkAccess(Set<String> users, String name) {
        return users.contains(name);
    }
}

class SimpleScheduler {

    private ArrayDeque<String> taskQueue = new ArrayDeque<>();

    void add(String task, boolean priority) {
        if (priority) {
            taskQueue.addFirst(task);
        } else {
            taskQueue.addLast(task);
        }
    }

    String next() {
        return taskQueue.pollFirst();
    }

    boolean isEmpty() {
        return taskQueue.isEmpty();
    }
}