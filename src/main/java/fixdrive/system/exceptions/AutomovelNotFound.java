package fixdrive.system.exceptions;

public class AutomovelNotFound extends RuntimeException {
    public AutomovelNotFound(int id) {
        super("Automovel do ID " + id + "não localizado");
    }
}
