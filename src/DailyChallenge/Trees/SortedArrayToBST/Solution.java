package DailyChallenge.Trees.SortedArrayToBST;
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    TreeNode root;
    public TreeNode sortedArrayToBST(int[] nums) {
           int start = 0;
           int end = nums.length-1;
           sortedBST(nums, start, end);
           return root;
    }
    private void sortedBST(int[] nums, int start, int end){
        if (start > end) return;
        int mid = start+(end-start)/2;
        insert(nums[mid]);
        sortedBST(nums, start, mid-1);
        sortedBST(nums, mid+1, end);
    }
    private void insert(int value){
        root = insert(root, value);
    } 
    private TreeNode insert(TreeNode node, int value){
        if (node == null) {
            return new TreeNode(value);
        }
        if(value < node.val) node.left = insert(node.left, value);
        if(value > node.val) node.right = insert(node.right, value);
        return node;
    }
}
