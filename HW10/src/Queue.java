/**
 * Represents the Queue Abstract Data type.
 * All of these methods should run in O(1) for the LinkedList data structure.
 * When dequeue is called, it should remove the item that was first added
 * to the Queue.
 * @author Andrew Chafos
 * @version 1.0
 * @param <T> The type of elements in this list
 */
public interface Queue<T> {
    /**
     * adds data to the Queue
     * Think about where in the list the data should be added in
     * order to make the ordering compatible.
     * @param data the data to add to the queue.
     */
    void enqueue(T data);
    /**
     * removes the oldest piece of data from our Queue; that is,
     * the first thing we added, or the item that has been waiting the longest
     * to be removed.  Think about from where in the list we should remove to
     * make this work.
     * @return the dequeued item
     */
    T dequeue();
}