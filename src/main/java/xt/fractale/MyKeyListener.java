package xt.fractale;

import xt.coloralgo.ColorAlgo;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.graph.Graph;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyKeyListener extends KeyAdapter {

	private Image image;
	private DrawStatus drawStatus;

	public MyKeyListener(Image image) {
		this.image = image;
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
		switch (key) {
			case KeyEvent.VK_ESCAPE : quit(); break;
			case KeyEvent.VK_ENTER  : image.getMathZone().centeredZoomOut(1.0666666666); redraw(); break;
			case KeyEvent.VK_LEFT   : image.getMathZone().shift(-1,  0); redraw(); break;
			case KeyEvent.VK_RIGHT  : image.getMathZone().shift(+1,  0); redraw(); break;
			case KeyEvent.VK_UP     : image.getMathZone().shift( 0, +1); redraw(); break;
			case KeyEvent.VK_DOWN   : image.getMathZone().shift( 0, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD7: image.getMathZone().keep (-1, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD8: image.getMathZone().keep ( 0, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD9: image.getMathZone().keep (+1, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD4: image.getMathZone().keep (-1,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD5: image.getMathZone().keep ( 0,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD6: image.getMathZone().keep (+1,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD1: image.getMathZone().keep (-1, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD2: image.getMathZone().keep ( 0, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD3: image.getMathZone().keep (+1, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD0: image.getMathZone().reinit(); redraw(); break;
			
			case KeyEvent.VK_ADD:
				{
					ColorAlgo colorAlgo = image.getColorAlgo();
					if (colorAlgo instanceof EscapeTimeAlgorithm) {
						EscapeTimeAlgorithm escapeTimeAlgorithm = (EscapeTimeAlgorithm) colorAlgo;
						int iMax = escapeTimeAlgorithm.getiMax();
						if (iMax <= (1 << 13)) {
							iMax *= 2;
							System.out.println("iMax := " + iMax);
							escapeTimeAlgorithm.setiMax(iMax);
							redraw();
						}
					}
				}
				break;
			case KeyEvent.VK_SUBTRACT:
				{
					ColorAlgo colorAlgo = image.getColorAlgo();
					if (colorAlgo instanceof EscapeTimeAlgorithm) {
						EscapeTimeAlgorithm escapeTimeAlgorithm = (EscapeTimeAlgorithm) colorAlgo;
						int iMax = escapeTimeAlgorithm.getiMax();
						if (iMax % 2 == 0) {
							iMax /= 2;
							System.out.println("iMax := " + iMax);
							escapeTimeAlgorithm.setiMax(iMax);
							redraw();
						}
					}
				}
				break;

			case KeyEvent.VK_Z:
			{
				ColorAlgo colorAlgo = image.getColorAlgo();
				if (colorAlgo instanceof EscapeTimeAlgorithm) {
					EscapeTimeAlgorithm escapeTimeAlgorithm = (EscapeTimeAlgorithm) colorAlgo;
					boolean smoothMode = escapeTimeAlgorithm.isSmoothMode();
					smoothMode = (! smoothMode);
					System.out.println("smoothMode := " + smoothMode);
					escapeTimeAlgorithm.setSmoothMode(smoothMode);
					redraw();
				}
			}
			break;
			
			case KeyEvent.VK_S:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String outFileName = "G:\\Fractales\\" + sdf.format(new Date()) + ".png";
				Graph.save(outFileName);
				InteractiveMain.saveParameters(outFileName, image);
				break;

			case KeyEvent.VK_G:
				if (InteractiveMain.granularite_de_depart == InteractiveMain.GRANULARITE_LA_PLUS_FINE) {
					InteractiveMain.granularite_de_depart = InteractiveMain.GRANULARITE_LA_PLUS_GROSSIERE;
				} else {
					InteractiveMain.granularite_de_depart = InteractiveMain.GRANULARITE_LA_PLUS_FINE;
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
