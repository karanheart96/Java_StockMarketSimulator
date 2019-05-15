package model;

import java.util.HashMap;

/**
 * The Stock class which has all the attributes and functionalities of a particular stock.
 */
public class Stock {
  double amount;
  String name;
  double number;
  String dateBought;
  double price;
  double commissionFee;
  HashMap<String, String> history;

  /**
   * The constructor which initializes the particular stock.
   *
   * @param name          The name of the stock.
   * @param dateBought    The Date at which the stock must be bought.
   * @param price         The Lowest price of the stock on a particular business day.
   * @param history       The History of the particular company's stock data.
   * @param amount        The amount to invest in the stock.
   * @param commissionFee The commssion fee to be invested.
   */
  public Stock(String name, String dateBought,
               double price, HashMap history,
               double amount, double commissionFee) {
    this.name = name;
    this.number = amount / price;
    this.dateBought = dateBought;
    this.price = price;
    this.history = history;
    this.amount = amount;
    this.commissionFee = commissionFee;

  }

  /**
   * The function which creates a new stockbuilder.
   *
   * @return Returns the stockbuilder object.
   */

  public static StockBuilder getBuilder() {
    return new StockBuilder();
  }

  /**
   * Method to convert stock object to string.
   *
   * @return All details of stock in String format.
   */
  @Override
  public String toString() {
    String output = "";
    output = output + "Name: ";
    output = output + this.name + "\n";
    output = output + "Total stocks Owned: ";
    output = output + this.number + "\n";
    output = output + "Date Bought: ";
    output = output + this.dateBought + "\n";
    output = output + "Price: ";
    output = output + this.price + "\n";
    output = output + "Commission Fee: ";
    output = output + this.commissionFee + "\n";

    return output;
  }

  /**
   * The function which calculates the value of a particular stock.
   *
   * @param date The Date at which the value of the stock must be calculated.
   * @return Returns the value of the stock. throws IllegalStateException if the stock is not
   *         present.
   */
  public double getValue(String date) {
    double value = 0;
    String line;
    String joinDate = date.replace("-", "");
    String joinDateBought = this.dateBought.replace("-", "");

    if (Integer.parseInt(joinDateBought) > Integer.parseInt(joinDate)) {
      return 0;
    }
    double cost;
    try {
      cost = this.number * Double.parseDouble(history.get(date));
    } catch (Exception e) {
      throw new IllegalStateException("NULL POINTER");
    }
    return cost;

  }

  /**
   * The function which calculates the cost of a particular stock.
   *
   * @param date The Date at which the cost of the stock must be calculated.
   * @return Returns the cost of the stock. throws IllegalStateException if the stock is not
   *         present.
   */
  public double getCost(String date) {
    double value = 0;
    String line;
    String joinDate = date.replace("-", "");
    String joinDateBought = this.dateBought.replace("-", "");

    if (Integer.parseInt(joinDateBought) > Integer.parseInt(joinDate)) {
      return 0;
    }
    double cost;
    try {
      cost = this.number * Double.parseDouble(history.get(this.dateBought));
    } catch (Exception e) {
      throw new IllegalStateException("NULL POINTER");
    }
    return cost + this.commissionFee;
  }

  public String getName() {
    return this.name;
  }


}
