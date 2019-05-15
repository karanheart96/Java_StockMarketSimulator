package view.pages;



import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javax.swing.BoxLayout;

import java.awt.Button;

import javax.swing.JLabel;

import java.awt.Font;

/**
 * Class for displaying the weights for all pages.
 */
public class WeightsPage extends JPanel implements Page {
  Button yes;
  Button no;

  /**
   * Constructor to initialize the Weights Page.
   */
  public WeightsPage() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    String message = "Do you want Pre determined weights ?";
    JLabel label = new JLabel(message);
    label.setFont(new Font("Verdana", 1, 20));

    this.add(label);

    yes = new Button("Yes");
    yes.setActionCommand("WeightsPage:yes");
    this.add(yes);

    no = new Button("No");
    no.setActionCommand("WeightsPage:no");
    this.add(no);
  }

  @Override
  public void setListener(ActionListener buttonPress) {
    yes.addActionListener(buttonPress);
    no.addActionListener(buttonPress);
  }

}
