class Building{}
public class Barn extends Building {
    public static void main(String[] args) {
        Building build1 = new Building();
        Barn barn1 = new Barn();
        Barn barn2 = (Barn) build1;
        Object obj1 = (Object) build1;
        String str1 = (String) build1;
        Building build2 = (Building) barn1;
    }
}
