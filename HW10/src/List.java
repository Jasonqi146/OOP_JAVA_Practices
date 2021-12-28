/**
 * Represents the List Abstract Data type.
 * @author Andrew Chafos
 * @version 1.0
 * @param <T> The type of elements in this list
 */
public interface List<T> {
    /**
     * Adds the given data to the list at the specified index.
     * For example, `add(0, "Hello")` for a List of generic type String would add `"Hello"`
     * to the beginning of the list.
     * @param index The index at which data will be added
     * @param data  the data to add
     */
    void add(int index, T data);
    /**
     * Removes the data at the given index from the list, and then returns it.
     * @param index the index to remove from
     * @return the removed piece of data
     */
    T remove(int index);
    /**
     * Returns the data at the specified index in the list.
     * @param index the index to return from
     * @return the data at the specified index
     */
    T get(int index);
    /**
     * returns **a new List object** containing *the first n elements in the current List*.
     * For example, if our list was [1, 2, 3, 4, 5, 6], subList(2) should
     * return a new list containing [1, 2], and subList(3)
     * should return a new list containing [1, 2, 3].
     * @param  n The amount of elements to take
     * @return a new List object containing the first n elements in the current list, as described above
     */
    List<T> subList(int n);
    /**
     * Returns the number of items in this list.
     * @return the number of items in this list
     */
    int size();
}
