package view.pages;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import java.util.List;

/**
 * Class for displaying the page for taking in more companies.
 */
public class MoreCompaniesPage extends JPanel implements Page {

  Button yes;
  Button no;

  /**
   * The constructor which initializes the page for getting more companies.
   * @param listOfCompanies The list of companies to be added to portfolio.
   */
  public MoreCompaniesPage(List<String> listOfCompanies) {
    if (listOfCompanies.size() == 0) {
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      String message = "<html> No companies bought yet Press Yes To add more companies<html>";
      JLabel companies = new JLabel(message);
      companies.setFont(new Font("Verdana", 1, 20));
      this.add(companies);
      yes = new Button("Yes");
      yes.setActionCommand("MoreCompaniesPage:yes");
      this.add(yes);
    } else {
      this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      String companies = "<html>" + listOfCompanies + " Press Yes to add more and No "
              +
              "to continue" + "</html>";
      JLabel label = new JLabel(companies);
      label.setFont(new Font("Verdana", 1, 20));

      this.add(label);

      yes = new Button("Yes");
      yes.setActionCommand("MoreCompaniesPage:yes");
      this.add(yes);

      no = new Button("No");
      no.setActionCommand("MoreCompaniesPage:no");
      this.add(no);
    }
  }

  @Override
  public void setListener(ActionListener buttonPress) {
    yes.addActionListener(buttonPress);
    no.addActionListener(buttonPress);
  }
}
