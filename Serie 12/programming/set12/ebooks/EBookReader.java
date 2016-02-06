package programming.set12.ebooks;

import java.awt.FontMetrics;
import java.util.StringTokenizer;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class EBookReader extends GraphicsProgram {
	private String font = "Serif-12";
	private int boarder = 10;
	private int lineWidth = 300;
	private int lineIndent = 20;
	private double spacingFactor = 1.2;

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

		StringTokenizer nl = new StringTokenizer(input, "\n");
		int line = 0; // line index
		while (nl.hasMoreTokens()) {
			StringTokenizer st = new StringTokenizer(nl.nextToken(), " "); // set
																			// Tokenizer
																			// for
																			// lines
			double lineWidth = 0;
			String test = "";
			String save = "";

			int indent = lineIndent; // sets indent so the next label has a line
										// indent
			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				test += str; // adds a word to test
				if (st.hasMoreTokens())
					test += " "; // adds a space
				GLabel label = new GLabel(""); // new label for font metrics
				label.setFont(font);
				FontMetrics fm = label.getFontMetrics();
				lineWidth = fm.stringWidth(test) + indent;
				if (lineWidth > this.lineWidth) { // test if the string is to
													// long
					label = new GLabel(save); // creates the label with string
												// without current word
					label.setFont(font);
					label.setLocation(boarder + indent,
							boarder + fm.getAscent() + (line * (fm.getHeight() * spacingFactor))); // calculate
																									// the
																									// position
																									// of
																									// the
																									// label
					add(label);
					test = str + " "; // builds a new string with the current
										// word and a space
					indent = 0; // sets indent 0 so the next line has no line
								// indent
					line++; // increase the line counter
				} else {
					save = test; // save the current string
				}
				if (!(st.hasMoreTokens())) { // adds a label if the label is
					// shorter then line width
					// and there are no more
					// words
					GLabel lastLabel = new GLabel(test);
					lastLabel.setFont(font);
					lastLabel.setLocation(boarder + indent,
							boarder + fm.getAscent() + (line * (fm.getHeight() * spacingFactor)));
					add(lastLabel);
					line++;
				}
			}
		}
	}

	@Override
	public void run() {
		setSize(600, 600);
		String str = "Alice waited till the eyes appeared, and then nodded. 'It's no use speaking to it,' she thought, 'till its ears have come, or at least one of them.' In another minute the whole head appeared, and then Alice put down her flamingo, and began an account of the game, feeling very glad she had someone to listen to her. The Cat seemed to think that there was enough of it now in sight, and no more of it appeared.";
		displayText(str);
	}

}
