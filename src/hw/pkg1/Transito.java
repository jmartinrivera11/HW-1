/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw.pkg1;

public class Transito {
    
    Multa[] multas;
    int contador;
    
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
            multa.pay();
            return true;
        }
        return false;
    }
    
    public String print(int codigo) {
        String text = "";
        Multa multa = buscar(codigo);
        if (multa != null)
            text = "Nombre: " + multa.getNombre() + "\nCódigo: " 
                    + multa.getCodigo() + "\nTipo: " + multa.getTipo() 
                    + "\nPagada: " + multa.getPagado() + "\n";
        return text;
    }
    
    public String printTodas() {
        String text = "";
        for (int i = 0; i < multas.length; i++)
            if (multas[i] != null)
                text += "Nombre: " + multas[i].getNombre() + "\nCódigo: " 
                        + multas[i].getCodigo() + "\nTipo: " + multas[i].getTipo() 
                        + "\nPagada: " + multas[i].getPagado();
        return text;
    }
    
    public String info() {
        String text;
        int pagada = 0, pendiente = 0;
        
        for (int i = 0; i < multas.length; i++) {
            if (multas[i] != null) {
                if (multas[i].getPagado())
                    pagada += 1;
                pendiente += 1;
            }
        }       
        
        text = "Cantidad de multas generadas: " + contador + "\nCantidad de "
                + "Multas Pagadas: " + pagada + "\nCantidad de Multas "
                + "Pendientes: " + pendiente;
        return text;
    }
}
