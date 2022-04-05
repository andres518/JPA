package clases;


import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import com.andres.dao.PersonaDao;
import com.andres.entidades.Mascota;
import com.andres.entidades.Nacimiento;
import com.andres.entidades.Persona;

public class GestionPersonas {

	PersonaDao miPersonaDao = new PersonaDao();
	
	public GestionPersonas() {
		
		String menu = "MENU OPCIONES - GESTION PERSONAS\n\n";
		menu+="1. Registrar Persona\n";
		menu+="2. Colsultar Persona\n";
		menu+="3. Consultar Lista de Personas\n";
		menu+="5. Actualizar Persona\n";
		menu+="6. Eliminar Persona\n";
		menu+="7. Salir\n";
		
		int opc = 0;
		
		while (opc != 7) {
			opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opc) {
			case 1: registrar(); break;
			case 2: consultar(); break;
			case 3: consultarLista(); break;
			case 5: actualizarNombre(); break;
			case 6: eliminar(); break;
			case 7: miPersonaDao.close(); break;

			}
		}
	}
	
	private void registrar() {
		try {
			Persona miPersona = new Persona();
			
			miPersona.setIdPersona(Long.parseLong(JOptionPane.showInputDialog("ingrese el documento de la persona")));
			miPersona.setNombre(JOptionPane.showInputDialog("ingrese el nombre de la persona"));
			miPersona.setTelefono(JOptionPane.showInputDialog("ingrese el telefono de la persona"));
			miPersona.setProfesion(JOptionPane.showInputDialog("ingrese la profesion de la persona"));
			miPersona.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo")));
			
			miPersona.setNacimiento(obtenerDatosNacimiento());
			
			System.out.println(miPersonaDao.registrarPersona(miPersona));
			System.out.println();
			
			System.out.println(miPersonaDao.registrarPersona(miPersona));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "La persona ya existe!");
		}
		
	}
	
	private Nacimiento obtenerDatosNacimiento() {
		int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DIA de Nacimiento"));
		int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el MES de Nacimiento"));
		int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el AÑO de Nacimiento"));
		
		Nacimiento datosNacimiento = new Nacimiento();
		
		datosNacimiento.setIdNacimiento(null);
		datosNacimiento.setFechaNacimiento(LocalDate.of(anio, mes, dia));
		datosNacimiento.setCiudadNacimiento(JOptionPane.showInputDialog("Ingrese la cuidad de nacimiento"));
		datosNacimiento.setDepartamentoNacimiento(JOptionPane.showInputDialog("ingrese el departamento de nacimiento"));
		datosNacimiento.setPaisNacimiento(JOptionPane.showInputDialog("ingrerse el pais de nacimiento"));
		
		return datosNacimiento;
	}
	
	private void consultar() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID de la persona"));
		
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if(miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontro la Persona");
		}
		System.out.println();
	}
	
	private void consultarLista() {
		System.out.println("Lista de Personas");
		
		List<Persona> listaPersonas = miPersonaDao.consultarListaPersonas();
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona);
		}
	}
	
	private void actualizarNombre() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona para actualizar su nombre"));
		
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if(miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
			miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el Nombre de la Persona"));
			miPersona.setTelefono(JOptionPane.showInputDialog("Ingrese el nuevo telefono"));
			miPersona.setProfesion(JOptionPane.showInputDialog("Ingrese la nueva profesion"));
			
			System.out.println(miPersonaDao.actualizarPersona(miPersona));
			System.out.println();
			
		}
		else {
			System.out.println();
			System.out.println("No se encontro la persona");
		}
		System.out.println();
	}
	
	private void eliminar() {
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la la persona a eliminar"));
		
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if (miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
			
			System.out.println(miPersonaDao.eliminarPersona(miPersona));
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No se encontro la persona");
		}
	}
}
