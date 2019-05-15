package view;

import java.awt.event.ActionListener;
import java.util.List;

public interface GraphicalView {

  /**
   * Method to setup the initial frame.
   */
  void setFrame();

  /**
   * Method to setup the menu page panel.
   */
  void setMenuPage(ActionListener e);


  /**
   * Method to setup a new portfolio.
   */
  void setCreatePortfolio(ActionListener e);

  /**
   * Method to get the portfolio name from the user.
   *
   * @return Returns the portfolio name as a string.
   */
  String getPortfolioName();

  /**
   * Method to get the portfolio number from the user.
   *
   * @return Returns the portfolio number as a string.
   */
  String getPortfolioNumber();

  /**
   * Method to display all portfolios with its respective companies.
   *
   * @param companyNames The companies belonging to each portfolio.
   */
  void setDisplayAllPortfolio(String companyNames, ActionListener e);

  /**
   * Method to set the page for buying individual stocks.
   *
   * @param nameOfPortfolios The name of portfolio for which the stock must be bought.
   */
  void setBuyIndividualStockPage(String nameOfPortfolios, ActionListener controller);

  /**
   * Method to set the page for displaying bought individual stocks.
   */
  void setIndividualStockDetailPage(ActionListener controller);

  /**
   * Method to get the ticker symbol from the user.
   *
   * @return Returns the ticker symbol as a string.
   */
  String getTicker();

  /**
   * Method to get the year from the user.
   *
   * @return Returns the year as a string.
   */
  String getYear();

  /**
   * Method to get the month from the user.
   *
   * @return Returns the month as a string.
   */
  String getMonth();

  /**
   * Method to get the day from the year.
   *
   * @return Returns the day as a string.
   */
  String getDay();

  /**
   * Method to get the amount from the user.
   *
   * @return Returns the amount as a string.
   */
  String getAmount();

  /**
   * Method to get the commission fees from the user.
   *
   * @return Returns the commission fees as a string.
   */
  String getCommission();

  /**
   * Method to set the page for displaying all portfolios.
   *
   * @param portfolioNames The portfolio names which is to be displayed.
   */
  void strategyAllPortfoliosPage(String portfolioNames, ActionListener controller);

  /**
   * Method to get the portfolio number for strategy based investment.
   *
   * @return Returns the strategy number as a string.
   */
  String getPortfolioNumberStrategy();

  /**
   * Method to set the page for listing the strategies available.
   */
  void setStrategyListPage(ActionListener controller);


  /**
   * Method to get the strategy as whether portfolio value or cost basis.
   *
   * @return Returns the selected strategy choice as a string.
   */
  String getStrategyNumber();

  /**
   * Method to include more companies.
   *
   * @param companies The companies to be included.
   */

  void setMoreCompaniesPage(List<String> companies, ActionListener controller);

  /**
   * Method to display the page for asking ticker symbol.
   */

  void setAskTickerSymbol(ActionListener controller);

  /**
   * Method to get the ticker symbol for strategy based investment.
   *
   * @return Returns the symbol as a string.
   */

  String getTickerStrategy(ActionListener controller);

  /**
   * Method to set the page for getting weights input.
   */

  void setWeightsPage(ActionListener controller);

  /**
   * Method to set the page for getting weights based on number of companies.
   *
   * @param companies The companies for which weights must be provided.
   */

  void setDynamicWeightsPage(List<String> companies, ActionListener controller);

  /**
   * Method to get the weights from the user.
   *
   * @return Returns the weights as a string.
   */

  String getWeights();

  /**
   * Method to get the start date from the user.
   *
   * @return Returns the start date as a string.
   */
  String getStartDate();

  /**
   * Method to get the end date from the user.
   *
   * @return Returns the end date as a string.
   */
  String getEndDate();

  /**
   * Method to add commission fees for strategy based investment.
   *
   * @return Returns the commission fees as a string.
   */

  String getCommissionStrategy();

  /**
   * Method to get the interval from the user.
   *
   * @return Returns the interval as a string.
   */

  String getInterval();

  /**
   * Method to set the dates and intervals for a portfolio.
   */

  void setDatesAndIntervalsPage(ActionListener controller);

  /**
   * Method to get the amount for strategy based investment.
   *
   * @return Returns the amount which was got as a string.
   */

  String getAmountStrategy();

  /**
   * Method to select the portfolio for which cost must be calculated.
   *
   * @param nameofPortfolios Name of the selected portfolio.
   */

  void setPortfolioForCost(String nameofPortfolios, ActionListener controller);

  /**
   * Method to calculate the cost for the selected portfolio.
   *
   * @return Returns the cost basis for the portfolio.
   */

  String getPortfolioNumberCost();

  /**
   * Method to set the page for displaying the value calculated.
   */

  void setValueCalculationPage(ActionListener a);

  /**
   * Method to get the year for cost basis calculation.
   *
   * @return Returns the year as a string.
   */

  String getYearValue();

  /**
   * Method to get the month for cost basis calculation.
   *
   * @return Returns the month as a string.
   */
  String getMonthValue();

  /**
   * Method to get the day for cost basis calculation.
   *
   * @return Returns the day as a string.
   */
  String getDayValue();

}
