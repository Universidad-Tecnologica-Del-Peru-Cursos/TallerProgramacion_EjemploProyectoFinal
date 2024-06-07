package Vista;
import Controlador.controlaLogin;
import java.util.Scanner;
public class ejecucion {
    public static void main(String[] args) {
        String nombreUsuario;
        String contrasena;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario: ");
        nombreUsuario = sc.nextLine();
        System.out.println("Ingrese su contraseña: ");
        contrasena = sc.nextLine();

        controlaLogin controlaLogin = new controlaLogin(nombreUsuario, contrasena);

        if (controlaLogin.ValidarUsuario()) {
            System.out.println("Usuario validado correctamente");
        } else {
            System.out.println("Usuario no validado");
        }

    }
}