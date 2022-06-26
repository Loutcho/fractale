package xt.coloralgo;

public class BubbleEffect {

	private boolean activated;
	
	public boolean isActivated() {
		return activated;
	}
	
	private BubbleEffect(boolean activated) {
		this.activated = activated;
	}
	
	public static final BubbleEffect ON = new BubbleEffect(true);
	public static final BubbleEffect OFF = new BubbleEffect(false);
}
