package fixdrive.system.exceptions;

public class AutomovelInvalid extends RuntimeException {
    public AutomovelInvalid() {

        super("ID já existente.");
    }
}
