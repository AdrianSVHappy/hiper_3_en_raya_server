package cerebroPack;

/**
 * <h1>Juego.java</h1><hr>
 * <p>Esta clase represanta el juego</p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 28-dic-2024
 */
public class Juego {

    private char[] tablero = new char[9];
    private char ganador;

    public Juego() {
        for (int i = 0; i < this.tablero.length; i++) {
            this.tablero[i] = '-';
        }
    }

    public char getGanador() {
        return ganador;
    }

    @Override
    public String toString() {
        String ret = "";

        for (int i = 0; i < this.tablero.length; i++) {

            ret += "| " + this.tablero[i] + " ";

            if (((i+1) % 3) == 0)
                ret += "|\n";
        }

        return ret;
    }

    public void colocar(int pos, char sim){
        this.tablero[pos] = sim;
    }

    public boolean libre(int pos){
        return this.tablero[pos] == '-';
    }

    public boolean ganar(){
        boolean ret = false;

        for (int i = 0; i < 9; i += 3) {
            if(this.tablero[i] != '-' && this.tablero[i] == this.tablero[i+1] && this.tablero[i] == this.tablero[i+2]){
                ret = true;
                this.ganador = this.tablero[i];
                break;
            }
        }

        if(!ret){
            for (int i = 0; i < 3; i++) {
                if(this.tablero[i] != '-' && this.tablero[i] == this.tablero[i+3] && this.tablero[i] == this.tablero[i+6]){
                    ret = true;
                    this.ganador = this.tablero[i];
                    break;
                }
            }
        }

        if(!ret){
            if(this.tablero[0] != '-' && this.tablero[0] == this.tablero[4] && this.tablero[0] == this.tablero[8]) {
                ret = true;
                this.ganador = this.tablero[0];
            }else if (this.tablero[2] != '-' && this.tablero[2] == this.tablero[4] && this.tablero[0] == this.tablero[6]) {
                ret = true;
                this.ganador = this.tablero[2];
            }
        }

        return ret;
    }

}
