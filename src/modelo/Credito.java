/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "creditos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credito.findAll", query = "SELECT c FROM Credito c"),
    @NamedQuery(name = "Credito.findById", query = "SELECT c FROM Credito c WHERE c.id = :id"),
    @NamedQuery(name = "Credito.findByFecha", query = "SELECT c FROM Credito c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Credito.findByCliente", query = "SELECT c FROM Credito c WHERE c.cliente = :cliente"),
    @NamedQuery(name = "Credito.findByValor", query = "SELECT c FROM Credito c WHERE c.valor = :valor"),
    @NamedQuery(name = "Credito.findByCuotas", query = "SELECT c FROM Credito c WHERE c.cuotas = :cuotas"),
    @NamedQuery(name = "Credito.findByInteres", query = "SELECT c FROM Credito c WHERE c.interes = :interes"),
    @NamedQuery(name = "Credito.findByValorCuota", query = "SELECT c FROM Credito c WHERE c.valorCuota = :valorCuota"),
    @NamedQuery(name = "Credito.findByCobrador", query = "SELECT c FROM Credito c WHERE c.cobrador = :cobrador"),
    @NamedQuery(name = "Credito.findBySaldo", query = "SELECT c FROM Credito c WHERE c.saldo = :saldo")})
public class Credito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @Column(name = "cliente")
    private String cliente;
    @Basic(optional = false)
    @Column(name = "valor")
    private int valor;
    @Basic(optional = false)
    @Column(name = "cuotas")
    private int cuotas;
    @Basic(optional = false)
    @Column(name = "interes")
    private int interes;
    @Basic(optional = false)
    @Column(name = "valor_cuota")
    private int valorCuota;
    @Basic(optional = false)
    @Column(name = "cobrador")
    private String cobrador;
    @Basic(optional = false)
    @Column(name = "saldo")
    private int saldo;

    public Credito() {
    }

    public Credito(Integer id) {
        this.id = id;
    }

    public Credito(Integer id, String fecha, String cliente, int valor, int cuotas, int interes, int valorCuota, String cobrador, int saldo) {
        this.id = id;
        this.fecha = fecha;
        this.cliente = cliente;
        this.valor = valor;
        this.cuotas = cuotas;
        this.interes = interes;
        this.valorCuota = valorCuota;
        this.cobrador = cobrador;
        this.saldo = saldo;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public int getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(int valorCuota) {
        this.valorCuota = valorCuota;
    }

    public String getCobrador() {
        return cobrador;
    }

    public void setCobrador(String cobrador) {
        this.cobrador = cobrador;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credito)) {
            return false;
        }
        Credito other = (Credito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Credito[ id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", valor=" + valor + ", , cuotas=" + cuotas + ", interes=" + interes + ", valor_cuota=" + valorCuota + ", cobrador=" + cobrador + ", saldo=" + saldo + " ]";
    }
    
}
