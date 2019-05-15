package model;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class StaticPortfolioHistorySaver {
  LinkedHashMap<String, HashMap<String, String>> stockPriceHistory;
  int portFolioNumber;

  public StaticPortfolioHistorySaver(LinkedHashMap<String,
          HashMap<String, String>> stockPriceHistory,
                                     int number) {
    this.stockPriceHistory = stockPriceHistory;
    this.portFolioNumber = number;
  }

  public LinkedHashMap<String, HashMap<String, String>> getStockPriceHistory() {
    return stockPriceHistory;
  }

  public int numberOfPortfolio() {
    return portFolioNumber;
  }

}
