import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class nomina{
    private String rutaArchivo;
    private ArrayADT<empleado> empleados;

    public nomina(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        int lineas = contarLineas();
        empleados = new ArrayADT<>(lineas); 
        LeerArchivo();
    }
    private int contarLineas() {
        int lineas = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            while (reader.readLine() != null) {
                lineas++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }
    public void LeerArchivo(){
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int indice = 0;
            reader.readLine();
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 7) {
                    String NumeroEmpleado = datos[0].trim();
                    String Nombres = datos[1].trim();
                    String Paterno = datos[2].trim();
                    String Materno = datos[3].trim();
                    int HorasExtras = Integer.parseInt(datos[4].trim());
                    double SueldoBase = Double.parseDouble(datos[5].trim());
                    int AñoIngreso = Integer.parseInt(datos[6].trim());
                    empleado emp = new empleado(NumeroEmpleado, Nombres, Paterno, Materno, HorasExtras, SueldoBase, AñoIngreso);
                    empleados.insertarElemento(indice, emp);
                    indice++;
                } else {
                    System.out.println("Formato de línea incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public void mayorAntiguedad() {
        if (empleados.longitud() == 0) return;
        empleado mayor = null;
        for (int i = 0; i < empleados.longitud(); i++) {
            empleado emp = empleados.obtenerElemento(i);
            if (emp != null) {
                if (mayor == null || emp.AñoIngreso < mayor.AñoIngreso) {
                    mayor = emp;
                }
            }
        }
        
        System.out.println("----------Empleado con mayor antiguedad----------");
        if (mayor != null) {
            System.out.println(mayor);
        } else {
            System.out.println("No se encontraron empleados.");
        }
    }

    public void menorAntiguedad() {
        if (empleados.longitud() == 0) return;
        empleado menor = null;
        for (int i = 0; i < empleados.longitud(); i++) {
            empleado emp = empleados.obtenerElemento(i);
            if (emp != null) {
                if (menor == null || emp.AñoIngreso > menor.AñoIngreso) {
                    menor = emp;
                }
            }
        }
        
        System.out.println("----------Empleado con menor antiguedad----------");
        if (menor != null) {
            System.out.println(menor);
        } else {
            System.out.println("No se encontraron empleados.");
        }
    }
    public void imprimirNomina() {
        for (int i = 0; i < empleados.longitud(); i++) {
            empleado emp = empleados.obtenerElemento(i);
           if(emp != null){
            System.out.println(emp);
           }
        }
    }
}