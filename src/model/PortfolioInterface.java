package model;

import java.util.HashMap;
import java.util.List;

/**
 * The interface which provides the functionality for 1)Calculating the value of a portfolio.
 * 2)Calculating the cost basis of the portfolio. 3)Adding the stock to the potfolio.
 */
public interface PortfolioInterface {

  /**
   * The function which calculates the portfolio's value.
   *
   * @param d The Date at which the value of the portfolio must be calculated.
   * @return Returns the portfolio's value at the particular date.
   * @throws IllegalStateException if date is invalid.
   */
  double getPortfolioValue(String d);

  /**
   * The function which calculates the costbasis of the portfolio.
   *
   * @param d The Date at which the costbasis must be calculated.
   * @return Returns the cost basis of the portfolio.
   * @throws IllegalStateException if date is invalid.
   */
  double getCostBasis(String d);

  /**
   * The function which adds the stock to the particular portfolio.
   *
   * @param name         Name of the company's stock.
   * @param noOfStocks   No of stocks to buy.
   * @param d            Date at which the stock must be bought. throws an IllegalStateException if
   *                     the company's name is invalid.
   * @param commsiionFee The commssion fee for buysing stock.
   */
  void buyStock(String name, double noOfStocks, String d, double commsiionFee);


  /**
   * The method to add company.
   *
   * @param companyName The company to be added.
   * @return if company is added or not.
   */
  boolean addCompany(String companyName);

  /**
   * Method to return all the companies in the portfolio.
   *
   * @return The list of companies stored in the portfolio.
   */
  List getNameOfCompanies();

  /**
   * Method to add the hashmap of weights.
   *
   * @param weights The Hashmap of the weights to be added.
   * @return if weight is added or not.
   */
  boolean addWeights(HashMap<String, Double> weights);

  /**
   * Method to return the weights of each company in the portfolio.
   *
   * @return The weights of each company.
   */
  HashMap<String, Double> getWeights();

  /**
   * The name of the portfolio.
   *
   * @return The name of portfolio as String.
   */
  String getNameOfPortfolio();

  /**
   * Method to get name of companies.
   *
   * @return The name of companies in portfolio as String;
   */
  String getCompaniesAsString();

  /**
   * Method to set default weights in a portfolio.
   */
  void setDefaultWeights();

}
