Feature: Test API
  Background: To Test API

    @Test
    Scenario: API run
      Given Load API endpoint "http://samples.leanpub.com/testrestapi-sample-preview.pdf"
      Then Verify text from pdf endpoint "http://samples.leanpub.com/testrestapi-sample-preview.pdf" contains text "Alan Richardson"