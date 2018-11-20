import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        SubObject sub1 = new SubObject("name1", "title1");
        TopObject top1 = new TopObject(sub1);

        TopObject top2 = deepClone(top1);

        top2.getSubObject().setName("name2");
        top2.getSubObject().setTitle("title2");

        System.out.println(top1);
        System.out.println(top2);
    }

    public static  TopObject deepClone(TopObject object){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            return (TopObject) objectInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
