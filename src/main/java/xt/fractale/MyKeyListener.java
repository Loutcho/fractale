package xt.fractale;

import xt.coloralgo.ColorAlgo;
import xt.coloralgo.EscapeTimeAlgorithm;
import xt.graph.Graph;
import xt.math.Complex;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyKeyListener extends KeyAdapter {

	private static final double D_THETA = Math.PI / 32.0;
	
	private Image image;
	private String directory;
	private DrawStatus drawStatus;
	private MathZone savedMandelbrotMathZone;

	public MyKeyListener(Image image, String directory) {
		this.image = image;
		this.directory = directory;
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
		ColorAlgo colorAlgo = image.getColorAlgo();

		switch (key) {
			case KeyEvent.VK_ESCAPE  : quit(); break;
			case KeyEvent.VK_NUMPAD0 : image.getMathZone().reinit(); redraw(); break;
			case KeyEvent.VK_ENTER   : image.getMathZone().centeredZoomOut(1.066666666666666666); redraw(); break;
			case KeyEvent.VK_DECIMAL : image.getMathZone().centeredZoomOut(0.967500000000000000); redraw(); break;
			case KeyEvent.VK_LEFT    : image.getMathZone().shift(-1,  0); redraw(); break;
			case KeyEvent.VK_RIGHT   : image.getMathZone().shift(+1,  0); redraw(); break;
			case KeyEvent.VK_UP      : image.getMathZone().shift( 0, +1); redraw(); break;
			case KeyEvent.VK_DOWN    : image.getMathZone().shift( 0, -1); redraw(); break;
			case KeyEvent.VK_MULTIPLY: image.getMathZone().rotate(+D_THETA); redraw(); break;
			case KeyEvent.VK_DIVIDE  : image.getMathZone().rotate(-D_THETA); redraw(); break;
			case KeyEvent.VK_NUMPAD7 : image.getMathZone().keep (-1, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD8 : image.getMathZone().keep ( 0, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD9 : image.getMathZone().keep (+1, +1); redraw(); break;
			case KeyEvent.VK_NUMPAD4 : image.getMathZone().keep (-1,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD5 : image.getMathZone().keep ( 0,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD6 : image.getMathZone().keep (+1,  0); redraw(); break;
			case KeyEvent.VK_NUMPAD1 : image.getMathZone().keep (-1, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD2 : image.getMathZone().keep ( 0, -1); redraw(); break;
			case KeyEvent.VK_NUMPAD3 : image.getMathZone().keep (+1, -1); redraw(); break;
			
			/*
			case KeyEvent.VK_ADD:
				{
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
			*/

			/*
			case KeyEvent.VK_Z:
			{
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
			*/

			case KeyEvent.VK_S:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String outFileName = directory + sdf.format(new Date()) + ".png";
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
			
			case KeyEvent.VK_J:
			{
				MathZone mathZone = image.getMathZone();
				Complex zCenter = mathZone.getzCenter();
				if (colorAlgo instanceof EscapeTimeAlgorithm) {
					EscapeTimeAlgorithm escapeTimeAlgorithm = (EscapeTimeAlgorithm) colorAlgo;
					Complex zJulia = escapeTimeAlgorithm.getzJulia();
					if (zJulia == null) {
						this.savedMandelbrotMathZone = mathZone;
						MathZone juliaMathZone = new MathZone(new Complex(0.0, 0.0), 1.5, 1.0, 0.0);
						image.setMathZone(juliaMathZone);
						escapeTimeAlgorithm.setzJulia(zCenter);
					} else {
						MathZone mandelbrotMathZone = (savedMandelbrotMathZone != null) ? savedMandelbrotMathZone : new MathZone(zJulia, 1.5, 1.0, 0.0); 
						image.setMathZone(mandelbrotMathZone);
						escapeTimeAlgorithm.setzJulia(null);
					}
					redraw();
				}
			}
			break;
			
			case KeyEvent.VK_F1: image.multiplyPeriod(0.50000000000000000000000000000000000000); redraw(); break;
			case KeyEvent.VK_F2: image.multiplyPeriod(0.96593632892484555106514431292046389939); redraw(); break;
			case KeyEvent.VK_F3: image.multiplyPeriod(1.03526492384137750434778819421124619770); redraw(); break;
			case KeyEvent.VK_F4: image.multiplyPeriod(2.00000000000000000000000000000000000000); redraw(); break;
			
			case KeyEvent.VK_F5: image.incrementPhase(-0.2500000000000000000000000000000000000); redraw(); break;
			case KeyEvent.VK_F6: image.incrementPhase(-0.0333333333333333333333333333333333333); redraw(); break;
			case KeyEvent.VK_F7: image.incrementPhase(+0.0333333333333333333333333333333333333); redraw(); break;
			case KeyEvent.VK_F8: image.incrementPhase(+0.2500000000000000000000000000000000000); redraw(); break;
			
			case KeyEvent.VK_F9: image.multiplyThreshold(0.50000000000000000000000000000000000000); redraw(); break;
			case KeyEvent.VK_F10: image.multiplyThreshold(1.0 / 1.01); redraw(); break;
			case KeyEvent.VK_F11: image.multiplyThreshold(1.01); redraw(); break;
			case KeyEvent.VK_F12: image.multiplyThreshold(2.00000000000000000000000000000000000000); redraw(); break;

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
