package jp.example.shitstorm;
public class Momoclo {
    private String name;
    private String color;
	
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }
	
    @Override
    public String toString() {
        return "[" + name + ":" + color + "]";
    }
}