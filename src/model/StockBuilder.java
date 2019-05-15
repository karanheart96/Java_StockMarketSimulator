package model;

import java.util.HashMap;

/**
 * The StockBuilder class which initializes the stocks.
 */
public class StockBuilder {
  String name;
  String dateBought;
  double price;
  HashMap history;
  double amount;
  double commissionFee;

  /**
   * The default constructor which assigns the default values.
   */
  public StockBuilder() {
    name = "";
    dateBought = null;
    price = 0;
    amount = 0;
    commissionFee = 0;
  }

  /**
   * The Function which assigns the history of stocks bought.
   *
   * @param history The history
   * @return Returns the stockbuilder object.
   */
  public StockBuilder history(HashMap history) {
    this.history = history;
    return this;
  }

  /**
   * The Function which assigns name of the stock.
   *
   * @param name The name of the stock to be bought.
   * @return Returns the stockbuilder object.
   */
  public StockBuilder name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The Function which assigns the number of the stock.
   *
   * @param amount The amount to be invested in the stock.
   * @return Returns the stockbuilder object.
   */
  public StockBuilder amount(double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * The Function which assigns the date in which the stock was bought.
   *
   * @param date The date at which the stock should be bought.
   * @return Returns the stockbuilder object.
   */
  public StockBuilder dateBought(String date) {
    this.dateBought = date;
    return this;
  }

  /**
   * The Function which assigns the price of the stock.
   *
   * @param price The price of the stock.
   * @return Returns the stockbuilder object.
   */
  public StockBuilder price(double price) {
    this.price = price;
    return this;
  }

  public StockBuilder commissionFee(double commissionFee) {
    this.commissionFee = commissionFee;
    return this;
  }


  /**
   * The Function builds the stock.
   *
   * @return Returns the stock which was created.
   */
  public Stock build() {
    return new Stock(this.name,
            this.dateBought,
            this.price, this.history, this.amount, this.commissionFee);
  }


}
