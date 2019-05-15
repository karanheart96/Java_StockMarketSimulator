package model;

import java.text.ParseException;
import java.util.HashMap;

import java.util.List;

/**
 * The Simulator Interface which provides all the functionalities for a simulator.
 */
public interface SimulatorInterface {

  /**
   * Adds the portfolio to the user's account.
   *
   * @param p The portfolio to be added.
   */
  void addPortfolio(PortfolioInterface p);

  /**
   * Display's all the portfolio and its contents.
   *
   * @return Returns a string which display's the, portfolio and its contents.
   */
  String displayAllPortfolios();

  /**
   * Creates a new Portfolio.
   *
   * @param name The name of the portfolio to be created.
   * @return Returns the newly created portfolio.
   */
  PortfolioInterface createPortfolio(String name);

  /**
   * Fetches and prints the particular portfolio's contents.
   *
   * @param portfolioNumber The index of the portfolio to be fetched.
   * @return Returns the particular portfolio and its contents.
   */
  String getPortfolio(int portfolioNumber);

  /**
   * The function which buys the stock and places it into the portfolio.
   *
   * @param portfolioNumber The portfolio number inside which, the newly bought stock must be
   *                        placed.
   * @param ticker          The Ticker symbol of the stock to be bought.
   * @param amount          The amount invested in the company.
   * @param year            The year in which the stock must be bought.
   * @param month           The month in which the stock must be bought.
   * @param day             The day in which the stock must be bought.throws IllegalStateException
   *                        if any of the provided data is wrong.
   * @param commissionFee   The commissionFee for buying stock.
   */
  void buyStockForPortfolio(int portfolioNumber, String ticker,
                            double amount, int year, int month, int day, double commissionFee);

  /**
   * The function which calculates the cost basis for the particular portfolio.
   *
   * @param portfolioNumber The Portfolio number for which, cost basis must be calculated.
   * @param year            The year in which the cost basis must be calculated.
   * @param month           The month in which the cost basis must be calculated.
   * @param day             The day in which the cost basis must be calculated.
   * @return Returns the cost basis value for the particular portfolio.
   * @throws IllegalStateException if any of the provided data is wrong.
   */
  double getCostBasisForPortfolio(int portfolioNumber, int year, int month, int day);

  /**
   * The function which calculates the portfolio's value for the specified portfolio.
   *
   * @param portfolioNumber The Portfolio number for which the value must be calculated.
   * @param year            The year in which the portfolio's value must be calculated.
   * @param month           The month in which the portfolio's value must be calculated.
   * @param day             The day in which the portfolio's value must be cal
   * @return Returns the portfolio's value .
   * @throws IllegalStateException if any of the provided data is wrong.
   */
  double getPortfolioValueForPortfolio(int portfolioNumber, int year, int month, int day);


  /**
   * The method to add company to the portfolio.
   *
   * @param portfolioNumber The portfolio to which we need to add company
   * @param company         The ticker symbol of company to add.
   * @return if company successfully added or not.
   */
  boolean addCompany(int portfolioNumber, String company);

  /**
   * The method to add weights to the portfolio.
   *
   * @param weights         The weights to be given to each company in the portfolio.
   * @param portfolioNumber The portfolio in which to add.
   * @return if the weight is added or not.
   */
  boolean addWeight(int portfolioNumber, HashMap weights);


  /**
   * Method to start dollar average strategy.
   *
   * @param portfolioNumber The portfolio number.
   * @param startDate       The start date of strategy
   * @param endDate         The endDate of strategy.
   * @param days            The interval.
   * @param amount          The amount to invest per interval.
   * @param commissionFee   The commission fee.
   * @throws ParseException for wrong parsing of date.
   */
  void startStrategy(int portfolioNumber, String startDate,
                     String endDate, int days, double amount,
                     double commissionFee) throws ParseException;

  /**
   * Returns list of companies in the portfolio.
   *
   * @param portfolioNumber The portfolio whose names we need.
   * @return The List of names.
   */
  List getListOfCompanies(int portfolioNumber);

  /**
   * Method to get Portfolio names.
   *
   * @return Name of all stored portfolios as string;
   */
  String getPortfolioNames();

  /**
   * Method to get company names as String.
   *
   * @param portfolioNumber The portfolio number to select.
   * @return The name of companies as string;
   */
  String getPortfolioCompanies(int portfolioNumber);

  /**
   * The method to set default weights.
   *
   * @param portfolioNumber The portfolio whose weights you want to set;
   */
  void setDefaultWeights(int portfolioNumber);


  /**
   * The method to save all the portfolios stored inside the Simulator.
   */
  void saveData();

  /**
   * The method to retrieve all the past portfolios stored inside the Simulator.
   */
  void retrieveData();

  HashMap<String,String> getHashMapOfPortFolios();



}
