package model;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

/**
 * Class for a mock model for testing.
 */
public class MockSimulator implements SimulatorInterface {

  private StringBuilder log;
  private final int uniqueCode;

  /**
   * Constructor for initializing log.
   *
   * @param log        For logging the input.
   * @param uniqueCode For returning unique code.
   */
  public MockSimulator(StringBuilder log, int uniqueCode) {
    this.log = log;
    this.uniqueCode = uniqueCode;
  }

  @Override
  public void addPortfolio(PortfolioInterface p) {
    log.append("Input is " + p);
  }

  @Override
  public String displayAllPortfolios() {
    return null;
  }

  @Override
  public PortfolioInterface createPortfolio(String name) {
    log.append("Input is " + name + uniqueCode);
    return null;
  }

  @Override
  public String getPortfolio(int portfolioNumber) {
    log.append("Input is " + portfolioNumber);
    return null;
  }

  @Override
  public void buyStockForPortfolio(int portfolioNumber, String ticker,
                                   double amount, int year, int month,
                                   int day, double commissionFee) {
    log.append("Input is "
            + portfolioNumber + "\n"
            + ticker + "\n"
            + amount + "\n"
            + year + "\n"
            + month + "\n"
            + day + "\n"
            + commissionFee + uniqueCode);
  }

  @Override
  public double getCostBasisForPortfolio(int portfolioNumber, int year, int month, int day) {
    log.append("Input is "
            + portfolioNumber + "\n"
            + year + "\n"
            + month + "\n"
            + day + " " + uniqueCode);
    return 0;
  }

  @Override
  public double getPortfolioValueForPortfolio(int portfolioNumber, int year, int month, int day) {
    log.append("Input is "
            + portfolioNumber + "\n"
            + year + "\n"
            + month + "\n"
            + day + uniqueCode);
    return 0;
  }

  @Override
  public boolean addCompany(int portfolioNumber, String company) {
    log.append("Input is "
            + portfolioNumber + "\n"
            + company + uniqueCode);
    return false;
  }

  @Override
  public boolean addWeight(int portfolioNumber, HashMap weights) {
    log.append("Input is "
            + portfolioNumber + "\n"
            + weights + uniqueCode);
    return false;
  }

  @Override
  public void startStrategy(int portfolioNumber, String startDate, String endDate,
                            int days, double amount, double commissionFee) throws ParseException {
    log.append("Input is "
            + portfolioNumber + "\n"
            + startDate + "\n"
            + endDate + "\n"
            + days + "\n"
            + amount + "\n"
            + commissionFee + uniqueCode);
  }

  @Override
  public List getListOfCompanies(int portfolioNumber) {
    log.append("Input is "
            + portfolioNumber + "\n" + uniqueCode);
    return null;
  }

  @Override
  public String getPortfolioNames() {
    return null;
  }

  @Override
  public String getPortfolioCompanies(int portfolioNumber) {
    log.append("Input is "
            + portfolioNumber + "\n" + uniqueCode);
    return null;
  }

  @Override
  public void setDefaultWeights(int portfolioNumber) {
    log.append("Input is "
            + portfolioNumber + "\n" + uniqueCode);
  }

  @Override
  public void saveData() {
  // mock saveData to check controller.
  }

  @Override
  public void retrieveData() {
  // mock retreiveData to check controller.
  }

  @Override
  public HashMap<String, String> getHashMapOfPortFolios() {
    return null;
  }
}
