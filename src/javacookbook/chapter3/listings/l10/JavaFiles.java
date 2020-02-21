package javacookbook.chapter3.listings.l10;

import java.io.File;
import java.io.FileFilter;

public class JavaFiles implements FileFilter {
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(".class") || file.isDirectory();
    }
}
