package list;

public class List {
	private Node first;

	public Node get(int index) {
		if (index == 0) {
			return first;
		} else {
			if (index > size()) {
				throw new RuntimeException("Out of list bound exception");
			} else {
				Node current = first;
				int increment = 0;
				while (increment != index) {
					current = current.getNext();
					increment++;
				}
				return current;
			}
		}
	}

	public boolean put(int index, Node node) {
		if (first == null) {
			first = node;
		} else {
			if (index > size()) {
				throw new RuntimeException("Out of list bound exception");
			} else {
				Node current = first;
				int increment = 0;
				while (increment != index) {
					current = current.getNext();
					increment++;
				}
				node.setNext(current.getNext());
				current.setNext(node);
			}
		}
		return true;
	}

	public boolean delete(int index) {
		if (index == 0) {
			first = first.getNext();
		} else {
			if (index > size()) {
				throw new RuntimeException("Out of list bound exception");
			} else {
				Node current = first;
				Node previous = null;
				int increment = 0;
				
				while (increment != index) {
					previous = current;
					current = current.getNext();
					increment++;
				}
				previous.setNext(current.getNext());
				current = null;
			}
		}
		return true;
	}

	public int size() {
		Node current = first;
		int increment = 0;
		while (current.getNext() != null) {
			current = current.getNext();
			increment++;
		}
		return increment;
	}
}
