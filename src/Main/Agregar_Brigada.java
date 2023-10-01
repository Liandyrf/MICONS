import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Agregar_Brigada {
    private int identificador;
    private String nombre;
    private String[] nombresHeroesCubanos = {
            "José Martí", "Antonio Maceo", "Ernesto Che Guevara", "Fidel Castro", "Camilo Cienfuegos",
            "Celia Sánchez", "Mariana Grajales", "Frank País", "Haydée Santamaría", "Abel Santamaría"
    };

    // Constructor
    public Agregar_Brigada() {
        this.identificador = generarIdentificador();
        this.nombre = generarNombreBrigadaAleatorio();
    }

    // Método para generar un identificador aleatorio
    private int generarIdentificador() {
        Random random = new Random();
        return random.nextInt(1000000000); // Puedes ajustar el rango según tus necesidades
    }

    // Método para generar un nombre de brigada aleatorio basado en héroes cubanos
    private String generarNombreBrigadaAleatorio() {
        Random random = new Random();
        int index = random.nextInt(nombresHeroesCubanos.length);
        return nombresHeroesCubanos[index] + " Brigada";
    }

    // Getters y Setters
    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void main(String[] args) {
        // Generar 10 brigadas y asignarles un proyecto aleatorio
        List<Agregar_Brigada> brigadas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Agregar_Brigada brigada = new Agregar_Brigada();
            brigadas.add(brigada);
        }

        // Asignar un proyecto aleatorio a cada brigada (asumimos que hay 5 proyectos)
        List<String> proyectos = Arrays.asList("Proyecto1", "Proyecto2", "Proyecto3", "Proyecto4", "Proyecto5");
        Random random = new Random();
        for (Agregar_Brigada brigada : brigadas) {
            int proyectoIndex = random.nextInt(proyectos.size());
            String proyectoAsignado = proyectos.get(proyectoIndex);
            System.out.println("Brigada: " + brigada.getNombre() + ", Proyecto asignado: " + proyectoAsignado);
        }
    }
}
