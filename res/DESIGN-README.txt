PACKAGES and their respective classes:

License: https://github.com/google/gson/blob/master/LICENSE

model
 - Simulator
 - SimulatorInterface
 - PortfolioInterface
 - Portfolio
 - Stock
 - StockBuilder
 - StaticPortfolioHistorySaver
 - MockSimulator

view
 - SimulationViewInterface
 - SimulationView
 - GraphicalView
 - GraphicalVieWImpl
 - 
 
controller
 - SimulationController
 - SimulationControllerInterface

Pages
 - AskTickerPage
 - BuyIndividualStockPage
 - CreatePortfolioPage
 - DatesAndIntervalsPage
 - DisplayAllPortfolio
 - DynamicWeightsPage
 - IndividualStockDetailsPage
 - MenuPage
 - MoreCompaniesPage
 - Page
 - PortfolioForCost
 - StrategyAllPortfoliosPage
 - StrategyListPage
 - ValueCalculationPage
 - WeightsPage

CHANGES FROM PREVIOUS DESIGN:
 - We have an Interface Called GraphicalView which has all the functions required for the graphicalView
 - We have a GraphicalViewInterface which will have implementation of all the functions in     the Interface.
 - We added two functions inside the model for saving and retrieving data.
 - The controller now checks if there is any save files before starting.
 - We are also saving a static variable inside a file called "history.json" which saves the data from the api so that it need not be called again.
 - We also save few variables from the controller.
 - We have added multiple Pages inside our view which are panels containing buttons and text box for unique pages.
 - We have a Page Interface which is implemented by all the pAGES.


DESIGN OF MODEL:
1) "Simulation" here is our model which provides all the functions.
2) "SimulationInterface" has all the public methods that are there in the "Simulation" class.
3) Portfolio is the class to define a single portfolio
4) One Simulation can have multiple portfolios.
5) PortfolioInterface has all the public functions of portfolio.
6) One Portfolio can have multiple stocks.
5) Stock class is used to represent a stock.
6) StockBuilder is used to create a stock since it has multiple parameters
7) Each Stock has the history of all its histrical prices stored as key - value pair <Date,Price on that date>
8) Each stock can calculate its own CostBasis for a given date and PortfolioValue on a given date.
9) All stocks in a Portfolio calculate their cost basis and give them to their respective Portfolio and the
   Portfolio adds them to give a total CostBasis. The same is true for Portfolio Value. 


WORKFLOW WHEN YOU(SUCCESSFULLY) BUY STOCK

                                                                 (calls the API for data and stores 
                                                                   the entire history in hashmap
                                                                   so that we need not call the API again   ( Each stock has its value, number a
            (calls buy stock function of the Portfolio)            for the same company)                      and its entire history of prices as a Hashmap <Date,Price> ) 
Simulation -------------------------------------------> Portfolio ------------------------------------------> Stock


DESIGN OF VIEW:
1) The view contains multiple functions to display all menus.
2) Each page is a new function, so to add a new page we just need to add a new function.
3) All functions take an Appendable object as input.
4) The view updates the Appendable object.
5) tHE GraphicalView extends the JFrame interface and acts as the main frame.
6) All the pages extend the JPanel interface.

DESIGN OF CONTROLLER:
1) The constructor of the controller accepts A MODEL, A VIEW, APPENDABLE AND READABLE object.
3) The controller calls the view if we need to display any menu
4) It calls the model if we need to use the functions in the model
5) The controller only takes input, and calls the model or view function accordingly.
