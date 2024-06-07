package Controlador;

import Modelo.usuario;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class controlaLogin {
    //atributos de la clase controlaLogin
    private usuario usuario;
    private int contador = 0;    

    //constructor de la clase controlaLogin
    public controlaLogin(){
        usuario = new usuario("","");
    }

    public void AccesoSistema(){
        Scanner lector = new Scanner(System.in);
        while(contador<=5){

            System.out.println("Ingresa usuario:");
            usuario.setNombreUsuario(lector.nextLine());
            System.out.println("Ingresa contraseña:");
            usuario.setContrasena(lector.nextLine());

            if (ValidarUsuario()) {
                System.out.println( "Usuario validado correctamente");
                return;
            } else {
                contador++;
                System.out.println("Usuario no validado");
            }
        }
        System.out.println( "Usuario bloqueado");
        return;
    }



    //metodo para validar el usuario
    public boolean ValidarUsuario() {
        File archivo = new File("usuarios.txt");
        try {
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(",");
                
                if (partes[0].equals("Usuario:"+usuario.getNombreUsuario()) && 
                partes[1].equals("Clave:"+usuario.getContrasena())) {
                    return true;
                }
            }
            
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }


}