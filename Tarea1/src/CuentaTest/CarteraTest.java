package CuentaTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarteraTest {

    @Test
    void testAlCrearCuentaElSaldoEsCero(){
        Cuenta c = new Cuenta();
        assertEquals(0,c.getSaldo());
    }

    //Tests del metodo ingresar
    @Test
    void testIngresar100DeSaldo(){
        Cuenta c = new Cuenta();
        c.ingresar(100);
        assertEquals(100, c.getSaldo());
    }

    @Test
    void testIngresar3000DeSaldo(){
        Cuenta c = new Cuenta();
        c.ingresar(3000);
        assertEquals(3000, c.getSaldo());
    }

    @Test
    void testIngresar3000AUnaCuentaQueTiene100(){
        Cuenta c = new Cuenta();
        c.ingresar(3000);
        c.ingresar(100);
        assertEquals(3100, c.getSaldo());
    }

    @Test
    void testIngresarSaldoNegativoEnLaCuenta(){
        Cuenta c = new Cuenta();
        c.ingresar(-100);
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testIngresarSaldoConDecimales(){
        Cuenta c = new Cuenta();
        c.ingresar(100.45);
        assertEquals(100.45, c.getSaldo());
    }

    @Test
    void testIngresarCantidadMaximaEnLaCuenta(){
        Cuenta c = new Cuenta();
        c.ingresar(6000.0);
        assertEquals(6000.0, c.getSaldo());
    }

    @Test
    void testIngresarCantidadQueSuperaElLimite(){
        Cuenta c = new Cuenta();
        c.ingresar(6000.01);
        assertEquals(0.0, c.getSaldo());
    }

    //Tests del metodo retirada
    @Test
    void testRetirarSaldoDeUnaCuenta(){
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(100);
        assertEquals(400, c.getSaldo());
    }

    @Test
    void testRetirarMasDeLoQueHay(){
        Cuenta c = new Cuenta();
        c.ingresar(200);
        c.retirar(500);
        assertEquals(200, c.getSaldo());
    }

    @Test
    void testRetirarSaldoNegativoDeUnaCuenta(){
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(-100);
        assertEquals(500, c.getSaldo());
    }

    @Test
    void testRetirarSaldoConDecimales(){
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(100.45);
        assertEquals(399.55, c.getSaldo());
    }

    @Test
    void testRetirarCentenasDeLaCuenta(){
        Cuenta c = new Cuenta();
        c.setSaldo(7000);
        c.retirar(6000);
        assertEquals(1000, c.getSaldo());
    }

    @Test
    void testRetirarSaldoPorEncimaDelLimite(){
        Cuenta c = new Cuenta();
        c.setSaldo(7000);
        c.retirar(6000.01);
        assertEquals(7000, c.getSaldo());
    }

    //Pruebas de los metodos de transferencias de la cartera
    @Test
    void testTransferirSaldo(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.setSaldo(500);
        c2.setSaldo(50);
        c1.transferir(c2, 100);
        assertEquals(450, c1.getSaldo());
        assertEquals(150, c2.getSaldo());
    }

    @Test
    void testTraspasarDesdeElLimite(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.setSaldo(3500);
        c2.setSaldo(50);
        c1.transferir(c2, 3000);
        assertEquals(500, c1.getSaldo());
        assertEquals(3050,c2.getSaldo());
    }

    @Test
    void testTransferirPorEncimaDelLimite(){
        Cuenta c1 = new Cuenta();
        Cuenta c2 = new Cuenta();
        c1.setSaldo(3500);
        c2.setSaldo(50);
        c1.transferir(c2, 3000.01);
        assertEquals(3500, c1.getSaldo());
        assertEquals(50, c2.getSaldo());
    }
}



