
public class ArrayComponentType {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        
        System.out.println("Array type: " + matrix.getClass().getName());
        System.out.println("Component type: " + matrix.getClass().getComponentType());
    
        String[][] words = new String[2][3];
        
        System.out.println("Array type: " + words.getClass().getName());
        System.out.println("Component type: " + words.getClass().getComponentType());
    
        String[] names = new String[5];
        System.out.println(names.getClass().getName());
        System.out.println(names.getClass().getComponentType());
    }
}


 

