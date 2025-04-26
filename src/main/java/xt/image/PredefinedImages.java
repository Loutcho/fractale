package xt.image;

import java.util.Map;
import java.util.TreeMap;

import xt.fractale.Image;

public class PredefinedImages {

	private static final Map<Integer, Image> IMAGE = new TreeMap<>();

	static {
		IMAGE.put(  0, Image000.get()); // L'ensemble de Mandelbrot
		IMAGE.put(  1, Image001.get()); // Propagation
		IMAGE.put(  2, Image002.get()); // Courbevoie
		IMAGE.put(  3, Image003.get()); // Fegatello
		IMAGE.put(  4, Image004.get()); // Chenille
		IMAGE.put(  5, Image005.get()); // Bouclier cérébral
		IMAGE.put(  6, Image006.get()); // Vaisseau alien
		IMAGE.put(  7, Image007.get()); // Vitrail de conques
		IMAGE.put(  8, Image008.get()); // Nimbocumulus
		IMAGE.put(  9, Image009.get()); // Obsession
		IMAGE.put( 10, Image010.get()); // Délire hallucinatoire
		IMAGE.put( 11, Image011.get()); // Parure d'améthystes
		IMAGE.put( 12, Image012.get()); // Papillon
		IMAGE.put( 13, Image013.get()); // Syracuse
		IMAGE.put( 14, Image014.get()); // Fortifications
		IMAGE.put( 15, Image015.get()); // Rayonnement solaire
		IMAGE.put( 16, Image016.get()); // Hiroshima
		IMAGE.put( 17, Image017.get()); // Quatorze juillet
		IMAGE.put( 18, Image018.get()); // Composition florale
		IMAGE.put( 19, Image019.get()); // Mélodies nacrées
		IMAGE.put( 20, Image020.get()); // Aïe j'ai mal
		IMAGE.put( 21, Image021.get()); // Lentille gravitationnelle
		IMAGE.put( 22, Image022.get()); // Silhouette vampirique
		IMAGE.put( 23, Image023.get()); // Eclatement de paradis
		IMAGE.put( 24, Image024.get()); // Stomoxe
		IMAGE.put( 25, Image025.get()); // Démonologie
		IMAGE.put( 26, Image026.get()); // Trop d'écran
		IMAGE.put( 27, Image027.get()); // Eclipse de trou noir
		IMAGE.put( 28, Image028.get()); // Comique et cosmique 
		IMAGE.put( 29, Image029.get()); // Danseuses aux rubans 
		IMAGE.put( 30, Image030.get()); // Chambre à bulles
		IMAGE.put( 31, Image031.get()); // Calice de minuit treize
		IMAGE.put( 32, Image032.get()); // Bêtises de Cambrai
		IMAGE.put( 33, Image033.get()); // Color Function 1 - identité (= légende)
		IMAGE.put( 34, Image034.get()); // Color Function 1 - cosinus
		IMAGE.put( 35, Image035.get()); // Color Function 1 - sinus
		IMAGE.put( 36, Image036.get()); // Color Function 1 - tangente
		IMAGE.put( 37, Image037.get()); // Color Function 1 - exponentielle
		IMAGE.put( 38, Image038.get()); // Color Function 1 - carré
		IMAGE.put( 39, Image039.get()); // Pavage
		IMAGE.put( 40, Image040.get()); // Color Function 1 - fonction "Sylvestre"
		IMAGE.put( 41, Image041.get()); // Color Function 1 - fonction "Papillon"
		IMAGE.put( 42, Image042.get()); // Color Function 1 - fonction "NidDeMonstres"
		IMAGE.put( 43, Image043.get()); // Color Function 2 - identité 
		IMAGE.put( 44, Image044.get()); // Color Function 2 - fonction z^3
		IMAGE.put( 45, Image045.get()); // Color Function 2 - fonction exponentielle 
		IMAGE.put( 46, Image046.get()); // Color Function 2 - cosinus
		IMAGE.put( 47, Image047.get()); // Color Function 2 - sinus
		IMAGE.put( 48, Image048.get()); // Color Function 2 - tangente
		IMAGE.put( 49, Image049.get()); // Color Function 2 - fonction "Sylvestre" 
		IMAGE.put( 50, Image050.get()); // Couronne de Pâques
		IMAGE.put( 51, Image051.get()); // Tentacules
		IMAGE.put( 52, Image052.get()); // Rubans et fourches
		IMAGE.put( 53, Image053.get()); // Domain Coloring, Color Function 3 - identité
		IMAGE.put( 54, Image054.get()); // Domain Coloring, pas très joli mais pédagogique : doublement d'angle
		IMAGE.put( 55, Image055.get()); // Fractale, pas très jolie mais pédagogique : doublement d'angle
		IMAGE.put( 56, Image056.get()); // Un EscapeTimeAlgorithm et un DomainColoring peuvent donner exactement le même résultat : comparer 56 et 57
		IMAGE.put( 57, Image057.get()); // Un EscapeTimeAlgorithm et un DomainColoring peuvent donner exactement le même résultat : comparer 56 et 57
		IMAGE.put( 58, Image058.get()); // Version non discrétisée du 57
		IMAGE.put( 59, Image059.get()); //
		IMAGE.put( 60, Image060.get()); // Projection astrale
		IMAGE.put( 61, Image061.get()); // Lettre J
		IMAGE.put( 62, Image062.get()); // Lettre B
		IMAGE.put( 63, Image063.get()); // Convergence des âmes
		IMAGE.put( 64, Image064.get()); // 
		IMAGE.put( 65, Image065.get()); // Des empreintes dans la neige
		IMAGE.put( 66, Image066.get()); //
		IMAGE.put( 67, Image067.get()); // Marelle
		IMAGE.put( 68, Image068.get()); // Mouche Toutankhamon
		IMAGE.put( 69, Image069.get()); // Marelle II
		IMAGE.put( 70, Image070.get()); // Disques
		IMAGE.put( 71, Image071.get()); // Une nuit sur le Mont Chauve
		IMAGE.put( 72, Image072.get()); // Mer agitée
		IMAGE.put( 73, Image073.get()); // Biface de diamant
		IMAGE.put( 74, Image074.get()); // Color function adaptée à l'algorithme d'Euclide en polaires, cf. ci-après 75)
		IMAGE.put( 75, Image075.get()); // Algorithme d'Euclide en polaires
		IMAGE.put( 76, Image076.get()); // Fleur d'artifice
		IMAGE.put( 77, Image077.get()); // Distance de 0 à z en évitant le mur circulaire x^2 + y^2 = 1 percé en 1 ; niveaux de gris.
		IMAGE.put( 78, Image078.get()); // Clown de Noël 
		IMAGE.put( 79, Image079.get()); // Odysseus
		IMAGE.put( 80, Image080.get()); // Embrasement
		IMAGE.put( 81, Image081.get()); // Méduse fantôme
		IMAGE.put( 82, Image082.get()); // Totem polype
		IMAGE.put( 83, Image083.get()); // Brebis turquoise
		IMAGE.put( 84, Image084.get()); // Color Function 5 (identité)
		IMAGE.put( 85, Image085.get()); // Surnombre
		IMAGE.put( 86, Image086.get()); // Magma basaltique
		IMAGE.put( 87, Image087.get()); // Joyeux anniversaire Nini !
		IMAGE.put( 88, Image088.get()); // Orobanche
		IMAGE.put( 89, Image089.get()); // Donut
		IMAGE.put( 90, Image090.get()); // Bisou
		IMAGE.put( 91, Image091.get()); // Epineux
		IMAGE.put( 92, Image092.get()); // Spiderman
		IMAGE.put( 93, Image093.get()); // Lemniscate
		IMAGE.put( 94, Image094.get()); // Barbie
		IMAGE.put( 95, Image095.get()); // Stomoxe II
		IMAGE.put( 96, Image096.get()); // Frise
		IMAGE.put( 97, Image097.get()); // Plumage
		IMAGE.put( 98, Image098.get()); // Zeus drapé
		IMAGE.put( 99, Image099.get()); // Escargots
		IMAGE.put(100, Image100.get()); // Entortillé
		IMAGE.put(101, Image101.get()); // Harmonie des Sphères
		IMAGE.put(102, Image102.get()); // Flocons de neige
		IMAGE.put(103, Image103.get()); // Supernova
		IMAGE.put(104, Image104.get()); // Arbre binaire double
		IMAGE.put(105, Image105.get()); // Galaxie
	}

	public static Image get(Integer n) {
		return IMAGE.get(n);
	}
}
