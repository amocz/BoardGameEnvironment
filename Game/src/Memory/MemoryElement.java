package Memory;

import GameEnvironment.Element;

public class MemoryElement extends Element {
    private String value;
    private boolean isFlipped;
    private boolean isMatched;
    
    public MemoryElement() {
        
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isFlipped() {
        return isFlipped;
    }

    public void setIsFlipped(boolean isFlipped) {
        this.isFlipped = isFlipped;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setIsMatched(boolean isMatched) {
        this.isMatched = isMatched;
    }
    
    @Override
    public String toString() {
        return this.value;
    }
}
