package ActivityDiagram;

public abstract class Element {
    protected String id;
    protected String type; 
    protected String label;
    protected int level; 

    public Element(String id, String type, String label, int level) {
        this.id = id;
        this.type = type;
        this.label = label;
        this.level = level;
    }
    
    public String getId() { 
        return id; 
    }
    
    public String getType() { 
        return type; 
    }
    
    public String getLabel() { 
        return label; 
    }
    
    public int getLevel() { 
        return level; 
    }
    
    public void setLevel(int level) {
        this.level = level; 
    }
}
