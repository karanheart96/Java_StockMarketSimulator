package view.pages;

import java.awt.event.ActionListener;

public interface Page {
  /**
   * Method to pass the action listner object.
   * @param buttonPress Action Listner object to take in input.
   */
  void setListener(ActionListener buttonPress);
}
