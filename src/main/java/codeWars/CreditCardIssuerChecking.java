package codeWars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreditCardIssuerChecking {
    public static void main(String[] args) {

        String cardNumber = "4111111111111111";

        System.out.println(getIssuer(cardNumber));
        String check = cardNumber.substring(0,3);
        System.out.println(check);

    }
    public static String getIssuer(String cardNumber) {
        String[] firstDigits = {"51","52","53","54","55","34", "37", "6011", "4"};

        for (String number : firstDigits){
            if(cardNumber.substring(0, 1).equalsIgnoreCase(number) && ((cardNumber.length() == 13) || (cardNumber.length() == 16))){
                return "VISA";
            } else if (cardNumber.substring(0,2).equalsIgnoreCase(number) && (cardNumber.length() == 16)){
                return "Mastercard";
            } else if (cardNumber.substring(0,4).equalsIgnoreCase(number) && (cardNumber.length() == 16)) {
                return "Discover";
            } else if (cardNumber.substring(0,2).equalsIgnoreCase(number) && (cardNumber.length() == 15)) {
                return "AMEX";
            }
        }
        return "Unknown";
    }
//    @Test
//    public void issuerTests() {
//        String[] firsDigits = {"51","52","53","54","55","34", "37", "6011", "4"};
//        assertEquals("VISA",getIssuer("4111111111111111",firsDigits));
//        assertEquals("AMEX",getIssuer("378282246310005",firsDigits));
//        assertEquals("Unknown",getIssuer("9111111111111111",firsDigits));
//        assertEquals("Mastercard",getIssuer("5105105105105100",firsDigits));
//    }
}
