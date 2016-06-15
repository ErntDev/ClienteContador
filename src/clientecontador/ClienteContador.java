package clientecontador;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author ernt
 */
public class ClienteContador {
    
    static final String HOST="localhost";
    static final int PUERTO=5000;

    public static void main(String[] args) {
        System.out.println("Iniciando Cliente");
        iniciarCliente();
    }
    
    public static void iniciarCliente(){
        try {
            Socket so = new Socket(HOST,PUERTO);
            
            //BufferedReader entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
            DataInputStream entrada = new DataInputStream(so.getInputStream());
            DataOutputStream salida = new DataOutputStream(so.getOutputStream());
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Ingrese una cadena de texto: ");
            String cadena = sc.nextLine();
            
            salida.writeUTF(cadena);
            
            String resultado = entrada.readUTF();
            
            System.out.println(resultado);
            
        } catch (Exception e) {
        }
    }
    
}
