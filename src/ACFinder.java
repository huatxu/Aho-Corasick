import java.util.HashMap;
import java.util.List;

public class ACFinder {
	HashMap<Character, Edge> rootNode;
	
	public ACFinder() {
		rootNode = new HashMap<>();
	}
	// TODO: Devolver Clave: Cantidad de ocurrencias Valor: Ocurrencias
	public HashMap<String, Integer> getTest(String toTest) {
		return null;
	}
	
	public void addWord(String word) {
		int length = word.length();
		Edge nextNode = null;
		while(word.length() != 0) {
			char nextChar = word.charAt(0);
			if(word.length() == length) {
				if(rootNode.containsKey(nextChar)) {
					nextNode = rootNode.get(nextChar);
				} else {
					rootNode.put(word.charAt(0), new Edge(nextChar));
					nextNode = rootNode.get(nextChar);
				}
			} else {
				if(nextNode.getChildren().containsKey(nextChar)) {
					nextNode = nextNode.getChildren().get(nextChar);
				} else {
					nextNode.getChildren().put(word.charAt(0), new Edge(nextChar));
					nextNode = nextNode.getChildren().get(nextChar);
				}
				if(word.length() == 1) 
					nextNode.setLeaf(true);
			}
			word = word.substring(1);
		}
	}
	private class Edge {
		private HashMap<Character, Edge> children = new HashMap<>();
		private char character;
		private boolean isLeaf;
		private Edge(char character) {
			this.character = character;
		}
		private HashMap<Character, Edge> getChildren() {
			return children;
		} 
		private char getCharacter() {
			return character;
		}
		private void setLeaf(Boolean leaf) {
			this.isLeaf = leaf;
		}
		private boolean isLeaf() {
			return isLeaf;
		}
	}
	
}
