Feature: Purchase order from Ecommerce website
    I want to use this template for my feature file

    Background:
        Given I landed on Ecommerce Page

    @Regression
    Scenario Outline: Positive test of submitting the order
        Given Logged in with username <name> and password <password>
        When I add product <productName> to Cart
        And Checkout <productName> and submit the order
        Then "THANK YOU FOR THE ORDER." message is displayed on ConfirmationPage
    Examples:
        | name                 | password | productName |
        | ejemplo1@ejemplo.com | Test1234 | ZARA COAT 3 |
