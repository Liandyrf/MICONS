package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Agregar_Trabajador {
    private String numeroIdentidad;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;
    private String sexo;
    private String direccion;

    // Constructor
    public Agregar_Trabajador(String numeroIdentidad, String nombre, String apellidoPaterno,
                              String apellidoMaterno, String fechaNacimiento, String sexo, String direccion) {
        this.numeroIdentidad = numeroIdentidad;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = calcularEdad(fechaNacimiento);
        this.sexo = sexo;
        this.direccion = direccion;
    }

    // Método para extraer la fecha de nacimiento a partir del número de identidad
    public String obtenerFechaNacimiento() {
        // Asumiendo que el número de identidad tiene el formato: YYMMDDXXXXXX (donde XXXXXX son 6 dígitos aleatorios)
        if (numeroIdentidad.length() >= 6) {
            int yearPrefix = Integer.parseInt(numeroIdentidad.substring(0, 2));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR) % 100; // Obtener los últimos dos dígitos del año actual

            // Determinar el siglo adecuado para el año de nacimiento
            int century = (currentYear - yearPrefix >= 0) ? 2000 : 1900;
            int year = century + yearPrefix;

            String mes = numeroIdentidad.substring(2, 4);
            String dia = numeroIdentidad.substring(4, 6);
            return dia + "." + mes + "." + year;
        } else {
            return "Fecha de nacimiento no disponible";
        }
    }    

    // Método para calcular la edad en años cumplidos
    public int calcularEdad() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date fechaNac = dateFormat.parse(obtenerFechaNacimiento());
            Date fechaActual = new Date();
            Calendar calendarFechaNac = Calendar.getInstance();
            calendarFechaNac.setTime(fechaNac);

            Calendar calendarFechaActual = Calendar.getInstance();
            calendarFechaActual.setTime(fechaActual);

            int edad = calendarFechaActual.get(Calendar.YEAR) - calendarFechaNac.get(Calendar.YEAR);

            // Verificar si aún no se ha cumplido el año de la fecha de nacimiento
            if (calendarFechaActual.get(Calendar.MONTH) < calendarFechaNac.get(Calendar.MONTH) ||
                    (calendarFechaActual.get(Calendar.MONTH) == calendarFechaNac.get(Calendar.MONTH) &&
                            calendarFechaActual.get(Calendar.DAY_OF_MONTH) < calendarFechaNac.get(Calendar.DAY_OF_MONTH))) {
                edad--;
            }

            return edad;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Getters y Setters
    public String getNumeroIdentidad() {
        return numeroIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDireccion() {
        return direccion;
    }

}
