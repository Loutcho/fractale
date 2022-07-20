package xt.fractale;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import xt.math.Circle;
import xt.math.Complex;
import xt.math.Moebius;

public class IndraFile {

	private MathZone mathZone;
	private String filename;
	private int width;
	private int height;
	
	public IndraFile(MathZone mathZone, String filename, int width, int height) {
		this.mathZone = mathZone;
		this.filename = filename;
		this.width = width;
		this.height = height;		
	}
	
	public void create() {
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		CoordinatesConverter cc = new CoordinatesConverter(mathZone, new PixelZone(width, height));

		Graphics2D g = (Graphics2D) img.getGraphics();
	
		breadthFirstSearch(cc, g);

		File file = new File(filename);
		try {
			ImageIO.write(img, "PNG", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void drawMathCircle(CoordinatesConverter cc, Graphics2D g, Circle mathCircle, int i, int j) {
		// centre ==> centre'
		// centre + r ==> centre' + z                 such that      |z| = r'
		
		
		Complex mathCenter = mathCircle.getCenter();
		double mathRadius = mathCircle.getRadius();
		Complex pixelCenter = cc.fromMathToPixel(mathCenter);
		double pixelRadius = Complex.sub(cc.fromMathToPixel(Complex.add(mathCenter, new Complex(mathRadius, 0.0))), pixelCenter).abs();
		Circle pixelCircle = new Circle(pixelCenter, pixelRadius);
		drawPixelCircle(g, pixelCircle, i, j);
	}
	
	private void drawPixelCircle(Graphics2D g, Circle c, int i, int j) {
		Complex center = c.getCenter();
		double x = center.re();
		double y = center.im();
		double r = c.getRadius();
		g.setColor(new Color((j & 0x01) << 7, (j & 0x02) << 6, (j & 0x04) << 5));
		g.fillOval((int)(x - r), (int)(y - r), (int)(2 * r), (int)(2 * r));
		g.setColor(Color.WHITE);
		g.drawOval((int)(x - r), (int)(y - r), (int)(2 * r), (int)(2 * r));
	}
	
	private void breadthFirstSearch(CoordinatesConverter cc, Graphics2D g) {
		// Indra's pearls, page 115
		Map<Integer, Moebius> gens = new TreeMap<>();
		Map<Integer, Moebius> group = new TreeMap<>();
		Map<Integer, Circle> circ = new TreeMap<>();
		int lev, levmax = 5;
		Map<Integer, Integer> inv = new TreeMap<>();
		Map<Integer, Integer> num = new TreeMap<>();
		Map<Integer, Integer> tag = new TreeMap<>();

		// a :=   1 (1-i)
		//        0   1

		// A :=   1   0
		//      (i-1) 1
		Moebius a = new Moebius(new Complex(1.0, 0.0), new Complex(1.0, -1.0), new Complex(0.0, 0.0), new Complex(1.0, 0.0));
		Moebius A = new Moebius(new Complex(1.0, 0.0), new Complex(0.0, 0.0), new Complex(-1.0, 1.0), new Complex(1.0, 0.0));
		
		Moebius b = new Moebius(new Complex(0.0, 1.0), new Complex(0.0, 0.0), new Complex(0.0, 0.0), new Complex(0.0, -1.0));
		Moebius B = new Moebius(new Complex(0.0, -1.0), new Complex(0.0, 0.0), new Complex(0.0, 0.0), new Complex(0.0, 1.0));
		
		gens.put(1, a);
		gens.put(2, b);
		gens.put(3, A);
		gens.put(4, B);
		
		Circle ca = new Circle(new Complex(-1.0, +1.0), 0.8);
		Circle cb = new Circle(new Complex(-1.0, -1.0), 0.8);
		circ.put(1, ca);
		circ.put(2, cb);
		
		System.out.println(b.onCircle(cb));
		
		circ.put(3, new Circle(new Complex(+1.0, +1.0), 0.8));
		circ.put(4, new Circle(new Complex(+1.0, -1.0), 0.8));
		
		inv.put(1,  3);
		inv.put(3,  1);
		inv.put(2,  4);
		inv.put(4,  2);
		
		for (int i = 1; i <= 4; i ++) {
			group.put(i, gens.get(i));
			tag.put(i, i);
			Circle mathCircle = circ.get(i);
			drawMathCircle(cc, g, mathCircle, 1, i);
		}
		
		num.put(1, 1);
		num.put(2, 5);
		
		for (lev = 2; lev < levmax; lev ++) {
			int inew = num.get(lev);
			for (int iold = num.get(lev - 1); iold <= num.get(lev) - 1; iold ++) {
				for (int j = 1; j <= 4; j ++) {
					if (j == inv.get(tag.get(iold))) {
						continue;
					}
					group.put(inew, Moebius.mul(group.get(iold), gens.get(j)));
					tag.put(inew, j);
					inew = inew + 1;
				}
			}
			num.put(lev + 1, inew);
		}
		
		for (int i = 1; i <= num.get(levmax) - 1; i ++) {
			for (int j = 1; j <= 4; j ++) {
				if (j == inv.get(tag.get(i))) {
					continue;
				}
				Circle newcirc = group.get(i).onCircle(circ.get(j));
				System.out.println(String.format("i=%d, j=%d, %s", i, j, newcirc.toString()));
				drawMathCircle(cc, g, newcirc, i, j);
			}
		}
	}
}
