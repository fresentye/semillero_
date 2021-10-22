/**
 * 
 */
package com.hbt.semillero.test;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidad.EstadoEnum;
import com.hbt.semillero.entidad.TematicaEnum;

/**
 * @author freck
 *
 */
public class CreacionComicTest {

	/**
	 * Se crea un arraylist para almacenar los comics
	 *
	 */
	
	private ArrayList<ComicDTO> list = new ArrayList<ComicDTO>();
	
	/**
	 * se crea un metodo  en donde se crean 10 comics antes del test
	 */
	@BeforeTest 
	public void Llamado () {
		ComicDTO c1 = new ComicDTO();
		c1.setNombre("juanito");
		c1.setAutores("juliana");
		c1.setCantidad(4L);
		c1.setColeccion("n1");
		c1.setColor(true);
		c1.setEditorial("ed1");
		c1.setEstadoEnum(EstadoEnum.ACTIVO);
		c1.setFechaVenta(null);
		c1.setId("1");
		c1.setNumeroPaginas(5);
		c1.setTematicaEnum(TematicaEnum.BELICO);
		c1.setPrecio(BigDecimal.valueOf(2.3));
		list.add(c1);
		list.add(c1);
		list.add(c1);
		list.add(c1);
		list.add(c1);
		list.add(c1);
		c1 = new ComicDTO();
		c1.setNombre("juanito");
		c1.setAutores("juliana");
		c1.setCantidad(4L);
		c1.setColeccion("n1");
		c1.setColor(true);
		c1.setEditorial("ed1");
		c1.setEstadoEnum(EstadoEnum.INACTIVO);
		c1.setFechaVenta(null);
		c1.setId("1");
		c1.setNumeroPaginas(5);
		c1.setTematicaEnum(TematicaEnum.BELICO);
		c1.setPrecio(BigDecimal.valueOf(2.3));
		list.add(c1);
		list.add(c1);
		list.add(c1);
		list.add(c1);
		list.add(c1);
		
	}
	/**
	 * se crea un metodo para verificar los comics activos
	 *
	 */
	
	private ArrayList<ComicDTO> activoC(){
		ArrayList<ComicDTO> activate = new ArrayList<ComicDTO>();
		for(ComicDTO i: list) {
			if(i.getEstadoEnum()== EstadoEnum.ACTIVO) {
				activate.add(i);
			}
		}
		return activate;
	}
	
	/**
	 * se crea un metodo para verificar los comics inactivos
	 *
	 */
	
	
	private ArrayList<ComicDTO> inactivoC(){
		ArrayList<ComicDTO> inactivate = new ArrayList<ComicDTO>();
		try {
			for(ComicDTO i: list) {
				if(i.getEstadoEnum()== EstadoEnum.INACTIVO) {
					inactivate.add(i);
				}
			}
			throw new Exception ();
			
		}catch(Exception e) {
			System.out.println("se ha detectado que de "+Integer.toString(list.size())+
					" comic se encontraron que "+Integer.toString(list.size()-inactivate.size())+
					" se encuentran activos y "+ Integer.toString(inactivate.size())+
					" inactivos. Los comics inactivos son: ");
			for(ComicDTO i:inactivate) {
				System.out.println(i.getNombre());
			}
		}
		return inactivate;
	}
	
	/**
	 * se hace una prueba unitaria para comprobar el correcto funcionamiento del metodo activoc
	 *
	 */
	
	@Test
	public void verificateA() {
		ArrayList<ComicDTO> activate = this.activoC();
		for(ComicDTO i: list) {
			System.out.println(i.toString());
		}
	}
	/**
	 * se hace una prueba unitaria para comprobar el correcto funcionamiento del metodo inactivoc
	 *
	 */
	
	@Test
	public void verificateI() {
		ArrayList<ComicDTO> activate = this.inactivoC();
		for(ComicDTO i: list) {
			System.out.println(i.toString());
		}
	}
}
	

