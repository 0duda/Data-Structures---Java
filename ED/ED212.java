//problema resolvido com ajuda

class ED212{
    public static int[] sumLevels(BTree<Integer> t) {
        int depth = t.depth(); 
        int[] v = new int[depth + 1]; 

        for (int level = 0; level <= depth; level++) {
            v[level] = sumLevel(t.getRoot(), level); // Soma para o nível atual
        }

        return v;
    }

    
    private static int sumLevel(BTNode<Integer> node, int level) {
        if (node == null) {
            return 0; 
        }

        if (level == 0) {
            return node.getValue(); //se estivermos no nível desejado
        }

        //caso contrário, desce para o próximo nível em ambas as subárvores
        return sumLevel(node.getLeft(), level - 1) + sumLevel(node.getRight(), level - 1);
    }
}