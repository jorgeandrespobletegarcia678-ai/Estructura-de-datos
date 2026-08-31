public class main{
    public static void main(String[] args) {
       nomina control = new nomina("C:\\Users\\jorge\\OneDrive\\Documentos\\Estructura-de-datos\\Tareas\\tarea-2\\junio.dat");
      System.out.println("------Nomina de empleados completa-------");
      control.imprimirNomina();
      control.mayorAntiguedad();   
      control.menorAntiguedad();
    }
}