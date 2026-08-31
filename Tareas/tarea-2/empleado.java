public class empleado {
    String NumeroEmpleado;
    String Nombres;
    String Paterno;
    String Materno;
    int HorasExtras;
    double SueldoBase;
    int AñoIngreso;
    public empleado(String NumeroEmpleado, String Nombres, String Paterno, String Materno, int HorasExtras, double SueldoBase, int AñoIngreso) {
        this.NumeroEmpleado = NumeroEmpleado;
        this.Nombres = Nombres;
        this.Paterno = Paterno;
        this.Materno = Materno;
        this.HorasExtras = HorasExtras;
        this.SueldoBase = SueldoBase;
        this.AñoIngreso = AñoIngreso;
    }
    public String getNumeroEmpleado() {
        return NumeroEmpleado;
    }
    public double CalcularSueldo() {
        double pagoPorHoraExtra = HorasExtras * 276.5;
        double prestacionesDeAntiguedad = SueldoBase * 0.03 * (2026 - AñoIngreso);
        return SueldoBase + prestacionesDeAntiguedad + pagoPorHoraExtra;
    }
   @Override
public String toString() {
    return "ID: " + NumeroEmpleado + 
           " | Nombre: " + Nombres + " " + Paterno + " " + Materno + 
           " | Antigüedad: " + (2026 - AñoIngreso) + " años" +
           " | SUELDO NETO: $" + String.format("%.2f", CalcularSueldo()); // <-- AQUÍ LLAMAS A TU MÉTODO
}
}
