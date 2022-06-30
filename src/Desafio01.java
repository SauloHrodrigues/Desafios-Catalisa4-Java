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
        int range;
        int cont = 0;
        boolean op = true;
        int pontuacao = 0;
        String resposta;
        Scanner imput = new Scanner(System.in);
        while (op) {
            boolean op2 = true;
            System.out.println("************ JOGO DA ADIVINHAÇÃO ************************\n");
            System.out.println("Funcionamento: Neste jogo você escolhe um tamanho de range, e tenta adivinhar ");
            System.out.println("qual o número o computador esta jogando. Se você acerta, ganha 10 pontos e joga");
            System.out.println("novamente, podendo aumentar a dificuldade, aumentando o range, se você errar por um,");
            System.out.println("a mais ou a menos, você ganha 5 pontos e joga novamente. Se você errar, o jogo acaba.");
            System.out.printf("Vamos lá!\n\n");
            System.out.print("Escolha o range inicial : ");
            range = imput.nextInt();
            while (op2) {
                cont++;
                numeroAleatorio = randomizandorNumerico(range);
                System.out.println(numeroAleatorio + " - " + range);// para testar

                System.out.printf("EDESAFIO %dº - ADIVINHE O NÚMERO ENTRE 0 E %d : ", cont, range);
                numero = imput.nextInt();

                if (numero == numeroAleatorio) {
                    System.out.println("Parmbéns! Você acertou o número e ganhou 10 pontos ");
                    pontuacao += 10;
                    range = alteraRange(range, imput);

                } else if (numero == (numeroAleatorio - 1) || numero == (numeroAleatorio + 1)) {
                    System.out.println("Legal! Você errou por um e ganhou 5 pontos");
                    pontuacao += 5;
                    range = alteraRange(range, imput);
                } else {
                    System.out.printf("\nQue pena! Você perdeu. Deseja jogar novamente? (s/n) ");
                    String x = imput.next();
                    boolean resp = verificarResposta(x, imput);
                    if (resp == true) {
                        System.out.printf("Você acumulou %d pontos. Deseja zerar? (s/n) ", pontuacao);
                        x = imput.next();
                        resp = verificarResposta(x, imput);
                        if (resp == true) {
                            pontuacao = 0;
                            op = true;
                        }
                    } else {
                        System.out.printf("Voce jogou %d vezer e angariou %d pontos!", cont, pontuacao);
                        op2 = false;
                        op = false;
                    }
                }
            }
        }

    }

    // função
    public static int randomizandorNumerico(int nivel) {
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(nivel);
        return valor;
    }

    public static Boolean verificarResposta(String resposta, Scanner sc) {
        boolean resp = true;
        boolean aux = true;
        String aux2 = resposta;
        while (resp) {
            if (aux2.equalsIgnoreCase("s")) {
                resp = false;
                aux = true;
            } else if (aux2.equalsIgnoreCase("n")) {
                resp = false;
                aux = false;
            } else {
                System.out.print("Resposta inválida! Responda (s ou n).");
                aux2 = sc.next();
            }
        }
        return aux;
    }

    public static int alteraRange(int range, Scanner recebe) {
        int nRange;
        System.out.printf("O range atual é %d, Deseja almentar? (s/n) ", range);
        String aux = recebe.next();
        boolean resp = verificarResposta(aux, recebe);
        if (resp == true) {
            System.out.print("Digite o novo range : ");
            nRange = recebe.nextInt();
        } else {
            nRange = range;
        }
        return nRange;
    }
}