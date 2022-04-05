package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.andres.dao.PersonaDao;
import com.andres.dao.ProductoDao;
import com.andres.entidades.Persona;
import com.andres.entidades.PersonasProductos;
import com.andres.entidades.Producto;

public class GestionProductos {
	
	ProductoDao miProductoDao = new ProductoDao();
	
	public GestionProductos() {
		
		String menu = "MENU DE OPCIONES - GESTION PRODUCTOS\n\n";
		menu+="1. Registrar Producto\n";
		menu+="2. ConsultarProducto\n";
		menu+="3. Consultar Lista de Productos\n";
		menu+="4. Comprar Productos\n";
		menu+="5. Actualizar Productos\n";
		menu+="6. Eliminar Productos\n";
		menu+="7. Salir\n";
		
		int opc = 0;
		
		while (opc != 7) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar(); break;
			case 2: consultar(); break;
			case 3: consultarLista(); break;
			case 4: comprarProductos(); break;
			case 5: actualizar(); break;
			case 6: eliminar(); break;
			case 7: miProductoDao.close(); break;

			}
		}
		
	}
	
	private void registrar() {
		
			
		Producto miProducto = new Producto();	
		//miProducto.setIdProducto(Long.parseLong(JOptionPane.showInputDialog("ingrese el codigo del producto")));
		miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre del producto"));
		miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto")));
			
		System.out.println(miProducto);
		System.out.println(miProductoDao.registrarProducto(miProducto));
		System.out.println();
			
	}

	
	private void consultar() {
		Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del producto"));
		
		Producto miProducto = miProductoDao.consultarProducto(idProducto);
		
		if (miProducto != null) {
			System.out.println(miProducto);
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontro el producto");
		}
		System.out.println();
	}
	
	private void consultarLista() {
		System.out.println("*** Lista de Productos ***");
		
		List<Producto> listaProductos = miProductoDao.ConsultarListaProductos();
		
		for (Producto producto : listaProductos) {
			System.out.println(producto);
		}
	}
	
	private void actualizar() {
		
		Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto para actualizar su nombre y precio"));
		
		Producto miProducto = miProductoDao.consultarProducto(idProducto);
		
		if(miProducto != null) {
			System.out.println(miProducto);
			System.out.println();
			miProducto.setNombreProducto(JOptionPane.showInputDialog("Ingrese el nombre del producto"));
			miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del Producto")));
			
			System.out.println(miProductoDao.actualizarProducto(miProducto, idProducto));
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontro el producto");
		}
		System.out.println();
	}
	
	private void eliminar() {
		Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto para eliminar"));
		
		Producto miProducto = miProductoDao.consultarProducto(idProducto);

		if(miProducto != null) {
			System.out.println(miProducto);
			System.out.println();
			
			System.out.println(miProductoDao.eliminarProducto(miProducto, idProducto));
			System.out.println();
		}
		else{
			System.out.println();
			System.out.println("no se encontro El producto");
		}
		
	}
	
	
	private void comprarProductos() {
		
		PersonasProductos producto;
		
		Long personaId;
		Long productoId;
		
		int opc = 0;
		
		do {
			producto = new PersonasProductos();
			personaId=Long.parseLong(JOptionPane.showInputDialog("ingrese el documento de la persona"));
			productoId=Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del producto"));
			
			producto.setPersonaId(personaId);
			producto.setProductoId(productoId);
			
			System.out.println(miProductoDao.registrarCompra(producto));
			System.out.println();
			opc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea agregar otro producto"));
			
		} while (opc == 1);
	}

}
