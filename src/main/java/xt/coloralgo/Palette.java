package xt.coloralgo;

public class Palette {

	private static final int NOIR = 0x000000;
	private static final int BITUME = 0x201511;
	private static final int BLANC = 0xFFFFFF;
	private static final int ARGENT = 0xFEFEFE;
	private static final int PLATINE = 0xE8E0E0;
	private static final int ROUGE = 0xFF0000;
	private static final int ECARLATE = 0xE30B01;
	private static final int GRENADINE = 0xEA474E;
	private static final int COQ_DE_ROCHE = 0xFC5606;
	private static final int CAPUCINE = 0xFF5E4D;
	private static final int BORDEAUX = 0x6D071A;
	private static final int FUCHSIA = 0xF2124D;
	private static final int VERT = 0x00FF00;
	private static final int EMERAUDE = 0x2ED585;
	private static final int VERT_D_EAU = 0xCEEEE0;
	private static final int VERT_BLEU = 0x0D8C7E;
	private static final int TURQUOISE = 0x25FDE9;
	private static final int PISTACHE = 0xBEF574;
	private static final int VERT_DE_VESSIE = 0x22780F;
	private static final int VERT_CYAN = 0x81FFB3;
	private static final int VERT_GAZON = 0x0AAD08;
	private static final int VERT_IMPERIAL = 0x00561B;
	private static final int ABSINTHE = 0x7FDD4C;
	private static final int BLEU = 0x0000FF;
	private static final int AZUR = 0x1E7FCB;
	private static final int AZURIN = 0xA9EAFE;
	private static final int BLEU_CIEL = 0x76AFF6;
	private static final int BLEU_FLAMME_DE_SOUFRE = 0x0032CA;
	private static final int BLEU_NUIT = 0x091A48;
	private static final int BLEU_KLEIN = 0x001F98;
	private static final int BLEU_FRANCE = 0x1375ED;
	private static final int BLEU_MARINE = 0x03224C;
	private static final int BLEU_ELECTRIQUE = 0x0C75FF;
	private static final int BLEU_INTERDIMENSIONNEL = 0x3300CC;
	private static final int ORANGE = 0xFD7F00;
	private static final int MANDARINE = 0xFD9715;
	private static final int OR = 0xFFD700;
	private static final int JAUNE = 0xFFFF00;
	private static final int CITRON = 0xF6F924;
	private static final int VIOLET = 0x660099;
	private static final int AMETHYSTE = 0x6E308F;
	private static final int FLUGGER_SWEET_60 = 0x531E39;
	private static final int CARNATION = 0xFEC3AC;
	private static final int CHAMPAGNE = 0xEDE3A4;
	private static final int OCRE = 0xEFC54C;
	private static final int BEIGE = 0xC8AD7F;
	private static final int MARRON = 0x5F351D;
	private static final int MARRON2 = 0x481200;
	private static final int BRONZE = 0x99723B;
	private static final int FUMEE = 0xBBD2E1;
	
