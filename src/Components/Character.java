package Components;
import Objects.Point;

public class Character extends Point{
    private char value;

    public Character(){
        this.value = 'P';
    }

    public Character(char newVa){
        this.setValue(newVa);
    }

    public void setValue(char newVal){
        this.value = newVal;
    }

    public final char getValue() {
        return this.value;
    }
}
