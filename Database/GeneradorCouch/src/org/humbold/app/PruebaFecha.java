package org.humbold.app;

public class PruebaFecha {

	public PruebaFecha() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date fecha = new java.util.Date();
		
		System.out.println ("Fecha 1 = " + fecha.getDate());
		System.out.println ("Fecha 2 = " + fecha.toGMTString());
		System.out.println ("Fecha 3 = " + fecha.toLocaleString());
		System.out.println ("Fecha 4 = " + fecha.toString());
		System.out.println ("Fecha 5 = " + fecha.toInstant());
	}

}
