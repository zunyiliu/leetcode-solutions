// solutuon 1: iterate method by applying queue, while deserialize you should apply queue<TreeNode> to pop each node and append itself with its children
// solution 2: recursive with pre-order 

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                sb.append("n,");
            }else{
                sb.append(node.val);
                sb.append(',');
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String vals[] = data.split(",");
        if(vals.length==1) return null;
        
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);
        int i = 1;
        while(i<vals.length){
            TreeNode cur = q.poll();
            if(cur==null) continue;
            
            if(!vals[i].equals("n")){
                cur.left = new TreeNode(Integer.parseInt(vals[i]));
                q.add(cur.left);
            }else{
                q.add(null);
            }
            
            if(!vals[i+1].equals("n")){
                cur.right = new TreeNode(Integer.parseInt(vals[i+1]));
                q.add(cur.right);
            }else{
                q.add(null);
            }
            
            i+=2;
        }
        
        return root;
    }
}

// solution 2
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root,sb);
        
        return sb.toString();
    }
    
    public void sHelper(TreeNode cur,StringBuilder sb){
        if(cur==null){
            sb.append("n,");
        }else{
            sb.append(cur.val+",");
            sHelper(cur.left,sb);
            sHelper(cur.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList( Arrays.asList(data.split(",")) );
        
        return dHelper(list);
    }
    
    public TreeNode dHelper(LinkedList<String> list){
        String cur = list.removeFirst();
        if(cur.equals("n")) return null;
        
        TreeNode ret = new TreeNode(Integer.parseInt(cur));
        ret.left = dHelper(list);
        ret.right = dHelper(list);
        
        return ret;
    }
}
