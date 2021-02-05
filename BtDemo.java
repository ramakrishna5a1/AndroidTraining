public class BtDemo
{
	public static void main(String args[])
	{		
		BtDemo bt=new BtDemo();
		
		BtDemo.Node root = null;
		BtDemo.BinarySearchTree bst =bt.new BinarySearchTree();
		
		//inserting data into tree
		int[] data = {1,2};
		
		for(int i=0;i<data.length;i++)
			root = bst.insert(root,data[i]);
		
		//displaying the tree In-Order treversal
		bst.display(root);
		
		//max Depth of the tree
		System.out.println("Depth: "+bst.maxDepth(root));
		
		//All leaf Nodes
		ArrayList<Integer> list =new ArrayList<>();
		bst.getLeaveNodes(root,list);
		
		System.out.println(list);
		
		bst.levelsUsingStack(root);
	}
	
	class Node
	{
		int data;
		Node left;
		Node right;
			
		public Node(int data){
			this.data = data;
			left=null;
			right=null;
		}
	}
	
	class BinarySearchTree
	{
		Node insert(Node root,int data)
		{
			Node newNode = new Node(data);

			if(root == null)
				return newNode;
			
			if(data <= root.data)
				root.left = insert(root.left,data);
			else if(data > root.data)
				root.right = insert(root.right,data);
			
			return root;
		}
		
		void display(Node root)
		{
			if(root != null){
				display(root.left);
				System.out.println(root.data);
				display(root.right);
			}
		}
		
		int maxDepth(Node root)
		{
			if(root == null)
				return 0;
	
			int left = maxDepth(root.left);
			int right = maxDepth(root.right);
	
			return (1+Math.max(left,right));
		}
		
		public ArrayList<Integer> getLeaveNodes(Node root,ArrayList<Integer> list){
			if(root.left == null && root.right == null)
				list.add(root.data);
			
			if(root.left != null)
				getLeaveNodes(root.left,list);
			
			if(root.right != null)
				getLeaveNodes(root.right,list);
			
			return list;
		}
		
		void levelsUsingStack(Node root)
		{
			if(root == null)
				return;
				
			Queue<Node> q = new LinkedList<>();
			q.add(root);
			
			while(!q.isEmpty())
			{
				Node temp = q.poll();
				
				if(temp.left != null)
					q.add(temp.left);
				
				if(temp.right != null)
					q.add(temp.right);
				
				System.out.print(temp.data+" ");			
			}
		}
	}
}
