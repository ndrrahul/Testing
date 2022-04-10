Feature: Test API
  Background: To Test API

    @Test
    Scenario: PDF API run
      Given Load PDF API endpoint "http://samples.leanpub.com/testrestapi-sample-preview.pdf" with method "GET"
      Then Download PDF and store in variable "RESPONSE_API"
      Then Verify text from PDF endpoint "http://samples.leanpub.com/testrestapi-sample-preview.pdf" contains text "Alan Richardson"