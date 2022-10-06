import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;  //estos dos se importan en automatico
import javax.xml.ws.Endpoint;

@WebService(name= "Service", targetNamespace = "utez")  //tarjet name es como un package
@SOAPBinding(style = SOAPBinding.Style.RPC)
//toda la implementacion de este servicio y todo lo va a hacer con este servicio en automatico
public class Service {

    @WebMethod(operationName = "responseMessage")
    public String responseMessage(
                    @WebParam(name = "name") String name,
                    @WebParam(name = "Apaterno") String Apaterno,
                    @WebParam(name = "Amaterno") String Amaterno,
                    @WebParam(name = "year") String year,
                    @WebParam(name = "month") String month,
                    @WebParam(name = "day") String day
    )
    {
    //String name, String Apaterno, String Amaterno, String year, String month, String day){
        String rfc= "";
        rfc = Apaterno.trim().substring(0,2);
        rfc = rfc.concat(Amaterno.trim().substring(0,1)) ;
        rfc= rfc.concat(name.trim().substring(0,1));
        rfc = rfc.concat(year.trim().substring(2,4));
        rfc = rfc.concat(month);
        rfc = rfc.concat(day);
        final String values = "abcdefghijklmnñopqrstuvwxyz0123456789";
        final int numbersRandom = 3;
        StringBuilder myRandom = new StringBuilder();
        for (int i=0; i<numbersRandom; i++ ){
            double valor = Math.random()*values.length();
            int cadenaPosition = (int ) valor;
            char caracter = values.charAt(cadenaPosition);
            myRandom.append(caracter);
        }
        rfc = rfc.concat(myRandom.toString());
        return rfc.toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println("Starting server...");
        Endpoint.publish("http://localhost:8081/Service", new Service());
        System.out.println("Waiting requests...");
    }

}
