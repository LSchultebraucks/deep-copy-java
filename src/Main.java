public class Main {

    public static void main(String[] args) {
        SubObject sub1 = new SubObject("name1", "title1");
        TopObject top1 = new TopObject(sub1);

        SubObject sub2 = new SubObject(sub1);
        TopObject top2 = new TopObject(top1);

        sub2.setName("name2");
        sub2.setTitle("title2");

        System.out.println(top1);
        System.out.println(top2);
        System.out.println(sub1);
        System.out.println(sub2);
    }
}
