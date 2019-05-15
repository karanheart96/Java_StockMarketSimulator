import model.Portfolio;
import model.PortfolioInterface;
import model.Simulator;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimulatorTest2 {

  @org.junit.Test
  public void normalStrategy() throws ParseException {
    Simulator a = new Simulator();
    PortfolioInterface p = a.createPortfolio("");
    a.addPortfolio(p);
    assertTrue(a.addCompany(0, "AAPL"));
    List<String> names = a.getListOfCompanies(0);
    HashMap<String, Double> nameAndWeights = new HashMap();
    for (int i = 0; i < names.size(); i++) {
      nameAndWeights.put(names.get(i), 1 / (double) names.size());
    }
    a.addWeight(0, nameAndWeights);
    String startDate = "07/01/2000";
    String endDate = "07/01/2001";
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);

    a.addCompany(0, "MSFT");
    nameAndWeights.put("AAPL", 0.5);
    nameAndWeights.put("MSFT", 0.5);
    a.addWeight(0, nameAndWeights);
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);
    assertEquals(a.displayAllPortfolios(), "1. Name: Portfolio 1\n"
            + "Stocks in Portfolio: \n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 20.94240837696335\n"
            + "Date Bought: 2000-01-07\n"
            + "Price: 95.5\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 16.869095816464238\n"
            + "Date Bought: 2000-03-08\n"
            + "Price: 118.56\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 15.936254980079681\n"
            + "Date Bought: 2000-04-07\n"
            + "Price: 125.5\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 21.829294913774284\n"
            + "Date Bought: 2000-06-07\n"
            + "Price: 91.62\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 38.365624400537115\n"
            + "Date Bought: 2000-07-07\n"
            + "Price: 52.13\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 34.63203463203463\n"
            + "Date Bought: 2000-09-06\n"
            + "Price: 57.75\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 95.23809523809524\n"
            + "Date Bought: 2000-10-06\n"
            + "Price: 21.0\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 142.85714285714286\n"
            + "Date Bought: 2000-12-06\n"
            + "Price: 14.0\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 124.53300124533003\n"
            + "Date Bought: 2001-01-05\n"
            + "Price: 16.06\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 9.318796011555307\n"
            + "Date Bought: 2000-01-07\n"
            + "Price: 107.31\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 10.471204188481675\n"
            + "Date Bought: 2000-01-07\n"
            + "Price: 95.5\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 10.989010989010989\n"
            + "Date Bought: 2000-03-08\n"
            + "Price: 91.0\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 8.434547908232119\n"
            + "Date Bought: 2000-03-08\n"
            + "Price: 118.56\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 11.764705882352942\n"
            + "Date Bought: 2000-04-07\n"
            + "Price: 85.0\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 7.968127490039841\n"
            + "Date Bought: 2000-04-07\n"
            + "Price: 125.5\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 14.898688915375446\n"
            + "Date Bought: 2000-06-07\n"
            + "Price: 67.12\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 10.914647456887142\n"
            + "Date Bought: 2000-06-07\n"
            + "Price: 91.62\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 12.413108242303872\n"
            + "Date Bought: 2000-07-07\n"
            + "Price: 80.56\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 19.182812200268557\n"
            + "Date Bought: 2000-07-07\n"
            + "Price: 52.13\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 14.427932477276006\n"
            + "Date Bought: 2000-09-06\n"
            + "Price: 69.31\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 17.316017316017316\n"
            + "Date Bought: 2000-09-06\n"
            + "Price: 57.75\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 18.264840182648403\n"
            + "Date Bought: 2000-10-06\n"
            + "Price: 54.75\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 47.61904761904762\n"
            + "Date Bought: 2000-10-06\n"
            + "Price: 21.0\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 17.83803068141277\n"
            + "Date Bought: 2000-12-06\n"
            + "Price: 56.06\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 71.42857142857143\n"
            + "Date Bought: 2000-12-06\n"
            + "Price: 14.0\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 21.026072329688812\n"
            + "Date Bought: 2001-01-05\n"
            + "Price: 47.56\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 62.26650062266501\n"
            + "Date Bought: 2001-01-05\n"
            + "Price: 16.06\n"
            + "Commission Fee: 10.0\n"
            + "\n"
            + "\n");
  }


  @org.junit.Test
  public void dateCheck() throws ParseException {
    Simulator a = new Simulator();
    PortfolioInterface p = a.createPortfolio("");
    a.addPortfolio(p);
    assertTrue(a.addCompany(0, "AAPL"));
    assertTrue(a.addCompany(0, "AMZN"));
    List<String> names = a.getListOfCompanies(0);
    HashMap<String, Double> nameAndWeights = new HashMap();
    for (int i = 0; i < names.size(); i++) {
      nameAndWeights.put(names.get(i), 1 / (double) names.size());
    }
    a.addWeight(0, nameAndWeights);
    String startDate = "20/11/2000";
    String endDate = "12/12/2012";
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);
    assertEquals(a.getPortfolioValueForPortfolio(0, 2018, 11, 1), 7214430.45586919, 0.01);
  }

  @org.junit.Test
  public void defaultWeights() throws ParseException {
    Simulator a = new Simulator();
    PortfolioInterface p = a.createPortfolio("");
    a.addPortfolio(p);
    assertTrue(a.addCompany(0, "AAPL"));
    assertTrue(a.addCompany(0, "AMZN"));
    List<String> names = a.getListOfCompanies(0);
    HashMap<String, Double> nameAndWeights = new HashMap();
    a.setDefaultWeights(0);
    String startDate = "20/11/2000";
    String endDate = "12/12/2012";
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);
    assertEquals(a.getCostBasisForPortfolio(0, 2018, 11, 5), 294920.0, 0.01);
  }

  @org.junit.Test
  public void buyingOnHoliday() throws ParseException {
    Simulator a = new Simulator();
    PortfolioInterface p = a.createPortfolio("");
    a.addPortfolio(p);
    assertTrue(a.addCompany(0, "AAPL"));
    assertTrue(a.addCompany(0, "AMZN"));
    List<String> names = a.getListOfCompanies(0);
    HashMap<String, Double> nameAndWeights = new HashMap();
    a.setDefaultWeights(0);
    String startDate = "20/11/2005";
    String endDate = "12/12/2012";
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);
    assertEquals(a.getCostBasisForPortfolio(0, 2018, 11, 5), 171700.0, 0.01);
  }


  @org.junit.Test
  public void portfOlioValueAndCostBasisWithCommission() throws ParseException {
    Simulator a = new Simulator();
    PortfolioInterface p = a.createPortfolio("");
    a.addPortfolio(p);
    assertTrue(a.addCompany(0, "AAPL"));
    assertTrue(a.addCompany(0, "AMZN"));
    List<String> names = a.getListOfCompanies(0);
    HashMap<String, Double> nameAndWeights = new HashMap();
    a.setDefaultWeights(0);
    String startDate = "20/11/2005";
    String endDate = "12/12/2012";
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);
    assertEquals(a.getCostBasisForPortfolio(0, 2018, 11, 5), 171700.0, 0.01);
    assertEquals(a.getPortfolioValueForPortfolio(0, 2018, 11, 5), 1924412.7991593368, 0.01);
  }

  @org.junit.Test
  public void noEndDate() throws ParseException {
    Simulator a = new Simulator();
    PortfolioInterface p = a.createPortfolio("");
    a.addPortfolio(p);
    assertTrue(a.addCompany(0, "AAPL"));
    assertTrue(a.addCompany(0, "AMZN"));
    List<String> names = a.getListOfCompanies(0);
    HashMap<String, Double> nameAndWeights = new HashMap();
    a.setDefaultWeights(0);
    String startDate = "20/11/2005";
    String endDate = "";
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);
    assertEquals(a.getCostBasisForPortfolio(0, 2018, 11, 5), 315120.0, 0.01);
    assertEquals(a.getPortfolioValueForPortfolio(0, 2018, 11, 5), 2251737.787040944, 0.01);
  }


  @org.junit.Test
  public void savingDataInFile() throws ParseException {
    Simulator a = new Simulator();
    PortfolioInterface p = a.createPortfolio("");
    a.addPortfolio(p);
    assertTrue(a.addCompany(0, "AAPL"));
    assertTrue(a.addCompany(0, "AMZN"));
    List<String> names = a.getListOfCompanies(0);
    HashMap<String, Double> nameAndWeights = new HashMap();
    a.setDefaultWeights(0);
    String startDate = "20/11/2005";
    String endDate = "20/11/2006";
    a.startStrategy(0, startDate, endDate, 30, 2000, 10);
    a.saveData();

  }


  @org.junit.Test
  public void retreivingDataFromFile() throws ParseException {
    Simulator a = new Simulator();
    a.retrieveData();
    assertEquals("[AAPL, AMZN]",a.getListOfCompanies(0).toString());
    assertEquals(Portfolio.STOCK_PRICE_DATA.toString(),"");
  }


}
