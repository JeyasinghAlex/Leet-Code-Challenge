import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {

        List<List<String>> ans = new ArrayList<>();
        int row = getMaxDepth(root);
        int col = (int) Math.pow(2, row) - 1;

        for (int i = 0; i < row; ++i) {
            List<String> r = new ArrayList<>();
            for (int j = 0; j < col; ++j) {
                r.add("");
            }
            ans.add(r);
        }

        Queue<TreeNode> qu = new LinkedList<>();
        Queue<int[]> index = new LinkedList<>();
        qu.offer(root);
        index.offer(new int[]{0, col - 1});

        int level = 0;
        while (!qu.isEmpty()) {

            int size = qu.size();
            while (size-- > 0) {
                TreeNode node = qu.poll();
                int[] indices = index.poll();

                if (node == null) {
                    continue;
                }

                int left =  indices[0];
                int right = indices[1];
                int mid = left + right >>> 1;
                ans.get(level).set(mid, String.valueOf(node.val));
                qu.offer(node.left);
                qu.offer(node.right);
                index.offer(new int[]{left, mid - 1});
                index.offer(new int[]{mid + 1, right});
            }
            level++;
        }
        return ans;
    }

    private int getMaxDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = getMaxDepth(node.left);
        int right = getMaxDepth(node.right);

        return 1 + Math.max(left, right);
    }
}
