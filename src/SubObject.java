import java.io.Serializable;

public class SubObject implements Cloneable, Serializable {
    private String name;
    private String title;

    public SubObject(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public SubObject(SubObject subObject) {
        this(subObject.getName(), subObject.getTitle());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "My name is " + name + " and I have the title " + title + ".";
    }

    @Override
    public SubObject clone() {
        try {
            return (SubObject) super.clone();
        } catch (CloneNotSupportedException e) {
            return new SubObject(this.name, this.title);
        }
    }
}
