package core;

import enums.Context;
import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<String, Object> scenarioContext;

    public ScenarioContext(){
        scenarioContext = new HashMap<>();
    }

    public void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
    }
    public void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }

    public Object getContext(Context key){
        return scenarioContext.get(key.toString());
    }
    public Object getContext(String key){
        return scenarioContext.get(key);
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
}
