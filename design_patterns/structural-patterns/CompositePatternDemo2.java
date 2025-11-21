import java.util.ArrayList;

//Abstract component
abstract class AbstractFile {
	public abstract void ls();
	public static StringBuffer g_indent = new StringBuffer();
}

//Concrete composite
class Directory extends AbstractFile{
  
	private String name;
	private ArrayList composite = new ArrayList();
  
	public Directory(String name){
      this.name = name;
	}
	
	public void add(AbstractFile obj){
	    composite.add(obj);
	}
  
	public void ls(){
		System.out.println(AbstractFile.g_indent + name);
		AbstractFile.g_indent.append("   ");
		for (int i = 0; i < composite.size(); ++i) {           
			AbstractFile obj = (AbstractFile) composite.get(i);
			obj.ls();
		}        
	}    
}

//Concrete leaf
class File extends AbstractFile{
	
	private String m_name;
	
	public File(String name){
        m_name = name;
    }
    
	public void ls(){
        System.out.println(AbstractFile.g_indent + m_name);
    }    
}

public class CompositePatternDemo2 {	
    public static void main(String[] args){
        
    	Directory one = new Directory("dir111"); 
    	Directory two = new Directory("dir222");
        Directory three = new Directory("dir333");
        
        File a = new File("a");
        File b = new File("b");
        File c = new File("c");
        File d = new File("d");
        File e = new File("e");
        
        one.add(a); //adding file a to directory one
        one.add(b); //adding file b to directory one
        one.add(two); //adding directory two to directory one
        two.add(c); //adding file c to directory two
        two.add(d); //adding file d to directory two
        two.add(three); //adding directory three to directory two
        three.add(e);
        
        one.ls();
    }
}