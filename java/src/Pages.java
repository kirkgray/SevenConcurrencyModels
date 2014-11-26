import java.util.Iterator;

/**
 * Created by kirkg on 11/25/14.
 */
public class Pages implements Iterable<Page> {

    private Integer lines;
    private String fileName;

    public Pages( Integer lines, String fileName ) {
        this.lines = lines;
        this.fileName = fileName;
    }

    @Override
    public Iterator<Page> iterator() {
        return null;
    }
}
