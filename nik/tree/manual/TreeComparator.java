package nik.tree.manual;

import java.util.Comparator;

public class TreeComparator implements Comparator<Tree> {
    @Override
    public int compare(Tree tree1, Tree tree2) {
        if (tree1.getRoot().amount < tree2.getRoot().amount)
            return 1;
        else if (tree1.getRoot().amount > tree2.getRoot().amount)
            return -1;
        return 0;
    }
    }

