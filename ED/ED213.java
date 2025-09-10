//o código não é da minha autoria, problema resolvido com ajuda

class ED213 {
    public static String maxSum(BTree<Integer> t) {
        return maxSum(t.getRoot()).path;
    }

    private static class Result {
        int sum;
        String path;

        Result(int sum, String path) {
            this.sum = sum;
            this.path = path;
        }
    }

    private static Result maxSum(BTNode<Integer> node) {
        if (node == null) {
            return new Result(0, "");
        }

        if (node.getLeft() == null && node.getRight() == null) {
            //nó folha
            return new Result(node.getValue(), "");
        }

        //subcaminhos esquerdo e direito
        Result leftResult = maxSum(node.getLeft());
        Result rightResult = maxSum(node.getRight());

        //caminho com a maior soma
        if (leftResult.sum >= rightResult.sum) {
            return new Result(leftResult.sum + node.getValue(), "E" + leftResult.path);
        } else {
            return new Result(rightResult.sum + node.getValue(), "D" + rightResult.path);
        }
    }
}
