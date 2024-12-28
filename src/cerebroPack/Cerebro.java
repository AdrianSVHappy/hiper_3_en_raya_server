package cerebroPack;

import java.util.Scanner;

/**
 * <h1>Cerebro.java</h1><hr>
 * <p>Esta clase represanta el cerebro del servidor, que modificará el tablero y mostrará el resultado correspondiente a los usuarios</p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 28-dic-2024
 */
public class Cerebro {

    private Juego juego;
    private Scanner sc;

    public Cerebro() {
        juego = new Juego();
        sc = new Scanner(System.in);
    }

    public void partida(){
        int pos;
        char ficha = 'X';

        while(!juego.ganar()){

            System.out.println(juego);

            System.out.print("Jugador " + ficha + " coloque su ficha\nPOS> ");

            pos = Integer.parseInt(sc.nextLine());

            if(juego.libre(pos))
                juego.colocar(pos, ficha);
            else {
                System.out.println("Posición ocupada");
                continue;
            }

            if(ficha == 'X')
                ficha = 'O';
            else
                ficha = 'X';

        }

        System.out.println(juego);

        System.out.println("Ganador -> " + juego.getGanador());

    }
}
