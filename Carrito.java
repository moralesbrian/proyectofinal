package clase;

public class Carrito {
	private String numC;
	private Cliente cli;
	private double montoTotal;
	
	public Carrito(String string, Cliente cliente) {
		numC =string;
		cli = cliente;
		montoTotal = 0.0;		
	}
	public String dameNumC() {
		return numC;
	}
	public Cliente dameCliente() {
		return cli;
	}
	public double dameMontoTotal() {
		return montoTotal;
	}
	public void agrearMontoTotal(double monto) {
		montoTotal = monto;
	}
	public void mostrarMontoTotal(double monto) {
		System.out.println("EL monto total del Carrito es : "+ monto);
	}
	

}
