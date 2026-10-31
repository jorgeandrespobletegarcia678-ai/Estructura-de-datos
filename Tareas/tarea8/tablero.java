public class tablero <T>{
private int longitud;
private int ancho;
private Object[][] datos;

public tablero(int l, int a){
this.longitud = l;
this.ancho = a;
this.datos = new Object[longitud][ancho];
}

public T obtenerElemento(int fila, int columna){
if(fila >= 0 && fila < longitud && columna >= 0 && columna < ancho) {
return (T) datos[fila][columna];
}else{
System.out.println("Indice fuera de rango");
throw new ArrayIndexOutOfBoundsException();
}
}

public void insertarElemento(int fila, int columna, T elemento){
if(fila >= 0 && fila < longitud && columna >= 0 && columna < ancho) {
datos[fila][columna] = elemento;
}else{
System.out.println("Indice fuera de rango");
throw new ArrayIndexOutOfBoundsException();
}
}

public int longitud(){
return longitud;
}

public int ancho(){
return ancho;
}

public void rellenar(T elemento){
for(int i = 0; i < longitud; i++){
for(int j = 0; j < ancho; j++){
datos[i][j] = elemento;
}
}
}

public void imprimir(){
System.out.print("[");
for(int i = 0; i < longitud; i++){
System.out.print("[");
for(int j = 0; j < ancho; j++){
System.out.print(datos[i][j] + ",");
}

System.out.println("]");
}
}
}

