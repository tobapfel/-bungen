package programming.set10.links;

public class LinkedElement<T> {
	private LinkedElement<T> link;
	private T value;

	public LinkedElement(T value) {
		this.value = value;
	}

	/**
	 * Returns the value of the i-th linked element.
	 * 
	 * @param i
	 *            0-based index of the element whose value to return.
	 * @return the i-th element's value, or {@code null} if there is no element
	 *         with that index.
	 */
	public T get(int i) {
		return get(i, 0);
	}

	/**
	 * Returns the value of the i-th linked element.
	 * 
	 * @param i
	 *            0-based index of the element whose value to return.
	 * @param n
	 *            counter whose initial value is 0
	 * @return the i-th element's value, or {@code null} if there is no element
	 *         with that index.
	 */
	private T get(int i, int n) {
		if (this.link == null) // if there is no next element
			return null;
		else if (i == n) { // the object at the given index
			return this.value;
		} else
			return this.link.get(i, n + 1); // method call itself and increase
											// the counter

	}

	/**
	 * Sets the value of the i-th linked element to the given value. If there is
	 * no i-th linked element, nothing happens.
	 * 
	 * @param i
	 *            0-based index of the element whose value to return.
	 * @param newVal
	 *            the new value to set.
	 */
	public void set(int i, T newVal) {
		set(i, 0, newVal);
	}

	/**
	 * Sets the value of the i-th linked element to the given value. If there is
	 * no i-th linked element, nothing happens.
	 * 
	 * @param i
	 *            0-based index of the element whose value to return.
	 * @param n
	 *            counter whose initial value is 0.
	 * @param newVal
	 *            the new value to set.
	 */
	private void set(int i, int n, T newVal) {
		if (i == n) { // sets the i-th element
			this.value = newVal;
		} else if (this.link == null) { // if there is no new element
			return;
		} else
			this.link.set(i, n + 1, newVal); // method calls itself and increase
												// counter

	}

	/**
	 * Returns the index of the first occurrence of a linked element carrying
	 * the given value in the list.
	 * 
	 * @param val
	 *            the value to search for.
	 * @return index where the value was found, or -1 if it's not in any of the
	 *         linked elements.
	 */
	public int firstIndexOf(T val) {
		return firstIndexOf(val, 0);
	}

	/**
	 * Returns the index of the first occurrence of a linked element carrying
	 * the given value in the list.
	 * 
	 * @param val
	 *            the value to search for.
	 * @param index
	 *            counter whose initial value is 0.
	 * @return index where the value was found, or -1 if it's not in any of the
	 *         linked elements.
	 */
	private int firstIndexOf(T newVal, int index) {
		if (newVal == this.value) // if we found our element
			return index;
		else if (this.link == null) // if there is no other element
			return -1;
		else
			return this.link.firstIndexOf(newVal, index + 1); // method calls
																// himself and
																// increase the
																// counter
	}

	/**
	 * Adds a new linked element holding the given value at the end of the
	 * linked elements.
	 * 
	 * @param newVal
	 *            the new value.
	 */
	public void add(T newVal) {
		if (this.link == null) {// if there is no next element
			LinkedElement<T> le = new LinkedElement<>(newVal); // create new
																// linked
																// element
			this.link = le; // link the new linked element
		} else
			this.link.add(newVal); // method calls himself
	}

	/**
	 * Removes the i-th element from the linked elements. If {@code i == 0},
	 * this will effectively remove the head element. Thus, this method returns
	 * the linked element that is the new head element.
	 * 
	 * @param i
	 *            index of the element to remove.
	 * @return the new head element.
	 */
	public LinkedElement<T> remove(int i) {
		if (i == 0)
			return this.link;
		remove(i, 0);
		return this;

	}

	/**
	 * Removes the i-th element from the linked elements. If {@code i == 0},
	 * this will effectively remove the head element. Thus, this method returns
	 * the linked element that is the new head element.
	 * 
	 * @param i
	 *            index of the element to remove.
	 * @param n
	 *            counter whose initial value is 0.
	 * @return the new head element.
	 */
	private void remove(int i, int n) {
		if (i - 1 == n) {
			this.link = this.link.link; // link the element with the after next
		} else if (this.link == null) { // there is no next element
			return;
		} else
			this.link.remove(i, n + 1); // method calls itself and increase
										// counter
	}

}
