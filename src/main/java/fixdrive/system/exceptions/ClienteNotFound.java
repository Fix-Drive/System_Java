package fixdrive.system.exceptions;

public class ClienteNotFound extends Exception{


    public ClienteNotFound(int id) {
        super("Cliente do ID" + id + "não localizado ");
    }
}
