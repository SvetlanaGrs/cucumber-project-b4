Feature: product data table practice

  @listOfMap @smoke
  Scenario: verify each product price
    # practice List<Map<String,String>>
    Given User is on the HomePage
    Then User should be able to see expected prices in the following product
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |
    #List Element 1(Map)
    #{Category=Phone, Product=Samsung galaxy s6, expectedPrice=360}
    #List Element 2(Map)
    #{Category=Phone, Product=Nokia lumia 1520, expectedPrice=360}
    #List Element 3(Map)
    #{Category=Phone, Product=Nexus 6 , expectedPrice=360}
    #List Element 4(Map)
    #{Category=Phone, Product=Sony vaio i5 , expectedPrice=360}
    #List Element 5(Map)
    #{Category=Phone, Product=Sony vaio i7, expectedPrice=360}
    #List Element 6(Map)
    #{Category=Phone, Product=MacBook air, expectedPrice=360}
    #List Element 7(Map)
    #{Category=Phone, Product=Apple monitor 24, expectedPrice=360}
    #List Element 8(Map)
    #{Category=Phone, Product=ASUS Full HD , expectedPrice=360}




  @ListOfList @smoke
  #practice List<List<String>>
  Scenario: Verify each product price List of List
    Given User is on the HomePage
    Then User should be able to see expected prices in the following products with listOfLists
      | Phones   | Samsung galaxy s6 | 360 |
      | Phones   | Nokia lumia 1520  | 820 |
      | Phones   | Nexus 6           | 650 |
      | Laptops  | Sony vaio i5      | 790 |
      | Laptops  | Sony vaio i7      | 790 |
      | Laptops  | MacBook air       | 700 |
      | Monitors | Apple monitor 24  | 400 |
      | Monitors | ASUS Full HD      | 230 |

  @MapList @smoke
  #practice Map<String,List<String>>
  Scenario: Verify students names on discord
    Then user should be able to see the following names in their groups
      | Group 1 | Nadir  | Feyruz | Shakir  |
      | Group 2 | Yuliia | Roma   | Nazarii |