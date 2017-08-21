import java.time.LocalDate;

import entity.Driver;
import entity.DriverLicense;
import entity.Human;
import entity.HumanBuilder;
import entity.Human.BloodGroup;
import entity.Human.Gender;
import service.DriverHire;

public class Main {
	public static void main(String[] args) {
		Human human = new HumanBuilder().setName("Ivanov").setGender(Gender.MALE).setBloodGroup(BloodGroup.SECOND)
				.setWorkPlace("").setBirthDay(LocalDate.of(1995, 11, 14)).buildHuman();

		DriverHire driverHire = new DriverHire(human.getName(), human.getWorkPlace(), "Nova poshta");

		driverHire.getExpectedCategories().add(DriverLicense.Category.A);
		driverHire.getExpectedCategories().add(DriverLicense.Category.B);

		Driver driver = driverHire.offerCandidate(human);
		System.out.println(driver);
	}
}
