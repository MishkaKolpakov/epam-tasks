
public class PenWriter {
	public static void main(String[] args) {
		HumanTemplate human = new HumanTemplate("Mykhailo", 21);
		Pen pen = new Pen(PenColor.BRUE, "Airpen");
		Paper paper = new Paper(PaperFormat.A4);

		Pen redPen = new Pen(PenColor.RED, "Chineese Pen");
		Paper a5Paper = new Paper(PaperFormat.A5);
		HumanTemplate humanMale = new HumanTemplate("Kostya", 22);

		Writer writer = new Writer(human, pen, paper);

		writer.write();

		writer = new Writer(humanMale, redPen, a5Paper);

		writer.write();
	}
}

class HumanTemplate {
	private String firstName;
	private int age;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	HumanTemplate(String firstName, int age) {
		this.firstName = firstName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [firstName=" + firstName + ", age=" + age + "]";
	}
}

interface WriterIF {
	void write();
}

class Writer implements WriterIF {

	HumanTemplate human;
	Pen pen;
	Paper paper;

	public Writer(HumanTemplate human, Pen pen, Paper paper) {
		this.human = human;
		this.pen = pen;
		this.paper = paper;
	}

	@Override
	public void write() {
		System.out.println(human + " " + pen + " " + paper);
	}

}

class Pen {
	private PenColor color;
	private String make;

	public Pen(PenColor color, String make) {
		this.color = color;
		this.make = make;
	}

	public PenColor getColor() {
		return color;
	}

	public void setColor(PenColor color) {
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Override
	public String toString() {
		return "Pen [color=" + color + ", make=" + make + "]";
	}

}

class Paper {
	private PaperFormat paperFormat;

	public Paper(PaperFormat paperFormat) {
		this.paperFormat = paperFormat;
	}

	public PaperFormat getPaperFormat() {
		return paperFormat;
	}

	public void setPaperFormat(PaperFormat paperFormat) {
		this.paperFormat = paperFormat;
	}

	@Override
	public String toString() {
		return "Paper [paperFormat=" + paperFormat + "]";
	}

}

enum PaperFormat {
	A5, A4, A3, A2;
}

enum PenColor {
	RED, BRUE;
}
