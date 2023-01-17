import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {
        // implement me
        String parentF1 = f1.getParent();
        String parentF2 = f2.getParent();
        return parentF1.equals(parentF2);
    }
}