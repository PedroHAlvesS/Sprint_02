import components.RegexPhraseEmotion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        String phrase = keyboard.nextLine();

        RegexPhraseEmotion regex = new RegexPhraseEmotion(phrase);
        System.out.println(regex.getPhraseEmotion());

    }
}
