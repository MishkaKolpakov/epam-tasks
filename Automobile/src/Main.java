import entities.car.CarBuilder;
import entities.car.DriverLicense;
import java.time.LocalDate;
import entities.car.Car;
import entities.car.Car.MarkType;
import entities.car.DriverLicense.Category;
import entities.details.Chassis;
import entities.details.Motor;
import entities.human.Human;
import entities.human.HumanBuilder;
import entities.human.Human.BloodGroup;
import entities.human.Human.Gender;
import roles.driver.Drive;
import roles.driver.DriverBuilder;

public class Main {
	public static void main(String[] args) {
		Car car = new CarBuilder().addCategory(Category.B).addChassis(new Chassis("iron")).addMotor(new Motor("v8"))
				.addMarkType(MarkType.Mazda).build();
		
		DriverLicense driverLicense = new DriverLicense(DriverLicense.Category.B, LocalDate.of(2015, 01, 01),
				LocalDate.of(2020, 01, 01));

		Human human = new HumanBuilder()
				.setBirthDay(LocalDate.of(1995, 11, 14))
				.setBloodGroup(BloodGroup.SECOND)
				.setGender(Gender.MALE).setName("Mykhailo")
				.buildHuman();

		Drive drive = new DriverBuilder().addDriverCategory(driverLicense).addHuman(human).buildDriver();
		drive.drive(car);
	}
}
