package view.pages;

import java.awt.Button;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import javax.swing.BoxLayout;


/**
 * Class for displaying the menu page.
 */
public class MenuPage extends JPanel implements Page {
  Button createPortfolio;
  Button displayPortfolio;
  Button buyStockIndividually;
  Button buyStockUsingStrategy;
  Button calculateValueCost;
  Button exit;

  /**
   * The constructor which initializes the menu page.
   */
  public MenuPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    //Adding components
    this.createPortfolio = new Button("Create Portfolio");
    this.add(createPortfolio);
    createPortfolio.setActionCommand("menuPage:createPortfolioPage");

    displayPortfolio = new Button("View Portfolio names and contents");
    this.add(displayPortfolio);
    displayPortfolio.setActionCommand("menuPage:displayAllPortfolioPage");

    buyStockIndividually = new Button("Buy Stocks Individually");
    this.add(buyStockIndividually);
    buyStockIndividually.setActionCommand("menuPage:buyStockIndividuallyPage");

    buyStockUsingStrategy = new Button("Buy Stocks using Strategy");
    this.add(buyStockUsingStrategy);
    buyStockUsingStrategy.setActionCommand("menuPage:buyStockUsingStrategy");

    calculateValueCost = new Button("Calculate Portfolio Value or Cost Basis");
    this.add(calculateValueCost);
    calculateValueCost.setActionCommand("menuPage:calculateValueCostPage");

    exit = new Button("Exit");
    this.add(exit);
    exit.setActionCommand("menuPage:exit");




  }

  @Override
  public void setListener(ActionListener buttonPress) {
    createPortfolio.addActionListener(buttonPress);
    displayPortfolio.addActionListener(buttonPress);
    buyStockIndividually.addActionListener(buttonPress);
    buyStockUsingStrategy.addActionListener(buttonPress);
    calculateValueCost.addActionListener(buttonPress);
    exit.addActionListener(buttonPress);
  }
}
