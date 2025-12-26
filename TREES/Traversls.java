
public class Traversls {

    // INTERATIVE PREORDER TRAVERSAL
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     if(root == null) return ans;
    //     Stack<TreeNode> st = new Stack<>();
    //     st.push(root);
    //     while(!st.isEmpty()){
    //         TreeNode curr = st.pop();
    //         ans.add(curr.val);
    //         if(curr.right != null){
    //             st.push(curr.right);
    //         }
    //         if(curr.left != null){
    //             st.push(curr.left);
    //         }
    //     }
    //     return ans;
    // }


    // INTERATIVE INORDER TRAVERSAL
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     Stack<TreeNode> st = new Stack<>();
    //     TreeNode node = root;
    //     while(true){
    //         if(node != null){
    //             st.push(node);
    //             node = node.left;
    //         }
    //         else{
    //             if(st.isEmpty()){
    //                 break;
    //             }
    //             node = st.pop();
    //             ans.add(node.val);
    //             node = node.right;

    //         }
    //     }
    //     return ans;


    // ITERATIVE POSTORDER USING 2 STACK

    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     if(root == null) return ans;
    //     Stack<TreeNode> st1 = new Stack<>();
    //     Stack<TreeNode> st2 = new Stack<>();
    //     st1.push(root);
    //     while(!st1.isEmpty()){
    //         TreeNode curr = st1.pop();
    //         st2.push(curr);
    //         if(curr.left != null){
    //             st1.push(curr.left);
    //         }
    //         if(curr.right != null){
    //             st1.push(curr.right);
    //         }
    //     }
    //     while(!st2.isEmpty()){
    //         ans.add(st2.pop().val);
    //     }
    //     return ans;
        
    // }


    // ITERATIVE POSTORDER USING 1 STACK
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     if (root == null)
    //         return ans;

    //     Stack<TreeNode> st = new Stack<>();

    //     TreeNode node = root;

    //     while (!st.isEmpty() || node != null) {
    //         if (node != null) {
    //             st.push(node);
    //             node = node.left;
    //         } else {
    //             TreeNode temp = st.peek().right;
    //             if (temp != null) {
    //                 node = temp;
    //             } else {
    //                 temp = st.pop();
    //                 ans.add(temp.val);
    //                 while (!st.isEmpty() && temp == st.peek().right) {
    //                     temp = st.pop();
    //                     ans.add(temp.val);
    //                 }
    //             }
    //         }
    //     }

    //     return ans;

    // }
}

