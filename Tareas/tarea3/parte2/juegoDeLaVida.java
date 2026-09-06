package parte2;
public class juegoDeLaVida{
    private Array2D<Integer> tableroActual;
    private int tamaño;

    public juegoDeLaVida(Array2D<Integer> tableroActual, int tamaño){
        this.tableroActual = tableroActual;
        this.tamaño = tamaño;
    }

    public int contarVecinosVivos(int fila, int columna){
        int vecinosVivos = 0;
        for(int f = fila - 1; f <= fila + 1; f++){
            for(int c = columna - 1; c <= columna + 1; c++){
                if(f == fila && c == columna){
                    continue;
                }
                if(f >= 0 && f < tamaño && c >= 0 && c < tamaño){
                    Integer estadoVecino = tableroActual.obtenerElemento(f, c);
                    if(estadoVecino != null && estadoVecino == 1){
                        vecinosVivos++;
                    }
                }
            }
        }
        return vecinosVivos;
    }

    public void calcularLaSiguienteGeneracion(){
        Array2D<Integer> tableroSiguiente = new Array2D<>(tamaño);

        for(int f = 0; f < tamaño; f++){
            
            for(int c = 0; c < tamaño; c++){
                int vecinosVivos = contarVecinosVivos(f, c);
                Integer estadoActual = tableroActual.obtenerElemento(f, c);
                
                if(estadoActual == null) {
                    estadoActual = 0; 
                }

                if(estadoActual == 1){
                    if(vecinosVivos < 2 || vecinosVivos > 3){
                        tableroSiguiente.insertarElemento(f, c, 0);

                    }else if(vecinosVivos == 2 || vecinosVivos == 3){
                        tableroSiguiente.insertarElemento(f, c, 1);
                    }else if(vecinosVivos >= 4){
                        tableroSiguiente.insertarElemento(f, c, 0);
                    }
                
                }else{
                    if(vecinosVivos == 3){
                        tableroSiguiente.insertarElemento(f, c, 1);
                    
                    }else{
                        tableroSiguiente.insertarElemento(f, c, 0);
                    }
                }
            }
        }
        tableroActual = tableroSiguiente;
    }
   // Método mejorado para imprimir el estado actual con símbolos visuales
public void mostrarJuego() {
    // Imprimimos un borde superior para encuadrar el tablero
    System.out.println("┌" + "──".repeat(tamaño) + "┐");

    for (int f = 0; f < tamaño; f++) {
        System.out.print("│"); // Borde izquierdo
        for (int c = 0; c < tamaño; c++) {
            Integer estado = (Integer) tableroActual.obtenerElemento(f, c);
            
            // Si la celda está viva (1), pintamos un cuadro; si está muerta (0), un espacio
            if (estado != null && estado == 1) {
                System.out.print("■ ");
            } else {
                System.out.print("  ");
            }
        }
        System.out.println("│");
    }
    System.out.println("└" + "──".repeat(tamaño) + "┘");
}
}