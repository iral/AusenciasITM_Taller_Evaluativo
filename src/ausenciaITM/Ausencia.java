package ausenciaITM;

public class Ausencia{

    private String id_empleado;
    private String motivo;
    private Fecha fecha;
    private int duracion;

    public Ausencia() {}

    public Ausencia(String id_empleado, String motivo, Fecha fecha, int duracion) {
        this.id_empleado = id_empleado;
        this.motivo = motivo;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public String getId_empleado() {
        return this.id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Fecha getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "El ID del usuario es " + id_empleado;
    }

}