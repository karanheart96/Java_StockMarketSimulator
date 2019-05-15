package view;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import view.pages.AskTickerPage;
import view.pages.BuyIndividualStockPage;
import view.pages.CreatePortfolioPage;
import view.pages.DatesAndIntervalsPage;
import view.pages.DisplayAllPortfolio;
import view.pages.DynamicWeightsPage;
import view.pages.IndividualStockDetailsPage;
import view.pages.MenuPage;
import view.pages.MoreCompaniesPage;

import view.pages.PortfolioForCost;
import view.pages.StrategyAllPortfoliosPage;
import view.pages.StrategyListPage;
import view.pages.ValueCalculationPage;
import view.pages.WeightsPage;

import java.util.List;

/**
 * Class for displaying the GUI.
 */
public class GraphicalViewImpl extends JFrame implements GraphicalView {

  CreatePortfolioPage createPortfolioPage;
  BuyIndividualStockPage buyIndividualStockPage;
  IndividualStockDetailsPage individualStockDetailsPage;
  StrategyAllPortfoliosPage strategyAllPortfoliosPage;
  StrategyListPage strategyListPage;
  AskTickerPage tickerPage;
  DynamicWeightsPage dynamicWeightsPage;
  DatesAndIntervalsPage datesAndIntervalsPage;
  PortfolioForCost portfolioForCostPage;
  ValueCalculationPage valueCalculationPage;

  /**
   * Constructor to Initialize the view.
   * @param caption The title of the frame.
   */
  public GraphicalViewImpl(String caption) {
    super(caption);
    this.setFrame();
  }


  @Override
  public void setFrame() {
    setSize(500 * 2, 300 * 2);
    setLocation(200, 200);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    this.setVisible(true);
  }

  @Override
  public void setMenuPage(ActionListener controller) {
    JPanel menuPage = new MenuPage();
    this.setContentPane(menuPage);
    this.invalidate();
    this.validate();
    ((MenuPage) menuPage).setListener(controller);
  }

  @Override
  public void setCreatePortfolio(ActionListener controller) {
    createPortfolioPage = new CreatePortfolioPage();
    this.setContentPane(createPortfolioPage);
    this.invalidate();
    this.validate();
    createPortfolioPage.setListener(controller);

  }

  @Override
  public void setBuyIndividualStockPage(String nameOfPortfolios, ActionListener controller) {
    buyIndividualStockPage = new BuyIndividualStockPage(nameOfPortfolios);
    JScrollPane scrollPane = new JScrollPane(buyIndividualStockPage);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    //buyIndividualStockPage.add(scrollPane);
    this.setContentPane(scrollPane);
    this.invalidate();
    this.validate();
    buyIndividualStockPage.setListener(controller);
  }

  @Override
  public void setIndividualStockDetailPage(ActionListener controller) {
    individualStockDetailsPage = new IndividualStockDetailsPage();
    this.setContentPane(individualStockDetailsPage);
    this.invalidate();
    this.validate();
    individualStockDetailsPage.setListener(controller);
  }

  @Override
  public String getTicker() {
    return individualStockDetailsPage.getTicker();
  }

  @Override
  public String getYear() {
    return individualStockDetailsPage.getYear();
  }

  @Override
  public String getMonth() {
    return individualStockDetailsPage.getMonth();
  }

  @Override
  public String getDay() {
    return individualStockDetailsPage.getDay();
  }

  @Override
  public String getAmount() {
    return individualStockDetailsPage.getAmount();
  }

  @Override
  public String getCommission() {
    return individualStockDetailsPage.getCommission();
  }

  @Override
  public void strategyAllPortfoliosPage(String portfolioNames, ActionListener controller) {
    strategyAllPortfoliosPage = new StrategyAllPortfoliosPage(portfolioNames);
    JScrollPane scrollPane = new JScrollPane(strategyAllPortfoliosPage);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.setContentPane(scrollPane);
    this.invalidate();
    this.validate();
    strategyAllPortfoliosPage.setListener(controller);

  }

  @Override
  public String getPortfolioNumberStrategy() {
    return strategyAllPortfoliosPage.getPortfolioNumber();
  }

