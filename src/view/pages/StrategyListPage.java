package view.pages;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;


/**
 * Class for displaying tall strategies available.
 */
public class StrategyListPage extends JPanel implements Page {
  JTextField input;
  Button okayButton;
  Button backButton;

  /**
   * Constructor tp initialize the strategy page.
   */
  public StrategyListPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    JLabel nameOfStrategies = new JLabel("1. Dollar Average "
            + "Enter the index to select the portfolio ");
    nameOfStrategies.setFont(new Font("Verdana", 1, 20));
    this.add(nameOfStrategies);

    input = new JTextField(10);
    this.add(input);
    okayButton = new Button("Confirm");
    okayButton.setActionCommand("StrategyListPage:okayButton");
    this.add(okayButton);

    backButton = new Button("Back");
    backButton.setActionCommand("StrategyListPage:backButton");
    this.add(backButton);

  }

  @Override
  public void setListener(ActionListener buttonPress) {
    okayButton.addActionListener(buttonPress);
    backButton.addActionListener(buttonPress);
  }

  /**
   * Method to get the strategy as whether portfolio value or cost basis.
   *
   * @return Returns the selected strategy choice as a string.
   */
  public String getStrategyNumber() {
    return input.getText();
  }

}
