import com.alura.cursos.challenge.monedas.ConsultarMoneda;
import com.alura.cursos.challenge.monedas.ConvertirMoneda;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda hacerConsulta = new ConsultarMoneda(); // Instancia de ConsultarMoneda

        int opcion = 0;
        while (opcion != 7) {  // El menú terminará cuando se seleccione la opción 7 (Salir)
            System.out.println("**************************************\n" +
                    "Sea bienvenido/a al Conversor de Moneda \n" +
                    "\n" +
                    "1) Dolar >> Peso argentino \n" +
                    "2) Peso argentino >> Dolar \n" +
                    "3) Dolar >> Real brasileno \n" +
                    "4) Real brasileno >> Dolar \n" +
                    "5) Dolar >> Peso colombiano \n" +
                    "6) Peso colombiano >> Dolar \n" +
                    "7) Salir\n");

            opcion = lectura.nextInt();  // Leer opción del menú
            lectura.nextLine();  // Limpiar el buffer

            // Llamar al método correspondiente según la opción seleccionada
            switch (opcion) {
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", hacerConsulta, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", hacerConsulta, lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", hacerConsulta, lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", hacerConsulta, lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", hacerConsulta, lectura);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", hacerConsulta, lectura);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta. Por favor ingrese una opción válida.");
                    break;
            }
        }
    }
}

