package parte1;
public class tablero <T>{
private int longitud;
private Object[][] datos;

public tablero(int l){
this.longitud = l;
this.datos = new Object[longitud][longitud];
}

public T obtenerElemento(int fila, int columna){
if(fila >= 0 && fila < longitud && columna >= 0 && columna < longitud) {
return (T) datos[fila][columna];
}else{
System.out.println("Indice fuera de rango");
throw new ArrayIndexOutOfBoundsException();
}
}

public void insertarElemento(int fila, int columna, T elemento){
if(fila >= 0 && fila < longitud && columna >= 0 && columna < longitud) {
datos[fila][columna] = elemento;
}else{
System.out.println("Indice fuera de rango");
throw new ArrayIndexOutOfBoundsException();
}
}

public int longitud(){
return longitud;
}

public void rellenar(T elemento){
for(int i = 0; i < longitud; i++){
for(int j = 0; j < longitud; j++){
datos[i][j] = elemento;
}
}
}

public void imprimir(){
System.out.print("[");
for(int i = 0; i < longitud; i++){
System.out.print("[");
for(int j = 0; j < longitud; j++){
System.out.print(datos[i][j] + ",");
}

System.out.println("]");
}
}
}

