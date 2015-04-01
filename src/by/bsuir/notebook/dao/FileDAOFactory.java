package by.bsuir.notebook.dao;

/**
 * Created by Valentin on 3/19/2015.
 */
public class FileDAOFactory extends DAOFactory {
    private static FileDAOFactory instance = new FileDAOFactory();
    private FileDAOFactory() {
        super();
    }
    public static FileDAOFactory getInstance(){
       return instance;
    }
    public INotebookDao getNotebookDao(){
        return FileNotebookDao.getInstance();
    }
}
