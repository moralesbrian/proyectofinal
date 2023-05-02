package clase;

public class DescuentoFijo extends Descuento {
	public double valorFinal(double valorInicial) {//valorInicial es el monto del carro
		return valorInicial - this.dameValorDesc();
		}

}
