import acm.program.GraphicsProgram;
import acm.program.*;
import acm.graphics.*;
import java.awt.Color;

public class MethodicalPyramid extends GraphicsProgram { //Das ist die Subclass "MethodicalPayramid". Diese erweitert GraphicsProgramm damit man die Methoden dieser Klasse nutzen kann.
	//Eine Class ist eine art bauplan für Objects 
	//Jede Instance in dieser Class ist gleichzeitig eine der Superclass. In diesem Fall GraphicsProgramm. Das nennt man Inheritance
	 /**
	 * Returns the color to be used for bricks in the given layer.
	 * 
	 * @param layerIndex
	 *            index of the layer whose color to return. {@code 0} is the
	 *            bottom layer, {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @return the color to be used for the given layer, or {@code null} if
	 *         {@code layerIndex} is invalid.
	 */
	public Color layerColor(int layerIndex, int numberOfLayers) { //Das ist die Methode "layerColor". Methoden sind Programmteile, die bestimmte Teilaufgeben lösen sollen. Diese berechnet die Farbe einer Zeile der Pyramide.
		if (layerIndex < 0 || layerIndex >= numberOfLayers){			  //Die Parameter der Methode sind layerIndex und numberOfLayers. 
			return null;
		}
		else{
		double bg = 220d / (numberOfLayers-1);
		bg = bg * layerIndex;
		int g = (int) bg;
		println (g);
		return new Color(255, g, g);
		}
	}

	/**
	 * Draws the given layer with bricks filled with the given color. If
	 * {@code layerIndex} is invalid, no bricks at all should be drawn.
	 * 
	 * @param layerIndex
	 *            index of the layer to draw. {@code 0} is the bottom layer,
	 *            {@code numberOfLayers - 1} is the top layer.
	 * @param numberOfLayers
	 *            the number of layers in the pyramid.
	 * @param layerColor
	 *            color the layer's bricks should be filled with.
	 */
	public void drawLayer(int layerIndex, int numberOfLayers, Color layerColor) { //Das ist die Methode "drawLayer". Methoden sind Programmteile, die bestimmte Teilaufgeben lösen sollen. Diese zeichnet eine Zeile der Pyramide.
		for (int j = 0; j < (numberOfLayers-layerIndex); j++) {
			double x = j * 100 + (50*layerIndex);  //dies ist ein statement.Hier wird die variable x mit dem typ double deklariet und dem wert einer expression zugewiesen. eine variable ist ein stellvertreter. Der Typ legt die art der zahl fest. Eine Expression ist ein mix aus variblen, operatoren und methodenaufrufe die genau einen wert haben.
			double y = (numberOfLayers - layerIndex) * 50;
			GRect rect = new GRect(x, y, 100, 50); //"new" erstellt ein neues Objekt. in diesem fall ein rechteck. 
			rect.setFillColor(layerColor);
			rect.setFilled(true);
			add(rect);
		}
	}

	public void run() { 
		int n = readInt("Enter the number of bricks in the bottom layer: ");
		for (int i = 0; i < n; i++) {
			Color layer = layerColor(i, n);
			drawLayer(i, n, layer);
		}
	}
}
