public class TopObject {
    private SubObject subObject;

    TopObject(SubObject subObject) {
        this.subObject = subObject;
    }

    public TopObject(TopObject topObject) {
        this(new SubObject(topObject.getSubObject()));
    }

    public SubObject getSubObject() {
        return subObject;
    }

    public void setSubObject(SubObject subObject) {
        this.subObject = subObject;
    }

    @Override
    public String toString() {
        return "I have following sub-object + " + subObject.toString();
    }
}
