/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PasswordChecker;
import java.util.Scanner;

/**
 *
 * @author wolf
 */
public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        int counter =0;
        Scanner scanner = new Scanner(System.in);
        
        String password;
        do{
            System.out.println("note that passwoed must contain at least :\n"+
                "one digit \n"
                + "one Uppercase Letter\n"
                + "one Lowercase letter\n");
        System.out.println("Enter your password !");
        
        password=scanner.next();
            if(isValidPassword(password) == true){
                counter++;
                System.out.println("your password is good !");
            }
            
        }
        while(counter < 1);
        
    }
    public static boolean isValidPassword(String password) {
        
        boolean finalValue = false;
        
        final int passwordLength = 8;
        
    if(password.length()<passwordLength) return finalValue;
        
    int uppercasecount=0 , lowerCasecount=0 , digitCount=0 , symbolCount =0;
        
    for(int i=0 ; i<password.length();i++)
    {
        
            
            if(Character.isUpperCase(password.charAt(i))){
                        uppercasecount ++;
                        System.out.println("There is one or more on uppercase letter \n");
            }
             else if (Character.isLowerCase(password.charAt(i))){
                        lowerCasecount++;
                        System.out.println("There is one or more on lowercase letter \n");

            }
            
            else if (Character.isDigit(password.charAt(i))){
                        digitCount++;
                        System.out.println("There is one or more on digit \n");

    }
        }
        if(uppercasecount !=0 && lowerCasecount !=0 && digitCount !=0){
        
            finalValue = true;
            return finalValue;
        }
        else{
            return finalValue;
        }
        
        
    }
}
