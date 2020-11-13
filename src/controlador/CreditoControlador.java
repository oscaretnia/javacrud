/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Vector;
import modelo.Credito;
import modelo.dao.CreditoDao;
import vista.Vista;

/**
 *
 * @author Mariana
 */
public class CreditoControlador {
    
    private final CreditoDao modelo;
    private final Vista vista;
    
    public CreditoControlador(Vista vista) {
        this.modelo = new CreditoDao();
        this.vista = vista;
    }

    public Vector<Vector> obtenerCreditos() {
        Vector<Vector> datos = new Vector<>();
        try {
            modelo.findCreditoEntities().forEach(credito -> {
                Vector<Object> row = new Vector();
                row.add(credito.getId());
                row.add(credito.getFecha());
                row.add(credito.getCliente());
                row.add(credito.getValor());
                row.add(credito.getCuotas());
                row.add(credito.getInteres());
                row.add(credito.getValorCuota());
                row.add(credito.getCobrador());
                row.add(credito.getSaldo());
                datos.add(row);
            });
            return datos;
        } catch(Exception ex) {
            vista.mostrarError("Error al cargar los creditos");
        }
        return datos;
    }
    
    public Vector<Object> obtenerCredito(Integer id) {
        Vector<Object> row = new Vector();
        try {
            Credito credito = modelo.findCredito(id);
            row.add(credito.getId());
            row.add(credito.getFecha());
            row.add(credito.getCliente());
            row.add(credito.getValor());
            row.add(credito.getCuotas());
            row.add(credito.getInteres());
            row.add(credito.getValorCuota());
            row.add(credito.getCobrador());
            row.add(credito.getSaldo());
        } catch(Exception ex) {
            vista.mostrarError("El id es incorrecto");
        }
        return row;
    }

    public void eliminarCredito(int id) {
        try {
            modelo.destroy(id);
        } catch(Exception ex) {
            vista.mostrarError("Falló al eliminar el credito");
        }
    }

    public void registrarCredito(String fecha, String cliente, String valor, String cuotas, String interes, String valorCuota, String cobrador, String saldo) {
        if(verificarVacio(fecha, cliente, valor, cuotas, interes, valorCuota, cobrador, saldo)) return;
        
        try {            
            Credito c = new Credito();
            c.setFecha(fecha);
            c.setCliente(cliente);
            c.setCobrador(cobrador);
            c.setInteres(Integer.parseInt(interes));
            c.setValor(Integer.parseInt(valor));
            c.setCuotas(Integer.parseInt(cuotas));
            c.setValorCuota(Integer.parseInt(valorCuota));
            c.setSaldo(Integer.parseInt(saldo));
            System.out.println(c);
            modelo.create(c);
            vista.navegar();
        } catch (Exception ex) {
            ex.printStackTrace();
            vista.mostrarError("Los campos numericos deben ser validos");
        }
    }
    
    public void actualizarCredito(String id, String fecha, String cliente, String valor, String cuotas, String interes, String valorCuota, String cobrador, String saldo) {
        if(verificarVacio(fecha, cliente, valor, cuotas, interes, valorCuota, cobrador, saldo)) return;
        
        try {            
            Credito c = new Credito();
            c.setId(Integer.parseInt(id));
            c.setFecha(fecha);
            c.setCliente(cliente);
            c.setCobrador(cobrador);
            c.setInteres(Integer.parseInt(interes));
            c.setValor(Integer.parseInt(valor));
            c.setCuotas(Integer.parseInt(cuotas));
            c.setValorCuota(Integer.parseInt(valorCuota));
            c.setSaldo(Integer.parseInt(saldo));
            System.out.println(c);
            modelo.edit(c);
            vista.navegar();
        } catch (Exception ex) {
            ex.printStackTrace();
            vista.mostrarError("Los campos numericos deben ser validos");
        }
    }
    
    private boolean verificarVacio(String... campos) {
        for (String campo: campos) {
            if (campo.isEmpty()) {
                vista.mostrarError("Los campos no deben estar vacíos");
                return true;
            }
        }
        return false;
    }

    public void actualizarCredito(String trim, String trim0, String trim1, String trim2, String trim3, String trim4, String trim5, String trim6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
