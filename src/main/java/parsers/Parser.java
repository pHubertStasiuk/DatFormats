package parsers;

import java.io.File;

public interface Parser<T> {

    T parse(File file);
}
