package unlam.edu.ar.pb2.colecciones;

import java.util.Comparator;

public class ClientePorEdad implements Comparator<Cliente>{

	@Override
	public int compare(Cliente o1, Cliente o2) {
	
		return o1.getEdad().compareTo(o2.getEdad());
	}

	
	
	
}
