package xt.coloralgo;

public class Palette {

	private static final int NOIR = 0x000000;
	private static final int BLANC = 0xFFFFFF;
	private static final int GRENADINE = 0xEA474E;
	private static final int COQ_DE_ROCHE = 0xFC5606;
	private static final int EMERAUDE = 0x2ED585;
	private static final int VERT_D_EAU = 0XCEEEE0;
	private static final int VERT_BLEU = 0x0D8C7E;
	private static final int AZUR = 0x1E7FCB;
	private static final int AZURIN = 0xA9EAFE;
	private static final int BLEU_CIEL = 0x76AFF6;
	private static final int BLEU_FLAMME_DE_SOUFRE = 0x0032CA;
	private static final int BLEU_NUIT = 0x091A48;
	private static final int ORANGE = 0xFD7F00;
	private static final int MANDARINE = 0xFEA347;
	private static final int MARRON = 0x5F351D;
	private static final int BEIGE = 0xC8AD7F;	 
	private static final int CHAMPAGNE = 0xEDE3A4;
	private static final int AMETHYSTE = 0x6E308F;
	private static final int CARNATION = 0xFEC3AC;
	

	public static final Palette PALETTE_001 = new Palette(BLEU_NUIT, BLEU_FLAMME_DE_SOUFRE, MANDARINE, NOIR, MANDARINE);
	public static final Palette PALETTE_002 = new Palette(BLANC, BEIGE, MARRON, NOIR, BLEU_NUIT, BLEU_CIEL);
	public static final Palette PALETTE_003 = new Palette(AZUR, AZURIN, VERT_D_EAU, CHAMPAGNE, ORANGE, BLEU_NUIT);
	public static final Palette PALETTE_004 = new Palette(EMERAUDE, NOIR, AMETHYSTE, AZURIN, BEIGE, COQ_DE_ROCHE, AMETHYSTE, AZURIN);
	public static final Palette PALETTE_005 = new Palette(VERT_BLEU, NOIR, MARRON, BLANC, BEIGE, BLANC);
	public static final Palette PALETTE_006 = new Palette(NOIR, GRENADINE);
	public static final Palette PALETTE_007 = new Palette(NOIR, BLANC);
	public static final Palette PALETTE_008 = new Palette(CARNATION, NOIR, AZUR, BLANC);
	public static final Palette PALETTE_009 = new Palette(BEIGE, CARNATION, MARRON, NOIR);

	private int rgb[];
	
	public Palette(int...rgb) {
		int n = rgb.length;
		this.rgb = new int[n];
		for (int i = 0; i < n; i ++) {
			this.rgb[i] = rgb[i];
		}
	}
	
	public int getNbColors() {
		return rgb.length;
	}
	
	public int getColor(int i) {
		return rgb[i];
	}
}
