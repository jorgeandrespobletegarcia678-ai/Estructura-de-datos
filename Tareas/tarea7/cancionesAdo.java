public class cancionesAdo{
    private String Nombre;
    private int anio;
    private String Duracion;

    public cancionesAdo() {
    }

    public cancionesAdo(String nombre, int anio, String duracion) {
        Nombre = nombre;
        this.anio = anio;
        Duracion = duracion;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getDuracion() {
        return Duracion;
    }
    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        cancionesAdo otra = (cancionesAdo) obj;
        return this.Nombre.equals(otra.Nombre);
    }


    @Override
    public String toString() {
        return Nombre + "  duracion:(" + Duracion+ ")  " + "  año:[" + anio + "]\n" ;
    }       
}