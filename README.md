# testng-browserstack

[TestNG](http://testng.org) Integration with BrowserStack.

![BrowserStack Logo](https://d98b8t1nnulk5.cloudfront.net/production/images/layout/logo-header.png?1469004780)

## Using Maven

### Setup

* Clone the repo
* Install dependencies `mvn compile`
* Update `*.conf.json` files inside the `src/test/resources/conf` directory with your [BrowserStack Username and Access Key](https://www.browserstack.com/accounts/settings)
* Copy the .toml file s to the folder where your selenium grid jar is available in the local machine

### Commands to up the Selenium hub and nodes
* navigate to the folder where selenium grid jar is available 
* java -jar <selenium-grid-name>.jar hub
* java -jar  <selenium-grid-name>.jar node --config <tomal_file_name>.toml

### Running your tests

- To run mobile tests, run `mvn test -P mobile`
- To run web tests, run `mvn test -P web`
