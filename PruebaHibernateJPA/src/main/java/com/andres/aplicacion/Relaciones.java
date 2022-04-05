package com.andres.aplicacion;

import com.andres.dao.MascotaDao;
import com.andres.dao.PersonaDao;
import com.andres.dao.ProductoDao;
import com.andres.entidades.PersonasProductos;
import com.andres.gui.ConsulProductoGui;
import com.andres.gui.ConsultarMascotasGui;
import com.andres.gui.ConsultarPersonaGui;
import com.andres.gui.ConsultarProductosGui;
import com.andres.gui.RegistrarMascotasGui;
import com.andres.gui.RegistrarPersonasGui;
import com.andres.gui.RegistrarProductosGui;
import com.andres.gui.TotalDePersonasRegistradas;
import com.andres.gui.VentanaPrincipal;

public class Relaciones {

	VentanaPrincipal miVentanaPrincipal;
	
	public Relaciones() {
		
		Coordinador miCoordinador;
		RegistrarPersonasGui miRegistrarPersonasGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		RegistrarProductosGui miRegistrarProductosGui;
		
		ConsultarPersonaGui miConsultarPersonaGui;
		ConsultarMascotasGui miConsultarMascotasGui;
		ConsultarProductosGui miConsultarProductosGui;
		ConsulProductoGui miConsulProductoGui;
		
		TotalDePersonasRegistradas miTotalDePersonasRegistradas;
		
		PersonaDao miPersonaDao;
		MascotaDao miMascotaDao;
		ProductoDao miProductoDao;
		
		// se instancia por unica ocasion las clases declaradas 
		
		miVentanaPrincipal = new VentanaPrincipal();
		miCoordinador = new Coordinador();
		miRegistrarPersonasGui = new RegistrarPersonasGui(miVentanaPrincipal, true);
		miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal, true, "");
		miRegistrarProductosGui = new RegistrarProductosGui(miVentanaPrincipal, true);
		
		miConsultarPersonaGui = new ConsultarPersonaGui();
		miConsultarMascotasGui = new ConsultarMascotasGui();
		miConsultarProductosGui = new ConsultarProductosGui();
		miConsulProductoGui = new ConsulProductoGui();
		
		miTotalDePersonasRegistradas = new TotalDePersonasRegistradas();
		
		miPersonaDao = new PersonaDao();
		miMascotaDao = new MascotaDao();
		miProductoDao = new ProductoDao();
		
		//Se establece la relación entre el coordinador y cada instancia unica
		//Al coordinador se le asigna el control de cada clase unica
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setRegistrarMascotaGui(miRegistrarMascotasGui);
		miCoordinador.setRegistrarProductosGui(miRegistrarProductosGui);
		
		miCoordinador.setConsultarPersonaGui(miConsultarPersonaGui);
		miCoordinador.setConsultarMascotaGui(miConsultarMascotasGui);
		miCoordinador.setConsultarProductosGui(miConsultarProductosGui);
		miCoordinador.setConsultarProductosGui(miConsulProductoGui);
		
		miCoordinador.setTotalDePersonasRegistradas(miTotalDePersonasRegistradas);
		
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setProductoDao(miProductoDao);
		
		
		//A cada clase unica se le asigna la unica instancia del coordinador
		
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miRegistrarProductosGui.setCoordinador(miCoordinador);
		miConsultarPersonaGui.setCoordinador(miCoordinador);
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		miConsultarProductosGui.setCoordinador(miCoordinador);
		miConsulProductoGui.setCoordinador(miCoordinador);
		miTotalDePersonasRegistradas.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
	}
	
	public void iniciar() {
		miVentanaPrincipal.setVisible(true);
	}

}
