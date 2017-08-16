import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class Main {
	public static void main(String[] args) {

		Ellipse ellipse = new Ellipse(20, 30, 100, 200);

		Class class1 = Point.class.getClass();
		Class class2 = ellipse.getClass();

		int modifiersClass1 = class1.getModifiers();
		int modifiersClass2 = class1.getModifiers();

		System.out.println("First class name = " + class1);
		System.out.println(class1 + " modifiers: ");
		if (Modifier.isPublic(modifiersClass1)) {
			System.out.println("public");
		}
		if (Modifier.isAbstract(modifiersClass1)) {
			System.out.println("abstract");
		}
		if (Modifier.isFinal(modifiersClass1)) {
			System.out.println("final");
		}

		Constructor[] constructorsFirst = class1.getConstructors();
		for (Constructor constructor : constructorsFirst) {
			System.out.println(constructor);
			Parameter[] parameters = constructor.getParameters();
			for (Parameter parameter : parameters) {
				System.out.println(parameter);
			}
		}
		System.out.println("=========================================");
		System.out.println("Second class name = " + class2);
		System.out.println(class2 + " modifiers: ");
		if (Modifier.isPublic(modifiersClass2)) {
			System.out.println("public");
		}
		if (Modifier.isFinal(modifiersClass2)) {
			System.out.println("final");
		}

		System.out.println("=========================================");
		Constructor[] constructorsSecond = class2.getConstructors();
		for (Constructor constructor : constructorsSecond) {
			System.out.println(constructor);
			Parameter[] parameters = constructor.getParameters();
			for (Parameter parameter : parameters) {
				System.out.println(parameter);
			}
		}
		System.out.println("=========================================");

	}
}
