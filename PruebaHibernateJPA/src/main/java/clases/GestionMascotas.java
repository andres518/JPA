package clases;

import java.util.List;

import javax.swing.JOptionPane;

import com.andres.dao.MascotaDao;
import com.andres.entidades.Mascota;
import com.andres.entidades.Persona;

public class GestionMascotas {

	MascotaDao miMascotaDao = new MascotaDao();
	
	public GestionMascotas() {
		
		String menu="MENU OPCIONES - GESTION MASCOTAS\n\n";
		menu+="1. Registrar Mascota\n";
		menu+="2. Consultar Mascota\n";
		menu+="3. Consultar Lista De Mascota\n";
		menu+="4. Consultar Lista De Mascota por Sexo\n";
		menu+="5. Actualizar Mascota\n";
		menu+="6. Eliminar Mascota\n";
		menu+="7. Salir\n\n";
		
		int opc=0;
		
		while (opc!=7) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			
			case 1: registrar(); break;
			case 2: consultar(); break;
			case 3: consultarLista(); break;
			case 4: consultarListaPorSexo(); break;
			case 5: actualizar(); break;
			case 6: eliminar(); break;
			case 7: miMascotaDao.close(); break;

			}
		}
	}
	
	private void registrar() {
		
		Mascota miMascota = new Mascota();
		miMascota.setIdMascota(null);
		miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Mascota"));
		miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la Raza dela Mascota"));
		miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la Mascota"));
		miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la Mascota"));
		
//		System.out.println(miMascotaDao.registrarMascota(miMascota));
//		System.out.println();
		
		Long idDuenio=Long.parseLong(JOptionPane.showInputDialog("ingrese el documento del dueño"));
		
		Persona duenio=new Persona();
		duenio.setIdPersona(idDuenio);
		miMascota.setDuenio(duenio);
		
		System.out.println(miMascotaDao.registrarMascota(miMascota));
		System.out.println();
		
	}
	
	private void consultar() {
		
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la mascota"));
		
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if (miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontro la mascota");
		}
		System.out.println();
	}
	
	private void consultarLista() {
		
		System.out.println("Lista Mascota");
		List<Mascota> listaMascota = miMascotaDao.consultarListaMascotas();
		
		for (Mascota mascota : listaMascota) {
			System.out.println(mascota);
		}
	}
	
	private void consultarListaPorSexo() {
		
		System.out.println("Lista de mascota por sexo");
		String sexo = JOptionPane.showInputDialog("ingrese el sexo de la Mascota");
		
		List<Mascota> listaMascota = miMascotaDao.consultarListaMascotasPorSexo(sexo);
		
		for (Mascota mascota : listaMascota) {
			System.out.println(mascota);
		}
	}
	
	private void actualizar() {
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la mascota para actualizar"));
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if (miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
			
			miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Mascota"));
			miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la Raza dela Mascota"));
			miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la Mascota"));
			miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la Mascota"));
			
			System.out.println(miMascotaDao.actualizarMascota(miMascota, idMascota));
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontro la mascota");
		}
		System.out.println();
	}
	
	
	private void eliminar() {
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("ingrese el id de la mascota para eliminar"));
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		
		if(miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
			
			System.out.println(miMascotaDao.eliminarMascota(miMascota, idMascota));
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("no se encontro la mascota");
		}
		System.out.println();
		
	}
}
