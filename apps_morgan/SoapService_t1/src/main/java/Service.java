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
    public String responseMessage(@WebParam(name = "message") String message){
        //return "El mensaje recibido fue "+message;
            int random = (int) (Math.random()*3+1);
            if(random == Integer.parseInt(message)){
                return ("You win!");
            }else{
                return ("Try again...");
            }
    }

    @WebMethod(operationName = "countConsonants")
    public String countConsonants(@WebParam(name = "message") String message){
        if(message == null)
            return "Missing fields";
        return message.replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "");
    }

    public static void main(String[] args) {
        System.out.println("Starting server...");
        Endpoint.publish("http://localhost:8081/Service", new Service());
        System.out.println("Waiting requests...");
    }

}
