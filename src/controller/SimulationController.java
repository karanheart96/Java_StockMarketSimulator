package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import model.PortfolioInterface;

import view.GraphicalView;
import view.SimulationViewInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.HashMap;

import model.SimulatorInterface;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import com.google.gson.GsonBuilder;

import java.util.Arrays;

/**
 * The Controller class which serves as the interface, between the model and the view.
 */
public class SimulationController implements SimulationControllerInterface, ActionListener {
  transient SimulatorInterface model;
  transient String pageType;
  transient SimulationViewInterface view;
  transient Readable in;
  transient Appendable out;
  transient HashMap<String, String> menuPageOptions = new HashMap<>();
  transient HashMap<String, String> displayAllPortfolioOption = new HashMap<>();
  HashMap<String, String> allPortFolios = new HashMap<>();
  int numberOfPortfolios;
  int selectedPortfolio;
  transient GraphicalView graphicalView;
  transient String portfolioName;


  /**
   * The constructor used to initialize the controller.
   *
   * @param model The model object used to access the model.
   * @param view  The view object used to access the view.
   * @param out   The appendable object which is used to print out the output.
   * @param in    The Readable object which is used to take the input.
   */
  public SimulationController(SimulatorInterface model, SimulationViewInterface view,
                              Appendable out, Readable in) {
    menuPageOptions.put("1", "createPortfolio");
    menuPageOptions.put("2", "displayAllPortfolio");
    menuPageOptions.put("3", "buyIndividualStocks");
    menuPageOptions.put("4", "calculateValue");
    menuPageOptions.put("5", "applyStrategy");
    menuPageOptions.put("6", "exit");

    numberOfPortfolios = 0;
    selectedPortfolio = 0;
    displayAllPortfolioOption.put("b", "menuPage");
    displayAllPortfolioOption.put("B", "menuPage");

    this.model = model;
    this.view = view;
    this.pageType = "menuPage";
    this.in = in;
    this.out = out;
    try {
      this.retrieveData();
    } catch (Exception e) {
      System.out.println("Error");
    }
    try {
      model.retrieveData();
    } catch (Exception e) {
      System.out.println("No existing portfolios");
    }
    try {
      numberOfPortfolios = this.allPortFolios.size();
    } catch (Exception e) {
      numberOfPortfolios = 0;
    }
  }


  /**
   * Method to check whether the option is currect for the given page.
   *
   * @param currentPage The current page.
   * @param command     The option entered by user.
   * @return Whether the option is correct or not.
   */
  boolean checkInput(String currentPage, String command) {
    switch (currentPage) {
      case "menuPage":
        return command.equals("1")
                || command.equals("2")
                || command.equals("3")
                || command.equals("4")
                || command.equals("5")
                || command.equals("6");
      case "displayAllPortfolio":
        return command.equals("b")
                || command.equals("B");
      case "createPortfolio":
        return true;
      case "buyIndividualStocks":
        if (command.equals("b")
                || command.equals("B")) {
          return true;
        }
        int value = 0;
        try {
          value = Integer.parseInt(command);
        } catch (Exception e) {
          return false;
        }
        return value <= numberOfPortfolios
                && value > 0;
      case "calculateValue":
        if (command.equals("b")
                || command.equals("B")) {
          return true;
        }
        int value1 = 0;
        try {
          value1 = Integer.parseInt(command);
        } catch (Exception e) {
          return false;
        }
        return value1 <= numberOfPortfolios
                && value1 > 0;
      case "valuePage":
        return command.equals("1")
                || command.equals("2")
                || command.equals("b")
                || command.equals("B");
      case "applyStrategy":
        return command.equals("1")
                || command.equals("B")
                || command.equals("b");

      case "displayPortfolioNames":
        if (command.equals("b")
                || command.equals("B")) {
          return true;
        }
        value1 = 0;
        try {
          value1 = Integer.parseInt(command);
        } catch (Exception e) {
          return false;
        }
        return value1 <= numberOfPortfolios
                && value1 > 0;
      case "dollarAverageStrategy":
        return command.equals("Y")
                || command.equals("N")
                || command.equals("b")
                || command.equals("B");
      case "enterValuesForStrategyPage":
        return command.equals("Y")
                || command.equals("N")
                || command.equals("b")
                || command.equals("B");
      default:
        return false;
    }

  }

