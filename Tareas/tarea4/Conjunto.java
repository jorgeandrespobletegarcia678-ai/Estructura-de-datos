public class Conjunto<T> {
    private Nodo<T> cabeza;

    public Conjunto() {
        this.cabeza = null;
    }

    public boolean contiene(T dato) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public boolean agregar(T dato) {
        if (contiene(dato)) {
            return false; 
        }
        Nodo<T> nuevo = new Nodo<>(dato, cabeza);
        cabeza = nuevo;
        return true;
    }
    public Conjunto<T> union(Conjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        
        Nodo<T> actual = this.cabeza;
        while (actual != null) {
            resultado.agregar(actual.getDato());
            actual = actual.getSiguiente();
        }
        
        actual = otro.cabeza;
        while (actual != null) {
            resultado.agregar(actual.getDato()); 
            actual = actual.getSiguiente();
        }
        
        return resultado;
    }

    public Conjunto<T> interseccion(Conjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        
        Nodo<T> actual = this.cabeza;
        while (actual != null) {
            if (otro.contiene(actual.getDato())) {
                resultado.agregar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        
        return resultado;
    }

    public Conjunto<T> diferencia(Conjunto<T> otro) {
        Conjunto<T> resultado = new Conjunto<>();
        
        Nodo<T> actual = this.cabeza;
        while (actual != null) {
            if (!otro.contiene(actual.getDato())) {
                resultado.agregar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        
        return resultado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("}");
        return sb.toString();
    }
}
