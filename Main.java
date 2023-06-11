import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        System.out.println("|Bem Vindo ao jogo da JavaGallows! - v1.0");
        Game jogo = new Game();

        jogo.seeder();
        jogo.startMenu();
      
    }
}