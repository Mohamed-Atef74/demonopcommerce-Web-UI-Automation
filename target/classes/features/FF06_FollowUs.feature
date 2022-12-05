@smoke
Feature: Provide the user with different social media links to follow us on
  Scenario Outline: User can follow the website on different social media
    When The user clicks on "<socialMediaName>" button
    Then The user should be redirected to the related "<socialMediaLink>"
    Examples:
    |socialMediaName|socialMediaLink|
    |Facebook       |https://www.facebook.com/nopCommerce                 |
    |Twitter        |https://twitter.com/nopCommerce                      |
    |RSS            |https://demo.nopcommerce.com/new-online-store-is-open|
    |YouTube        |https://www.youtube.com/user/nopCommerce             |