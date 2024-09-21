package Test_Cases;

import Data_Structures.GoogleClass;
import Data_Structures.LinkedList;

public class TestCases {
    public static void GoogleClassTest() {
        GoogleClass googleClass = new GoogleClass();

        // Inserting values
        googleClass.insert(5);
        googleClass.insert(4);
        googleClass.insert(425);
        googleClass.insert(83);
        googleClass.insert(21);
        googleClass.insert(19);

        System.out.println(googleClass.toString());

        googleClass.remove(0);
        googleClass.remove(425);
        googleClass.remove(21);

        System.out.println("after remove: " + googleClass.toString());

        System.out.println("Random value from google class: " + googleClass.getRandom());
        System.out.println("Random value from google class: " + googleClass.getRandom());
        System.out.println("Random value from google class: " + googleClass.getRandom());
        System.out.println("Random value from google class: " + googleClass.getRandom());

    }

    public static void LinkedListTest() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("abcd");
        linkedList.addFirst("asdasd");
        linkedList.addFirst("ndoe 3 data");
        linkedList.addFirst("nose");
        linkedList.addFirst("sasd");

        linkedList.addLast("test123312");
        int count = 0;
        for (String i : linkedList) {
            if (count == 0) {
                System.out.print("[");
            } else if (count == linkedList.size() - 1) System.out.print("]");
            else {
                System.err.print(i + ", ");
            }
            count++;
        }
    }
}
