
public final class Ellipse extends Point{
	private int majorAxesLength;
	private int minorAxesLength;

	public Ellipse(int x, int y, int majorAxesLength, int minorAxesLength) {
		super(x, y);
		this.majorAxesLength = majorAxesLength;
		this.minorAxesLength = minorAxesLength;
	}

	public int getMajorAxesLength() {
		return majorAxesLength;
	}

	public void setMajorAxesLength(int majorAxesLength) {
		this.majorAxesLength = majorAxesLength;
	}

	public int getMinorAxesLength() {
		return minorAxesLength;
	}

	public void setMinorAxesLength(int minorAxesLength) {
		this.minorAxesLength = minorAxesLength;
	}
	
	public void sum(int x, int y) {
		System.out.println(x + " " + y);
	}
	
	@Method
	@Override
	public String toString() {
		return "Ellipse [majorAxesLength = " + majorAxesLength + ", minorAxesLength = " + minorAxesLength + ", x ="
				+ getX() + ", y = " + getY() + "]";
	}
	
	
	
	

}
