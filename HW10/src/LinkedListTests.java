import java.util.Arrays;
/**
 * Provided file that contains a number of tests to help you
 * debug your LinkedList class!
 * @author Andrew Chafos and Shishir
 * @version 1.0
 */
public class LinkedListTests {
    /**
     * Contains the main execution of the program.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        List<String> myList = new LinkedList<>();

        // First, we test all the exceptions

        // Empty list tests  ([])
        assertEquals(0, myList.size(), "An empty list should have a size of 0!");
        assertThrows(IllegalArgumentException.class, () -> myList.add(-1, ""));
        assertThrows(IllegalArgumentException.class, () -> myList.remove(0));
        assertThrows(IllegalArgumentException.class, () -> myList.get(0));
        assertThrows(IllegalArgumentException.class, () -> myList.subList(-1));

        // Now that we're done with exceptions, let's test the main functionality

        LinkedList<String> list2 = new LinkedList<>();


        String[] toAdd = {"3", "4", "1", "2"};
        // will add 3 at index 0, 4 at index 1, 1 at index 0, and then 2 at index 1

        list2.add(0, "Maddy");
        assertListEquals(new String[]{"Maddy"}, list2);

        list2.add(1, "Allan");
        list2.add(0, "Felipe");
        list2.add(1, "Jack");
        list2.add(2, "Carl");

        // The list should now look like: [Felipe, Jack, Carl, Maddy, Allan]

        assertListEquals(
            new String[]{"Felipe", "Jack", "Carl", "Maddy", "Allan"},
            list2
        );


        LinkedList<String> subList1 = (LinkedList<String>) list2.subList(3);
        assertListEquals(
            new String[]{"Felipe", "Jack", "Carl"},
            subList1
        );

        List<String> subList2 = list2.subList(7);
        assertTrue(subList2 != list2, "subList() should create a new LinkedList object, not modify an existing one!");
        assertListEquals(
            new String[] {"Felipe", "Jack", "Carl", "Maddy", "Allan"},
            subList2
        );

        assertEquals("Felipe", list2.remove(0), "remove from index 0 should give first element");
        assertEquals("Allan", list2.remove(3), "remove from index (size - 1) should give last element");
        // Now the list looks like [Jack, Carl, Maddy]
        assertListEquals(
            new String[] {"Jack", "Carl", "Maddy"},
            list2
        );

        Queue<String> myQueue = new LinkedList<>();

        myQueue.enqueue("Will");
        myQueue.enqueue("Prerna");
        myQueue.enqueue("Julia");

        assertEquals("Will", myQueue.dequeue(), "Queue should always remove first added element first");
        assertEquals("Prerna", myQueue.dequeue(), "Queue should remove based on order added");

        myQueue.enqueue("Vince");

        assertEquals("Julia", myQueue.dequeue(), "Queue should remove based on order added");

        System.out.println("All Tests Passed!");
    }


    // YOU CAN IGNORE EVERYTHING BELOW THIS


    /**
     * Helper method that terminates the program if the given boolean expression is false.
     * @param expression when false, ends the program and prints out message.  Otherwise, method does nothing
     * @param message message to show if the progrsam ends.
     */
    private static void assertTrue(boolean expression, String message) {
        if (!expression) {
            throw new AssertionError("Test Failed: " + message);
        }
    }

    /**
     * Helper method that terminates the program if the given objects are not equal by the equals() method.
     * @param expected the expected value of `actual`
     * @param actual when not equal to expected, ends the program and prints out message.
     * @param message message to show if the progrsam ends.
     */
    private static void assertEquals(Object expected, Object actual, String message) {
        if ((actual == null && expected != null) || !actual.equals(expected)) {
            throw new AssertionError(
                "Test Failed: " + message + ".  Expected "
                + String.valueOf(expected) + ", was actually:" + String.valueOf(actual)
            );
        }
    }

    /**
     * Helper method to check if an exception was thrown from a call
     * @param expectedType The exception to expect
     * @param executable   The call to make
     */
    private static void assertThrows(Class<? extends Exception> expectedType, Runnable executable) {
        try {
            executable.run();
            throw new AssertionError("Expected: " + expectedType.getSimpleName() + ", but no exception was thrown.");
        } catch (Exception caught) {
            if (!expectedType.isInstance(caught)) {
                throw new AssertionError("Expected " + expectedType.getSimpleName() + " to be thrown"
                    + " but instead got " + caught.getClass().getSimpleName());
            }
        }
    }

    private static void assertListEquals(String[] expected, List<String> actual) {
        assertEquals(expected.length, actual.size(),
            "Expected list of size " + expected.length + " but got " + actual.size());

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(actual.get(i))) {
                throw new AssertionError("Expected " + Arrays.toString(expected) + ", but got " + actual.get(i)
                                        + " at index " + i);
            }
        }
    }
    public static void printList(LinkedList<String> a){
        Node<String> current = a.head;
        for(int i = 0; i < a.size(); i++){
            System.out.print(current.getData() + "*");
            current = current.getNext();
        }
        System.out.println();
    }

}
