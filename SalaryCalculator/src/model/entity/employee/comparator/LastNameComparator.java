package model.entity.employee.comparator;

import java.util.Comparator;

public class LastNameComparator implements Comparator<String> {

	@Override
	public int compare(String lastName1, String lastName2) {
		return lastName1.compareTo(lastName2);
	}

}
