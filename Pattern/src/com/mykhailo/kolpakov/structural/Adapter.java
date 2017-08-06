package com.mykhailo.kolpakov.structural;

public class Adapter {
	public static void main(String[] args) {
		// 1-method inheritance
		VectorGraphics g1 = new VectorAdapterFromRaster();
		g1.drawLine();
		
		// 2-method composite
		VectorGraphics g2 = new VectorAdapterFromRaster2();
		g2.drawSquare();
	}
}

interface VectorGraphics {
	void drawLine();

	void drawSquare();
}

class RasterGraphics {
	void drawRasterLine() {
		System.out.println("Draw line!");
	}

	void drawRasterSquare() {
		System.out.println("Draw square");
	}
}

class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphics {

	@Override
	public void drawLine() {
		drawRasterLine();

	}

	@Override
	public void drawSquare() {
		drawRasterSquare();
	}
}

class VectorAdapterFromRaster2 implements VectorGraphics {
	RasterGraphics raster = new RasterGraphics();

	@Override
	public void drawLine() {
		raster.drawRasterLine();
	}

	@Override
	public void drawSquare() {
		raster.drawRasterSquare();
	}

}
