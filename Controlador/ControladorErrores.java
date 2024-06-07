package Controlador;
import Modelo.Errores;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ControladorErrores {
    public static void guardarError(Errores error) {
        // Nombre del archivo
        String nombreArchivo = "errores.log";

        // Texto que se va a escribir en el archivo
        String texto = error.toString();
        // Crear el archivo
        File archivo = new File(nombreArchivo);

        // Utilizar FileWriter para escribir en el archivo
        try (FileWriter escritor = new FileWriter(archivo)) {
            escritor.write(texto);
        } catch (IOException e) {
            // Manejar la excepción en caso de error
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}




