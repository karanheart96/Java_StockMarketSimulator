package view;

import java.io.IOException;
import java.util.HashMap;

/**
 * The class which implements the SimulationViewInterface.
 */
public class SimulatorView implements SimulationViewInterface {


  @Override
  public void displayMenu(HashMap<String, String> menu, Appendable out) throws IOException {
    String output = "\n********* Welcome to Stock Market Simulator **********\n";
    for (String key : menu.keySet()) {
      output = output + key + " ." + menu.get(key) + "\n";
    }
    output = output + "PRESS THE MENU OPTION YOU DESIRE\n";

    out.append(output);
  }

  @Override
  public void displayAllPortfolio(String allPortfolios, Appendable out) throws IOException {
    out.append("\n********* Welcome to DISPLAY ALL PORTFOLIO **********\n");
    if (allPortfolios.equals("")) {

      out.append("\nNo portfolio created\n"
              + "Enter B or b to GO back to Menu\n");
    } else {
      out.append(allPortfolios + "\n"
              + "ENTER \"B\" TO GO BACK TO MENU\n");
    }
  }

  @Override
  public void createPortfolio(Appendable out) throws IOException {
    out.append("\n********* Welcome to CREATE PORTFOLIO PAGE **********\n");
    out.append("\nTYPE OUT THE NAME OF THE PORTFOLIO YOU DESIRE AND PRESS ENTER"
            + " IF YOU LEAVE IT BLANK IT WILL AUTOMATICALLY BE NAMED\n");
  }

  @Override
  public void returnGivenString(String input, Appendable out) throws IOException {
    out.append(input);
  }

  @Override
  public void displaySinglePortfolio(String portfolioToDisplay, Appendable out) throws IOException {
    if (portfolioToDisplay.equals("")) {
      out.append("\nNO STOCKS BOUGHT IN THIS PORTFOLIO\n");
    } else {
      out.append("\n********* Welcome to SINGLE PORTFOLIO PAGE **********\n");
      out.append(portfolioToDisplay);
    }
  }

  @Override
  public void valuePageOptions(Appendable out) throws IOException {
    out.append("\n********* Welcome to CALCULATE VALUE PAGE **********\n");
    out.append("\n PRESS 1 FOR COST BASIS\nPRESS 2 FOR PORTFOLIO VALUE\n PRESS B TO GO BACK\n");
  }

  @Override
  public void displayCostBasis(double costBasis, Appendable out) throws IOException {
    out.append("\nTHE COST BASIS OF THIS PORTFOLIO IS " + Double.toString(costBasis) + "\n");
  }

  @Override
  public void displayPortfolioValue(double portfolioValue, Appendable out) throws IOException {
    out.append("\nTHE PORTFOLIO VALUE OF THIS PORTFOLIO IS "
            + Double.toString(portfolioValue) + "\n");
  }

  @Override
  public void displayEditPortfolios(String allPortfolios, Appendable out) throws IOException {
    out.append("\n********* Welcome to EDIT PORTFOLIO PAGE **********\n");
    if (allPortfolios.equals("")) {

      out.append("\nNo portfolio created\n"
              + "Enter B or b to GO back to Menu\n");
    } else {
      out.append(allPortfolios + "\n"
              + "ENTER \"B\" TO GO BACK TO MENU\n");
    }
  }

  @Override
  public void strategyNames(Appendable out) throws IOException {
    out.append("\n********* Welcome to STRATEGY SELECTION PAGE **********\n");
    out.append("\n1. Dollar Cost Averaging\n");
    out.append("\nEnter the index of the strategy you want to apply\n");
  }

  @Override
  public void displayAllCompanies(String companyNames, Appendable out) throws IOException {
    out.append("\n********* Welcome to COMPANIES IN THIS PORTFOLIO PAGE **********\n");
    if (companyNames.equals("")) {

      out.append("\nNo STOCKS IN PORTTFOLIO\n"
              + "Enter B or b to GO back to Menu\n"
              + "Enter Y to enter new companies\n");
    } else {
      out.append(companyNames + "\n"
              + "ENTER \"B\" TO GO BACK TO MENU\n"
              + "PRESS Y TO ADD MORE COMPANIES OR N TO PROCEED TO INVEST IN THE ABOVE COMPANIES\n");
    }

  }

}

