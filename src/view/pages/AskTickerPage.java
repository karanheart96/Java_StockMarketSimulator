package view.pages;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.awt.Button;

/**
 * Class for displaying the page for asking ticker ymbol.
 */
public class AskTickerPage extends JPanel implements Page {
  JTextField ticker = new JTextField();
  Button okayButton;
  Button backButton;


  /**
   * Consrtuctor to initialize the ask Ticker page.
   */
  public AskTickerPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(new JLabel("ENTER TICKER SYMBOL"));
    this.add(ticker);
    okayButton = new Button("Add Company");
    okayButton.setActionCommand("AskTickerPage:okayButton");
    this.add(okayButton);
    backButton = new Button("Back");
    backButton.setActionCommand("AskTickerPage:backButton");
    this.add(backButton);

  }


  @Override
  public void setListener(ActionListener buttonPress) {


    okayButton.addActionListener(buttonPress);
    backButton.addActionListener(buttonPress);

  }


  /**
   * Gets the ticker symbol.
   *
   * @return Returns the ticker symbol as a string.
   */
  public String getTicker() {
    return ticker.getText();
  }
}
