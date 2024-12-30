package redPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * <h1>HiloSesion.java</h1><hr>
 * <p>Esta clase represanta cada sesión</p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 30-dic-2024
 */
public class HiloSesion implements Runnable {

    private final static String COD_TEXTO = "UTF-8";

    private Socket sock;

    private char ficha;
    private String ip;
    private int port;

    public HiloSesion(Socket sock) {
        this.sock = sock;
        this.ip = sock.getInetAddress().getHostAddress();
        this.port = sock.getPort();
    }

    /**
     * Función Run del hilo, que establece comunicación de lectura con los clientes
     */
    @Override
    public void run() {

        String linea;

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(this.sock.getInputStream(), COD_TEXTO));
        ) {

            while ((linea = br.readLine()) != null) {
                System.out.println(this.ip + " : " + this.port);
                System.out.println(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


