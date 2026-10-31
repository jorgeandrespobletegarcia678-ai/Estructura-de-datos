import java.util.Stack;

public class backtraking {
    private static final int[] DIR_FILAS = {-1, 1, 0, 0};
    private static final int[] DIR_COLUMNAS = {0, 0, -1, 1};

    public static boolean resolver(tablero<Character> lab, int filaInicio, int colInicio) {
        Stack<Coordenada> pila = new Stack<>();
        pila.push(new Coordenada(filaInicio, colInicio));

        while (!pila.isEmpty()) {
            Coordenada actual = pila.peek();
            int f = actual.fila;
            int c = actual.col;

            char celdaActual = lab.obtenerElemento(f, c);
            if (celdaActual == 'S') {
                return true;
            }
            if (celdaActual == '0') {
                lab.insertarElemento(f, c, '.');
            }
            boolean seMovio = false;
            for (int i = 0; i < 4; i++) {
                int nuevaFila = f + DIR_FILAS[i];
                int nuevaColumna = c + DIR_COLUMNAS[i];

                if (nuevaFila >= 0 && nuevaFila < lab.longitud() && nuevaColumna >= 0 && nuevaColumna < lab.ancho()) {
                    char vecino = lab.obtenerElemento(nuevaFila, nuevaColumna);
                    if (vecino == '0' || vecino == 'S') {
                        pila.push(new Coordenada(nuevaFila, nuevaColumna));
                        seMovio = true;
                        break;
                    }
                }
            }
            if (!seMovio) {
                pila.pop();
                if (lab.obtenerElemento(f, c) == '.') {
                    lab.insertarElemento(f, c, ' '); 
                }
            }
        }

        return false;
    }
}
