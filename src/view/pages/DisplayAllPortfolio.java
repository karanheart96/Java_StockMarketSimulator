package view.pages;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 * Class for displaying every portfolio.
 */
public class DisplayAllPortfolio extends JPanel implements Page {

  JLabel nameOfCompanies;
  Button backButton;

  /**
   * The constructor for setting the layout.
   * @param portfolioContent The content of the portfolio.
   */
  public DisplayAllPortfolio(String portfolioContent) {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    if (portfolioContent.equals("")) {
      portfolioContent = "<html> No Portfolios created yet. "
              + "Please create Portfolios to view them</html>";
    } else {
      portfolioContent = "<html>" + portfolioContent + "</html>";
      portfolioContent = portfolioContent.replace("\n", "<br/>");
    }
    nameOfCompanies = new JLabel(portfolioContent);
    nameOfCompanies.setFont(new Font("Verdana", 1, 20));
    this.add(nameOfCompanies);


    backButton = new Button("Back");
    this.add(backButton);
    backButton.setActionCommand("displayAllPortfolioPage:backButton");


  }


  @Override
  public void setListener(ActionListener buttonPress) {
    backButton.addActionListener(buttonPress);
  }
}
