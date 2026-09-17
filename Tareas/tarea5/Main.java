public class Main {
    public static void main(String[] args) {
      Nodo<String> Nodo= new Nodo("al", new Nodo("b", new Nodo("c", new Nodo("De",new Nodo("Mc",new Nodo("zi"))))));
        System.out.println(Nodo);
        System.out.println("El primer dato del nodo es: " + Nodo.getDato());
        System.out.println("El ultimo nodo es: " + Nodo.getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().getDato());
        Nodo.getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo("fe", Nodo.getSiguiente().getSiguiente().getSiguiente().getSiguiente()));
        System.out.println(Nodo);
        Nodo.getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo ("Zz"));
        System.out.println(Nodo);
        Nodo = new Nodo<>("Aa", Nodo);
        System.out.println(Nodo);
    }
}