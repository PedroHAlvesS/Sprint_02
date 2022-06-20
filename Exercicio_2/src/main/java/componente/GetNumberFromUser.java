package componente;

import Exceptions.NumberOutOfRange;

import java.util.Scanner;

public abstract class GetNumberFromUser {
    public static int getIntNumberBetween(String phrase, int minor, int larger) {
        while (true) {
            try {

                Scanner keyboard = new Scanner(System.in);
                System.out.println(phrase);
                int number = Integer.parseInt(keyboard.nextLine());
                if (number < minor || number > larger) {
                    String exceptionString = "Número fora do intervalo entre " + minor + " e " + larger;
                    throw new NumberOutOfRange(exceptionString);
                }
                return number;
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Por favor, informe um número válido!");
            } catch (NumberOutOfRange numberOutOfRange) {
                System.out.println(numberOutOfRange.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.getStackTrace();
            }
        }
    }
}
