package parte1;
public class main {
    public static void main(String[] args) throws Exception {
        System.setOut(new java.io.PrintStream(System.out,true, "UTF-8"));
        tablero<String> tablero = new tablero<>(8);
        tablero.rellenar(" ");
        tablero.insertarElemento(0, 4, "\u2654");
        tablero.insertarElemento(0, 3, "\u2655");
        tablero.insertarElemento(0, 0, "\u2656");
        tablero.insertarElemento(0, 7, "\u2656");
        tablero.insertarElemento(0, 7, "\u2656");
        tablero.insertarElemento(0, 2, "\u2657");
        tablero.insertarElemento(0, 5, "\u2657");
        tablero.insertarElemento(0, 1, "\u2658");
        tablero.insertarElemento(0, 6, "\u2658");
        tablero.insertarElemento(0, 6, "\u2658");
        for (int i = 0; i < 8; i++) {
            tablero.insertarElemento(1, i, "\u2659");
        }
        // fichas blancas
        tablero.insertarElemento(7, 4, "\u265A");
        tablero.insertarElemento(7, 3, "\u265B");
        tablero.insertarElemento(7, 0, "\u265C");
        tablero.insertarElemento(7, 7, "\u265C");
        tablero.insertarElemento(7, 7, "\u265C");
        tablero.insertarElemento(7, 2, "\u265D");
        tablero.insertarElemento(7, 5, "\u265D");
        tablero.insertarElemento(7, 1, "\u265E");
        tablero.insertarElemento(7, 6, "\u265E");
        tablero.insertarElemento(7, 6, "\u265E");
        for (int i = 0; i < 8; i++) {
            tablero.insertarElemento(6, i, "\u265F");
        }
        tablero.imprimir();
    }
}