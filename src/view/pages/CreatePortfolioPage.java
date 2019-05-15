package view.pages;

import java.awt.Button;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.BoxLayout;


/**
 * Class to display create portfolio page.
 */
public class CreatePortfolioPage extends JPanel implements Page {
  private JTextField input;
  private Button okayButton;
  private Button backButton;

  /**
   * Constructor to initialize the page.
   */
  public CreatePortfolioPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    input = new JTextField(10);
    this.add(input);

    okayButton = new Button("Confirm");
    this.add(okayButton);
    okayButton.setActionCommand("createPortfolioPage:okayButton");

    backButton = new Button("Back");
    this.add(backButton);
    backButton.setActionCommand("createPortfolioPage:backButton");

  }


  @Override
  public void setListener(ActionListener buttonPress) {
    okayButton.addActionListener(buttonPress);
    backButton.addActionListener(buttonPress);
  }

  /**
   * Method to get the portfolio name.
   *
   * @return Returns the portfolio name as a string.
   */
  public String getPortfolioName() {
    return input.getText();
  }
}
