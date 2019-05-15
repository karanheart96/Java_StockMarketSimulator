package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * The Simulator class which acts as a virtual simulation, between the user and the application.
 */
public class Simulator implements SimulatorInterface {
  List<PortfolioInterface> portfolios = new ArrayList<>();
  HashMap<String, String> portfolioNames = new HashMap<>();
  int portfolioNumber = 0;

  @Override
  public PortfolioInterface createPortfolio(String name) {
    if (name == null || name.equals("")) {
      return new Portfolio();
    }
    return new Portfolio(name);
  }

  @Override
  public String getPortfolio(int portfolioNumber) {
    return portfolios.get(portfolioNumber - 1).toString();
  }

  private boolean isLeapYear(int year) {
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        return year % 400 == 0;
      } else {
        return true;
      }

    } else {
      return false;
    }

  }

  /**
   * Method to check if the date is a valid date.
   *
   * @param year  the year.
   * @param month the month of the year.
   * @param day   the day of the week.
   * @return if its the correct date.
   */
  private boolean checkDate(int year, int month, int day) {
    if (year < 999) {
      return false;
    } else if (month < 1 || month > 12) {
      return false;
    } else if (day < 1) {
      return false;
    } else if (month == 1 && day > 31) {
      return false;
    } else if (month == 2) {
      if (isLeapYear(year)) {
        if (day > 29) {
          return false;
        }
      } else {
        if (day > 28) {
          return false;
        }
      }

    } else if (month == 3 && day > 30) {
      return false;
    } else if (month == 4 && day > 31) {
      return false;
    } else if (month == 5 && day > 30) {
      return false;
    } else if (month == 6 && day > 31) {
      return false;
    } else if (month == 7 && day > 30) {
      return false;
    } else if (month == 8 && day > 31) {
      return false;
    } else if (month == 9 && day > 30) {
      return false;
    } else if (month == 10 && day > 31) {
      return false;
    } else if (month == 11 && day > 30) {
      return false;
    } else if (month == 12 && day > 31) {
      return false;
    }
    return true;
  }

  /**
   * Method to check whether the date is a weekend.
   *
   * @param year  the year.
   * @param month the month of the year.
   * @param day   the day of the week.
   * @return if its weekend or not.
   */
  private boolean checkWeekend(int year, int month, int day) {
    String dayString;
    String monthString;
    if (day < 10) {
      dayString = "0" + Integer.toString(day);
    } else {
      dayString = Integer.toString(day);
    }
    if (month < 10) {
      monthString = "0" + Integer.toString(month);
    } else {
      monthString = Integer.toString(month);
    }

    String inputDate = dayString
            + "/"
            + monthString
            + "/"
            + Integer.toString(year);
    SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
    Date dt1 = null;

    {
      try {
        dt1 = format1.parse(inputDate);
      } catch (ParseException e) {
        throw new IllegalArgumentException("Formatting error for date");
      }
    }

    DateFormat format2 = new SimpleDateFormat("EEEE");
    String finalDay = format2.format(dt1);
    return finalDay.equals("Sunday")
            || finalDay.equals("Saturday");
  }

  @Override
  public void buyStockForPortfolio(int portfolioNumber, String ticker,
                                   double amount, int year,
                                   int month, int day, double commissionFee) {
    String date = "";
    String dayString;
    String monthString;
    if (!checkDate(year, month, day)) {
      throw new IllegalArgumentException("Wrong date");
    }
    if (checkWeekend(year, month, day)) {
      throw new IllegalArgumentException("Saturday or Sunday");
    }
    if (day < 10) {
      dayString = "0" + Integer.toString(day);
    } else {
      dayString = Integer.toString(day);
    }
    if (month < 10) {
      monthString = "0" + Integer.toString(month);
    } else {
      monthString = Integer.toString(month);
    }
    date = Integer.toString(year)
            + "-"
            + monthString
            + "-"
            + dayString;
    try {
      portfolios.get(portfolioNumber).buyStock(ticker, amount, date, commissionFee);
    } catch (Exception e) {
      throw new IllegalStateException("Wrong data");
    }
  }

  @Override
  public double getCostBasisForPortfolio(int portfolioNumber, int year, int month, int day) {
    String date = "";
    String dayString;
    String monthString;
    if (day < 10) {
      dayString = "0" + Integer.toString(day);
    } else {
      dayString = Integer.toString(day);
    }
    if (month < 10) {
      monthString = "0" + Integer.toString(month);
    } else {
      monthString = Integer.toString(month);
    }
    date = Integer.toString(year)
            + "-"
            + monthString
            + "-"
            + dayString;

    try {
      this.portfolios.get(portfolioNumber).getCostBasis(date);
    } catch (Exception e) {
      throw new IllegalStateException("Wrong date");
    }
    return this.portfolios.get(portfolioNumber).getCostBasis(date);
  }

  @Override
  public double getPortfolioValueForPortfolio(int portfolioNumber, int year, int month, int day) {
    String date = "";
    String dayString;
    String monthString;
    if (day < 10) {
      dayString = "0" + Integer.toString(day);
    } else {
      dayString = Integer.toString(day);
    }
    if (month < 10) {
      monthString = "0" + Integer.toString(month);
    } else {
      monthString = Integer.toString(month);
    }
    date = Integer.toString(year)
            + "-"
            + monthString
            + "-"
            + dayString;

    try {
      this.portfolios.get(portfolioNumber).getPortfolioValue(date);
    } catch (Exception e) {
      throw new IllegalStateException("Wrong date");
    }
    return this.portfolios.get(portfolioNumber).getPortfolioValue(date);
  }

  @Override
  public boolean addCompany(int portfolioNumber, String company) {

    return portfolios.get(portfolioNumber).addCompany(company);
  }

  @Override
  public boolean addWeight(int portfolioNumber, HashMap weights) {
    return portfolios.get(portfolioNumber).addWeights(weights);
  }

  private boolean checkStartDate(List<String> dates, String startDateString) {
    String[] startDateArray = startDateString.split("/");
    long startDate = Long.parseLong(startDateArray[2] + startDateArray[1] + startDateArray[0]);
    String[] stockStartDate;
    long companyStartDate;
    for (int i = 0; i < dates.size(); i++) {
      stockStartDate = dates.get(i).split("-");
      companyStartDate = Long.parseLong(stockStartDate[0] + stockStartDate[1] + stockStartDate[2]);
      if (companyStartDate > startDate) {
        return false;
      }
    }
    return true;
  }

  private int monthConvertor(String monthString) {
    switch (monthString) {
      case "Jan":
        return 1;
      case "Feb":
        return 2;
      case "Mar":
        return 3;
      case "Apr":
        return 4;
      case "May":
        return 5;
      case "Jun":
        return 6;
      case "Jul":
        return 7;
      case "Aug":
        return 8;
      case "Sep":
        return 9;
      case "Oct":
        return 10;
      case "Nov":
        return 11;
      case "Dec":
        return 12;
      default:
        throw new IllegalArgumentException("Month convertor error");

    }

  }

  @Override
  public void startStrategy(int portfolioNumber, String startDateString, String endDateString,
                            int interval, double amount,
                            double commissionFee) throws ParseException {

    if (amount <= 0 || interval < 1) {
      throw new IllegalArgumentException("Negative");
    }
    Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
    HashMap<String, Double> weights = portfolios.get(portfolioNumber).getWeights();

    Date endDate;
    if (endDateString.equals("")) {
      endDate = new Date();
      long yes = endDate.getTime() - 24 * 60 * 60 * 1000L;
      endDate.setTime(yes);
    } else {
      endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateString);
    }

    List dates = new LinkedList<String>();
    for (String key : weights.keySet()) {
      final long count = Portfolio.STOCK_PRICE_DATA.get(key).keySet().stream().count();
      dates.add(Portfolio.STOCK_PRICE_DATA
              .get(key)
              .keySet()
              .stream()
              .skip(count - 1)
              .findFirst()
              .get());
    }
    if (!this.checkStartDate(dates, startDateString)) {
      throw new IllegalArgumentException("Company doesn't exist");
    }
    Date currentDate = startDate;
    int year;
    int month;
    int date;
    String[] partOfDate;
    long currentDateInLong;
    int countOfBuying = 1;
    List<String> companies = new LinkedList();
    for (String key : weights.keySet()) {
      companies.add(key);
    }
    while (currentDate.compareTo(endDate) <= 0) {
      for (int i = 0; i < companies.size(); i++) {
        partOfDate = currentDate.toString().split("\\s+");
        year = Integer.parseInt(partOfDate[5]);
        month = this.monthConvertor(partOfDate[1]);
        date = Integer.parseInt(partOfDate[2]);
        try {

          this.buyStockForPortfolio(portfolioNumber,
                  companies.get(i),
                  amount * weights.get(companies.get(i)),
                  year, month, date, commissionFee);
          countOfBuying++;
        } catch (Exception e) {
          currentDateInLong = currentDate.getTime();
          currentDate.setTime(currentDateInLong + 24 * 60 * 60 * 1000L);
          i = i - 1;
        }

      }
      currentDateInLong = currentDate.getTime();
      currentDate.setTime(currentDateInLong + interval * 24 * 60 * 60 * 1000L);
    }

  }

  @Override
  public List getListOfCompanies(int portfolioNumber) {
    return portfolios.get(portfolioNumber).getNameOfCompanies();
  }

  @Override
  public String getPortfolioNames() {
    String output = "";
    for (int i = 0; i < portfolios.size(); i++) {
      output = output + (i + 1) + ". " + portfolios.get(i).getNameOfPortfolio() + "\n";
    }
    return output;
  }

  @Override
  public String getPortfolioCompanies(int portfolioNumber) {
    return this.portfolios.get(portfolioNumber).getCompaniesAsString();
  }

  @Override
  public void setDefaultWeights(int portfolioNumber) {
    portfolios.get(portfolioNumber).setDefaultWeights();
  }

  @Override
  public void saveData() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(this.portfolios);

    try {
      //write converted json data to a file named "portfolios.json"
      FileWriter writer = new FileWriter("portfolios.json");
      writer.write(json);
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }


    StaticPortfolioHistorySaver history = new StaticPortfolioHistorySaver(
            Portfolio.STOCK_PRICE_DATA,
            Portfolio.portfolioNumber);
    json = gson.toJson(history);
    try {
      //write converted json data to a file named "portfolios.json"
      FileWriter writer = new FileWriter("history.json");
      writer.write(json);
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  @Override
  public void retrieveData() {
    Gson gson = new Gson();
    try {

      BufferedReader br = new BufferedReader(
              new FileReader("portfolios.json"));
      Type portfolioType = new TypeToken<ArrayList<Portfolio>>() {
      }.getType();

      //convert the json string back to object
      this.portfolios = gson.fromJson(br, portfolioType);

    } catch (IOException e) {
      throw new IllegalStateException("No file present");
    }

    try {

      BufferedReader br = new BufferedReader(
              new FileReader("history.json"));


      //convert the json string back to object
      StaticPortfolioHistorySaver a = gson.fromJson(br, StaticPortfolioHistorySaver.class);
      Portfolio.STOCK_PRICE_DATA = a.getStockPriceHistory();
      Portfolio.portfolioNumber = a.numberOfPortfolio();

    } catch (IOException e) {
      e.printStackTrace();
    }


  }

  @Override
  public HashMap<String, String> getHashMapOfPortFolios() {
    return this.portfolioNames;
  }


  @Override
  public void addPortfolio(PortfolioInterface p) {
    this.portfolioNames.put(Integer.toString(portfolioNumber++), p.getNameOfPortfolio());
    this.portfolios.add(p);
  }

  @Override
  public String displayAllPortfolios() {
    String output = "";
    for (int i = 0; i < portfolios.size(); i++) {
      output = output + (i + 1) + ". " + portfolios.get(i).toString() + "\n";
    }
    return output;
  }


}



