import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        // Buscar todos los archivos .lab en la raíz del proyecto
        File carpeta = new File("laberintos"); 
        File[] archivosLab = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".lab"));

        if (archivosLab == null || archivosLab.length == 0) {
            System.out.println("No se encontraron archivos");
            return;
        }

        System.out.println("Se encontro " + archivosLab.length + " laberintos para resolver.\n");

        for (File archivo : archivosLab) {
            System.out.println("==================================================");
            System.out.println("PROCESANDO: " + archivo.getName());
            System.out.println("==================================================");

            tablero<Character> laberinto = cargarDesdeArchivo(archivo.getAbsolutePath());

            if (laberinto == null) {
                System.out.println("Saltando archivo por error de lectura.\n");
                continue;
            }

            System.out.println("--- Estado Inicial ---");
            laberinto.imprimir();

            int filaInicio = -1, colInicio = -1;
            for (int i = 0; i < laberinto.longitud(); i++) {
                for (int j = 0; j < laberinto.ancho(); j++) {
                    if (laberinto.obtenerElemento(i, j) == 'E') {
                        filaInicio = i;
                        colInicio = j;
                        break;
                    }
                }
            }

            if (filaInicio == -1) {
                System.out.println("\nNo se encontró la Entrada\n");
                continue; 
            }

            System.out.println("\nResolviendo coordenadas de inicio(" + filaInicio + ", " + colInicio + ")...");
            boolean resuelto = backtraking.resolver(laberinto, filaInicio, colInicio);

            if (resuelto) {
                System.out.println("\n--- ¡Laberinto Resuelto Exitosamente! ---");
                laberinto.imprimir();
            } else {
                System.out.println("\n--- No se encontró solución ---");
            }
            System.out.println("\n");
        }
    }
    private static tablero<Character> cargarDesdeArchivo(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            int filas = Integer.parseInt(br.readLine().trim());
            int columnas = Integer.parseInt(br.readLine().trim());
            
            tablero<Character> lab = new tablero<>(filas, columnas);

            for (int i = 0; i < filas; i++) {
                String linea = br.readLine();
                if (linea == null) break;
                
                String[] valores = linea.split(","); 
                for (int j = 0; j < columnas; j++) {
                    if (j < valores.length) {
                        lab.insertarElemento(i, j, valores[j].trim().charAt(0));
                    } else {
                        lab.insertarElemento(i, j, '1');
                    }
                }
            }
            return lab;
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
            return null;
        }
    }
}
