package view.pages;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 * Class for buying individual stocks.
 */
public class BuyIndividualStockPage extends JPanel implements Page {

  JLabel nameOfCompanies;
  Button backButton;
  JTextField input;
  Button okayButton;

  /**
   * Consrtuctor to initialize the page.
   * @param portfolioNames The portfolio names to display.
   */
  public BuyIndividualStockPage(String portfolioNames) {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    if (portfolioNames.equals("")) {
      portfolioNames = "<html> No Portfolios created yet."
              + " Please create Portfolios to view them</html>";
      nameOfCompanies = new JLabel(portfolioNames);
      nameOfCompanies.setFont(new Font("Verdana", 1, 20));
      this.add(nameOfCompanies);

      input = new JTextField(10);
      this.add(input);

      backButton = new Button("Back");
      this.add(backButton);
      backButton.setActionCommand("buyStockIndividuallyPage:backButton");

    } else {
      portfolioNames = "<html>" + portfolioNames;
      portfolioNames = portfolioNames + "\nEnter the Index of the"
              + " Portfolio you want to buy stocks for\n" + "</html>";
      portfolioNames = portfolioNames.replace("\n", "<br/>");

      nameOfCompanies = new JLabel(portfolioNames);
      nameOfCompanies.setFont(new Font("Verdana", 1, 20));
      this.add(nameOfCompanies);

      input = new JTextField(10);
      this.add(input);

      okayButton = new Button("Confirm");
      this.add(okayButton);
      okayButton.setActionCommand("buyStockIndividuallyPage:okayButton");
      backButton = new Button("Back");
      this.add(backButton);
      backButton.setActionCommand("buyStockIndividuallyPage:backButton");

    }

  }

  @Override
  public void setListener(ActionListener buttonPress) {
    backButton.addActionListener(buttonPress);
    okayButton.addActionListener(buttonPress);
  }


  /**
   * Method to get the portfolio number.
   *
   * @return Returns the portfolio number as a string.
   */
  public String getPortfolioNumber() {
    return input.getText();
  }
}
