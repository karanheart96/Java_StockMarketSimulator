package view;

import java.io.IOException;
import java.util.HashMap;

/**
 * The interface for view.
 */
public interface SimulationViewInterface {

  /**
   * Method to display the menu and append it to output.
   *
   * @param menu The menu
   * @param out  THE APPENDABLE OBJECT FOR OUTPUT.
   * @throws IOException for the Appendable object.
   */
  void displayMenu(HashMap<String, String> menu, Appendable out) throws IOException;

  /**
   * Method to display all portfolios.
   *
   * @param allPortfolios The portfolios to display.
   * @param out           THE Appendable object for output.
   * @throws IOException for the Appendable object.
   */
  void displayAllPortfolio(String allPortfolios, Appendable out) throws IOException;

  /**
   * Method to display the create portfolio page.
   *
   * @param out The appendable object.
   * @throws IOException for the Appendable object.
   */
  void createPortfolio(Appendable out) throws IOException;

  /**
   * Method to append the given input string to the output.
   *
   * @param input The input to append to out.
   * @param out   The appendable object.
   * @throws IOException for the Appendable object.
   */
  void returnGivenString(String input, Appendable out) throws IOException;

  /**
   * Method to display a single portfolio.
   *
   * @param portfolioToDisplay The portfolio to display.
   * @param out                The appendable object.
   * @throws IOException for the Appendable object.
   */
  void displaySinglePortfolio(String portfolioToDisplay, Appendable out) throws IOException;

  /**
   * The options on the page valuePage.
   *
   * @param out The appendable object.
   * @throws IOException for the Appendable object.
   */
  void valuePageOptions(Appendable out) throws IOException;

  /**
   * Method to append cost basis to screen.
   *
   * @param costBasis The cost basis value to display.
   * @param out       The appendable object.
   * @throws IOException for the Appendable object.
   */
  void displayCostBasis(double costBasis, Appendable out) throws IOException;

  /**
   * Method to display the portfolio value.
   *
   * @param portfolioValue The portfolio value to display.
   * @param out            The appendable object.
   * @throws IOException for the Appendable object.
   */
  void displayPortfolioValue(double portfolioValue, Appendable out) throws IOException;

  /**
   * EditPortfolio page.
   *
   * @param allPortfolios All the current portfolios to display.
   * @param out           The appendable object.
   * @throws IOException for the Appendable object.
   */
  void displayEditPortfolios(String allPortfolios, Appendable out) throws IOException;

  /**
   * Page to display the strategy to be applied.
   *
   * @param out The appendable object.
   * @throws IOException for Appendable object.
   */
  void strategyNames(Appendable out) throws IOException;

  /**
   * Mehtod to print company names.
   *
   * @param companyNames The name of companies to display
   * @param out          Appendable object.
   * @throws IOException Appendable object.
   */
  void displayAllCompanies(String companyNames, Appendable out) throws IOException;


}
