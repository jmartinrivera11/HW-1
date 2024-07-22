/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw.pkg1;

public class Transito {
    
    Multa[] multas;
    int contador;
    String text;
    
    public Transito() {
        multas = new Multa[100];
        contador = 0;
    }
    
    public Multa buscar(int codigo) {
        for (Multa multa : multas) {
            if (multa != null && multa.getCodigo() == codigo) {
                return multa;
            }
        }
        return null;
    }
    
    public boolean agregarMulta(int codigo, String nombre, String tipo) {
        if (buscar(codigo) == null)
            for (int i = 0; i < multas.length; i++) {
                if (multas[i] == null) {
                    multas[i] = new Multa(codigo, nombre, tipo);
                    contador += 1;
                    return true;
                }
            }
        return false;
    }
    
    public boolean pagarMulta(int codigo) {
        Multa multa = buscar(codigo);
        if (multa != null) {
            text = multa.pay();
            return true;
        }
        return false;
    }
    
    public String print(int codigo) {
        String texto = "";
        Multa multa = buscar(codigo);
        if (multa != null)
            texto = "Nombre: " + multa.getNombre() + "\nCódigo: " 
                    + multa.getCodigo() + "\nTipo: " + multa.getTipo() 
                    + "\nPagada: " + multa.getPagado();
        return texto;
    }
    
    public String printTodas() {
        String texto = "";
        for (int i = 0; i < multas.length; i++)
            if (multas[i] != null)
                texto += "Nombre: " + multas[i].getNombre() + "\nCódigo: " 
                        + multas[i].getCodigo() + "\nTipo: " + multas[i].getTipo() 
                        + "\nPagada: " + multas[i].getPagado() + "\n";
        return texto;
    }
    
    public String info() {
        String texto;
        int pagada = 0;
        
        for (int i = 0; i < multas.length; i++) {
            if (multas[i] != null) {
                if (multas[i].getPagado())
                    pagada += 1;
            }
        }
        
        texto = "Cantidad de multas generadas: " + contador + "\nCantidad de "
                + "Multas Pagadas: " + pagada + "\nCantidad de Multas "
                + "Pendientes: " + (contador - pagada);
        return texto;
    }
}
