package section_08_methods;

/**
 * @author goran on 12/07/2017.
 */
public class MethodDesign {

    public void jump() {}

//    void public jump2() {} // does not compile

    void jump3() {}

    public final void jump4() {}
    public static final void jump5() {}
    public final static void jump6() {}

//    public array void jump7() {}
//    public String int float double jump8() {}
//    final public void final jump9() {}
    final static public void jump10() {}
//    String int public void jump11() {} // does not compile
}
