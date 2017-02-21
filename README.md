# ISBN13-Verification

A java application to verify the check number of a ISBN13.

### Prerequisites

This example requires a Java IDE such as Eclipse.

## Running the program

The getISBN(); method is called which prompts the user to enter a ISBN13 code. 

```
getISBN();
```

The validateISBN(); method is called so that we may remove any non-numeric characters 
from the user input. Next the method checks to see if the length of the input is equal
to 13. Otheriwse we will re-prompt the user for a ISBN13 code as it MUST be 13 digits in 
length. This method returns a boolean that is used for the last method.

```
validateISBN();
```

The verifyISBN(); method is called which determines whether or not the ISBN13 entered is
valid. The method first calls the validateISBN() method to ensure it is true. 

If the ISBN is valid then we will loop through the ISBN.

Each digit, from left to right, is alternately multiplied by 1 or 3. Then those products are summed modulo 10 to give a value ranging from 0 to 9. Subtracted from 10, that leaves a result from 1 to 10. A zero replaces a ten, so, in all cases, a single check digit results.

The output of the method is either valid or invalid. 

```
verifyISBN();
```

## Authors

* **Bailey Granam** - *Author* - [BaileyGranam](https://github.com/BaileyGranam)
