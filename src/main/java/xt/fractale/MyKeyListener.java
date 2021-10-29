package xt.fractale;

import xt.coloralgo.ColorAlgo;
import xt.coloralgo.FractalColorAlgo;
import xt.function.Function;
import xt.graph.Graph;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyKeyListener extends KeyAdapter {

	private Function function;
	private ColorAlgo colorAlgo;

	public MyKeyListener(Function function, ColorAlgo colorAlgo) {
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
				Drawer.zone.keep(-1, +1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD8:
				Drawer.zone.keep(0, +1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD9:
				Drawer.zone.keep(+1, +1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD4:
				Drawer.zone.keep(-1, 0);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD5:
				Drawer.zone.keep(0, 0);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD6:
				Drawer.zone.keep(+1, 0);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD1:
				Drawer.zone.keep(-1, -1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD2:
				Drawer.zone.keep(0, -1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
			case KeyEvent.VK_NUMPAD3:
				Drawer.zone.keep(+1, -1);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_COLON:
				System.out.println("gotcha");
				Drawer.zone.vZoom();
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_NUMPAD0:
				Drawer.zone = new RectangularZone(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_S:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String outFileName = "C:\\Users\\Luc\\Desktop\\" + sdf.format(new Date()) + ".png";
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
						FractalColorAlgo fractalColorAlgo = (FractalColorAlgo) colorAlgo;
						fractalColorAlgo.setJuliaX((Drawer.zone.getxMin() + Drawer.zone.getxMax()) / 2);
						fractalColorAlgo.setJuliaY((Drawer.zone.getyMin() + Drawer.zone.getyMax()) / 2);
						Drawer.zone = new RectangularZone(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX);
						Drawer.drawingMode = Drawer.DrawingMode.FRACTAL_JULIA;
						Drawer.status = Drawer.STATUS_REDRAW;
						fractalColorAlgo.processKeyEvent(key);
					}
					break;
					case FRACTAL_JULIA: {
						Drawer.zone = Drawer.saveZone;
						FractalColorAlgo fractalColorAlgo = (FractalColorAlgo) colorAlgo;
						Drawer.drawingMode = Drawer.DrawingMode.FRACTAL;
						Drawer.status = Drawer.STATUS_REDRAW;
						fractalColorAlgo.processKeyEvent(key);
					}
					break;
				}
				break;
			default:
				colorAlgo.processKeyEvent(key);
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
		}
	}
}
