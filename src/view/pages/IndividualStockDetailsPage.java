package view.pages;

import java.awt.event.ActionListener;
import java.awt.Button;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

/**
 * Class for displaying all individual stocks.
 */
public class IndividualStockDetailsPage extends JPanel implements Page {
  JTextField ticker = new JTextField();
  JTextField amount = new JTextField();
  JTextField year = new JTextField();
  JTextField month = new JTextField();
  JTextField day = new JTextField();
  JTextField commission = new JTextField();
  Button buyStockButton = new Button("Buy Stocks");
  Button backButton = new Button("Back");


  /**
   * The constructor for setting up the individual stock page.
   */
  public IndividualStockDetailsPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(new JLabel("ENTER TICKER SYMBOL"));
    this.add(ticker);
    this.add(new JLabel("ENTER AMOUNT"));
    this.add(amount);
    this.add(new JLabel("ENTER YEAR"));
    this.add(year);
    this.add(new JLabel("ENTER MONTH( Number between 1 - 12)"));
    this.add(month);
    this.add(new JLabel("ENTER DAY( Number between 1 - 7)"));
    this.add(day);
    this.add(new JLabel("ENTER COMMISSION"));
    this.add(commission);
    buyStockButton.setActionCommand("IndividualStockDetailsPage:buyStockButton");
    this.add(buyStockButton);
    backButton.setActionCommand("IndividualStockDetailsPage:backButton");
    this.add(backButton);
  }

  @Override
  public void setListener(ActionListener buttonPress) {
    buyStockButton.addActionListener(buttonPress);
    backButton.addActionListener(buttonPress);
  }

  /**
   * Method to get the ticker symbol from the user.
   *
   * @return Returns the ticker symbol as a string.
   */
  public String getTicker() {

    return ticker.getText();
  }

  /**
   * Method to get the amount from the user.
   *
   * @return Returns the amount as a string.
   */
  public String getAmount() {

    return amount.getText();
  }

  /**
   * Method to get the year from the user.
   *
   * @return Returns the year as a string.
   */
  public String getYear() {
    return year.getText();
  }

  /**
   * Method to get the month from the user.
   *
   * @return Returns the month as a string.
   */
  public String getMonth() {
    return month.getText();
  }

  /**
   * Method to get the day from the year.
   *
   * @return Returns the day as a string.
   */
  public String getDay() {
    return day.getText();
  }

  /**
   * Method to get the commission fees from the user.
   *
   * @return Returns the commission fees as a string.
   */
  public String getCommission() {
    return commission.getText();
  }

}
