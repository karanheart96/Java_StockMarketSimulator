package view.pages;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;



/**
 * Class for displaying the page which prints the portfolio cost.
 */
public class PortfolioForCost extends JPanel implements Page {

  JLabel nameOfCompanies;
  Button backButton;
  JTextField input;
  Button okayButton;

  /**
   * The constructor which creates the page for displaying portfolio cost.
   * @param portfolioNames The names of the portfolios.
   */
  public PortfolioForCost(String portfolioNames) {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    if (portfolioNames.equals("")) {
      portfolioNames = "<html> No Portfolios created yet."
              +
              " Please create Portfolios to view them</html>";
      nameOfCompanies = new JLabel(portfolioNames);
      nameOfCompanies.setFont(new Font("Verdana", 1, 20));
      this.add(nameOfCompanies);

      backButton = new Button("Back");
      this.add(backButton);
      backButton.setActionCommand("PortfolioForCost:backButton");

    } else {
      portfolioNames = "<html>" + portfolioNames + "</html>";
      portfolioNames = portfolioNames + "\nEnter the Index of the "
              +
              "Portfolio you want to buy stocks for\n";
      portfolioNames = portfolioNames.replace("\n", "<br/>");

      nameOfCompanies = new JLabel(portfolioNames);
      nameOfCompanies.setFont(new Font("Verdana", 1, 20));
      this.add(nameOfCompanies);

      input = new JTextField(10);
      this.add(input);

      okayButton = new Button("Confirm");
      this.add(okayButton);
      okayButton.setActionCommand("PortfolioForCost:okayButton");
      backButton = new Button("Back");
      this.add(backButton);
      backButton.setActionCommand("PortfolioForCost:backButton");
    }

  }

  @Override
  public void setListener(ActionListener buttonPress) {
    backButton.addActionListener(buttonPress);
    okayButton.addActionListener(buttonPress);
  }

  /**
   * Method to get the portfolio number from the user.
   * @return Returns the portfolio number as a string.
   */
  public String getPortfolioNumber() {
    return input.getText();
  }
}
