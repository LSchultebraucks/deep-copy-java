import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        SubObject subObject = new SubObject("myName", "myTitle");
        TopObject topObject = new TopObject(subObject);

        TopObject copyContructorTopObject = new TopObject(topObject);
        TopObject cloneableTopObject = topObject.clone();
        TopObject seralizationTopObject = deepClone(topObject);

        copyContructorTopObject.getSubObject().setName("nameChangedByCopyContructor");
        copyContructorTopObject.getSubObject().setTitle("titleChangedByCopyContrutor");
        cloneableTopObject.getSubObject().setName("nameChangedByCloneable");
        cloneableTopObject.getSubObject().setTitle("titleChangedByCloneable");
        seralizationTopObject.getSubObject().setName("nameChangedBySerialization");
        seralizationTopObject.getSubObject().setTitle("titleChangedBySerialization");

        System.out.println("--- Deep Copy of Objects ---");
        System.out.println("Original object: " + topObject);
        System.out.println("Copy Contructor: " + copyContructorTopObject);
        System.out.println("Cloneable: " + cloneableTopObject);
        System.out.println("Serialization: " + seralizationTopObject);
    }

    public static TopObject deepClone(TopObject object) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            return (TopObject) objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
