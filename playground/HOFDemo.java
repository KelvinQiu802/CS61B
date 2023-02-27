public class HOFDemo {
    public static int do_twice(IntUnaryFunction fn, int x) {
        return fn.apply(fn.apply(x));
    }

    // 因为就版本Java的MemoryBox不能仅仅指向一个函数，所以需要通过一个类和接口来避开这个缺点
    public static void main(String[] args) {
        System.out.println(do_twice(new AddTen(), 10));
    }
}
