
public class SVGAAdapter {
	public static void main(String[] args) {
		DVIAdapterFromSVGA dviAdapterFromSVGA = new DVIAdapterFromSVGA();
		dviAdapterFromSVGA.connect();
	}
}

interface SVGAInterface {
	void connect();
}

class SVGA {

	public void svgaConnect() {
		System.out.println("The cable was connected");
	}
}

class DVIAdapterFromSVGA extends SVGA implements SVGAInterface {

	@Override
	public void connect() {
		svgaConnect();
	}

}