package model.espacos;

public class Sala {
    private int numero, andar;

    public Sala(int numero, int andar) {
        this.numero = numero;
        this.andar = andar;
    }

    public int getNumero() {
        return numero;
    }

    public int getAndar() {
        return andar;
    }
}
