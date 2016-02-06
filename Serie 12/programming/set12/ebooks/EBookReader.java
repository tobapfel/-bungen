package programming.set12.ebooks;

import java.awt.FontMetrics;
import java.util.StringTokenizer;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class EBookReader extends GraphicsProgram {
	private String font = "";
	private int boarder = 0;
	private int lineWidth = 0;
	private int lineIndent = 0;
	private double spacingFactor = 0;

	/**
	 * configures the font to be used to display the text
	 * 
	 * @param font
	 */
	public void setTextFont(String font) {
		this.font = font;
	}

	/**
	 * configures how many pixels to leave around the text and the window frame
	 * 
	 * @param pixel
	 */
	public void setBorder(int pixel) {
		boarder = pixel;
	}

	/**
	 * configures how wide lines of text are allowed to be
	 * 
	 * @param pixel
	 */
	public void setLineWidth(int pixel) {
		lineWidth = pixel;
	}

	/**
	 * configures by how many pixels the first line of each paragraph of text
	 * should be indented
	 * 
	 * @param pixel
	 */
	public void setFirstLineIndent(int pixel) {
		lineIndent = pixel;
	}

	/**
	 * sets the line spacing factor
	 * 
	 * @param n
	 */
	public void setLineSpacingFactor(double n) {
		spacingFactor = n;
	}

	public void displayText(String input) {
		// set defaults
		if (font == "")
			font = "Serif-12";
		if (boarder == 0)
			boarder = 10;
		if (lineWidth == 0)
			lineWidth = 300;
		if (lineIndent == 0)
			lineIndent = 20;
		if (spacingFactor == 0.0)
			spacingFactor = 1.2;

		StringTokenizer nl = new StringTokenizer(input, "\n");
		int line = 1;
		while (nl.hasMoreTokens()) {
			StringTokenizer st = new StringTokenizer(nl.nextToken(), " ");
			double lineWidth = 0;
			String test = "";
			String save = "";

			int indent = lineIndent;
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				test += str;
				test += " ";
				GLabel label = new GLabel("");
				label.setFont(font);
				FontMetrics fm = label.getFontMetrics();
				lineWidth = fm.stringWidth(test) + indent;
				if (lineWidth > this.lineWidth) {
					label = new GLabel(save);
					label.setFont(font);
					label.setLocation(boarder + indent,
							boarder + (line * fm.getAscent()) + ((line - 1) * (fm.getHeight() * spacingFactor)));
					add(label);
					test = str + " ";
					indent = 0;
					line++;
				} else {
					save = test;
				}
			}
		}
	}

	@Override
	public void run() {
		setSize(600, 300);
		setTextFont("Garamond-bold-18");
		setBorder(10);
		setLineWidth(350);
		setFirstLineIndent(20);
		setLineSpacingFactor(1.2);
		String str = "The alley was unusually dark and alley-like. A thick mist covered the ground, penetrating the air like a heavy mattress, but without the solid parts. He felt reminded of an ingeniously staged theatre play. But this time, he might not make it out in one piece, the Don would make sure of that if given half a chance.\n'You're late!', said a voice in the dark.\nIt was then that he noticed that he might not have been on time.";
		displayText(str);
	}

}
