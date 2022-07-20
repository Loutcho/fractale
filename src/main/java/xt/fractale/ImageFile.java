package xt.fractale;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import xt.coloralgo.ColorAlgo;
import xt.math.Complex;

public class ImageFile {
	
	private ColorAlgo colorAlgo;
	private MathZone mathZone;
	private String filename;
	private int width;
	private int height;
	
	public ImageFile(ColorAlgo colorAlgo, MathZone mathZone, String filename, int width, int height) {
		this.colorAlgo = colorAlgo;
		this.mathZone = mathZone;
		this.filename = filename;
		this.width = width;
		this.height = height;
	}
	
	public void create() {

		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		CoordinatesConverter cc = new CoordinatesConverter(mathZone, new PixelZone(width, height));

		for (int xxx = 0; xxx < width; xxx ++) {
			System.out.println("|" + xxx);
			for (int yyy = 0; yyy < height; yyy ++) {
				Complex zzz = new Complex(xxx, yyy);
				Complex z = cc.fromPixelToMath(zzz);
				Color color = colorAlgo.getColor(z);
				int r = color.getRed();
				int g = color.getGreen();
				int b = color.getBlue();
				int rgb = (r << 16) | (g << 8) | b;
				img.setRGB(xxx, yyy, rgb);
			}
		}
		
		File file = new File(filename);
		try {
			ImageIO.write(img, "PNG", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
