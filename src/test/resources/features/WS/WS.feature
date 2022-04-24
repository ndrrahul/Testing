Feature: Test API

  Background: To Test API

  @Test1
  Scenario: PDF API run
    Given Load PDF API endpoint "http://samples.leanpub.com/testrestapi-sample-preview.pdf" with method "GET"
    Then Download PDF and store in variable "RESPONSE_API"
    Then Verify text from PDF contains text "Alan Richardson"

  @Test
  Scenario: API run
#    Given Load API endpoint "https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=xml&tzshift=0" with method "POST"
#    Given Load API endpoint "https://api.publicapis.org/entries" with method "GET"
    Given Set request body with template "request.txt"
    Given Load API endpoint "https://reqres.in/api/users" with method "POST"

