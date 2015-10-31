package com.keybellsoft.binaryhexapowermachine;

import java.math.BigInteger;

/**
 * Created by Fabi on 29/10/2015.
 */
public class Operations {


    public String sum(String num1,String num2) {
        char[] charArrayNum1 = num1.toCharArray();
        char[] charArrayNum2 = num2.toCharArray();

        int lenghtMinimumChar=0;
        int lenghtMaximumChar=0;
        if(charArrayNum1.length <= charArrayNum2.length)
        {
            lenghtMinimumChar = charArrayNum1.length-1;
            lenghtMaximumChar = charArrayNum2.length-1;
        }
        else
        {
            lenghtMinimumChar = charArrayNum2.length-1;
            lenghtMaximumChar = charArrayNum1.length-1;
        }

        int auxMaximChar=lenghtMaximumChar;
        String resultString="";
        String missing="";
        for(int x = lenghtMinimumChar; x >= 0; x--,auxMaximChar--)
        {
            String firstNumber = "";
            String secondNumber = "";
            if(charArrayNum1.length-1 == lenghtMinimumChar)
            {
                firstNumber= String.valueOf(charArrayNum1[x]);
                secondNumber= String.valueOf(charArrayNum2[auxMaximChar]);
            }else {
                firstNumber= String.valueOf(charArrayNum2[x]);
                secondNumber= String.valueOf(charArrayNum1[auxMaximChar]);
            }

            if((firstNumber.equals("1") && secondNumber.equals("0")) || (firstNumber.equals("0") && secondNumber.equals("1")))
            {
                if(missing.equals("1"))
                {
                    resultString = resultString + "0";
                    missing="1";
                }else
                {
                    resultString = resultString + "1";
                }

            }else if(firstNumber.equals("1") && secondNumber.equals("1")){

                if(missing.equals("1"))
                {
                    resultString = resultString + "1";
                }else
                {
                    resultString = resultString + "0";
                }

                missing="1";
            }else if(firstNumber.equals("0") && secondNumber.equals("0")){

                if(missing.equals("1"))
                {
                    resultString = resultString + "1";
                }else {
                    resultString = resultString + "0";
                }

                missing="";
            }

        }


        String finalNumber="";
        Boolean increase=false;
        for(int y=auxMaximChar; y >= 0; y--)
        {
            increase=true;
            if(charArrayNum1.length-1 == lenghtMinimumChar)
            {
                finalNumber= String.valueOf(charArrayNum2[y]);
            }else {
                finalNumber= String.valueOf(charArrayNum1[y]);
            }

            if(missing.equals("1"))
            {
                if(finalNumber.equals("1"))
                {
                    resultString = resultString + "0";
                    missing="1";
                }else if (finalNumber.equals("0"))
                {
                    resultString = resultString + "1";
                }
            }
            else
            {
                resultString = resultString + finalNumber;
            }
        }

        if(!increase){
            resultString = resultString + missing;
        }

        StringBuilder builder=new StringBuilder(resultString);
        String invertString=builder.reverse().toString();

        return invertString;
    }




    public static String hexToBin(String s) {
        return new BigInteger(s, 16).toString(2);
    }

    public String convertToHexa(String result)
    {
        try
        {
            int decimal = Integer.parseInt(result,2);
            String hexStr = Integer.toString(decimal,16);
            return hexStr;
        }catch (Exception io)
        {
            return "";
        }
    }

}
