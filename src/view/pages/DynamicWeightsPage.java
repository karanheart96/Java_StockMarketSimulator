package view.pages;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.util.List;

/**
 * Class for displaying the page where the weights are entered.
 */

public class DynamicWeightsPage extends JPanel implements Page {
  JTextField weights;

  Button okayButton;
  Button backButton;
  List<String> companyNames;

  /**
   * The constructor for setting the weights page.
   * @param companyNames The name of the companies.
   */
  public DynamicWeightsPage(List<String> companyNames) {
    this.companyNames = companyNames;
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    String names = "";
    names = companyNames + "Enter weights seperated by commmas( Weights are)";
    names = "<html>" + names + "</html>";
    JLabel companies = new JLabel(names);
    companies.setFont(new Font("Verdana", 1, 20));
    this.add(companies);
    weights = new JTextField();
    this.add(weights);

    okayButton = new Button("Confirm");
    okayButton.setActionCommand("DynamicWeightsPage:okayButton");
    this.add(okayButton);

    backButton = new Button("Back");
    backButton.setActionCommand("DynamicWeightsPage:backButton");
    this.add(backButton);


  }

  @Override
  public void setListener(ActionListener buttonPress) {
    okayButton.addActionListener(buttonPress);
    backButton.addActionListener(buttonPress);
  }

  /**
   * Method to get the weights from the user.
   *
   * @return Return the weights as a string.
   */
  public String getWeights() {

    return weights.getText();
  }


}
