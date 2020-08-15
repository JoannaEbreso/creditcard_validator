package com.creditCardValidation;

//create class CreditCard
public class CreditCard {
    private String creditCardNumber;
    private String creditCardType;


    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String checkCardType(String creditCardNumber) {
        if (creditCardNumber.matches("[5][1-4]\\d{14}") || creditCardNumber.matches("[222100-272099]\\d{10}")){
            creditCardType = "MasterCard";
        }
        else
            if(creditCardNumber.matches("[4]\\d{12,18}")){
                creditCardType = "Visa";
            }
        return creditCardType;
    }

    public String reverseCardNumber(String creditCardNumber){
        String[] arrayOfNumbers = creditCardNumber.split("");
        StringBuilder reversedCardNumber = new StringBuilder();
        for(int i=arrayOfNumbers.length-1; i>=0; i--){
            reversedCardNumber.append(arrayOfNumbers[i]);
        }
        return reversedCardNumber.toString();
    }

    private void checkForTwoDigitsAndSumThem(StringBuilder cardNumbers, String doubledDigit) {
        if(doubledDigit.length()==2){
            String[] doubledDigitArray = doubledDigit.split("");
            int sumOfDigits = Integer.parseInt(doubledDigitArray[0]) + Integer.parseInt(doubledDigitArray[1]);
            cardNumbers.append(sumOfDigits);
        }
        else {
            cardNumbers.append(doubledDigit);
        }
    }

    public String getStringOfDoubledCardNumber(String number){
        String[] arrayOfNumbers = number.split("");
        StringBuilder doubledCardNumbers = new StringBuilder();
        for(int index=0; index<arrayOfNumbers.length; index++){

            //check for digits at odd index and double them
            if(index%2==1){
                int doubledDigit = Integer.parseInt(arrayOfNumbers[index])*2;
                String doubledDigitAsString = String.valueOf(doubledDigit);

                //sum digits of the doubling operation that have 2 digits
                checkForTwoDigitsAndSumThem(doubledCardNumbers, doubledDigitAsString);
            }
            else{
                doubledCardNumbers.append(arrayOfNumbers[index]);
            }
        }
        return doubledCardNumbers.toString();
    }

    public int getSumOfDigits(String digits){
        String[] digitsArray = digits.split("");
        int sumOfDigits = 0;
        for (int i = 0; i < digitsArray.length; i++) {
            int digitInDoubledNumbersArray = Integer.parseInt(digitsArray[i]);
            sumOfDigits += digitInDoubledNumbersArray;
        }
        return sumOfDigits;
    }

    public boolean isValid() {
        // Reverse the inputted number
        String reversedNumber = reverseCardNumber(creditCardNumber);

        //double the value of every digit in the reversed number that has an odd index
        String doubledNumbers = getStringOfDoubledCardNumber(reversedNumber);

        //sum digits of the final number gotten after the doubling operation
        int sumOfDoubledNumbers = getSumOfDigits(doubledNumbers);

        //To know if CreditCard Number is valid
        //Check that the final sum divided by 10 does not leave a remainder
        if(sumOfDoubledNumbers%10==0){
            return true;
        }
        else{
           return false;
        }
    }

}

