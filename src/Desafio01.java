import java.util.Random;
import java.util.Scanner;
    /*
       Módulo 02 - Desafio 01
        Você deve gerar um número aleatório e comparar com a resposta vinda do usuário. Caso seja o mesmo
        número o usuário ganha 10 pontos, caso seja número diferente o programa deve comparar para saber se
        o número está 1 acima ou 1 abaixo do número sorteado, caso positivo o usuário ganha 5 pontos, caso
        negativo o usuário apenas perde. No fim deverá ser exibida a pontuação do usuário. Tudo via console.

        Entrega Mínima: Sistema sorteia o número e realiza todas as comparação, no final ele exibe a pontuação correta

        Entrega Média: O sistema permite jogar mais de uma vez e soma todas as pontuações.

        Entrega Máxima: O sistema permite adicionar nível de dificuldade de alguma forma e exibe, além da pontuação,
        os números que o usuário errou e acertou.
    */
public class Desafio01 {
    public static void main(String[] args) {
        int numero;
        int numeroAleatorio;
        boolean op = true;
        int pontuacao=0;
        String sair;
        Scanner imput = new Scanner(System.in);
        while (op) {
            boolean op2=true;
            System.out.print("\n*************** ADIVINHE O NÚMERO - DESAFIO 01 ****************\n\n");
            while(op2){
                numeroAleatorio= randomizandorNumerico(20);
                System.out.println(numeroAleatorio);
                System.out.printf("Escolha um Número entre 0 e 20:");
                numero = imput.nextInt();
                if(numero==numeroAleatorio) {
                    pontuacao += 10;
                }else if(numero == (numeroAleatorio-1)|| numero == (numeroAleatorio+1)){
                    pontuacao+=5;
                }else{
                    System.out.println("Você Perdeu!!!!");
                    op2=false;
                }
            }
            System.out.printf("\nSua Pontuação foi de %d pontos.\n", pontuacao);
            op2=true;
            while (op2) {
                System.out.print("Deseja jogar novamente? (s/n) ");
                sair = imput.next();
                if (sair.equalsIgnoreCase("s")) {
                    op2 = false;
                    pontuacao = 0;
                    System.out.printf("\n\n\n\n\n");
                } else if (sair.equalsIgnoreCase("n")) {
                    op = false;
                    op2 = false;
                } else {
                    System.out.println("Opção inválida!!");
                }
            }
        }// fim do while op
    }
    // função
    public static int randomizandorNumerico(int nivel){
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(nivel);
        return valor;
    }
}
