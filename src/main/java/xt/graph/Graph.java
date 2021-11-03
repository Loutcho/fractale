package xt.graph;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Graph {
	static final long serialVersionUID = 1234;

	GraphicsDevice device = null;
	GraphicsConfiguration graphicsConfiguration = null;
	Frame mainFrame = null;
	BufferStrategy bufferStrategy = null;
	Graphics graphics = null;
	Rectangle rectangle = null;

	public void init() {
		GraphicsEnvironment env = null;
		env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = env.getDefaultScreenDevice();
		graphicsConfiguration = device.getDefaultConfiguration();
		mainFrame = new Frame(graphicsConfiguration);
		mainFrame.setUndecorated(true);
		mainFrame.setIgnoreRepaint(true);
		device.setFullScreenWindow(mainFrame);
		mainFrame.createBufferStrategy(1);
		bufferStrategy = mainFrame.getBufferStrategy();
		graphics = bufferStrategy.getDrawGraphics();
		rectangle = mainFrame.getBounds();
		mainFrame.setFocusable(true);
	}

	public void done() {
		bufferStrategy.show();
		graphics.dispose();
		device.setFullScreenWindow(null);
	}

	public Graphics getGraphics() {
		return graphics;
	}

	public Rectangle getRectangle() {
		return mainFrame.getBounds();
	}

	public void addKeyListener(KeyAdapter ka) {
		mainFrame.addKeyListener(ka);
	}

	public static void save(String outFileName) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Rectangle screenRect = new Rectangle(screenSize);
		try {
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRect);
			ImageIO.write(image, "png", new File(outFileName));
		} catch (AWTException | IOException e) {
			e.printStackTrace();
		}
	}
}