  @Override
  public void setStrategyListPage(ActionListener controller) {
    strategyListPage = new StrategyListPage();
    this.setContentPane(strategyListPage);
    this.invalidate();
    this.validate();
    strategyListPage.setListener(controller);

  }

  @Override
  public String getStrategyNumber() {
    return strategyListPage.getStrategyNumber();
  }

  @Override
  public void setMoreCompaniesPage(List<String> companies, ActionListener controller) {
    MoreCompaniesPage page = new MoreCompaniesPage(companies);
    this.setContentPane(page);
    this.invalidate();
    this.validate();
    page.setListener(controller);
  }

  @Override
  public void setAskTickerSymbol(ActionListener controller) {
    tickerPage = new AskTickerPage();
    this.setContentPane(tickerPage);
    this.invalidate();
    this.validate();
    tickerPage.setListener(controller);

  }

  @Override
  public String getTickerStrategy(ActionListener controller) {
    return tickerPage.getTicker();
  }

  @Override
  public void setWeightsPage(ActionListener controller) {
    WeightsPage page = new WeightsPage();
    this.setContentPane(page);
    this.invalidate();
    this.validate();
    page.setListener(controller);
  }

  @Override
  public void setDynamicWeightsPage(List<String> companies, ActionListener controller) {

    dynamicWeightsPage = new DynamicWeightsPage(companies);
    this.setContentPane(dynamicWeightsPage);
    this.invalidate();
    this.validate();
    dynamicWeightsPage.setListener(controller);

  }

  @Override
  public String getPortfolioName() {
    return createPortfolioPage.getPortfolioName();
  }

  @Override
  public String getPortfolioNumber() {
    return buyIndividualStockPage.getPortfolioNumber();
  }

  @Override
  public void setDisplayAllPortfolio(String nameOfCompanies, ActionListener controller) {
    DisplayAllPortfolio displayAllPortfolio = new DisplayAllPortfolio(nameOfCompanies);
    JScrollPane scrollPane = new JScrollPane(displayAllPortfolio);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.setContentPane(scrollPane);
    this.invalidate();
    this.validate();
    displayAllPortfolio.setListener(controller);
  }

  @Override
  public String getWeights() {
    return dynamicWeightsPage.getWeights();
  }

  @Override
  public String getStartDate() {
    return datesAndIntervalsPage.getStartDate();
  }

  @Override
  public String getEndDate() {
    return datesAndIntervalsPage.getEndDate();
  }

  @Override
  public String getCommissionStrategy() {
    return datesAndIntervalsPage.getCommission();
  }

  @Override
  public String getInterval() {
    return datesAndIntervalsPage.getInterval();
  }

  @Override
  public void setDatesAndIntervalsPage(ActionListener controller) {
    datesAndIntervalsPage = new DatesAndIntervalsPage();
    this.setContentPane(datesAndIntervalsPage);
    this.invalidate();
    this.validate();
    datesAndIntervalsPage.setListener(controller);
  }

  @Override
  public String getAmountStrategy() {
    return datesAndIntervalsPage.getAmount();
  }

  @Override
  public void setPortfolioForCost(String nameofPortfolios, ActionListener controller) {
    portfolioForCostPage = new PortfolioForCost(nameofPortfolios);
    this.setContentPane(portfolioForCostPage);
    this.invalidate();
    this.validate();
    portfolioForCostPage.setListener(controller);
  }

  @Override
  public String getPortfolioNumberCost() {
    return portfolioForCostPage.getPortfolioNumber();
  }

  @Override
  public void setValueCalculationPage(ActionListener controller) {
    valueCalculationPage = new ValueCalculationPage();
    this.setContentPane(valueCalculationPage);
    this.invalidate();
    this.validate();
    valueCalculationPage.setListener(controller);
  }

  @Override
  public String getYearValue() {
    return valueCalculationPage.getYear();
  }

  @Override
  public String getMonthValue() {
    return valueCalculationPage.getMonth();
  }

  @Override
  public String getDayValue() {
    return valueCalculationPage.getDay();
  }


}
