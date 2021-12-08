public class Main {
    public static void main(String[] args) {
        Girl girl = new Girl();
        System.out.println(girl.greeting());
        KotlinGirl kgirl = new KotlinGirl("Lily");
        System.out.println(kgirl.greeting());
    }
}
