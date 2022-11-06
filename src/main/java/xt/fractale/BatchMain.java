package xt.fractale;

public class BatchMain {
	
	private static final int NUMERO_IMAGE = 0;
	private static final int DIMENSION_X = 7200;
	private static final int DIMENSION_Y = 4800;
	
	private static String PATH = System.getenv("FRACTALE_HOME");

	public static void main(String[] args) {
		Image image = PredefinedImages.get(NUMERO_IMAGE);
		String filename = String.format("%simage_%03d.png", PATH, NUMERO_IMAGE);
		new ImageFile(image, filename, DIMENSION_X, DIMENSION_Y).create();
	}
}
