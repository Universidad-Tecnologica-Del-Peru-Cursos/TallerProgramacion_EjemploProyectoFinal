package Controlador;

import Modelo.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ControladorLogin {
    // Número máximo de intentos permitidos para ingresar al sistema
    private static final int MAX_INTENTOS = 5;

    // Atributo de la clase Usuario para almacenar los datos del usuario
    private Usuario usuario;
    // Contador para llevar la cuenta de los intentos de acceso fallidos
    private int contador = 0;

    // Constructor de la clase ControladorLogin que inicializa el objeto Usuario
    public ControladorLogin() {
        usuario = new Usuario("", "");
    }

    public void ImprimirBienvenidaLogin() {
        System.out.println("********************************************");
        System.out.println("Bienvenido al sistema de analisis de datos");
        System.out.println("********************************************");
    }
    // Método que gestiona el proceso de acceso al sistema
    public void accesoSistema() {
        // Crear un objeto Scanner para leer la entrada del usuario desde la consola
        try (Scanner lector = new Scanner(System.in)) {
            // Bucle que permite hasta MAX_INTENTOS intentos de acceso
            while (contador <= MAX_INTENTOS) {
                // Solicitar al usuario que ingrese su nombre de usuario
                System.out.print("Ingresa usuario:");
                usuario.setNombreUsuario(lector.nextLine());
                
                // Solicitar al usuario que ingrese su contraseña
                System.out.print("Ingresa contraseña:");
                usuario.setContrasena(lector.nextLine());

                // Verificar las credenciales ingresadas
                if (validarUsuario()) {
                    // Si las credenciales son válidas, se notifica al usuario y se termina el proceso
                    System.out.println("Usuario validado correctamente");
                    System.out.println("********************************************");
                    return;
                } else {
                    // Si las credenciales no son válidas, se incrementa el contador y se notifica al usuario
                    contador++;
                    System.out.println("Usuario no validado");
                    System.out.println("********************************************");
                }
            }
            // Si se excede el número máximo de intentos, se notifica al usuario que ha sido bloqueado
            System.out.println("Usuario bloqueado");
            System.out.println("********************************************");
        }
    }

    // Método que valida las credenciales del usuario comparándolas con un archivo de texto
    public boolean validarUsuario() {
        // Usar FileReader y BufferedReader para leer el archivo de usuarios
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            // Leer el archivo línea por línea
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando la coma como delimitador
                String[] partes = linea.split(",");

                // Comparar las credenciales ingresadas con las almacenadas en el archivo
                if (partes[0].equals("Usuario:" + usuario.getNombreUsuario()) &&
                    partes[1].equals("Clave:" + usuario.getContrasena())) {
                    // Si las credenciales coinciden, devolver true
                    return true;
                }
            }
            // Si ninguna línea coincide con las credenciales ingresadas, devolver false
            return false;
        } catch (IOException e) {
            // Manejar la excepción si ocurre un error al leer el archivo y notificar al usuario
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
            return false;
        }
    }
}