
public class Driver {
	public static void main(String... args) {
		ACFinder finder = new ACFinder();
		finder.addWord("hola");
		finder.addWord("hadios");
		System.out.println(finder.getTest("amigholsdhadosasdhola jdf holahadiosholahola"));
	} 
}
