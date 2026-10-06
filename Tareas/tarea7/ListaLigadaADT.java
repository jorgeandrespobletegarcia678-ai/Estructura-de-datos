public class ListaLigadaADT<T> {
    private Nodo<T> head;
    //constructor
    public ListaLigadaADT(){
        this.head = null;
    }

    //Esta vacia?
    public void EstaVacia(){
        if (head == null) {
            System.out.println("Esta lista esta vacia");
        }else{
            System.err.println("la lista es:" + head);
        }
    }
    //regresa el numero de elementos que hay
    public int getTamanio(){
        int contador = 0;
        if(head == null){
            return contador;
        }else {
            Nodo<T> actual = head;
            do{
                contador++;
                actual = actual.getSiguiente();
            }while(actual != null);
            return contador;
        }
    }
    //agregar Datos
    public void agregar(T dato){
        if(head == null){
            this.head = new Nodo<>(dato);
        }else{
            Nodo<T> actual = head;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<>(dato));

        }
    }
    //mete un nodo al final
    public void agregarAlFinal(T dato){
        if (head == null) {
            this.head = new Nodo<>(dato);
        }else{
            Nodo<T> actual = this.head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(new Nodo<>(dato));
        }
    }

    //mete un nuevo nodo en el inicio
    public void agregaAlInicio(T dato){
      this.head = new Nodo<>(dato,this.head);

    }
    //agrega un nuevo dato despues de dato que pongamos de referencia
    public void agregarDespuesDe(T referencia, T valor ){
        if(head == null){
            System.out.println("Vacia");
        }else{
            Nodo<T> actual = this.head;
            while(!actual.getDato().equals(referencia)){
                actual = actual.getSiguiente();
            }
            Nodo<T> nuevoNodo = new Nodo<>(valor, actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
        }
    }


    //elimina el primer dato
    public void EliminaElPrimero(){
        if (this.head != null) {
            this.head = this.head.getSiguiente();
        }
    }

    //elimina el ultimo dato
    public void EliminaElUltimoDato(){
        if (this.head == null) {
            System.out.println("Esta vacia");
        } else if(this.head.getSiguiente() ==null){
            this.head = null;
        } else{
            Nodo<T> actual = head;
            while (actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
        }
    }

    //buscar un elemento
    public void buscar(T dato){
        int contador = 0;
        if(this.head == null){
            System.out.println("Esta vacia la lista");
        }else{
           Nodo<T> actual = head;
           while (actual != null) { 
               if (actual.getDato().equals(dato)) {
                System.out.println("Dato encontrado:"+ dato + "en la posicion" +contador);
                return;
               }
               actual = actual.getSiguiente();
               contador ++;
           }
           System.out.println("El dato ingresado no se ecnuentra en la lista");
        }
    }
        
    //actualiza el estado de un valor ya establecido
    public void actualizar(T aBuscar, T nuevoValor){
        if(head == null){
            System.out.println("Vacia");
        }else{
            Nodo<T> actual = this.head;
            while(!actual.getDato().equals(aBuscar)){
                actual = actual.getSiguiente();
            }
            actual.setDato(nuevoValor);
        }
    }
    //recorrido transversal para mostrar todos los elementos
    public void transversal(){
             if(head == null){
                 System.out.println("Vacia");
             }else {
                 Nodo<T> actual = head;
      //           while (actual.getSiguiente() != null) {
      //               System.out.print("|" + actual.getDato());
       //              actual = actual.getSiguiente();
      //           }
                 do{
                     System.out.print("|" + actual.getDato());
                     actual = actual.getSiguiente();
                 }while(actual != null);
             }
         }
}