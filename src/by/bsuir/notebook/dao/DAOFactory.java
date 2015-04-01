package by.bsuir.notebook.dao;

/**
 * Created by Valentin on 3/19/2015.
 */
public abstract class DAOFactory {
    //ToDo
    //Make loading from conf file
    private static SourceType type = SourceType.XML_FILE;
    protected DAOFactory(){}
    public abstract INotebookDao getNotebookDao();
    public static DAOFactory getInstance()
    {
        DAOFactory result = null;
        switch (type){
            case XML_FILE:
                result = FileDAOFactory.getInstance();
                break;
        }
        return result;
    }

}
