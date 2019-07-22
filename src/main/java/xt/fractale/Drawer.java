package xt.fractale;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import xt.coloralgo.FractalColorAlgo;
import xt.coloralgo.FunctionColorAlgo;
import xt.coloralgo.EscapeTime;
import xt.function.ZPower;
import xt.math.Complex;
import xt.function.BurningShip;
import xt.function.Function;
import xt.graph.Graph;
import xt.sound.Sound;

public class Drawer extends Graph
{
	static final long		serialVersionUID	= 1234;
	
	static final double     DEFAULT_X_CENTER    =  0.0;
	static final double     DEFAULT_Y_CENTER    =  0.0;
	static final int        RESOLUTION_X = /* 1280 */ /* 1366 */ 1920; /* A adapter */
	static final int        RESOLUTION_Y = /* 1024 */ /* 768 */ 1080; /* A adapter */
	static final int        PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = /* 256 */ /* 2 */ 8; /* A adapter */
	static final int        EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR = /* 8 */ /* 1 */ 3; /* A adapter */
	static final int        MINIMAL_INTEGER_X = RESOLUTION_X / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static final int        MINIMAL_INTEGER_Y = RESOLUTION_Y / PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static final double     DEFAULT_X_LENGTH    =  3.0 * ((double) MINIMAL_INTEGER_X) / ((double) MINIMAL_INTEGER_Y);
	static final double     DEFAULT_Y_LENGTH    =  3.0;

	static final double		DEFAULT_X_MIN		= DEFAULT_X_CENTER - DEFAULT_X_LENGTH / 2.0;
	static final double		DEFAULT_X_MAX		= DEFAULT_X_CENTER + DEFAULT_X_LENGTH / 2.0;
	static final double		DEFAULT_Y_MIN		= DEFAULT_Y_CENTER - DEFAULT_Y_LENGTH / 2.0;
	static final double		DEFAULT_Y_MAX		= DEFAULT_Y_CENTER + DEFAULT_Y_LENGTH / 2.0;

	static double			save_X_MIN			= DEFAULT_X_MIN;
	static double			save_X_MAX			= DEFAULT_X_MAX;
	static double			save_Y_MIN			= DEFAULT_Y_MIN;
	static double			save_Y_MAX			= DEFAULT_Y_MAX;
	
	static final int		STATUS_WAIT			= 0;
	static final int		STATUS_DRAW			= 1;
	static final int		STATUS_REDRAW		= 2;
	static final int		STATUS_QUIT			= 9;
	static int				status				= STATUS_DRAW;
	
	static final int GRANULARITE_LA_PLUS_GROSSIERE = 0;
	static final int GRANULARITE_LA_PLUS_FINE = EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR;
	static int granularite_de_depart = GRANULARITE_LA_PLUS_GROSSIERE;
	
	static RectangularZone zone = null;
	static RectangularZone saveZone = null;
	static Function function = null;
	static FractalColorAlgo fractalColorAlgo = null;
	static FunctionColorAlgo functionColorAlgo = null;
	
	enum DrawingMode {
		FUNCTION,
		FRACTAL,
		FRACTAL_JULIA,
	};
	
	static DrawingMode drawingMode;

	public static void main(String[] args)
	{
		zone = new RectangularZone(DEFAULT_X_MIN, DEFAULT_X_MAX, DEFAULT_Y_MIN, DEFAULT_Y_MAX);

		function = new ZPower(2);
		//function = new BurningShip();
		drawingMode = DrawingMode.FRACTAL;
		fractalColorAlgo = new EscapeTime(function, false, 1.0, 0.5, 100, 100.0, true);

		//function = new Blanche();
		//drawingMode = DrawingMode.FUNCTION;
		//functionColorAlgo = new HueArg(false, false, false);
		//functionColorAlgo = new AbsBlackAndWhite(0.2, true);
		
		Drawer f = new Drawer();
		f.init();
		f.addKeyListener2(f.new MyKeyListener());
		Graphics graphics = f.getGraphics2();
		
		while (status != STATUS_QUIT)
		{
			switch (status)
			{
			case STATUS_DRAW:
				draw(graphics, f.getRectangle());
				if (status == STATUS_DRAW)
				{
					status = STATUS_WAIT;
				}
				break;
			case STATUS_REDRAW:
				status = STATUS_DRAW;
				break;
			case STATUS_WAIT:
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				break;
			}
		}

		f.done();
		System.exit(0);
	}

