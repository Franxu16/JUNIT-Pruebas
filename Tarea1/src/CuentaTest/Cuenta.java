package CuentaTest;

public class Cuenta {
    //Atributos
    private double saldo;

    //Getters

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingresar(double cantidad) {
        if (saldo + cantidad > 0 && cantidad <= 6000){
            this.saldo += cantidad;
        }else{
            this.saldo = 0;
        }
    }

    public void retirar(double cantidad) {
        double L = 6000.0;

        if (saldo - cantidad > 0 && cantidad <= L) {
            this.saldo -= cantidad;
        } else if (cantidad > L && this.saldo - cantidad < 0) {
            this.saldo = 0;
        }
    }

    public void transferir(Cuenta C1, double cantidad){
        double L = 3000.0;

        if(cantidad > 0 && cantidad <= L){
            C1.ingresar(cantidad);
            retirar(cantidad);
        }
    }
}
