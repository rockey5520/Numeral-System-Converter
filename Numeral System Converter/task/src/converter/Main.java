package converter;

import static java.lang.System.in;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
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
