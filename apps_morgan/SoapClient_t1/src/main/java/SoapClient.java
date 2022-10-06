import utez.Service;
import utez.ServiceService;

import java.util.Scanner;

public class SoapClient {
    public static void main(String[] args) {
        ServiceService service = new ServiceService();
        Service port = service.getServicePort();

        Scanner obj= new Scanner(System.in);
        int opc=0;
        int num;
        String word;
        String response="";
do {
    System.out.println("*****MEMU DE OPCIONES*****");
    System.out.println("1-Juego de adivina el número");
    System.out.println("2-Leer palabra y devolver consonantes");
    System.out.println("3-salir");

    opc = obj.nextInt();
    switch (opc) {
        case 1:
            do {
                System.out.println("Introduzca un número: ");
                num = obj.nextInt();
                response = port.responseMessage(String.valueOf(num));
                System.out.println(response);
            }
            while (!response.equals("You win!"));
            break;
        case 2:
            System.out.println("Enter a word: ");
            word = obj.next();
            String savetheWord = port.countConsonants(word);
            System.out.println(savetheWord);
            break;
        default:
            System.out.println("Elija una opción válida");
    }
}while (opc!=3);


}
}
