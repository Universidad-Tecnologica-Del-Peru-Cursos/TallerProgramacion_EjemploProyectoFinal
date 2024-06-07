package Vista;

import Controlador.ControladorLogin;

public class Ejecucion {
    public static void main(String[] args) {
        // Crear una instancia del controlador de login
        ControladorLogin controladorLogin = new ControladorLogin();
        
        // Llamar al método que gestiona el acceso al sistema
        controladorLogin.ImprimirBienvenidaLogin();
        controladorLogin.accesoSistema();
    }
}