  /**
   * The method to check if ticker value is correct or not.
   *
   * @param input The ticker value
   * @return true because all ticker values are allowed.
   */
  boolean checkTicker(String input) {
    return true;
  }

  boolean iskNumber(String input) {
    int value = 0;
    try {
      value = Integer.parseInt(input);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  boolean isNumberDouble(String input) {
    double value = 0;
    try {
      value = Double.parseDouble(input);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  @Override
  public void goController() throws IOException {
    Scanner scan = new Scanner(this.in);
    String command = "";
    String ticker;
    int year;
    int month;
    int day;
    double amount = 0;
    double costBasis;
    double portfolioValue;
    String valuePageOption;
    String startDateString = "";
    String endDateString = "";
    int interval = 1;
    double commission = 0;
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    formatter.setLenient(false);
    while (true) {

      switch (pageType) {
        case "exit":
          out.append("\nThank you for using the application.\n");
          model.saveData();
          this.saveState();
          return;
        case "menuPage":
          view.displayMenu(menuPageOptions, out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          this.pageType = this.menuPageOptions.get(command);
          break;
        case "displayAllPortfolio":
          view.displayAllPortfolio(model.displayAllPortfolios(), out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          this.pageType = this.displayAllPortfolioOption.get(command);
          break;

        case "createPortfolio":
          view.createPortfolio(out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          allPortFolios.put(Integer.toString(numberOfPortfolios++), command);
          model.addPortfolio(model.createPortfolio(command));
          view.returnGivenString("Portfolio "
                  + command
                  + " successfully created\n", out);
          this.pageType = "menuPage";
          break;

        case "buyIndividualStocks":
          view.displayEditPortfolios(model.getPortfolioNames(), out);
          if (model.displayAllPortfolios().equals("")) {
            command = scan.nextLine();
            while (!(command.equals("b") || command.equals("B"))) {
              out.append("Error in input please try again.\n");
              command = scan.nextLine();
            }
            this.pageType = "menuPage";
            break;
          }
          view.returnGivenString("\nEnter the index of the portfolio "
                  + "you wanna buy stocks for from the above list\n", out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          this.selectedPortfolio = Integer.parseInt(command);
          out.append("\n" + allPortFolios.get(Integer.toString(selectedPortfolio - 1))
                  + " Portfolio selected\n");
          view.displaySinglePortfolio(model.getPortfolio(Integer.parseInt(command)), out);
          this.pageType = "buyStockPage";
          break;


        case "buyStockPage":
          view.returnGivenString("********* Welcome to BUY STOCK PAGE **********", out);
          view.returnGivenString("\nEnter TICKER symbol ?\n", out);
          command = scan.nextLine();
          while (!checkTicker(command)) {
            out.append("\nError in input please try again.\n");
            command = scan.nextLine();
          }
          ticker = command.toUpperCase();

          view.returnGivenString("\nEnter the amount you want to invest in stock ? "
                  + "Enter B to go back to Main Menu\n", out);
          command = scan.nextLine();
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          while (!isNumberDouble(command)) {
            out.append("\nError in input please try again.\n");
            command = scan.nextLine();
          }
          amount = Double.parseDouble(command);

          view.returnGivenString("\nEnter Year you wanna buy the stock ? "
                  + "Enter B to go back to Main Menu\n", out);
          command = scan.nextLine();
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          while (!iskNumber(command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          year = Integer.parseInt(command);
          view.returnGivenString("\nEnter Month you wanna buy the stock ? "
                  + "Enter B to go back to Main Menu\n", out);
          command = scan.nextLine();
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          while (!iskNumber(command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          month = Integer.parseInt(command);
          view.returnGivenString("\nEnter day you wanna buy the stock ? "
                  + "Enter B to go back to Main Menu\n", out);
          command = scan.nextLine();
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          while (!iskNumber(command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          day = Integer.parseInt(command);
          view.returnGivenString("\nEnter commission "
                  + "Enter B to go back to Main Menu\n", out);
          command = scan.nextLine();
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          while (!isNumberDouble(command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          commission = Double.parseDouble(command);
          try {
            out.append("Processing Request ........");
            model.buyStockForPortfolio(selectedPortfolio - 1,
                    ticker, amount, year, month, day, commission);
          } catch (Exception e) {
            out.append("\nUnable to buy stock due error in TICKER, DATE OR NEGATIVE QUANTITY\n");
            break;
          }
          out.append("Successfully bought stock\n");
          out.append("\nPress y to buy more or n to go back to select a new portfolio\n");
          command = scan.nextLine();
          if (command.equals("y")
                  || command.equals("Y")) {
            break;
          } else {
            this.pageType = "buyIndividualStocks";
          }
          break;

        case "calculateValue":
          view.displayAllPortfolio(model.getPortfolioNames(), out);
          if (model.displayAllPortfolios().equals("")) {
            command = scan.nextLine();
            while (!(command.equals("b") || command.equals("B"))) {
              out.append("Error in input please try again.\n");
              command = scan.nextLine();
            }
            this.pageType = "menuPage";
            break;
          }
          view.returnGivenString("\nEnter the index of the portfolio you wanna "
                  + "calculate values for from the above pics and B to go back to menu\n", out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          this.selectedPortfolio = Integer.parseInt(command);
          out.append("\n" + allPortFolios.get(Integer.toString(selectedPortfolio - 1))
                  + " Portfolio selected\n");
          view.displaySinglePortfolio(model.getPortfolioCompanies(this.selectedPortfolio - 1), out);
          this.pageType = "valuePage";
          break;


        case "valuePage":
          view.valuePageOptions(out);
          command = scan.nextLine();

          while (!checkInput(this.pageType, command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "calculateValue";
            break;
          }
          valuePageOption = command;
          view.returnGivenString("\nEnter Year you wanna calculate for\n", out);
          command = scan.nextLine();
          while (!iskNumber(command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          year = Integer.parseInt(command);
          view.returnGivenString("\nEnter Month you wanna calculate for\n", out);
          command = scan.nextLine();
          while (!iskNumber(command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          month = Integer.parseInt(command);
          view.returnGivenString("\nEnter day you wanna calculate for\n", out);
          command = scan.nextLine();
          while (!iskNumber(command)) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          day = Integer.parseInt(command);

          if (valuePageOption.equals("1")) {
            try {
              costBasis = model.getCostBasisForPortfolio(selectedPortfolio - 1, year, month, day);
            } catch (Exception e) {
              out.append("\nUNABLE TO CALCULATE COST BASIS FOR THE GIVEN DATE\n");
              break;
            }
            view.displayCostBasis(costBasis, out);
          } else if (valuePageOption.equals("2")) {
            try {
              portfolioValue = model.getPortfolioValueForPortfolio(selectedPortfolio - 1,
                      year, month, day);
            } catch (Exception e) {
              out.append("\nUNABLE TO CALCULATE PORTFOLIO VALUE FOR THE GIVEN DATE\n");
              break;
            }
            view.displayPortfolioValue(portfolioValue, out);
          }
          break;

        case "applyStrategy":
          view.strategyNames(out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command.toUpperCase())) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "menuPage";
            break;
          }
          this.pageType = "displayPortfolioNames";
          break;

        case "displayPortfolioNames":
          view.displayAllPortfolio(model.getPortfolioNames(), out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command.toUpperCase())) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          if (command.equals("B")
                  || command.equals("b")) {
            this.pageType = "applyStrategy";
            break;
          }
          this.selectedPortfolio = Integer.parseInt(command);
          this.pageType = "dollarAverageStrategy";
          break;


        case "dollarAverageStrategy":
          view.displayAllCompanies(model.getPortfolioCompanies(this.selectedPortfolio - 1), out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command.toUpperCase())) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          if (command.toUpperCase().equals("Y")) {
            this.pageType = "enterCompanyPage";
            break;
          } else if (command.toUpperCase().equals("N")) {
            this.pageType = "enterValuesForStrategyPage";
            break;
          } else if (command.toUpperCase().equals("B")) {
            this.pageType = "displayPortfolioNames";
            break;
          }
          break;
        case "enterCompanyPage":
          view.returnGivenString("\nEnter the ticker single of company you want\n", out);
          command = scan.nextLine();
          if (model.addCompany(this.selectedPortfolio - 1, command.toUpperCase())) {
            view.returnGivenString("\nCompany successfully added !\n", out);
            this.pageType = "dollarAverageStrategy";
            break;
          }
          out.append("Error in input please try again.\n");
          break;
        case "enterValuesForStrategyPage":
          view.returnGivenString("\nEnter Y for Preset values of weight "
                  + "and N for custom values and B to go back\n", out);
          command = scan.nextLine();
          while (!checkInput(this.pageType, command.toUpperCase())) {
            out.append("Error in input please try again.\n");
            command = scan.nextLine();
          }
          if (command.toUpperCase().equals("Y")) {
            this.pageType = "askDatesAndFeePage";
            model.setDefaultWeights(this.selectedPortfolio - 1);
            break;
          } else if (command.toUpperCase().equals("N")) {
            this.pageType = "askWeightsPage";
            break;
          } else if (command.toUpperCase().equals("B")) {
            this.pageType = "dollarAverageStrategy";
            break;
          }
          break;
        case "askWeightsPage":
          List<String> companies = model.getListOfCompanies(this.selectedPortfolio - 1);
          HashMap<String, Double> weights = new HashMap<>();
          for (int i = 0; i < ((List) companies).size(); i++) {

            out.append("\nEnter Weight for " + companies.get(i) + " between 0-1 "
                    + "but the total of all stocks should be 1\n");
            command = scan.nextLine();
            try {
              weights.put(companies.get(i), Double.parseDouble(command));
            } catch (Exception e) {
              out.append("\nNot a valid value. Try again !\n");
              i = i - 1;
            }
          }
          if (model.addWeight(this.selectedPortfolio - 1, weights)) {
            out.append("\nWeights sucessfully inserted !\n");
            this.pageType = "askDatesAndFeePage";
            break;
          } else {
            out.append("\nWeights not inserted ! RETRY\n");
            break;
          }
        case "askDatesAndFeePage":
          int flag = 0;
          while (true) {
            flag = 0;
            out.append("\nEnter the start date in the format dd/MM/YYYY\n");
            command = scan.nextLine();
            try {
              Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(command);
              startDate = formatter.parse(command);
            } catch (Exception e) {
              flag = 1;
              out.append("\nIncorrect format please try again\n");
            }
            if (flag == 0) {
              startDateString = command;
              break;
            }
          }
          flag = 0;
          while (true) {
            out.append("\nDo you want an end date ? Press Y for yes and N for no\n");
            command = scan.nextLine();
            if (command.toUpperCase().equals("Y") || command.toUpperCase().equals("N")) {
              break;
            } else {
              out.append("\nIncorrect input try again\n");
            }
          }
          if (command.toUpperCase().equals("Y")) {
            while (true) {
              flag = 0;
              out.append("\nEnter the end date in the format dd/MM/YYYY\n");
              command = scan.nextLine();
              try {
                Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(command);
                endDate = formatter.parse(command);
                Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
                startDate = formatter.parse(startDateString);
                if (startDate.compareTo(endDate) > 0) {
                  throw new Exception();
                }
              } catch (Exception e) {
                out.append("\nIncorrect format please try again\n");
                flag = 1;
              }
              if (flag == 0) {
                endDateString = command;
                break;
              }
            }
          }
          while (true) {
            flag = 0;
            out.append("\nEnter Commission fee\n");
            command = scan.nextLine();
            try {
              commission = Double.parseDouble(command);
              if (commission < 0) {
                throw new Exception();
              }
            } catch (Exception e) {
              out.append("\nError try again\n");
              flag = 1;
            }
            if (flag == 0) {
              commission = Double.parseDouble(command);

              break;
            }
          }
          while (true) {
            flag = 0;
            out.append("\nEnter Interval in days\n");
            command = scan.nextLine();
            try {
              interval = Integer.parseInt(command);
              if (interval < 1 || interval > 365) {
                throw new Exception();
              }
            } catch (Exception e) {
              out.append("\nError try again\n");
              flag = 1;
            }
            if (flag == 0) {
              interval = Integer.parseInt(command);

              break;
            }
          }
          while (true) {
            flag = 0;
            out.append("\nEnter amount to invest\n");
            command = scan.nextLine();
            try {
              amount = Double.parseDouble(command);
              if (amount < 1) {
                throw new Exception();
              }
            } catch (Exception e) {
              out.append("\nError try again\n");
              flag = 1;
            }
            if (flag == 0) {
              amount = Double.parseDouble(command);

              break;
            }
          }
          int flag1 = 0;
          while (true) {
            flag = 0;
            try {
              model.startStrategy(this.selectedPortfolio - 1, startDateString,
                      endDateString, interval, amount, commission);
            } catch (Exception e) {
              flag = 1;
              out.append("\nError in start date because one of the companies doesnt exist."
                      + " enter a new start date in dd/MM/YYYY format\n");
            }
            if (flag == 0) {
              out.append("\nSuccessfully executed strategy !\n");
              this.pageType = "menuPage";
              break;
            }
            while (true) {
              flag1 = 0;
              out.append("\nEnter new start date\n");
              command = scan.nextLine();
              try {
                Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(command);
              } catch (Exception e) {
                out.append("\nWrong format try again\n");
                flag1 = 1;
              }
              if (flag1 == 0) {
                startDateString = command;
                break;
              }
            }
          }
          break;
        default:
          break;
      }
    }
  }


  private void retrieveData() {

    Gson gson = new Gson();
    try {

      BufferedReader br = new BufferedReader(
              new FileReader("portfolioNames.json"));


      Type typeOfHashMap = new TypeToken<HashMap<String, String>>() {
      }.getType();
      this.allPortFolios = gson.fromJson(br, typeOfHashMap);

      //convert the json string back to object


    } catch (IOException e) {
      throw new IllegalStateException("No file present");
    }


  }

  private void saveState() {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(this.allPortFolios);


    try {
      //write converted json data to a file named "portfolios.json"
      FileWriter writer = new FileWriter("portfolioNames.json");
      writer.write(json);
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  /**
   * Constructor to initialize graphical view.
   *
   * @param model The model of the Simulator.
   * @param view  The graphical view.
   */
  public SimulationController(SimulatorInterface model, GraphicalView view) {
    this.graphicalView = view;
    this.model = model;
    view.setMenuPage(this);
    numberOfPortfolios = 0;
    try {
      this.retrieveData();
    } catch (Exception e) {
      System.out.println("Error");
    }
    try {
      model.retrieveData();
    } catch (Exception e) {
      System.out.println("No existing portfolios");
    }
    try {
      numberOfPortfolios = this.allPortFolios.size();
    } catch (Exception e) {
      numberOfPortfolios = 0;
    }

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "menuPage:exit":
        model.saveData();
        this.saveState();
        System.exit(0);
        break;

      case "createPortfolioPage:okayButton":
        portfolioName = graphicalView.getPortfolioName();
        PortfolioInterface p = model.createPortfolio(portfolioName);
        model.addPortfolio(p);

        this.allPortFolios.put(Integer.toString(numberOfPortfolios++), p.getNameOfPortfolio());
        JOptionPane.showMessageDialog(new JFrame(), portfolioName + " successfully created !");
        graphicalView.setMenuPage(this);
        break;

      case "menuPage:createPortfolioPage":
        graphicalView.setCreatePortfolio(this);
        break;

      case "menuPage:displayAllPortfolioPage":
        String nameOfCompanies = model.displayAllPortfolios();
        graphicalView.setDisplayAllPortfolio(nameOfCompanies, this);
        break;

      case "createPortfolioPage:backButton":
        graphicalView.setMenuPage(this);
        break;

      case "displayAllPortfolioPage:backButton":
        graphicalView.setMenuPage(this);
        break;

      case "menuPage:buyStockIndividuallyPage":
        graphicalView.setBuyIndividualStockPage(model.getPortfolioNames(), this);
        break;

      case "buyStockIndividuallyPage:backButton":
        graphicalView.setMenuPage(this);
        break;
      case "buyStockIndividuallyPage:okayButton":
        try {
          this.selectedPortfolio = Integer.parseInt(graphicalView.getPortfolioNumber());
        } catch (Exception a) {
          JOptionPane.showMessageDialog(new JFrame(), "Error in input try again");
        }
        if (this.selectedPortfolio <= numberOfPortfolios
                && this.selectedPortfolio > 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  allPortFolios.get(Integer.toString(selectedPortfolio - 1)) + " selected !");
          graphicalView.setIndividualStockDetailPage(this);
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid Input Try Again");
          graphicalView.setBuyIndividualStockPage(model.getPortfolioNames(), this);
          break;
        }
        break;

      case "IndividualStockDetailsPage:buyStockButton":
        int year;
        int month;
        int day;
        double amount;
        String ticker;
        double commission;
        try {
          ticker = graphicalView.getTicker().toUpperCase();
          year = Integer.parseInt(graphicalView.getYear());
          month = Integer.parseInt(graphicalView.getMonth());
          day = Integer.parseInt(graphicalView.getDay());
          amount = Double.parseDouble(graphicalView.getAmount());
          commission = Double.parseDouble(graphicalView.getCommission());
          model.buyStockForPortfolio(selectedPortfolio - 1,
                  ticker, amount, year, month, day, commission);
        } catch (Exception a) {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid Input Try Again");
          graphicalView.setIndividualStockDetailPage(this);
          break;
        }
        JOptionPane.showMessageDialog(new JFrame(), "Stock successfully bought !");
        graphicalView.setMenuPage(this);
        break;
      case "IndividualStockDetailsPage:backButton":
        graphicalView.setBuyIndividualStockPage(model.getPortfolioNames(), this);
        break;

      case "strategyAllPortfoliosPage:backButton":
        graphicalView.setMenuPage(this);
        break;

      case "menuPage:buyStockUsingStrategy":
        graphicalView.setStrategyListPage(this);
        break;

      case "strategyAllPortfoliosPage:okayButton":
        try {
          this.selectedPortfolio = Integer.parseInt(graphicalView.getPortfolioNumberStrategy());
        } catch (Exception a) {
          JOptionPane.showMessageDialog(new JFrame(), "Error in input try again");
        }
        if (this.selectedPortfolio <= numberOfPortfolios
                && this.selectedPortfolio > 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  allPortFolios.get(Integer.toString(selectedPortfolio - 1)) + " selected !");
          graphicalView.setMoreCompaniesPage(model.getListOfCompanies(selectedPortfolio - 1), this);
          break;
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid Input Try Again");
          graphicalView.strategyAllPortfoliosPage(model.getPortfolioNames(), this);
          break;
        }


      case "StrategyListPage:okayButton":
        String number = graphicalView.getStrategyNumber();
        if (number.equals("1")) {
          graphicalView.strategyAllPortfoliosPage(model.getPortfolioNames(), this);
          break;
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid Input Try Again");
          graphicalView.setStrategyListPage(this);
          break;
        }

      case "StrategyListPage:backButton":
        graphicalView.setMenuPage(this);
        break;

      case "MoreCompaniesPage:yes":
        graphicalView.setAskTickerSymbol(this);
        break;


      case "AskTickerPage:okayButton":
        String ticker1 = graphicalView.getTickerStrategy(this);
        if (model.addCompany(selectedPortfolio - 1, ticker1.toUpperCase())) {
          JOptionPane.showMessageDialog(new JFrame(), "Company successfully added !");
          graphicalView.setMoreCompaniesPage(model.getListOfCompanies(selectedPortfolio - 1), this);
          break;
        } else {
          graphicalView.setAskTickerSymbol(this);
          break;
        }

      case "AskTickerPage:backButton":
        graphicalView.setMoreCompaniesPage(model.getListOfCompanies(selectedPortfolio - 1), this);
        break;

      case "MoreCompaniesPage:no":
        graphicalView.setWeightsPage(this);
        break;

      case "WeightsPage:yes":
        model.setDefaultWeights(selectedPortfolio - 1);
        JOptionPane.showMessageDialog(new JFrame(), "Weights Successfully Set !");
        graphicalView.setDatesAndIntervalsPage(this);
        break;

      case "WeightsPage:no":
        graphicalView.setDynamicWeightsPage(model.getListOfCompanies(selectedPortfolio - 1), this);
        break;

      case "DynamicWeightsPage:backButton":
        graphicalView.setWeightsPage(this);
        break;

      case "DynamicWeightsPage:okayButton":
        String weights = graphicalView.getWeights();

        List<String> weightList = Arrays.asList(weights.split(","));
        if (weightList.size() != model.getListOfCompanies(selectedPortfolio - 1).size()) {
          JOptionPane.showMessageDialog(new JFrame(), "Weights are wrong ! Please try again !");
          graphicalView.setDynamicWeightsPage(
                  model.getListOfCompanies(selectedPortfolio - 1),
                  this);
          break;
        }
        List<Double> weightsDouble = new LinkedList<>();
        double sum = 0;
        for (int i = 0; i < weightList.size(); i++) {
          try {
            weightsDouble.add(Double.parseDouble(weightList.get(i)));
            sum = sum + weightsDouble.get(i);
          } catch (Exception a) {
            JOptionPane.showMessageDialog(new JFrame(), "Weights are wrong ! Please try again !");
            graphicalView.setDynamicWeightsPage(
                    model.getListOfCompanies(selectedPortfolio - 1),
                    this);
            break;
          }
        }
        if (sum < 0.9 || sum > 1) {
          JOptionPane.showMessageDialog(new JFrame(), "Weights are wrong ! Please try again !");
          graphicalView.setDynamicWeightsPage(
                  model.getListOfCompanies(selectedPortfolio - 1),
                  this);
          break;
        }
        List<String> companyNames = model.getListOfCompanies(selectedPortfolio - 1);
        HashMap<String, Double> weightSet = new HashMap<>();

        for (int i = 0; i < weightsDouble.size(); i++) {
          weightSet.put(companyNames.get(i), weightsDouble.get(i));
        }


        if (model.addWeight(selectedPortfolio - 1, weightSet)) {
          JOptionPane.showMessageDialog(new JFrame(), "Weights Successfully added");
          graphicalView.setDatesAndIntervalsPage(this);
          break;
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Weights are wrong ! Please try again !");
          graphicalView.setDynamicWeightsPage(
                  model.getListOfCompanies(selectedPortfolio - 1),
                  this);
          break;
        }

      case "DatesAndIntervalsPage:backButton":
        graphicalView.setDynamicWeightsPage(model.getListOfCompanies(selectedPortfolio - 1), this);
        break;

      case "DatesAndIntervalsPage:buyStockButton":
        try {
          String startDate = graphicalView.getStartDate();
          String endDate = graphicalView.getEndDate();

          DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
          formatter.setLenient(false);
          Date startDateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
          startDateFormat = formatter.parse(startDate);
          if (!endDate.equals("")) {
            Date endDateFormat = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            endDateFormat = formatter.parse(endDate);
          }

          int interval = Integer.parseInt(graphicalView.getInterval());
          amount = Double.parseDouble(graphicalView.getAmountStrategy());
          commission = Double.parseDouble(graphicalView.getCommissionStrategy());
          model.startStrategy(selectedPortfolio - 1,
                  startDate,
                  endDate,
                  interval,
                  amount,
                  commission);
        } catch (Exception a) {
          JOptionPane.showMessageDialog(new JFrame(), "Wrong Input please try again !");
          graphicalView.setDatesAndIntervalsPage(this);
          break;
        }
        JOptionPane.showMessageDialog(new JFrame(), "Strategy successfully executed !");
        graphicalView.setMenuPage(this);
        break;

      case "menuPage:calculateValueCostPage":
        graphicalView.setPortfolioForCost(model.getPortfolioNames(), this);
        break;
      case "PortfolioForCost:backButton":
        graphicalView.setMenuPage(this);
        break;
      case "PortfolioForCost:okayButton":
        try {
          this.selectedPortfolio = Integer.parseInt(graphicalView.getPortfolioNumberCost());
        } catch (Exception a) {
          JOptionPane.showMessageDialog(new JFrame(), "Error in input try again");
          graphicalView.setPortfolioForCost(model.getPortfolioNames(), this);
          break;
        }
        if (this.selectedPortfolio <= numberOfPortfolios
                && this.selectedPortfolio > 0) {
          JOptionPane.showMessageDialog(new JFrame(),
                  allPortFolios.get(Integer.toString(selectedPortfolio - 1)) + " selected !");

          graphicalView.setValueCalculationPage(this);
          break;
        } else {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid Input Try Again");
          graphicalView.setPortfolioForCost(model.getPortfolioNames(), this);
          break;
        }

      case "ValueCalculationPage:backButton":
        graphicalView.setMenuPage(this);
        break;

      case "ValueCalculationPage:costBasis":
        try {
          year = Integer.parseInt(graphicalView.getYearValue());
          month = Integer.parseInt(graphicalView.getMonthValue());
          day = Integer.parseInt(graphicalView.getDayValue());
          Double costBasis = model.getCostBasisForPortfolio(selectedPortfolio - 1,
                  year,
                  month,
                  day);
          JOptionPane.showMessageDialog(new JFrame(), "The cost Basis is " + costBasis);
          graphicalView.setValueCalculationPage(this);
          break;
        } catch (Exception a) {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid Input Try Again");
          graphicalView.setValueCalculationPage(this);
          break;
        }

      case "ValueCalculationPage:portfolioValue":
        try {
          year = Integer.parseInt(graphicalView.getYearValue());
          month = Integer.parseInt(graphicalView.getMonthValue());
          day = Integer.parseInt(graphicalView.getDayValue());
          Double costBasis = model.getPortfolioValueForPortfolio(selectedPortfolio - 1,
                  year,
                  month,
                  day);
          JOptionPane.showMessageDialog(new JFrame(), "The cost Basis is " + costBasis);
          graphicalView.setValueCalculationPage(this);
          break;
        } catch (Exception a) {
          JOptionPane.showMessageDialog(new JFrame(), "Invalid Input Try Again");
          graphicalView.setValueCalculationPage(this);
          break;
        }
      default:
        break;
    }
  }
}
