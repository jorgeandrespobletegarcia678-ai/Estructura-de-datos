import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class tarea1 {
    public static void main(String[] args) {
        ArrayList<tabla> BaseDeDatos = new ArrayList<>();
        String rutaArchivo = "C:\\Users\\jorge\\OneDrive\\Documentos\\Estructura-de-datos\\Tareas\\tarea-1\\datos_redes_sociales (1).csv";
        String linea;

        //Aqui inicia la lectura del archivo 
        //Bufferedreader sirve para leer texto de un flujo de entrada de caracteres, como un archivo de texto.

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine(); // Saltarse la primera línea de encabezados

            while ((linea = br.readLine()) != null) {
                // Dividimos la línea en columnas usando la coma como separador ocupando split
                String[] columnas = linea.split(",");
                // Validamos que la línea tenga al menos 4 columnas (red, concepto, año y al menos un mes)
                if (columnas.length < 4) continue;

              String red = columnas[0].replace("\"", "").trim().toUpperCase();
              String concepto = columnas[1].replace("\"", "").trim().toUpperCase();    
              String anioTexto = columnas[2].trim();
              int año = Integer.parseInt(anioTexto);

              double[] valoresMeses = new double[12];
                for (int i = 0; i < 12; i++) {
                    if (i + 3 >= columnas.length || columnas[i + 3].trim().isEmpty()) {
                        valoresMeses[i] = 0.0;
                    } else {
                        String valorTexto = columnas[i + 3].replace("%", "").replace("\"", "").trim();
                        valoresMeses[i] = Double.parseDouble(valorTexto);
                    }
                }

                tabla nuevaFila = new tabla(red, concepto, año, valoresMeses);
                BaseDeDatos.add(nuevaFila);
            }
            System.out.println("¡Base de datos cargada con éxito en la memoria RAM!");

        } catch (IOException e) {
            System.out.println("Error al abrir el archivo CSV: " + e.getMessage());
            System.out.println("Asegúrate de que el archivo esté en la misma carpeta que este código.");
            return;
        }

        // Aqui ya pedimos los menses
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingresa el primer mes (ej. Enero): ");
        String mesInicioTexto = teclado.next().trim();
        System.out.print("Ingresa el segundo mes (ej. Junio): ");
        String mesFinTexto = teclado.next().trim();

        // Convertimos el texto ingresado a su índice de columna (0 a 11)
        int idxInicio = convertirMesAIndice(mesInicioTexto);
        int idxFin = convertirMesAIndice(mesFinTexto);

        if (idxInicio == -1 || idxFin == -1 || idxInicio > idxFin) {
            System.out.println("Error: Los meses no son válidos o el orden es incorrecto.");
            teclado.close();
            return;
        }
        System.out.println("\nRESULTADOS");

        double sumaCrecimientoTwitter = 0;
        double sumaCrecimientoFacebook = 0;
        int mesesContados = (idxFin - idxInicio) + 1;

        double sumaMeGustaTotal = 0;
        int filasMeGustaContadas = 0;

        for (tabla fila : BaseDeDatos) {
            // EJERCICIO A: Diferencia de seguidores en Twitter
           if (fila.redSocial.contains("TWITTER") && fila.concepto.contains("SEGUIDOR")) {
  
              double diferenciaTwitter = fila.meses[5] - fila.meses[0];
              System.out.printf("A) Diferencia de seguidores en Twitter (Ene-Jun): %,.0f\n", diferenciaTwitter);
}

            // EJERCICIO B: Diferencia de visualizaciones en YouTube
            if (fila.redSocial.equals("YOUTUBE") && fila.concepto.equals("VISUALIZACIONES")) {
                double difVisitas = fila.meses[idxFin] - fila.meses[idxInicio];
                System.out.printf("B) Diferencia de visualizaciones en YouTube (%s a %s): %,.0f%n", 
                        mesInicioTexto, mesFinTexto, difVisitas);
            }

            // Para EJERCICIO C: Crecimiento acumulado
            if (fila.concepto.contains("CRECIMIENTO") && !fila.concepto.contains("PORCENTAJE DE CRECIMIENTO")) {
                if (fila.redSocial.equals("TWITTER")) {
                    for (int i = 0;i <= 5; i++) {
                        sumaCrecimientoTwitter += fila.meses[i];
                    }
                }
                if (fila.redSocial.equals("FACEBOOK")) {
                    for (int i = 0; i <= 5; i++)
                         sumaCrecimientoFacebook += fila.meses[i];
                }
            }

            // Para EJERCICIO D: Promedio general de "Me gusta"
            if (fila.concepto.contains("ME GUSTA")) {
                for (int i = 0; i<12; i++) {
                    sumaMeGustaTotal += fila.meses[i];
                }
                filasMeGustaContadas++;
            }
        }
            // Cálculos finales y despliegue de promedios
            double promCrecimientoTwitter = sumaCrecimientoTwitter / 6.0;
            double promCrecimientoFacebook = sumaCrecimientoFacebook / 6.0;

            System.out.printf("C) Promedio de crecimiento en Twitter: %.2f%% | En Facebook: %.2f%%\n", 
              promCrecimientoTwitter, promCrecimientoFacebook);

            double promMeGustaTotal = 0;
            if (filasMeGustaContadas > 0) {
            promMeGustaTotal = sumaMeGustaTotal / (filasMeGustaContadas * 12.0);
}
            System.out.printf("D) Promedio general de 'Me gusta' (Todas las redes): %,.2f\n", promMeGustaTotal);
        teclado.close();
    }

    // convertimos el mes a su índice correspondiente (0 a 11)
    public static int convertirMesAIndice(String mes) {
        switch (mes.toLowerCase()) {
            case "enero": return 0;
            case "febrero": return 1;
            case "marzo": return 2;
            case "abril": return 3;
            case "mayo": return 4;
            case "junio": return 5;
            case "julio": return 6;
            case "agosto": return 7;
            case "septiembre": return 8;
            case "octubre": return 9;
            case "noviembre": return 10;
            case "diciembre": return 11;
            default: return -1;
        }
    }
}