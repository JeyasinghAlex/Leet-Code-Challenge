import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        return leverOrder(root);
    }

    private List<Double> leverOrder(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while (!qu.isEmpty()) {

            int len = qu.size();
            double sum = 0.0;
            int l = len;
            while (len > 0) {

                TreeNode temp = qu.poll();
                if (temp != null) {
                    sum += temp.val;
                    if (temp.left != null)
                        qu.offer(temp.left);
                    if (temp.right != null)
                        qu.offer(temp.right);
                }
                len--;
            }
            list.add(sum / l);
        }
        return list;
    }
}
