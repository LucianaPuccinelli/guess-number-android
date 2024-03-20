package com.lucianapuccinelli.adivinheonumero;

import java.util.Random;
public class adivinheNumero {
    private int numeroSecreto;
    private int tentativas;

    public adivinheNumero() {
        Random random = new Random();
        numeroSecreto = random.nextInt(1000) + 1;
        tentativas = 0;
    }

    public String checarTentativa(int tentativa) {
        tentativas++;
        if (tentativa == numeroSecreto) {
            return "Parabéns! Você acertou o número em " + tentativas + " tentativas!";
        } else if (tentativa < numeroSecreto) {
            return "É um número maior.";
        } else {
            return "É um número menor.";
        }
    }

    public void recomecar() {
        Random random = new Random();
        numeroSecreto = random.nextInt(100) + 1;
        tentativas = 0;
    }
}
