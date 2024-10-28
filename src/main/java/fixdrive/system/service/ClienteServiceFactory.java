package fixdrive.system.service;

import fixdrive.system.dao.ClienteDao;

public class ClienteServiceFactory {




    private ClienteServiceFactory() {
    }

    public static ClienteService create(){
        return new ClienteServiceImpl();
    }
}
