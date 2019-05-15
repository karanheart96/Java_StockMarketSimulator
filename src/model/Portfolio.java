package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * The portfolio class which has all functionalities, associated with a particular user's portfolio.
 * This class implements the portfolio interface.
 */
public class Portfolio implements PortfolioInterface {
  static int portfolioNumber = 0;
  List<Stock> stocks;
  String name;
  public static LinkedHashMap<String, HashMap<String, String>> STOCK_PRICE_DATA;
  List<String> companyNames;
  HashMap<String, Double> weights;


  /**
   * The constructor which creates a portfolio with the default name.
   */
  public Portfolio() {
    stocks = new LinkedList<Stock>();
    name = "Portfolio " + (portfolioNumber + 1);
    portfolioNumber++;
    STOCK_PRICE_DATA = new LinkedHashMap<>();
    companyNames = new LinkedList<>();
    weights = new HashMap<String, Double>();
  }

  /**
   * The constructor which creates a portfolio with the name given by the user.
   *
   * @param name The name of the portfolio specified by the user.
   */
  public Portfolio(String name) {
    stocks = new LinkedList<Stock>();
    this.name = name;
    portfolioNumber++;
    STOCK_PRICE_DATA = new LinkedHashMap<>();
    companyNames = new LinkedList<>();
    weights = new HashMap<String, Double>();
  }

  @Override
  public double getPortfolioValue(String d) {
    double value = 0;
    try {
      for (int i = 0; i < this.stocks.size(); i++) {
        value = value + this.stocks.get(i).getValue(d);
      }
    } catch (Exception e) {
      throw new IllegalStateException("NO DATE PRESENT");
    }
    return value;
  }

  @Override
  public double getCostBasis(String d) {
    double value = 0;
    try {
      for (int i = 0; i < this.stocks.size(); i++) {
        value = value + this.stocks.get(i).getCost(d);
      }
    } catch (Exception e) {
      throw new IllegalStateException("NO DATE PRESENT");
    }
    return value;

  }

  @Override
  public void buyStock(String name, double amount, String d, double commissionFee) {
    if (!STOCK_PRICE_DATA.containsKey(name)) {
      try {
        STOCK_PRICE_DATA.put(name,
                this.createHashMap(this.getDataFromAPI(name)));
      } catch (Exception e) {
        throw new IllegalStateException("The name of company doesn't exist in the database");
      }
    }
    if (amount <= 0 || commissionFee < 0) {
      throw new IllegalArgumentException("Negative stocks");
    }
    Stock stockToBuy = Stock.getBuilder()
            .name(name)
            .dateBought(d)
            .amount(amount)
            .price(Double.parseDouble(STOCK_PRICE_DATA.get(name).get(d)))
            .history(STOCK_PRICE_DATA.get(name))
            .commissionFee(commissionFee)
            .build();
    if (!this.companyNames.contains(name)) {
      this.companyNames.add(name);
    }
    this.stocks.add(stockToBuy);
  }

  @Override
  public boolean addCompany(String companyName) {
    if (!this.companyNames.contains(companyName)) {
      try {
        if (!STOCK_PRICE_DATA.containsKey(companyName)) {
          STOCK_PRICE_DATA.put(companyName,
                  this.createHashMap(this.getDataFromAPI(companyName)));
        }
        this.companyNames.add(companyName);
      } catch (Exception e) {
        return false;
      }
      return true;
    }
    return true;
  }

  @Override
  public List getNameOfCompanies() {

    return companyNames;
  }

  @Override
  public boolean addWeights(HashMap<String, Double> weights) {
    double sum = 0;
    for (String key : weights.keySet()) {
      sum = sum + weights.get(key);
    }
    if (sum <= 1 && sum >= 0.9) {
      this.weights = weights;
      return true;
    }
    return false;

  }

  @Override
  public HashMap<String, Double> getWeights() {
    return this.weights;
  }

  @Override
  public String getNameOfPortfolio() {
    return this.name;
  }

  @Override
  public String getCompaniesAsString() {
    String output = "";

    for (int i = 0; i < companyNames.size(); i++) {
      output = output + companyNames.get(i) + "\n";
    }
    return output;
  }

  @Override
  public void setDefaultWeights() {
    for (int i = 0; i < companyNames.size(); i++) {
      weights.put(companyNames.get(i), 1 / (double) companyNames.size());
    }
  }


  /**
   * Function to make a hashmap for the given companhy and its data.
   *
   * @param apiOutput The output given by api as String
   * @return Hashmap containg stock price.
   */
  private HashMap<String, String> createHashMap(String apiOutput) {
    LinkedHashMap<String, String> companyData = new LinkedHashMap<>();
    Scanner outputString = new Scanner(apiOutput);
    outputString.nextLine();
    String line;
    while (outputString.hasNextLine()) {
      line = outputString.nextLine();
      String[] data = line.split(",");
      companyData.put(data[0], data[4]);
    }
    return companyData;
  }

  /**
   * The function which gets us data for the specific comapny.
   *
   * @param nameOfCompany Name of company we need stock data for.
   * @return The entire history of stock data as a string.
   */
  private String getDataFromAPI(String nameOfCompany) {
    //the API key needed to use this web service.
    //Please get your own free API key here: https://www.alphavantage.co/
    //Please look at documentation here: https://www.alphavantage.co/documentation/
    String apiKey = "DKKRC89YOPSL6NTK";
    String stockSymbol = nameOfCompany; //ticker symbol for Google
    URL url = null;

    try {
      /*
      create the URL. This is the query to the web service. The query string
      includes the type of query (DAILY stock prices), stock symbol to be
      looked up, the API key and the format of the returned
      data (comma-separated values:csv). This service also supports JSON
      which you are welcome to use.
       */
      url = new URL("https://www.alphavantage"
              + ".co/query?function=TIME_SERIES_DAILY"
              + "&outputsize=full"
              + "&symbol"
              + "=" + stockSymbol + "&apikey=" + apiKey + "&datatype=csv");
    } catch (MalformedURLException e) {
      throw new RuntimeException("the alphavantage API has either changed or "
              + "no longer works");
    }

    InputStream in = null;
    StringBuilder output = new StringBuilder();

    try {
      /*
      Execute this query. This returns an InputStream object.
      In the csv format, it returns several lines, each line being separated
      by commas. Each line contains the date, price at opening time, highest
      price for that date, lowest price for that date, price at closing time
      and the volume of trade (no. of shares bought/sold) on that date.

      This is printed below.
       */
      in = url.openStream();
      int b;

      while ((b = in.read()) != -1) {
        output.append((char) b);
      }
    } catch (IOException e) {
      throw new IllegalArgumentException("No price data found for " + stockSymbol);
    }
    return output.toString();
  }


  @Override
  public String toString() {
    String output = "";
    output = output + "Name: " + this.name + "\n";
    output = output + "Stocks in Portfolio: \n";
    for (int i = 0; i < stocks.size(); i++) {
      output = output + stocks.get(i).toString() + "\n";
    }
    return output;
  }


}
