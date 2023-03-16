package Repositories;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryManager {

    private ApplicationContext context;

    @Autowired
    public void RepositoryRouter(ApplicationContext context) {
        this.context = context;
    }

    public RepositoryManager(ApplicationContext context) {
        this.context = context;
    }

    public IRepository getRepository(String label) {
        switch (label) {
            case "JDBC":
                return context.getBean(RepositoryJDBC.class);
            case "Stub":
                return context.getBean(RepositoryStub.class);
            default:
                throw new IllegalArgumentException("Invalid repository label: " + label);
        }
    }

}
