package parte2;
import java.io.BufferedReader;
import java.io.FileReader;
public class main{
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out,true,"UTF-8"));
        Array2D<Integer> array = new Array2D<>(10);
        String rutaArchivo= "parte2/poblacion.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int fila = 0;
            while ((linea = br.readLine()) != null && fila < 10) {
                String[] valores = linea.split(",");
                for (int columna = 0; columna < valores.length && columna < 10; columna++) {
                   int celda = Integer.parseInt(valores[columna].trim());
                   array.insertarElemento(fila, columna, celda);
                }
                fila++;
            }
            System.out.println("Matriz de población: inicial");
            array.imprimir();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        juegoDeLaVida juego = new juegoDeLaVida(array, 10);
        int generaciones = 10;
        for (int i = 0; i < generaciones; i++) {
            juego.calcularLaSiguienteGeneracion();
            System.out.println("Matriz de población: generación " + (i + 1));
            juego.mostrarJuego();
        }
    }
    
}