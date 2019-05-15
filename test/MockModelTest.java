import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import controller.SimulationController;
import model.SimulatorInterface;
import model.MockSimulator;
import view.SimulationViewInterface;
import view.SimulatorView;

import static org.junit.Assert.assertEquals;

public class MockModelTest {
  @org.junit.Test
  public void goEXit() throws IOException {
    StringBuffer out = new StringBuffer();
    Reader in = new StringReader("1\n2\nb\n6");
    StringBuilder log = new StringBuilder();
    SimulatorInterface s1 = new MockSimulator(log, 0);
    SimulationViewInterface v1 = new SimulatorView();
    SimulationController c1 = new SimulationController(s1, v1, out, in);
    c1.goController();
    assertEquals(out.toString(), "\n"
            + "********* Welcome to Stock Market Simulator **********\n"
            + "1 .createPortfolio\n"
            + "2 .displayAllPortfolio\n"
            + "3 .buyIndividualStocks\n"

            + "4 .calculateValue\n"
            + "5 .applyStrategy\n"
            + "6 .exit\n"
            + "PRESS THE MENU OPTION YOU DESIRE\n"
            + "\n"
            + "********* Welcome to CREATE PORTFOLIO PAGE **********\n"
            + "\n"
            + "TYPE OUT THE NAME OF THE PORTFOLIO YOU DESIRE AND PRESS "
            + "ENTER IF YOU LEAVE IT BLANK IT WILL AUTOMATICALLY BE NAMED\n"
            + "Portfolio 2 successfully created\n"
            + "\n"
            + "********* Welcome to Stock Market Simulator **********\n"
            + "1 .createPortfolio\n"
            + "2 .displayAllPortfolio\n"
            + "3 .buyIndividualStocks\n"
            + "4 .calculateValue\n"
            + "5 .applyStrategy\n"
            + "6 .exit\n"
            + "PRESS THE MENU OPTION YOU DESIRE\n"
            + "Error in input please try again.\n"
            + "\n"
            + "Thank you for using the application.\n");
    assertEquals(log.toString(), "Input is 2Input is null");
  }
}
