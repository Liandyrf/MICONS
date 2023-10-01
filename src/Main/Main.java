package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Crear algunos trabajadores (puedes adaptar según tus necesidades)
        ArrayList<Agregar_Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(new Agregar_Trabajador("95110412345", "Juan", "Pérez", "González", "04.11.1995", "M", "Calle 123"));
        trabajadores.add(new Agregar_Trabajador("99050656789", "María", "López", "Fernández", "06.05.1999", "F", "Avenida 456"));
        trabajadores.add(new Agregar_Trabajador("88021087654", "Carlos", "Martínez", "Díaz", "10.02.1988", "M", "Calle 789"));

        // Ordenar los trabajadores por edad de mayor a menor
        Collections.sort(trabajadores, Comparator.comparingInt(Agregar_Trabajador::getEdad).reversed());

        // Exportar los datos a un archivo de texto
        exportarTrabajadores(trabajadores, "trabajadores_micons.txt");
    }

    public static void exportarTrabajadores(ArrayList<Agregar_Trabajador> trabajadores, String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Agregar_Trabajador trabajador : trabajadores) {
                String linea = trabajador.getEdad() + ", " + trabajador.getNumeroIdentidad() + ", " + trabajador.getNombre();
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}