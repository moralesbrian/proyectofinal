package clase;
import java.util.List;




import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;

public class Main {
    
    public static void main(String[] args) {
    Cliente c1 = new Cliente(3,49862582,"rossi lucresia","bs as 500");
    Carrito carro = new Carrito("001", c1);
    
    Producto p1 = new Producto(100, "Dulce", "Repostero x 500grs.", 450.30, 1000);
    Producto p2 = new Producto(101, "Leche", "En polvo x 500grs.", 200, 1000);
    Producto p3 = new Producto(102, "Pan", "Casero x 500grs.", 150.30, 500);
    Producto p4 = new Producto(103, "Café", "Frasco x 500grs.", 450.30, 1000);
    Producto p5 = new Producto(100, "Arroz", "Repostero x 500grs.", 450.30, 1000);
    Producto p6 = new Producto(101, "Fideo", "En polvo x 500grs.", 200, 1000);
    Producto p7 = new Producto(102, "Te", "Casero x 500grs.", 150.30, 500);
    Producto p8 = new Producto(103, "Cacao", "Frasco x 500grs.", 450.30, 1000);
    Producto[] productos = {p1, p2, p3, p4, p5, p6, p7, p8};
    ItemCarrito itemC1 = new ItemCarrito(carro, p1, 1);
    ItemCarrito itemC2 = new ItemCarrito(carro, p2, 2);
    ItemCarrito itemC3 = new ItemCarrito(carro, p3, 3);
    ItemCarrito itemC4 = new ItemCarrito(carro, p4, 4);
    ItemCarrito itemC5 = new ItemCarrito(carro, p5, 2);
    ItemCarrito itemC6 = new ItemCarrito(carro, p6, 1);
    ItemCarrito itemC7 = new ItemCarrito(carro, p7, 3);
    ItemCarrito itemC8 = new ItemCarrito(carro, p8, 2);

    List<ItemCarrito> itemL = new ArrayList<ItemCarrito>();

    itemL.add(itemC1);
    itemL.add(itemC2);
    itemL.add(itemC3);
    itemL.add(itemC4);
    itemL.add(itemC5);
    itemL.add(itemC6);
    itemL.add(itemC7);
    itemL.add(itemC8);

    mostrarItems(itemL, carro, c1);
}// main

public static void mostrarItems(List<ItemCarrito> itemL, Carrito carro, Cliente c1) {
	
    Iterator<ItemCarrito> itL = itemL.iterator();
    double total = 0, montoDes = 0;
    boolean mostrarTitulo = true;
    LocalDate fecha = LocalDate.now();

    while (itL.hasNext()) {
        ItemCarrito datosI = itL.next();
        if (mostrarTitulo) {
            mostrarTitulo = false;
            c1.mostrarPersona();
            datosI.mostrarTitulo();
        }
        datosI.mostrarItems();
        total = total + datosI.dameMontoItem();
        carro.agrearMontoTotal(total);
    }

	carro.mostrarMontoTotal(total);	
	if (total>0)
		  montoDes = descuentos(total);
	else
		System.out.println("No se aplican descuentos a montos <= a cero");

						
}//mostrarItems
			
			public static double descuentos(double total) {
				 final double montoMin = 5000; 
				 LocalDate dia = LocalDate.now();
				 double montoD=0;

			     int descuento = dia.getDayOfMonth();
			     if (descuento %2==0) {
				 Descuento descFijo=new DescuentoFijo();
				 descFijo.asignaValorDesc(200);//asigno monto fijo que queiro descontar
				 montoD = descFijo.valorFinal(total);
				 	if (montoD>0)
				 		System.out.println("El monto total a pagar con descuento es: "+ String.format("%.2f",montoD));
				 		
				 	else 
				 		System.out.println("El descuento no se puede realizar");
			     }
			    else {
				Descuento descPorc = new DescuentoPorcentaje();
				
				if (total<montoMin) {
					descPorc.asignaValorDesc(0.05);
				}
				else
				descPorc.asignaValorDesc(0.10);
				montoD = descPorc.valorFinal(total);	
				if (montoD>0)
					System.out.println("El monto total a pagar con descuento es: "+ String.format("%.2f",montoD));
				else 
					System.out.println("El descuento no se puede realizar");
			
			    }//else del dia de descuento

				return montoD;
			}//cierre de descuento
		
}//cierre de la clase