	public static final Palette PALETTE_000 = new Palette(BLEU_MARINE, BLANC, BEIGE, MARRON);
	public static final Palette PALETTE_001 = new Palette(BLEU_MARINE, BLEU_FRANCE, OCRE, NOIR);
	public static final Palette PALETTE_002 = new Palette(BLANC, BEIGE, MARRON, NOIR, BLEU_NUIT, BLEU_CIEL);
	public static final Palette PALETTE_003 = new Palette(BLEU_FLAMME_DE_SOUFRE, AZUR, AZURIN, VERT_D_EAU, CHAMPAGNE, ORANGE, BLEU_NUIT);
	public static final Palette PALETTE_004 = new Palette(EMERAUDE, NOIR, AMETHYSTE, AZURIN, BEIGE, COQ_DE_ROCHE, AMETHYSTE, AZURIN);
	public static final Palette PALETTE_005 = new Palette(VERT_BLEU, NOIR, MARRON, BLANC, BEIGE, BLANC);
	public static final Palette PALETTE_006 = new Palette(NOIR, GRENADINE);
	public static final Palette PALETTE_007 = new Palette(NOIR, BLANC);
	public static final Palette PALETTE_008 = new Palette(CARNATION, NOIR, AZUR, BLANC);
	public static final Palette PALETTE_009 = new Palette(BEIGE, CARNATION, MARRON, NOIR);
	public static final Palette PALETTE_010 = new Palette(BLEU, VIOLET, ROUGE, ORANGE, JAUNE, VERT);
	public static final Palette PALETTE_011 = new Palette(AMETHYSTE, BLANC, AMETHYSTE, NOIR, NOIR, NOIR);
	public static final Palette PALETTE_012 = new Palette(BLEU_FLAMME_DE_SOUFRE, AZUR, AZURIN, VERT_D_EAU, CHAMPAGNE, ORANGE, BLEU_NUIT);
	public static final Palette PALETTE_013 = new Palette(ORANGE, NOIR, BLANC);
	public static final Palette PALETTE_014 = new Palette(NOIR, BLANC, ROUGE);
	public static final Palette PALETTE_015 = new Palette(CITRON, EMERAUDE, VERT_BLEU, BLEU_CIEL, AMETHYSTE, COQ_DE_ROCHE);
	public static final Palette PALETTE_016 = new Palette(ROUGE);
	public static final Palette PALETTE_017 = new Palette(GRENADINE, ROUGE, BLANC, BLEU_FRANCE, BLEU_FLAMME_DE_SOUFRE, BLANC);
	public static final Palette PALETTE_017bis = new Palette(COQ_DE_ROCHE, ROUGE, BLANC, BLEU, BLEU_KLEIN, BLANC);
	public static final Palette PALETTE_018 = new Palette(PISTACHE, BLEU_CIEL, CAPUCINE);
	public static final Palette PALETTE_019 = new Palette(BLEU, PISTACHE, ORANGE);
	public static final Palette PALETTE_020 = new Palette(BLANC, BLEU_FLAMME_DE_SOUFRE, BLANC, NOIR);
	public static final Palette PALETTE_021 = new Palette(BLEU, AZURIN, BLANC);
	public static final Palette PALETTE_022 = new Palette(ROUGE, NOIR, BLANC);
	public static final Palette PALETTE_023 = new Palette(NOIR, BLEU_FRANCE, BLANC);
	public static final Palette PALETTE_024 = new Palette(CARNATION, MARRON2, BLANC, BLEU_NUIT, NOIR);
	public static final Palette PALETTE_025 = new Palette(NOIR, BLEU_FRANCE, BLANC, NOIR, BLANC, ORANGE, BLANC);
	public static final Palette PALETTE_026 = new Palette(VERT, NOIR, BLANC, NOIR);
	public static final Palette PALETTE_027 = new Palette(BLEU_FRANCE, BLANC, CAPUCINE, BLANC);
	public static final Palette PALETTE_028 = new Palette(OR, BLEU_FLAMME_DE_SOUFRE);
	public static final Palette PALETTE_029 = new Palette(OR, ARGENT, BRONZE);
	public static final Palette PALETTE_030 = new Palette(BORDEAUX, VERT_DE_VESSIE, VERT_CYAN, BLANC, VERT_CYAN, BLANC, BORDEAUX, VERT_DE_VESSIE);
	public static final Palette PALETTE_031 = new Palette(BLANC, ROUGE, BLEU_NUIT, BORDEAUX);
	public static final Palette PALETTE_032 = new Palette(BLEU_NUIT, BLANC, NOIR, BEIGE);
	public static final Palette PALETTE_039 = new Palette(FUCHSIA, ABSINTHE, BLANC, BLEU_NUIT);
	public static final Palette PALETTE_050 = new Palette(BLANC, ECARLATE, VERT_GAZON, BLEU_ELECTRIQUE);
	public static final Palette PALETTE_051 = new Palette(BLANC, MANDARINE, VERT_IMPERIAL, BLEU_FLAMME_DE_SOUFRE);
	public static final Palette PALETTE_056 = new Palette(NOIR, BLEU_FRANCE, BLANC, ORANGE);
	public static final Palette PALETTE_059 = new Palette(BLEU_NUIT, NOIR, OCRE, BLANC, BLANC, BLANC);
	public static final Palette PALETTE_060 = new Palette(BLEU_NUIT, BLANC, BEIGE);
	public static final Palette PALETTE_063 = new Palette(BLEU_CIEL, BLANC, CARNATION, BLANC);
	public static final Palette PALETTE_065 = new Palette(BLANC, AZURIN, AZUR, AZURIN);
	public static final Palette PALETTE_066 = new Palette(BLEU_CIEL, BLANC, OCRE);
	public static final Palette PALETTE_068 = new Palette(AZUR, OCRE, BLANC, OCRE);
	public static final Palette PALETTE_070 = new Palette(BLEU_FRANCE, BLEU_CIEL, BLANC, BORDEAUX);
	public static final Palette PALETTE_071 = new Palette(NOIR, NOIR, AZUR, BLANC, CAPUCINE);
	public static final Palette PALETTE_072 = new Palette(EMERAUDE, BLEU_KLEIN, VERT_IMPERIAL, BLANC, AZURIN);
	public static final Palette PALETTE_073 = new Palette(FUMEE, FLUGGER_SWEET_60, BLEU_ELECTRIQUE, BLANC);
	public static final Palette PALETTE_075 = new Palette(NOIR, NOIR, BEIGE, BLANC, BEIGE);
	public static final Palette PALETTE_078 = new Palette(BEIGE, BLANC, BORDEAUX, BLANC, BORDEAUX, BLANC, OCRE, GRENADINE, OCRE, BLANC);
	public static final Palette PALETTE_079 = new Palette(BLANC, BITUME);
	public static final Palette PALETTE_080 = new Palette(BLANC, ECARLATE, ORANGE, JAUNE);
	public static final Palette PALETTE_081 = new Palette(BLANC, PLATINE, BLEU_MARINE);
	public static final Palette PALETTE_082 = new Palette(0xE0E0FF, 0xFF0000, 0xC0C0FF, 0xFF80A0, 0xE0E0FF, 0xFFE0E0, 0xFFFFFF, 0xFF80A0);
	public static final Palette PALETTE_083 = new Palette(OR, BEIGE, BRONZE, CHAMPAGNE, VERT_IMPERIAL, TURQUOISE);
	public static final Palette PALETTE_086 = new Palette(BLANC, AZURIN, BLEU_ELECTRIQUE, BLEU_NUIT, MARRON, BEIGE);
	public static final Palette PALETTE_087 = new Palette(BLANC, BLEU_ELECTRIQUE, BLANC, FUCHSIA);
	public static final Palette PALETTE_089 = new Palette(BLANC, EMERAUDE, VERT_BLEU, BLEU_CIEL, AMETHYSTE, FUCHSIA);
	public static final Palette PALETTE_090a = new Palette(BLANC, 0x9FFFC9);
	public static final Palette PALETTE_090b = new Palette(BLANC, 0xFEA36C);
	public static final Palette PALETTE_091 = new Palette(BLANC, BORDEAUX);
	public static final Palette PALETTE_092 = new Palette(NOIR, NOIR, BLEU_CIEL, BLANC, BLANC, BLANC, BLANC, BLANC, BLANC, BLANC, BLEU_INTERDIMENSIONNEL, NOIR);
	public static final Palette PALETTE_094 = new Palette(0xFFDDEE, 0x336633, 0xFFEEDD, 0x336633);
	public static final Palette PALETTE_099 = new Palette(BLANC, BEIGE, OCRE, BEIGE, BLANC, BLEU_CIEL, BLEU_ELECTRIQUE, BLEU_ELECTRIQUE, BLEU_ELECTRIQUE, BLEU_ELECTRIQUE, BLEU_CIEL);
	public static final Palette PALETTE_100 = new Palette(BLANC, VERT_IMPERIAL);
	public static final Palette PALETTE_104 = new Palette(MARRON, BEIGE, FUMEE, BLANC, AZUR, BLEU_INTERDIMENSIONNEL);
	
	public static final Palette PALETTE_VIDEO_001 = new Palette(BLEU, BLANC);
	public static final Palette PALETTE_VIDEO_010 = new Palette(0x000000, 0xFF0000, 0xFFCC00);
	public static final Palette PALETTE_VIDEO_010a = new Palette(0x000000, 0xFFFFFF, 0xFF0000, 0xFF0000, 0xFFCC00, 0xFFCC00);
	
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Palette(");
		for (int i = 0; i < rgb.length; i ++) {
			if (i > 0) {
				builder.append(", ");
			}
			int c = rgb[i];
			builder.append(String.format("0x%06X", c));
		}
		builder.append(")");
		return builder.toString();
	}
}
