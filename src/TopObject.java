public class TopObject implements Cloneable {
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


    @Override
    protected TopObject clone()  {
        TopObject topObject = null;
        try {
            topObject = (TopObject) super.clone();
        } catch (CloneNotSupportedException e) {
            topObject = new TopObject(this.subObject);
        }
        topObject.subObject = this.subObject.clone();
        return topObject;
    }
}
