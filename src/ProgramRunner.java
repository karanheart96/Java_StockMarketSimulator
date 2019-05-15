
import java.io.IOException;

import controller.SimulationController;

import model.Simulator;
import model.SimulatorInterface;
import view.GraphicalView;
import view.GraphicalViewImpl;
import view.SimulationViewInterface;
import view.SimulatorView;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import controller.SimulationControllerInterface;

public class ProgramRunner {


  /**
   * The main function to run the program.
   *
   * @param args Through the terminal.
   * @throws IOException for the Appendable object.
   */
  public static void main(String[] args) throws IOException {

    SimulatorInterface model = new Simulator();
    if (args.length != 2) {
      System.out.println("\nWrong format !\n");
      System.exit(0);
    } else {
      if (args[0].equals("-view")) {
        if (args[1].equals("console")) {
          SimulationViewInterface view = new SimulatorView();
          BufferedReader in
                  = new BufferedReader(new InputStreamReader(System.in));

          SimulationControllerInterface controller =
                  new SimulationController(model, view, System.out, in);
          controller.goController();
        } else if (args[1].equals("gui")) {
          GraphicalView view = new GraphicalViewImpl("Stock Simulator");
          SimulationControllerInterface controller = new SimulationController(model, view);
        } else {
          System.out.println("\nWrong argument!\n");
          System.exit(0);
        }
      }
    }
  }


}









