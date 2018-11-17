package lecture16.standard.binarytree;

public abstract class BinaryTreeTools {
	public static BinaryTreeNode stringToTree(String s) {
		BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(String.valueOf(s.charAt(0))));
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				// Maybe make it handle as null?
				continue;
			}
			
		}
		return root;
	}
}
