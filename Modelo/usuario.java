package Modelo;

public class usuario{
    //atributos de la clase usuario
    private String nombreUsuario;
    private String contrasena;

    //constructor de la clase usuario
    public usuario(String nombreUsuario, String contrasena){
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    //metodos get y set de la clase usuario
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    //metodos get y set de la clase usuario
    public String getContrasena(){
        return contrasena;
    }
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    //metodo sobreescrito toString de la clase usuario
    @Override
    public String toString(){
        return  nombreUsuario + "_" + contrasena;
    }

    
}