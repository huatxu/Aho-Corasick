import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ACFinder {
	private HashMap<Character, Edge> rootNode;
	private List<String> dictionary;
	private HashMap<String, Integer> answer;
	public ACFinder() {
		rootNode = new HashMap<>();
		dictionary = new ArrayList<>();
		answer = new HashMap<>();
	}
	// Devolver Clave: Ocurrencias Valor: Cantidad de ocurrencias
	public HashMap<String, Integer> getTest(String toTest) {
		int length = toTest.length();
		answer.forEach((String j, Integer k) -> answer.replace(j, 0));
		HashMap<Character, Edge> nextNode = rootNode;
		for(int i = 0; i < length; i++) {
			String findingWord = "";
			int lastIndex = i;
			while(nextNode.containsKey(toTest.charAt(i))) {
				findingWord = findingWord + toTest.charAt(i);;
				if(nextNode.get(toTest.charAt(i)).isLeaf()) {
					answer.replace(findingWord, answer.get(findingWord) + 1);
				} 
				nextNode = nextNode.get(toTest.charAt(i)).getChildren();
				if(i < length - 1)
					i++;
			}
			i = lastIndex;
			nextNode = rootNode;
		}		
		return answer;
	}
	public void addWord(String word) {
		if(!dictionary.contains(word)) {
		dictionary.add(word);
		answer.put(word, 0);
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
			}
			if(word.length() == 1) {
				nextNode.setLeaf(true);
			}
			word = word.substring(1);
		}
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
		@SuppressWarnings("unused")
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
