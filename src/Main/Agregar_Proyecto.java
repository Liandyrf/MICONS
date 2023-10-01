package Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;

public class Agregar_Proyecto {

    private HashMap<String, String[]> provincias;

    public Agregar_Proyecto() {
        this.provincias = new HashMap<>();
        // Agregar las provincias y sus municipios
        agregarProvincia("Pinar del Río",
                "Consolación del Sur", "Guane", "La Palma", "Los Palacios", "Mantua",
                "Minas de Matahambre", "Pinar del Río", "San Juan y Martínez", "San Luis", "Sandino", "Viñales");

        agregarProvincia("Artemisa",
                "Alquízar", "Artemisa", "Bahía Honda", "Bauta", "Caimito", "Candelaria", "Guanajay",
                "Güira de Melena", "Mariel", "San Antonio de los Baños", "San Cristóbal");

        agregarProvincia("La Habana",
                "Arroyo Naranjo", "Boyeros", "Centro Habana", "Cerro", "Cotorro", "Diez de Octubre",
                "Guanabacoa", "La Habana del Este", "La Habana Vieja", "La Lisa", "Marianao", "Playa",
                "Plaza de la Revolución", "Regla", "San Miguel del Padrón");

        agregarProvincia("Mayabeque",
                "Batabanó", "Bejucal", "Güines", "Jaruco", "Madruga", "Melena del Sur", "Nueva Paz",
                "Quivicán", "San José de las Lajas", "San Nicolás", "Santa Cruz del Norte");

        agregarProvincia("Matanzas",
                "Calimete", "Cárdenas", "Ciénaga de Zapata", "Colón", "Jagüey Grande", "Jovellanos",
                "Limonar", "Los Arabos", "Martí", "Matanzas", "Pedro Betancourt", "Perico", "Unión de Reyes");

        agregarProvincia("Cienfuegos",
                "Abreus", "Aguada de Pasajeros", "Cienfuegos", "Cruces", "Cumanayagua", "Lajas", "Palmira", "Rodas");

        agregarProvincia("Villa Clara",
                "Caibarién", "Camajuaní", "Cifuentes", "Corralillo", "Encrucijada", "Manicaragua", "Placetas",
                "Quemado de Güines", "Ranchuelo", "San Juan de los Remedios", "Sagua la Grande", "Santa Clara", "Santo Domingo");

        agregarProvincia("Sancti Spíritus",
                "Cabaiguán", "Fomento", "Jatibonico", "La Sierpe", "Sancti Spíritus", "Taguasco", "Trinidad", "Yaguajay");

        agregarProvincia("Ciego de Ávila",
                "Baraguá", "Bolivia", "Chambas", "Ciego de Ávila", "Ciro Redondo", "Florencia", "Majagua", "Morón",
                "Primero de Enero", "Venezuela");

        agregarProvincia("Camagüey",
                "Camagüey", "Carlos M. de Céspedes", "Esmeralda", "Florida", "Guáimaro", "Jimaguayú", "Minas", "Najasa",
                "Nuevitas", "Santa Cruz del Sur", "Sibanicú", "Sierra de Cubitas", "Vertientes");

        agregarProvincia("Las Tunas",
                "Amancio", "Colombia", "Jesús Menéndez", "Jobabo", "Las Tunas", "Majibacoa", "Manatí", "Puerto Padre");

        agregarProvincia("Holguín",
                "Antilla", "Báguanos", "Banes", "Cacocum", "Calixto García", "Cueto", "Frank País", "Gibara", "Holguín",
                "Mayarí", "Moa", "Rafael Freyre", "Sagua de Tánamo", "Urbano Noris");

        agregarProvincia("Granma",
                "Bartolomé Masó", "Bayamo", "Buey Arriba", "Campechuela", "Cauto Cristo", "Guisa", "Jiguaní",
                "Manzanillo", "Media Luna", "Niquero", "Pilón", "Río Cauto", "Yara");

        agregarProvincia("Santiago de Cuba",
                "Contramaestre", "Guamá", "Mella", "Palma Soriano", "San Luis", "Santiago de Cuba", "Segundo Frente", "Songo-La Maya", "Tercer Frente");

        agregarProvincia("Guantánamo",
                "Baracoa", "Caimanera", "El Salvador", "Guantánamo", "Imías", "Maisí", "Manuel Tames", "Niceto Pérez",
                "San Antonio del Sur", "Yateras");
        agregarProvincia("Isla de la Juventud",
                "Isla de la Juventud");


        // No se agregan municipios al Municipio especial Isla de la Juventud
    }

    private void agregarProvincia(String nombreProvincia, String... municipios) {
        ArrayList<String> listaMunicipios = new ArrayList<>();
        for (String municipio : municipios) {
            listaMunicipios.add(municipio);
        }
        provincias.put(nombreProvincia, listaMunicipios);
    }

    public ArrayList<String> getMunicipios(String nombreProvincia) {
        return provincias.getOrDefault(nombreProvincia, new ArrayList<>());
    }
   
public void solicitarNombreProyecto(String identificador, String nombreProyecto) {
    System.out.println("Nombre del proyecto asociado a " + identificador + ": " + nombreProyecto);
}

/*método para generar el identificador de la obra o proyecto, siempre y cuando el nombre esté 
compuesto por una sola palabra, de lo contrario se toma la primera letra de cada palabra que 
componga el nombre de la provincia, seguidamente un guion “-”, luego las dos primeras letras
del nombre del municipio en el que se va a llevar a cabo, seguidamente un guion “-” y luego el día,
mes, año, seguido de un guion y el número en orden consecutivo de los proyectos agregados ese mismo día,
por lo que el identificador de un proyecto a ejecutar en Granma, Bayamo, siendo este el 
primer proyecto agregado al sistema en fecha 30.09.2023 quedaría 
de la siguiente forma “GRA-BA-30.09.23-01”       */
    private String generarIdentificador(String provincia, String municipio, Date fecha, int proyectosAgregadosHoy) {
        // Generar el identificador según el formato indicado
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
        String fechaFormato = sdf.format(fecha);
        String identificador_proyecto = provincia.substring(0, 3).toUpperCase() + "-" +
                municipio.substring(0, 2).toUpperCase() + "-" +
                fechaFormato + "-" +
                String.format("%02d", proyectosAgregadosHoy);
        
        
 // Llamar al método para solicitar el nombre del proyecto
        solicitarNombreProyecto(identificador_proyecto);

        return identificador_proyecto;
    }

}