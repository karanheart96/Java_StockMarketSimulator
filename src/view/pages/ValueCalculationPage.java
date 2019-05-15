package view.pages;

import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Button;
import javax.swing.JLabel;

/**
 * Class for displaying the calculated values for the portfolios.
 */
public class ValueCalculationPage extends JPanel implements Page {
  Button backButton = new Button("Back");
  Button portfolioValue = new Button("Calculate Portfolio Value");
  Button costBasis = new Button("Calculate Cost Basis");
  JTextField year = new JTextField();
  JTextField month = new JTextField();
  JTextField day = new JTextField();

  /**
   * Constructoer to initialize the page.
   */
  public ValueCalculationPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(new JLabel("ENTER YEAR"));
    this.add(year);
    this.add(new JLabel("ENTER MONTH( Number between 1 - 12)"));
    this.add(month);
    this.add(new JLabel("ENTER DAY( Number between 1 - 31)"));
    this.add(day);

    portfolioValue.setActionCommand("ValueCalculationPage:portfolioValue");
    this.add(portfolioValue);

    costBasis.setActionCommand("ValueCalculationPage:costBasis");
    this.add(costBasis);

    backButton.setActionCommand("ValueCalculationPage:backButton");
    this.add(backButton);
  }

  @Override
  public void setListener(ActionListener buttonPress) {
    portfolioValue.addActionListener(buttonPress);
    costBasis.addActionListener(buttonPress);
    backButton.addActionListener(buttonPress);
  }

  /**
   * Method to get the year from the user.
   *
   * @return Returns the year as a string.
   */
  public String getYear() {
    return this.year.getText();
  }

  /**
   * Method to get the month from the user.
   *
   * @return Returns the month as a string.
   */
  public String getMonth() {
    return this.month.getText();
  }

  /**
   * Method to get the day from the year.
   *
   * @return Returns the day as a string.
   */
  public String getDay() {
    return this.day.getText();
  }

}
