public class Main {

    public static void main(String[] args) {
        SubObject sub1 = new SubObject("name1", "title1");
        TopObject top1 = new TopObject(sub1);

        TopObject top2 = top1.clone();

        top2.getSubObject().setName("name2");
        top2.getSubObject().setTitle("title2");

        System.out.println(top1);
        System.out.println(top2);
    }
}
