import java.util.LinkedList;
import java.util.Queue;

public class FindCorrespondingNodeOfBinaryTreeInCloneOfThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Queue<TreeNode> qu = new LinkedList<>();
        Queue<TreeNode> clone = new LinkedList<>();
        qu.offer(original);
        clone.offer(cloned);

        while (!qu.isEmpty()) {

            int size = qu.size();

            while (size-- > 0) {
                TreeNode node = qu.poll();
                TreeNode cl = clone.poll();

                if (node == target) {
                    return cl;
                }

                if (node.left != null) {
                    qu.offer(node.left);
                    clone.offer(cl.left);
                }

                if (node.right != null) {
                    qu.offer(node.right);
                    clone.offer(cl.right);
                }
            }
        }
        return null;
    }
}