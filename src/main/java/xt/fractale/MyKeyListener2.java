package xt.fractale;

import xt.graph.Graph;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

class MyKeyListener2 extends KeyAdapter {

	public MyKeyListener2() {
	}

	public void keyPressed(KeyEvent event) {
		int key = event.getKeyCode();

		switch (key) {
			case KeyEvent.VK_ESCAPE:
				System.out.print("keyPressed");
				System.out.println("[" + key + "]");
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
				/*
				Drawer.zone = new MathZone(Drawer.DEFAULT_X_MIN, Drawer.DEFAULT_X_MAX, Drawer.DEFAULT_Y_MIN, Drawer.DEFAULT_Y_MAX);
				*/
				Drawer.status = Drawer.STATUS_REDRAW;
				break;

			case KeyEvent.VK_S:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String outFileName = "G:\\Fractales\\" + sdf.format(new Date()) + ".png";
				Graph.save(outFileName);
				break;

			default:
				System.out.print("keyPressed");
				System.out.println("[" + key + "]");
				Drawer.status = Drawer.STATUS_REDRAW;
				break;
		}
	}
}
