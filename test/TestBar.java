import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import unlam.edu.ar.pb2.colecciones.Bar;
import unlam.edu.ar.pb2.colecciones.Cliente;
import unlam.edu.ar.pb2.colecciones.ClientePorEdad;
import unlam.edu.ar.pb2.colecciones.NoSeAdmitenDuplicadosException;

public class TestBar {

	@Test
	public void agregarClienteAlBar() {
		Cliente clienteNuevo = new Cliente("armando", "perez", 23);
		Cliente clienteNuevo1 = new Cliente("bart", "perez", 23);
		Cliente clienteNuevo2 = new Cliente("carlos", "perez", 23);
		Bar barNuevo = new Bar("anthares");
		barNuevo.agregarCliente(clienteNuevo);
		barNuevo.agregarCliente(clienteNuevo1);
		barNuevo.agregarCliente(clienteNuevo2);
		barNuevo.agregarCliente(clienteNuevo);
		
		Assert.assertEquals(3, barNuevo.getClientes().size());

	}



	@Test
	public void agregarClienteAlBarOrdenados() {
		Cliente clienteNuevo = new Cliente("armando", "perez", 23);
		Cliente clienteNuevo1 = new Cliente("bart", "perez", 23);
		Cliente clienteNuevo2 = new Cliente("carlos", "perez", 23);
		Bar barNuevo = new Bar("anthares");
		barNuevo.agregarCliente(clienteNuevo);
		barNuevo.agregarCliente(clienteNuevo1);
		barNuevo.agregarCliente(clienteNuevo2);
		barNuevo.agregarCliente(clienteNuevo);
		
		int i = 0;

		for (Cliente c : barNuevo.getClientes()) {
			switch (i) {
			case 0:
				Assert.assertEquals("armando", c.getNombre());
				break;
			case 1:
				Assert.assertEquals("bart", c.getNombre());
				break;
			case 2:
				Assert.assertEquals("carlos", c.getNombre());
				break;
			}
			i++;
		}

	}

	
	
	@Test
	public void agregarClienteAlBarOrdenadosPorEdad() {
		Cliente clienteNuevo = new Cliente("armando", "perez", 25);
		Cliente clienteNuevo1 = new Cliente("bart", "perez", 23);
		Cliente clienteNuevo2 = new Cliente("carlos", "perez", 27);
		ClientePorEdad ordenDeCliente = new ClientePorEdad();
		Bar barNuevo = new Bar("anthares", ordenDeCliente);
		
		barNuevo.agregarCliente(clienteNuevo);
		barNuevo.agregarCliente(clienteNuevo1);
		barNuevo.agregarCliente(clienteNuevo2);
		
		
		int i = 0;

		for (Cliente c : barNuevo.getClientes()) {
			switch (i) {
			case 0:
				Assert.assertEquals(23, c.getEdad(),0.0);
				break;
			case 1:
				Assert.assertEquals(25, c.getEdad(),0.0);
				break;
			case 2:
				Assert.assertEquals(27, c.getEdad(),0.0);
				break;
			}
			i++;
		}

	}
	
	@Test
	public void cambiarOrdenDelBar() {
		Cliente clienteNuevo = new Cliente("armando", "perez", 23);
		Cliente clienteNuevo1 = new Cliente("bart", "perez", 23);
		Cliente clienteNuevo2 = new Cliente("carlos", "perez", 23);
		Bar barNuevo = new Bar("anthares");
		barNuevo.agregarCliente(clienteNuevo);
		barNuevo.agregarCliente(clienteNuevo1);
		barNuevo.agregarCliente(clienteNuevo2);
		barNuevo.agregarCliente(clienteNuevo);
		ClientePorEdad ordenDeCliente = new ClientePorEdad();
		barNuevo.cambiarOrden(ordenDeCliente);
		
		int i = 0;

		for (Cliente c : barNuevo.getClientes()) {
			switch (i) {
			case 0:
				Assert.assertEquals(23, c.getEdad(),0.0);
				break;
			case 1:
				Assert.assertEquals(25, c.getEdad(),0.0);
				break;
			case 2:
				Assert.assertEquals(27, c.getEdad(),0.0);
				break;
			}
			i++;
		}

	}
}

//HashCode y equeals sobreescrito en cliente (para que no repita HashSet) , padre colecciones/hijo Set(No aceptan repetidos) y List/  HashSet no los ordena busca por hashCode. 
//TreeSet hijo "se le puede dar un patron de ordenamiento" 