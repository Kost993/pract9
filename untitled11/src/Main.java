public class Main {

    public static void main(String[] args) {

        CustomArrayList list1 = new CustomArrayList(4);

        list1.addLast(40);
        list1.addLast(10);
        list1.addLast(30);
        list1.addLast(20);

        System.out.println("Оригінал:");
        list1.print();

        list1.sort();

        System.out.println("Відсортовано за зростанням:");
        list1.print();

        list1.sort(new DescendingComparator());

        System.out.println("Відсортовано за спаданням:");
        list1.print();

        CustomArrayList list2 = new CustomArrayList(4);

        list2.addLast(1);
        list2.addLast(2);

        int result = list1.compareTo(list2);

        if (result > 0) {
            System.out.println("список1 більший за список2");
        } else if (result < 0) {
            System.out.println("список1 менший за список2");
        } else {
            System.out.println("список1 дорівнює списку2");
        }
    }
}