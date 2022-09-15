package xt.fractale;

import xt.coloralgo.ColorAlgo;
import xt.graph.Graph;
import xt.math.Complex;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

class MyKeyListener extends KeyAdapter {

	private Function<Complex, Complex> function;
	private ColorAlgo colorAlgo;

	public MyKeyListener(Function<Complex, Complex> function, ColorAlgo colorAlgo) {
		this.function = function;
		this.colorAlgo = colorAlgo;
	}

	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		/*
		System.out.print("keyPressed");
		System.out.println("[" + key + "]");
		*/

		switch (key) {
			case KeyEvent.VK_ESCAPE:
				Drawer.status = Drawer.STATUS_QUIT;
				break;

			case KeyEvent.VK_ENTER:
				Drawer.zone.centeredZoomOut(1.0666666666);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_LEFT:
				Drawer.zone.shift(-1, 0);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_RIGHT:
				Drawer.zone.shift(+1, 0);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_UP:
				Drawer.zone.shift(0, +1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_DOWN:
				Drawer.zone.shift(0, -1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_NUMPAD7:
				/*
				Drawer.zone.keep(-1, +1);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD8:
				/*
				Drawer.zone.keep(0, +1);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD9:
				/*
				Drawer.zone.keep(+1, +1);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD4:
				/*
				Drawer.zone.keep(-1, 0);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD5:
				/*
				Drawer.zone.keep(0, 0);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD6:
				/*
				Drawer.zone.keep(+1, 0);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD1:
				/*
				Drawer.zone.keep(-1, -1);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD2:
				/*
				Drawer.zone.keep(0, -1);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD3:
				/*
				Drawer.zone.keep(+1, -1);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_COLON:
				System.out.println("gotcha");
				/*
				Drawer.zone.vZoom();
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_NUMPAD0:
				Drawer.zone = new MathZone(new Complex(0.0, 0.0), 3.0, 2.0, 0.0);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_S:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String outFileName = "G:\\Fractales\\" + sdf.format(new Date()) + ".png";
				Graph.save(outFileName);
				Drawer.saveParameters(outFileName, function, colorAlgo);
				break;

			case KeyEvent.VK_G:
				if (Drawer.granularite_de_depart == Drawer.GRANULARITE_LA_PLUS_FINE) {
					Drawer.granularite_de_depart = Drawer.GRANULARITE_LA_PLUS_GROSSIERE;
				} else {
					Drawer.granularite_de_depart = Drawer.GRANULARITE_LA_PLUS_FINE;
				}
				Drawer.status = Drawer.STATUS_REDRAW;

				break;
			case KeyEvent.VK_J:
				switch (Drawer.drawingMode) {
					case FUNCTION:
						break;
					case FRACTAL: {
						Drawer.saveZone = Drawer.zone;
						/*FIXME
						fractalColorAlgo.setJuliaX((Drawer.zone.getxMin() + Drawer.zone.getxMax()) / 2);
						fractalColorAlgo.setJuliaY((Drawer.zone.getyMin() + Drawer.zone.getyMax()) / 2);
						Drawer.zone = new MathZone(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX);
						*/
						Drawer.drawingMode = Drawer.DrawingMode.FRACTAL_JULIA;
						Drawer.status = Drawer.STATUS_REDRAW;
						colorAlgo.processKeyEvent(key);
					}
					break;
					case FRACTAL_JULIA: {
						Drawer.zone = Drawer.saveZone;
						Drawer.drawingMode = Drawer.DrawingMode.FRACTAL;
						Drawer.status = Drawer.STATUS_REDRAW;
						colorAlgo.processKeyEvent(key);
					}
					break;
				}
				break;
			default:
				System.out.print("keyPressed");
				System.out.println("[" + key + "]");
				colorAlgo.processKeyEvent(key);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
		}
	}
}
