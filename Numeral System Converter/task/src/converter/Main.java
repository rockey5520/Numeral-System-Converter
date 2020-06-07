package converter;

import static java.lang.System.in;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //stage 6
    try {
      Scanner scanner = new Scanner(System.in);
      boolean amIFloat = false;
      int sourceRadix = scanner.nextInt();
      String sourceNumber = scanner.next();
      int targetRadix = scanner.nextInt();

      if (sourceRadix > 36 || sourceRadix < 1) {
        throw new Exception();
      }
      if (targetRadix > 36 || targetRadix < 1) {
        throw new Exception();
      }

      double decimal;
      StringBuilder targetNumber = new StringBuilder();

      String integerPart = "";
      String fractionPart = "";

      if (sourceNumber.contains(".")) {
        amIFloat = true;
        integerPart = sourceNumber.split("\\.")[0];
        fractionPart = sourceNumber.split("\\.")[1];
      } else {
        integerPart = sourceNumber;
      }

      if (sourceRadix == 1) {
        decimal = sourceNumber.length();
      } else {
        decimal = Long.parseLong(integerPart, sourceRadix);
      }

      for (int i = 0; i < fractionPart.length(); i++) {
        decimal += Integer.parseInt(Character.toString(fractionPart.charAt(i)), sourceRadix) / Math
            .pow(sourceRadix, i + 1);
      }

      long integerParLong = (long) decimal;
      double fractionParDouble = decimal - integerParLong;
      if (targetRadix == 1) {
        for (int i = 0; i < integerParLong; i++) {
          targetNumber.append('1');
        }
      } else {
        targetNumber.append(Long.toString(integerParLong, targetRadix));

        if (amIFloat) {
          targetNumber.append('.');
          if (fractionParDouble == 0) {
            targetNumber.append('0');
          }
        }
        int k = 5;
        while (fractionParDouble > 0 && k > 0) {
          k--;
          fractionParDouble *= targetRadix;
          targetNumber.append(Long.toString((int) fractionParDouble, targetRadix));
          fractionParDouble -= (int) fractionParDouble;
        }
      }

      System.out.println(targetNumber);
    } catch (Exception e) {
      System.out.println("Sorry, an error occurred!");
    }
 //stage 5
    Scanner sc = new Scanner(System.in);
    boolean amIFloat = false;
    int sourceRadix = sc.nextInt();
    String sourceNumber = sc.next();
    int targetRadix = sc.nextInt();
    double decimal;
    String output = "";

    String numberPart = "";
    String decimalPart = "";

    if (sourceNumber.contains(".")) {
      amIFloat = true;
      numberPart = sourceNumber.split("\\.")[0];
      decimalPart = sourceNumber.split("\\.")[1];
    } else {
      numberPart = sourceNumber;
    }

    if (sourceRadix == 1) {
      decimal = sourceNumber.length();
    } else {
      decimal = Long.parseLong(numberPart, sourceRadix);
    }

    for (int i = 0; i < decimalPart.length(); i++) {
      decimal += Integer.parseInt(Character.toString(decimalPart.charAt(i)), sourceRadix) / Math.pow(sourceRadix, i + 1);
    }

    long integerPartInLong = (long) decimal;
    double fractionPartInDouble = decimal - integerPartInLong;
    if (targetRadix == 1) {
      for (int i = 0; i < integerPartInLong; i++) {
        output += '1';
      }
    } else {
      output += Long.toString(integerPartInLong, targetRadix);

      if (amIFloat) {
        output += '.';
        if (fractionPartInDouble == 0) {
          output += '0';
        }
      }
      int k = 5;
      while (fractionPartInDouble > 0 && k > 0) {
        k--;
        fractionPartInDouble *= targetRadix;
        output += Long.toString((int) fractionPartInDouble, targetRadix);
        fractionPartInDouble -= (int) fractionPartInDouble;
      }
    }

    System.out.println(output);


    //stage 4
    Scanner sc = new Scanner(System.in);
    int sourceRadix = sc.nextInt();
    int sourceNumber = sc.nextInt();
    int targetRadix = sc.nextInt();
    String output = "";

    if (sourceRadix == 1 || targetRadix == 1) {
      if (sourceRadix == 1) {
        sourceRadix = 10;
        sourceNumber = String.valueOf(sourceNumber).length();
        output = Integer.toString(Integer.parseInt(String.valueOf(sourceNumber), sourceRadix), targetRadix);
      }
      if (targetRadix == 1) {
        for (int i = 0; i < Integer.parseInt(String.valueOf(sourceNumber), sourceRadix); i++) {
          output += '1';
        }
      }
    } else {
      output = Integer.toString(Integer.parseInt(String.valueOf(sourceNumber), sourceRadix), targetRadix);
    }
    System.out.println(output);




   //stage 3
    Scanner scanner = new Scanner(in);
    int decInput = scanner.nextInt();
    int radix = scanner.nextInt();
    if (radix == 2){
      System.out.println("0b"+Integer.toString(decInput,radix));
    }else if(radix == 8){
      System.out.println("0"+Integer.toString(decInput,radix));
    }else if(radix == 16){
      System.out.println("0x"+Integer.toString(decInput,radix));
    }


    //stage 2
    Scanner scanner = new Scanner(in);
    int input = scanner.nextInt();
    System.out.println(Integer.toString(input, 8).charAt(Integer.toString(input, 8).length() - 1));

    //stage 1
    System.out.println("2 is equal to 0b10");

  }
}
