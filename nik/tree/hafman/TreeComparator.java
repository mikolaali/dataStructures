package nik.tree.hafman;

import java.util.Comparator;

public class TreeComparator implements Comparator<Tree> {
    @Override
    public int compare(Tree t1, Tree t2) {
        if(t1.root.amount > t2.root.amount)
            return 1;
        else if(t1.root.amount < t2.root.amount)
            return -1;
        return 0;
    }
}
