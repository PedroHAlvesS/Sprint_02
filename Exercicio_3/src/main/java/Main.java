import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);


        System.out.println("Digite uma frase: ");
        String frase = teclado.nextLine();

        Pattern divertido = Pattern.compile(":-)", Pattern.LITERAL);
        Pattern chateado = Pattern.compile(":-(", Pattern.LITERAL);
        Matcher divertidoMatcher = divertido.matcher(frase);
        Matcher chateadoMatcher = chateado.matcher(frase);
        long divertidoQuantidade = divertidoMatcher.results().count();
        long chateadoQuantidade = chateadoMatcher.results().count();

        if (divertidoQuantidade > chateadoQuantidade) {
            System.out.println("Divertido!");
        }
        if (chateadoQuantidade > divertidoQuantidade) {
            System.out.println("Chateado!");
        }
        if (chateadoQuantidade == divertidoQuantidade) {
            System.out.println("Neutro!");
        }
    }
}
