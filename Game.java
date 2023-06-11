import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Game{
    private int hits;
    private int errors;
    Palavra palavraobj;
    private int attempts;
    private int wordSize;
    
    ArrayList<Palavra> palavras =  new ArrayList();
    ArrayList<String> letters =  new ArrayList();
    Scanner ler = new Scanner(System.in);


    public void seeder(){
        Palavra word1= new Palavra("lapis", "Grafite");
        palavras.add(word1);
        Palavra word2= new Palavra("Celular", "É smart");
        palavras.add(word2);
        Palavra word3= new Palavra("Caderno", "Notebook");
        palavras.add(word3);
    }

    public void startMenu(){
        boolean on1=true;
        while(on1==true){

            System.out.println("|-------------------------------------------");
            System.out.println("|(1)Iniciar Padrão (Palavra Aleatória)");
            System.out.println("|(2)Iniciar Personalizado(Palavra Personalizada)");
            System.out.println("|(0)Encerrar");

            switch(ler.nextInt()){
                case 0:
                    System.exit(0);
                break;

                case 1:
                     defaultGame();
                break;

                case 2:
                    customGame();
                break;

                default:
                    
                    System.out.println("|Opção Inválida");                    
            }
        }
    }

    public void defaultGame(){
        clear();
        Random gerador =  new Random();   

        this.palavraobj = (Palavra) palavras.get(gerador.nextInt(palavras.size()));//pegando a palavra da lista de objetos

        this.wordSize=palavraobj.getPalavra().length();//tamanho da palavra

        System.out.println("|Palavra aleatória escolhida!");

        game();
    }

    public void customGame(){
        clear();
        Palavra customword = new Palavra();

        System.out.println("|Insira a palavra");
        ler.nextLine();
        customword.setPalavra(ler.nextLine());

        System.out.println("|Insira uma dica sobre a palavra");
        customword.setDica(ler.nextLine());
        
        this.palavraobj = customword;
        this.wordSize=palavraobj.getPalavra().length();//tamanho da palavra
        System.out.println("|Palavra personalizada inserida!");

        game();
    }

    public void game(){
        boolean on2=true;
        while(on2==true){
            verify();
            System.out.println("--------------------------------------");
            System.out.println("|Acertos:"+this.getHits());
            System.out.println("|Erros:"+this.getErrors());
            System.out.println("|Tentativas:"+this.getAttempts());
            System.out.println("--------------------------------------");
            System.out.println("(1)Inserir letra");
            System.out.println("(2)Inserir palavra (Tudo ou nada)");
            System.out.println("(3)Dica");
            System.out.println("(0)Sair");

            switch(ler.nextInt()){
                case 1:
                    letter();
                break;

                case 2:
                    everythingOrNothing();
                break;

                case 3:
                    System.out.println("|A dica é: "+this.palavraobj.getDica());
                break;

                case 0:
                    clear();
                    on2=false;
                break;

                default:
                    System.out.println("|Opção inválida");
            }
        }
    }

    public void everythingOrNothing(){
        String palavra = this.palavraobj.getPalavra();
        System.out.println("|Desafio tudo ou nada! Insira uma palavra");

        ler.nextLine();
        String inputPalavra = ler.nextLine();

        if(inputPalavra.equals(palavra)){
            System.out.println("|O JOGADOR ACERTOU -- FIM DE PARTIDA");
            clear();
            startMenu();
        }else{
            System.out.println("|O JOGADOR NÃO ACERTOU -- FIM DE PARTIDA");
            clear();
            startMenu();
        }

    }

    public void letter(){
        String palavra = this.palavraobj.getPalavra();
        System.out.println("|Digite uma letra!");
        ler.nextLine();
        String letter = ler.nextLine();

        if(palavra.indexOf(letter)>=0){
            this.hits++;
            letters.add(letter);
        }else{
            this.errors++;
            letters.add(letter);
        }

        this.attempts++;
    }

    public  void verify(){
        if(this.errors>10){
            System.out.println("--------------------------------------");
            System.out.println("|Numero de tentativas excedidas |Tentativas: "+this.getAttempts());
            System.out.println("|Palavra Correta: "+this.palavraobj.getPalavra());
            for (String letra : letters) {
                System.out.println("|Letras inseridas:"+letra);
            }
            System.out.println("|FIM DE JOGO");
            clear();//zera o jogo
            startMenu();//menu inicial
        }

        if(this.hits==this.wordSize){
            System.out.println("--------------------------------------");
            System.out.println("|Todas as letras da palavra foram digitadas! |Tentativas: "+this.getAttempts());
            System.out.println("|Palavra: "+this.palavraobj.getPalavra());
            for (String letra : letters) {
                System.out.println("|Letras inseridas:"+letra);
            }
            System.out.println("|FIM DE JOGO");
            clear();//zera o jogo
            startMenu();//menu inicial
        }

        System.out.println("--------------------------------------");
    }
    
    public void clear(){
        letters.clear();
        this.attempts=0;
        this.errors=0;
        this.palavraobj=null;
        this.wordSize=0;
        this.hits=0;
    }

    public int getAttempts(){
        return attempts;
    }

    public int getHits(){
        return hits;
    }

    public int getErrors(){
        return errors;
    }

}