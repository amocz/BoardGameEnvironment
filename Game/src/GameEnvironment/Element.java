package GameEnvironment;

public abstract class Element {
    
    private String piecename;
    
    public Element() {
        this.piecename = "";
    }

    public String getPiecename() {
        return piecename;
    }

    public void setPiecename(String piecename) {
        this.piecename = piecename;
    }
}
