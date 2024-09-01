package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class SandboxConjuntos {

    private NavigableSet<String> arbolCadenas;

    public SandboxConjuntos() {
        arbolCadenas = new TreeSet<>();
    }

    public List<String> getCadenasComoLista() {
        // No cambios significativos necesarios aquí, ya que es un método simple.
        return new ArrayList<>(arbolCadenas);
    }

    public List<String> getCadenasComoListaInvertida() {
        // Uso de una referencia local para mayor claridad y menor impacto en la eficiencia.
        NavigableSet<String> conjuntoInvertido = arbolCadenas.descendingSet();
        return new ArrayList<>(conjuntoInvertido);
    }

    public String getPrimera() {
        // Aprovecho la llamada directa a first() sin verificación redundante.
        return arbolCadenas.isEmpty() ? null : arbolCadenas.first();
    }

    public String getUltima() {
        // Similar a getPrimera(), se reduce la verificación redundante.
        return arbolCadenas.isEmpty() ? null : arbolCadenas.last();
    }

    public Collection<String> getSiguientes(String cadena) {
        // Simplificación de tailSet utilizando la propiedad de "inclusive" explícitamente.
        return arbolCadenas.tailSet(cadena, true);
    }

    public int getCantidadCadenas() {
        // Método simple y directo, no requiere cambios.
        return arbolCadenas.size();
    }

    public void agregarCadena(String cadena) {
        // Método estándar de adición, sin necesidad de modificar.
        arbolCadenas.add(cadena);
    }

    public void eliminarCadena(String cadena) {
        // Método estándar de eliminación, no requiere modificaciones.
        arbolCadenas.remove(cadena);
    }

    public void eliminarCadenaSinMayusculasOMinusculas(String cadena) {
        // Simplificación del proceso de eliminación ignorando mayúsculas y minúsculas.
        arbolCadenas.removeIf(c -> c.equalsIgnoreCase(cadena));
    }

    public void eliminarPrimera() {
        // Método de eliminación directa de la primera entrada.
        if (!arbolCadenas.isEmpty()) {
            arbolCadenas.pollFirst();
        }
    }

    public void reiniciarConjuntoCadenas(List<Object> objetos) {
        // Claridad en el uso de toString() y reinicio del conjunto.
        arbolCadenas.clear();
        for (Object obj : objetos) {
            arbolCadenas.add(obj.toString());
        }
    }

    public void volverMayusculas() {
        // Reemplazo de arbolCadenas por una nueva instancia con cadenas en mayúsculas.
        NavigableSet<String> nuevoArbol = new TreeSet<>();
        for (String cadena : arbolCadenas) {
            nuevoArbol.add(cadena.toUpperCase());
        }
        arbolCadenas = nuevoArbol;
    }

    public TreeSet<String> invertirCadenas() {
        // Reutilización del método descendingSet() para invertir el orden.
        return new TreeSet<>(arbolCadenas.descendingSet());
    }

    public boolean compararElementos(String[] otroArreglo) {
        // Optimización con la salida anticipada si no se encuentra un elemento.
        for (String cadena : otroArreglo) {
            if (!arbolCadenas.contains(cadena)) {
                return false;
            }
        }
        return true;
    }
}