	public static void draw(Graphics graphics, Rectangle rectangle)
	{
		int ix, iy;
		int granu;
		int cote, nx, ny;
		int x, y;
		
		granu = granularite_de_depart;
		while ((granu <= GRANULARITE_LA_PLUS_FINE) && (status == STATUS_DRAW))
		{
			cote = 1 << (EXPOSANT_PLUS_GRANDE_PUISSANCE_DE_2_COMMUN_DIVISEUR - granu); // cote du carre
			
			nx = MINIMAL_INTEGER_X * (1 << granu); // nombre de carres de cette taille
			ny = MINIMAL_INTEGER_Y * (1 << granu);

			ix = 0;
			while ((ix < nx) && (status == STATUS_DRAW))
			{
				x = ix * cote;
				graphics.setColor(Color.BLACK);
				graphics.fillRect(x, 0, cote, rectangle.height);
				for (iy = 0; iy < ny; iy++)
				{
					y = iy * cote;
					Complex z = new Complex(zone.toX(x, rectangle), zone.toY(y, rectangle));
					Color color = null;
					switch (drawingMode)
					{
					case FRACTAL:
					case FRACTAL_JULIA:
						color = fractalColorAlgo.getColor(z);
						break;
					case FUNCTION:
						z = function.apply(z);
						color = functionColorAlgo.getColor(z);
						break;
					}
					graphics.setColor(color);
					graphics.fillRect(x, y, cote, cote);
				}

				ix++;
			}

			granu++;
		}

		if (status == STATUS_DRAW)
		{
			new Sound().sound("toto.wav");
		}
	}
	

	
	public static void saveParameters(String outFileName)
	{
		BufferedWriter bw = null;

		try
		{
			bw = new BufferedWriter(new FileWriter("C:\\Users\\Luc\\Pictures\\04 - Fractales\\" + "Coords.txt", true));
			bw.write("filename = " + outFileName + ";\n");
			bw.write(function.toString());
			bw.write(fractalColorAlgo != null ? fractalColorAlgo.toString() : "");
			bw.write(functionColorAlgo.toString());
			/*
			bw.write("X_MIN = " + X_MIN + ";\n");
			bw.write("X_MAX = " + X_MAX + ";\n");
			bw.write("Y_MIN = " + Y_MIN + ";\n");
			bw.write("Y_MAX = " + Y_MAX + ";\n");
			bw.write("I_REF = I_MAX = " + I_MAX + ";\n");
			bw.write("juliaMode = " + juliaMode + ";\n");
			if (juliaMode)
			{
				bw.write("JULIA_X = " + JULIA_X + ";\n");
				bw.write("JULIA_Y = " + JULIA_Y + ";\n");
				bw.write("save_X_MIN = " + save_X_MIN + ";\n");
				bw.write("save_X_MAX = " + save_X_MAX + ";\n");
				bw.write("save_Y_MIN = " + save_Y_MIN + ";\n");
				bw.write("save_Y_MAX = " + save_Y_MAX + ";\n");
			}
			int i;
			for (i = 0; i < 3; i ++)
			{
				bw.write("periode[" + i + "] = " + periode[i] + "; ");
				bw.write("kphi[" + i + "] = " + kphi[i] + ";\n");
			}
			bw.write("// ------------------\n");
			*/
			bw.newLine();
			bw.flush();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		finally
		{ // always close the file
			if (bw != null)
				try
				{
					bw.close();
				}
				catch (IOException ioe2)
				{
					// just ignore it
				}
		} // end try/catch/finally
	}
	
	private class MyKeyListener extends KeyAdapter {

		public void keyPressed(KeyEvent event)
		{
			System.out.print("keyPressed");
			int key = event.getKeyCode();
			System.out.println("[" + key + "]");

			switch (key)
			{
			case KeyEvent.VK_ESCAPE:
				status = STATUS_QUIT;
				break;

			case KeyEvent.VK_ENTER:
				zone.centeredZoomOut(1.0666666666);
				status = STATUS_REDRAW;
				break;

			case KeyEvent.VK_LEFT : zone.shift(-1, 0); status = STATUS_REDRAW; break;
			case KeyEvent.VK_RIGHT: zone.shift(+1, 0); status = STATUS_REDRAW; break;
			case KeyEvent.VK_UP   : zone.shift(0, +1); status = STATUS_REDRAW; break;
			case KeyEvent.VK_DOWN : zone.shift(0, -1); status = STATUS_REDRAW; break;

			case KeyEvent.VK_NUMPAD7: zone.keep(-1, +1); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD8: zone.keep( 0, +1); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD9: zone.keep(+1, +1); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD4: zone.keep(-1,  0); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD5: zone.keep( 0,  0); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD6: zone.keep(+1,  0); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD1: zone.keep(-1, -1); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD2: zone.keep( 0, -1); status = STATUS_REDRAW; break;
			case KeyEvent.VK_NUMPAD3: zone.keep(+1, -1); status = STATUS_REDRAW; break;

			case KeyEvent.VK_COLON:
				System.out.println("gotcha");
				zone.vZoom(); status = STATUS_REDRAW; break;

			case KeyEvent.VK_NUMPAD0:
				zone = new RectangularZone(DEFAULT_X_MIN, DEFAULT_X_MAX, DEFAULT_Y_MIN, DEFAULT_Y_MAX);
				status = STATUS_REDRAW;
				break;

			case KeyEvent.VK_S:
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
				String outFileName = "C:\\Users\\Luc\\Desktop\\" + sdf.format(new Date()) + ".png";
				Graph.save(outFileName);
				saveParameters(outFileName);
				break;

			case KeyEvent.VK_G:
				if (granularite_de_depart == GRANULARITE_LA_PLUS_FINE)
				{
					granularite_de_depart = GRANULARITE_LA_PLUS_GROSSIERE;
				}
				else
				{
					granularite_de_depart = GRANULARITE_LA_PLUS_FINE;
				}
				status = STATUS_REDRAW;
				
				break;
			case KeyEvent.VK_J:
				switch (drawingMode)
				{
				case FUNCTION:
					break;
				case FRACTAL:
					saveZone = zone;
					fractalColorAlgo.setJuliaX((zone.getxMin() + zone.getxMax()) / 2);
					fractalColorAlgo.setJuliaY((zone.getyMin() + zone.getyMax()) / 2);
					zone = new RectangularZone(DEFAULT_X_MIN, DEFAULT_X_MAX, DEFAULT_Y_MIN, DEFAULT_Y_MAX);
					drawingMode = DrawingMode.FRACTAL_JULIA;
					status = STATUS_REDRAW;
					fractalColorAlgo.processKeyEvent(key);
					break;
				case FRACTAL_JULIA:
					zone = saveZone;
					drawingMode = DrawingMode.FRACTAL;
					status = STATUS_REDRAW;
					fractalColorAlgo.processKeyEvent(key);
					break;
				}
				
				
				break;
			default:
				switch (drawingMode)
				{
				case FRACTAL:
				case FRACTAL_JULIA:
					fractalColorAlgo.processKeyEvent(key);
					break;
				case FUNCTION:
					functionColorAlgo.processKeyEvent(key);
					break;
				}
				status = STATUS_REDRAW;
				break;
			}
		}
	}
}
