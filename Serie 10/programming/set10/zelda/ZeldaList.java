package programming.set10.zelda;

public class ZeldaList<T> {

	private ZeldaElement<T> head = null;
	private int index = 0;

	/**
	 * Adds the given value to the end of the list.
	 * 
	 * @param value
	 *            the value to add. If {@code value == null}, nothing happens.
	 */
	public void add(T value) {
		if (value == null) {
			return;
		}

		ZeldaElement<T> element = new ZeldaElement<>(); // create new element
		element.setValue(value);
		if (index == 0) { // if there is no element before, the new element =
							// head element
			head = element;
		} else {
			ZeldaElement<T> current;
			for (current = head; current.getNextElement() != null; current = current.getNextElement()) // search
																										// for
																										// tail
																										// element
				;
			current.setNextElement(element); // link new element with last
												// element
		}
		index++; // increase index
	}

	/**
	 * Inserts the given value into the list at the given index. The element
	 * that was at that index previously ends up at {@code index + 1} after this
	 * method.
	 * 
	 * @param index
	 *            the index to insert the value at, with
	 *            {@code 0 <= index <= getSize()}. If this condition is not met,
	 *            nothing happens.
	 * @param value
	 *            the value to insert. If this is {@code null}, nothing happens.
	 */
	public void add(int index, T value) {
		if (index < 0 || index > this.index)
			return;
		ZeldaElement<T> element = new ZeldaElement<>(); // create new element
		element.setValue(value);
		if (index == 0) { // new element = new head element
			element.setNextElement(head);
		} else {
			ZeldaElement<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.getNextElement(); // get element at index -1
			}
			ZeldaElement<T> next = current.getNextElement(); // save element at
																// index
			current = element; // link new element
			element = next;
		}

		this.index++; // increase index
	}

	/**
	 * Removes the given value from the list if it's in there somewhere.
	 * 
	 * @param value
	 *            the value to remove. If this is {@code null}, nothing is
	 *            removed.
	 * @return {@code true} if the value was found and removed, {@code false}
	 *         otherwise.
	 */
	public boolean remove(T value) {
		if (value == null)
			return false;
		if (head == null) // if there is no list
			return false;

	}

	/**
	 * Removes all elements from the list.
	 */
	public void clear() {
		// Implement me!
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements.
	 */
	public int size() {
		// Implement me!
	}

	/**
	 * Returns the value at the given index in the list.
	 * 
	 * @param index
	 *            the index of the element whose value to return.
	 * @return the value at the given index, or {@code null} if the index is
	 *         invalid.
	 */
	public T get(int index) {
		// Implement me!
	}

	/**
	 * Sets the value at the given index.
	 * 
	 * @param index
	 *            index of the value to reset.
	 * @param value
	 *            the new value. If this is {@code null}, nothing happens.
	 * @return the old value at the index, or {@code null} if the index was
	 *         invalid or the new value is {@code null}.
	 */
	public T set(int index, T value) {
		// Implement me!
	}

	/**
	 * Returns the smallest index where the given value appears in the list, if
	 * it does.
	 * 
	 * @param value
	 *            the value to look for.
	 * @return the value's index or -1 if {@code value == null} or if the value
	 *         is not in the list.
	 */
	public int indexOf(T value) {
		// Implement me!
	}

	/**
	 * Checks if the given value appears anywhere in the list.
	 * 
	 * @param value
	 *            the value to search for.
	 * @return {@code true} if the value appears in the list, {@code false} if
	 *         it doesn't or if it is {@code null}.
	 */
	public boolean contains(T value) {
		// Implement me!
	}

	/**
	 * Checks if the list contains any elements.
	 * 
	 * @return {@code true} if the list is empty, {@code false} if it isn't.
	 */
	public boolean isEmpty() {
		// Implement me!
	}

}
