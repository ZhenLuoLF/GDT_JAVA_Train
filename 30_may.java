class A {
    int i = 10;
    int j = 30;
    int k;

    public static void main (String arg[]) {
        A a1 = new A();
        A a2 = new A();

        System.out.println("The k of a1 is " + a1.k);
        System.out.println("The k of a1 is " + a2.k);
        a1.add();
        a2.add();
        System.out.println("The k of a1 is " + a1.k);
        System.out.println("The k of a1 is " + a2.k);

    }

    void add() {
        k = i + j;
    }

}