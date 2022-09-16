package xt.fractale;

import xt.coloralgo.ColorAlgo;
import xt.graph.Graph;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyKeyListener extends KeyAdapter {

	private MathZone mathZone;
	private ColorAlgo colorAlgo;
	private DrawStatus drawStatus;

	public MyKeyListener(MathZone mathZone, ColorAlgo colorAlgo) {
		this.mathZone = mathZone;
		this.colorAlgo = colorAlgo;
		this.drawStatus = DrawStatus.DRAW;
	}

	private void quit() {
		this.drawStatus = DrawStatus.QUIT;
	}
	
	private void redraw() {
		this.drawStatus = DrawStatus.REDRAW;
	}

	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();
		/*
		System.out.print("keyPressed");
		System.out.println("[" + key + "]");
		*/

		switch (key) {
			case KeyEvent.VK_ESCAPE : quit(); break;
			case KeyEvent.VK_ENTER  : mathZone.centeredZoomOut(1.0666666666); redraw(); break;
			case KeyEvent.VK_LEFT   : mathZone.shift(-1,  0); redraw(); break;
			case KeyEvent.VK_RIGHT  : mathZone.shift(+1,  0); redraw(); break;
			case KeyEvent.VK_UP     : mathZone.shift( 0, +1); redraw(); break;
			case KeyEvent.VK_DOWN   : mathZone.shift( 0, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD7: mathZone.keep (-1, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD8: mathZone.keep ( 0, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD9: mathZone.keep (+1, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD4: mathZone.keep (-1,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD5: mathZone.keep ( 0,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD6: mathZone.keep (+1,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD1: mathZone.keep (-1, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD2: mathZone.keep ( 0, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD3: mathZone.keep (+1, -1); redraw(); break;

			case KeyEvent.VK_COLON:
				/*
				Drawer.zone.vZoom();
				*/
				redraw();
				break;

			case KeyEvent.VK_NUMPAD0:
				mathZone.reinit();
				redraw();
				break;

			case KeyEvent.VK_S:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String outFileName = "G:\\Fractales\\" + sdf.format(new Date()) + ".png";
				Graph.save(outFileName);
				Drawer.saveParameters(outFileName, colorAlgo, mathZone);
				break;

			case KeyEvent.VK_G:
				if (Drawer.granularite_de_depart == Drawer.GRANULARITE_LA_PLUS_FINE) {
					Drawer.granularite_de_depart = Drawer.GRANULARITE_LA_PLUS_GROSSIERE;
				} else {
					Drawer.granularite_de_depart = Drawer.GRANULARITE_LA_PLUS_FINE;
				}
				redraw();
				break;
			/*
			case KeyEvent.VK_J:
				switch (Drawer.drawingMode) {
					case FUNCTION:
						break;
					case FRACTAL: {
						Drawer.saveZone = Drawer.zone;
						//FIXME
						//fractalColorAlgo.setJuliaX((Drawer.zone.getxMin() + Drawer.zone.getxMax()) / 2);
						//fractalColorAlgo.setJuliaY((Drawer.zone.getyMin() + Drawer.zone.getyMax()) / 2);
						//Drawer.zone = new MathZone(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX);
						//
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
			*/
			default:
				System.out.print("keyPressed");
				System.out.println("[" + key + "]");
				break;
		}
	}

	public DrawStatus getDrawStatus() {
		return drawStatus;
	}

	public void setDrawStatus(DrawStatus drawStatus) {
		this.drawStatus = drawStatus;
	}
}
