package xt.coloralgo;

public class Palette {

	public static final int NOIR = 0x000000;
	public static final int BLANC = 0xFFFFFF;
	public static final int VERT_BLEU = 0x0D8C7E;
	public static final int MARRON = 0x5F351D;
	public static final int BEIGE = 0xC8AD7F;
	public static final int BLEU_CIEL = 0x76AFF6;
	public static final int CACA_D_OIE = 0xC4DE11;
	public static final int GREGE = 0xBBAE98;
	public static final int GRENADINE = 0xEA474E;
	public static final int AZUR = 0x1E7FCB;
	public static final int AZURIN = 0xA9EAFE;
	public static final int VERT_D_EAU = 0XCEEEE0;
	public static final int CHAMPAGNE = 0xEDE3A4;
	public static final int OR = 0xF8CF15;
	public static final int ORANGE = 0xFD7F00;
	public static final int BLEU_NUIT = 0x091A48;
	public static final int EMERAUDE = 0x2ED585; 
	public static final int COQ_DE_ROCHE = 0xFC5606;
	public static final int VERT = 0x6BF066;
	public static final int AMETHYSTE = 0x6E308F;
	public static final int SOUFRE = 0xFFF866;

	public static final Palette PALETTE_1 = new Palette(
			BLEU_NUIT, 0x0032CA, 0xFFFF00, NOIR, 0xFFFF00);

	public static final Palette PALETTE_3 = new Palette(
			AZUR, AZURIN, VERT_D_EAU, CHAMPAGNE, ORANGE, BLEU_NUIT);
	
	public static final Palette PALETTE_4 = new Palette(
			BLANC, BEIGE, MARRON, NOIR, BLEU_NUIT, BLEU_CIEL);
	
	public static final Palette PALETTE_5 = new Palette(
			EMERAUDE, NOIR, AMETHYSTE, AZURIN, BEIGE, COQ_DE_ROCHE, AMETHYSTE, AZURIN);
	
	public static final Palette PALETTE_6 = new Palette(
			VERT_BLEU, NOIR,
			MARRON, BLANC,
			BEIGE, BLANC);

	public static final Palette PALETTE_7 = new Palette(
			BLEU_CIEL, BLEU_CIEL, NOIR,
			CACA_D_OIE, CACA_D_OIE, BLANC,
			GREGE, GREGE, BLANC,
			GRENADINE, GRENADINE, NOIR);

	
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
