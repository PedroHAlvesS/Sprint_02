package services;

public abstract class Menu {
    public static int getOptionFromMenu() {
        System.out.println("Menu de opções");
        System.out.println("0 - Sair");
        System.out.println("1 - Inserir 3 produtos");
        System.out.println("2 - Atualizar o primeiro produto");
        System.out.println("3 - Deletar o segundo produto");
        return componente.GetNumberFromUser.getIntNumberBetween("Informe uma opcão: ", 0, 3);

    }

}
