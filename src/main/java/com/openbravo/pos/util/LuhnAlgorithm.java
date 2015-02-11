package com.openbravo.pos.util;

public class LuhnAlgorithm {

    /**
     * Creates a new instance of LuhnAlgorithm */
    private LuhnAlgorithm() {
    }

    public static boolean checkCC(String cardNumber){
        int sum = 0;

        int flip = 0;

        if ( !StringUtils.isNumber(cardNumber) ){
            return false;
        }

        for (int i = cardNumber.length() -1; i >= 0; i--) {
             int k = Character.digit(cardNumber.charAt(i), 10);
             flip ++;

             if ( flip % 2 == 0 ) {
                k *= 2;
                if (k > 9) {
                    k -= 9;
                }
            }
            sum += k;
        }
        return (sum % 10 == 0);
    }

//  Resolution of AMEX card issue
//  Mikel Iurata, Openbravo Thu Sep 16
//  Jack Gerrard, uniCenta Fri Sep 17
//    public static void main(String[] args) {
//        // Testing sample numbers
//
//        System.out.println(LuhnAlgorithm.checkCC("4111111111111111")); // Visa
//        System.out.println(LuhnAlgorithm.checkCC("5500000000000004")); // Master card
//        System.out.println(LuhnAlgorithm.checkCC("340000000000009")); // AMEX
//        System.out.println(LuhnAlgorithm.checkCC("30000000000004")); // Diners
//        System.out.println(LuhnAlgorithm.checkCC("30000000000004")); // Carte blanche
//        System.out.println(LuhnAlgorithm.checkCC("6011000000000004")); // Discover
//        System.out.println(LuhnAlgorithm.checkCC("201400000000009")); // EnRoute

}

