We have 3 json files.

File name: portfolios.json

Explanation : portfolios.json stores an entire list of portfolios.

["amount": 1000.0,
        "name": "AAPL",
        "number": 5.659629860207143,
        "dateBought": "2018-12-04",
        "price": 176.69,
        "commissionFee": 0.0,
        "history": {}
        "name": "iris",
    "companyNames": [
      "AAPL"
    ],
    "weights": {
      "AAPL": 1.0 }]


File Name: history.json

Explanation : History is the data we fetch from the API. We store that in the Json format.
With key as company name and value as the data retrieved.
 {stocks:"{ CompanyName :"{ Date : Prices}""}

File Name : portfolioNames.json

Explanation : portfolioNames contains a hash map with key as portfolio number and value as portfolio name.

{"portfolio number":"PortfolioName"}
