package Controlador;

import Modelo.usuario;

public class controlaLogin {
    //atributos de la clase controlaLogin
    private usuario usuario;
    private String nombreUsuario;
    private String contrasena;
    
    //constructor de la clase controlaLogin
    public controlaLogin(String nombreUsuario, String contrasena){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }
    
    //metodo para validar el usuario
    public boolean validarUsuario(){
        //se crea un objeto de la clase usuario
        usuario = new usuario(nombreUsuario, contrasena);
        //se valida el usuario
        if(usuario.getNombreUsuario().equals("admin") && usuario.getContrasena().equals("admin")){
            return true;
        }else{
            return false;
        }
    }
}