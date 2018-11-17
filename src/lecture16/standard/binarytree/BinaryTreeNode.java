package lecture16.standard.binarytree;

public class BinaryTreeNode {
	public int val;
	public BinaryTreeNode left = null, right = null;
	
	BinaryTreeNode(int v) {
		val = v;
	}
	
	public String toString() {
		return String.valueOf(val);
	}
}
