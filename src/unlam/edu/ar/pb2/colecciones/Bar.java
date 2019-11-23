package unlam.edu.ar.pb2.colecciones;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Bar {

	Set<Cliente> clientes;
	String nombreDelBar;

	public Bar(String nombre) {
		this.nombreDelBar = nombre;
		clientes = new TreeSet<Cliente>();
	}

	public Bar(String nombre, Comparator orden) {
		this.nombreDelBar = nombre;
		this.clientes = new TreeSet<Cliente>(orden);
	}

	public void cambiarOrden(Comparator orden) {
		TreeSet<Cliente> nueva = new TreeSet(orden);

		nueva.addAll(this.clientes);
		this.clientes = nueva;
	}

	public boolean agregarCliente(Cliente cliente) {

		return clientes.add(cliente);

	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}
