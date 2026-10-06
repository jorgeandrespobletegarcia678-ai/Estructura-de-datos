public class Main{
    public static void main(String[] args) {
        ListaLigadaADT<cancionesAdo> playlist = new ListaLigadaADT<>();

        cancionesAdo cancion1 =new cancionesAdo("Odo",2021 ,"3:24");
        cancionesAdo cancion2 = new cancionesAdo("Dignity version MV",2023,"4:12");
        cancionesAdo cancion3 = new cancionesAdo("Show",2023,"3:09");
        cancionesAdo cancion4 = new cancionesAdo("I am controversy", 2023, "3:15");
        cancionesAdo cancion5 = new cancionesAdo("Magic", 2025, "2:52");
        cancionesAdo cancion6 = new cancionesAdo("Ussewa Live", 2024, "3:35");
        playlist.EstaVacia();
        playlist.agregar(cancion1);
        playlist.agregar(cancion2);
        playlist.transversal();
        System.out.println("-----------------------");
        playlist.agregaAlInicio(cancion3);
        playlist.transversal();
        System.out.println("El numero canciones por el momento son:" + playlist.getTamanio());
        playlist.agregarAlFinal(cancion4);
        playlist.transversal();
        System.out.println("-----------------------");
        playlist.buscar(cancion2);
        playlist.actualizar(cancion4, cancion5);
        playlist.transversal();
        System.out.println("-----------------------");
        playlist.agregarDespuesDe(cancion3, cancion6);
        playlist.transversal();
        System.out.println("-----------------------");
        playlist.EliminaElPrimero();
        playlist.EliminaElUltimoDato();
        playlist.transversal();
    }
}