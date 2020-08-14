package com.creditCardValidation;

//create class CreditCard
public class CreditCard {
    private String number;
    private String numberStatus;
    private String cardType;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String checkCardType(String number) {
        String[] arrayOfNumbers = number.split("");
        if (number.matches("[5][1-4]\\d{14}") || number.matches("[222100-272099]\\d{10}")){
            cardType = "MasterCard";
        }
        else
            if(number.matches("[4]\\d{12}\\d{14}\\d{18}")){
                cardType = "Visa";
            }
            return cardType;
    }

    public String validateCardNUmber(String number) {
        // Reverse the inputted number
        String[] arrayOfNumbers = number.split("");
        String reversedNumber = "";
        for(int i=arrayOfNumbers.length-1; i>=0; i--){
            reversedNumber += arrayOfNumbers[i];
        }

        //double the value of every digit in the reversed number that has an odd index
        String[] arrayOfReversedNumbers = reversedNumber.split("");
        StringBuilder doubledNumbers = new StringBuilder();
        for(int counter=0; counter<arrayOfReversedNumbers.length; counter++){

            //check for odd index
            if(counter%2==1){
                int doubledReversedNumbers = Integer.parseInt(arrayOfReversedNumbers[counter])*2;
                String doubledReversedNumberAsString = String.valueOf(doubledReversedNumbers);

                //sum digits of the doubling operation that have 2 digits
                if(doubledReversedNumberAsString.length()==2){
                    String[] arrString = doubledReversedNumberAsString.split("");
                    int sumOfDigits = Integer.parseInt(arrString[0]) + Integer.parseInt(arrString[1]);
                    doubledNumbers.append(sumOfDigits);
                }
                else {
                    doubledNumbers.append(doubledReversedNumbers);
                }
            }
            else{
                doubledNumbers.append(arrayOfReversedNumbers[counter]);
            }
        }
        //sum digits of the final number gotten after the doubling operation
        String[] doubledNumbersArray = new String(doubledNumbers).split("");
        int sumOfDoubledNumbers = 0;
        for (int i = 0; i < doubledNumbersArray.length; i++) {
            int digitInDoubledNumbersArray = Integer.parseInt(doubledNumbersArray[i]);
            sumOfDoubledNumbers += digitInDoubledNumbersArray;
        }
        //To know if CreditCard Number is valid
        //Check that the final sum divided by 10 does not leave a remainder
        if(sumOfDoubledNumbers%10==0){
            numberStatus = "valid";
        }
        else{
            numberStatus = "invalid";
        }

        return numberStatus;
    }

}

