import java.util.Random;

public class Desafio01 {
    public static void main(String[] args) {

    }
    // função
    public static int randomizandorNumerico(int nivel){
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(nivel);
        return valor;
    }
}
