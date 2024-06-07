package Controlador;

import Modelo.usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class controlaLogin {
    //atributos de la clase controlaLogin
    private usuario usuario;

    
    //constructor de la clase controlaLogin
    public controlaLogin(String nombreUsuario, String contrasena){
        this.usuario = new usuario(nombreUsuario, contrasena);
    }
    
    //metodo para validar el usuario
    public boolean ValidarUsuario() {
        File archivo = new File("usuarios.txt");
        try {
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");
                System.out.println("Usuario:"+usuario.getNombreUsuario());
                System.out.println("Clave:"+usuario.getContrasena());
                if (partes[0].equals("usuario:"+usuario.getNombreUsuario()) && 
                partes[1].equals("clave:"+usuario.getContrasena())) {
                    return true;
                }
            }
            sc.close();
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


}