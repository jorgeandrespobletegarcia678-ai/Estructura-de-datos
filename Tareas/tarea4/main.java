public class main{
    public static void main(String[] args){
        Conjunto<String> biomas = new Conjunto<>();
        biomas.agregar("Taiga");
        biomas.agregar("Desierto");
        biomas.agregar("Sabana");
        biomas.agregar("Pantano");
        biomas.agregar("Arrecife");
        System.out.println("Biomas: " + biomas);
        
        Conjunto<String> biomas_descubiertos_por_jugador1 = new Conjunto<>();
        biomas_descubiertos_por_jugador1.agregar("Taiga");
        biomas_descubiertos_por_jugador1.agregar("Desierto");
        biomas_descubiertos_por_jugador1.agregar("Sabana");
        System.out.println("Biomas descubiertos por el jugador 1: " + biomas_descubiertos_por_jugador1);

        Conjunto<String> biomas_descubiertos_por_jugador2 = new Conjunto<>();
        biomas_descubiertos_por_jugador2.agregar("Pantano");
        biomas_descubiertos_por_jugador2.agregar("Arrecife");
        biomas_descubiertos_por_jugador2.agregar("Desierto");
        biomas_descubiertos_por_jugador2.agregar("Taiga");
        biomas_descubiertos_por_jugador2.agregar("Sabana");
        System.out.println("Biomas descubiertos por el jugador 2: " + biomas_descubiertos_por_jugador2);

        Conjunto<String> biomas_no_descubiertos = biomas.diferencia(biomas_descubiertos_por_jugador1);
        System.out.println("Biomas no descubiertos por el jugador 1: " + biomas_no_descubiertos);

       Conjunto<String> logro_biomas_descubiertos_por_jugador2 = biomas.interseccion(biomas_descubiertos_por_jugador2);
        System.out.println("Logro de biomas descubiertos por el jugador 2: " + logro_biomas_descubiertos_por_jugador2);

        Conjunto<String> Dimensiones = new Conjunto<>();
        Dimensiones.agregar("Nether");
        Dimensiones.agregar("Overworld");
        Dimensiones.agregar("End");
        System.out.println("Dimensiones: " + Dimensiones);

        Conjunto<String> Dimensiones_descubiertas = new Conjunto<>();
        Dimensiones_descubiertas.agregar("Nether");
        Dimensiones_descubiertas.agregar("Overworld");
        System.out.println("Dimensiones descubiertas: " + Dimensiones_descubiertas);

        Conjunto<String> Dimensiones_no_descubiertas = Dimensiones.diferencia(Dimensiones_descubiertas);
        System.out.println("Dimensiones no descubiertas: " + Dimensiones_no_descubiertas);
    }
}