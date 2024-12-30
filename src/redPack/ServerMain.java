package redPack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <h1>ServerMain.java</h1><hr>
 * <p>Esta clase represanta el controlador de sesiones</p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 30-dic-2024
 */
public class ServerMain {

    private int port;

    public ServerMain(int port) {
        this.port = port;
    }

    /**
     * Función principal, se encarga de crear seciones para cada cliente que se conecte
     */
    public void escuchar() {

        Socket sockComCli;
        Thread hiloSesion;

        try (ServerSocket serSock = new ServerSocket(port)) {

            System.out.println("Escuchando en puesto: " + this.port);

            while (true) {

                sockComCli = serSock.accept();

                System.out.println("Conectado");

                hiloSesion = new Thread(new HiloSesion(sockComCli));

                hiloSesion.start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
