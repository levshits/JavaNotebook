package by.bsuir.notebook.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valentin on 3/19/2015.
 */
public class Request {
    private OperationType operationType;
    private Map<ParametersType, String> parameters = new HashMap<ParametersType, String>();


    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Map<ParametersType, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<ParametersType, String> parameters) {
        this.parameters = parameters;
    }
    public void setParameter(ParametersType type, String value){
        parameters.put(type, value);
    }
    public String getParameter(ParametersType type){
        String result = null;
        if(parameters.containsKey(type))
        {
            result = parameters.get(type);
        }
        return result;
    }
}
