package view.pages;

import java.awt.Button;

import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javax.swing.JTextField;

import javax.swing.BoxLayout;

import javax.swing.JLabel;

/**
 * Class for displaying dates and Interval.
 */
public class DatesAndIntervalsPage extends JPanel implements Page {

  JTextField startDate = new JTextField();
  JTextField endDate = new JTextField();
  JTextField interval = new JTextField();
  JTextField commission = new JTextField();
  JTextField amount = new JTextField();

  Button buyStockButton = new Button("Start Strategy");
  Button backButton = new Button("Back");

  /**
   * Thters.e constructor for setting the parame
   */
  public DatesAndIntervalsPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.add(new JLabel("ENTER START DATE dd/MM/YYYY"));
    this.add(startDate);
    this.add(new JLabel("ENTER END DATE dd/MM/YYYY"));
    this.add(endDate);
    this.add(new JLabel("ENTER INTERVAL IN DAYS"));
    this.add(interval);
    this.add(new JLabel("ENTER AMOUNT"));
    this.add(amount);
    this.add(new JLabel("ENTER COMMISSION"));
    this.add(commission);
    buyStockButton.setActionCommand("DatesAndIntervalsPage:buyStockButton");
    this.add(buyStockButton);
    backButton.setActionCommand("DatesAndIntervalsPage:backButton");
    this.add(backButton);
  }


  @Override
  public void setListener(ActionListener buttonPress) {
    buyStockButton.addActionListener(buttonPress);
    backButton.addActionListener(buttonPress);
  }


  /**
   * Method to get the start date from the user.
   * @return Returns the start date as a string.
   */
  public String getStartDate() {
    return startDate.getText();
  }

  /**
   * Method to get the end date from the user.
   * @return Returns the end date as a string.
   */
  public String getEndDate() {
    return endDate.getText();
  }

  /**
   * Method to get the interval period from the user.
   * @return Returns the interval period as a string.
   */
  public String getInterval() {
    return interval.getText();
  }

  /**
   * Method to get the commission fees from the user.
   * @return Returns the commission fees as a string.
   */
  public String getCommission() {
    return commission.getText();
  }

  /**
   * Method to get the amount from the user.
   * @return Returns the amount as a string.
   */
  public String getAmount() {
    return amount.getText();
  }

}
