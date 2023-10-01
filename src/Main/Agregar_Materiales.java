package Main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Agregar_Materiales {
    private String identificador;
    private String nombre;
    private String tipoDistribucion;
    private String unidadMedida;
    private double precioUnitario;
    private double cantidadExistencia;

    // Constructor
    public Agregar_Materiales(String nombre, String tipoDistribucion, String unidadMedida, double precioUnitario, double cantidadExistencia, String identificadorProyecto) {
        this.identificador = generarIdentificador(identificadorProyecto);
        this.nombre = nombre;
        this.tipoDistribucion = tipoDistribucion;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.cantidadExistencia = cantidadExistencia;
    }

    // Método para generar un identificador aleatorio basado en la fecha y hora actuales y el identificador del proyecto al que se asocia el material
    private String generarIdentificador(String identificador_proyecto) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss/ddMMyy");
        Date fechaActual = new Date();
        return dateFormat.format(fechaActual) + "/" + identificador_proyecto;
    }

    // Getters y Setters
    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDistribucion() {
        return tipoDistribucion;
    }

    public void setTipoDistribucion(String tipoDistribucion) {
        this.tipoDistribucion = tipoDistribucion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(double cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }
}
