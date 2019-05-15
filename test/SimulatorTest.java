import model.Portfolio;
import model.PortfolioInterface;
import model.Simulator;
import model.SimulatorInterface;

import static org.junit.Assert.assertEquals;

public class SimulatorTest {

  //Multiple portfolios and one portfolio with multiple stocks
  @org.junit.Test
  public void addPortfolio() {
    PortfolioInterface p = new Portfolio();
    PortfolioInterface p1 = new Portfolio();
    String myDate = "2014-10-29";
    p.buyStock("AAPL", 5, myDate, 0);
    p.buyStock("MSFT", 4, myDate, 0);
    p.buyStock("GOOG", 5, myDate, 0);
    p1.buyStock("AMZN", 5, myDate, 0);
    SimulatorInterface s1 = new Simulator();
    s1.addPortfolio(p);
    s1.addPortfolio(p1);

    assertEquals("1. Name: Portfolio 1\n"
            + "Stocks in Portfolio: \n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 5\n"
            + "Date Bought: 2014-10-29\n"
            + "Price: 106.36\n"
            + "\n"
            + "Name: MSFT\n"
            + "Total stocks Owned: 4\n"
            + "Date Bought: 2014-10-29\n"
            + "Price: 46.34\n"
            + "\n"
            + "Name: GOOG\n"
            + "Total stocks Owned: 5\n"
            + "Date Bought: 2014-10-29\n"
            + "Price: 546.98\n"
            + "\n"
            + "\n"
            + "2. Name: Portfolio 2\n"
            + "Stocks in Portfolio: \n"
            + "Name: AMZN\n"
            + "Total stocks Owned: 5\n"
            + "Date Bought: 2014-10-29\n"
            + "Price: 293.0701\n"
            + "\n"
            + "\n", s1.displayAllPortfolios());
  }

  @org.junit.Test
  public void createPortfolio() {
    SimulatorInterface s1 = new Simulator();
    PortfolioInterface p = s1.createPortfolio("");
    String myDate = "2014-10-29";
    p.buyStock("AAPL", 5, myDate, 0);
    s1.addPortfolio(p);
    assertEquals("1. Name: Portfolio 1\n"
            + "Stocks in Portfolio: \n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 5\n"
            + "Date Bought: 2014-10-29\n"
            + "Price: 106.36\n"
            + "\n"
            + "\n", s1.displayAllPortfolios());
  }


  @org.junit.Test
  public void portfolioValue() {
    PortfolioInterface p = new Portfolio();
    String myDate = "2014-10-29";
    p.buyStock("AAPL", 5, myDate, 0);
    p.buyStock("MSFT", 4, myDate, 0);
    p.buyStock("GOOG", 5, myDate, 0);
    assertEquals(0, p.getPortfolioValue("2013-10-29"), 0.1);
  }

  @org.junit.Test
  public void costBasis() {
    PortfolioInterface p = new Portfolio();
    String myDate = "2014-10-29";
    p.buyStock("AAPL", 5, myDate, 0);
    myDate = "2015-10-29";
    p.buyStock("AAPL", 5, myDate, 0);
    SimulatorInterface s1 = new Simulator();
    //s1.addPortfolio(p);
    //assertEquals("",s1.displayAllPortfolios());
    assertEquals(1123.15, p.getCostBasis("2016-10-29"), 0.1);

  }

  @org.junit.Test
  public void displayAllPortfolios() {
    SimulatorInterface s1 = new Simulator();
    PortfolioInterface p = s1.createPortfolio("Retirement");
    s1.addPortfolio(p);
    s1.buyStockForPortfolio(1, "AAPL", 1, 2018, 11, 9, 0);
    assertEquals("1. Name: Retirement\n"
            + "Stocks in Portfolio: \n"
            + "Name: AAPL\n"
            + "Total stocks Owned: 1\n"
            + "Date Bought: 2018-11-09\n"
            + "Price: 202.25\n"
            + "\n"
            + "\n", s1.displayAllPortfolios());

  }


}