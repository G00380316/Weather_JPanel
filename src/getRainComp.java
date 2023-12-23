import java.util.Comparator;
/* Gets Rain Comparison */
public class getRainComp implements Comparator<Project> {
    @Override
    public int compare(Project o1, Project o2) {
        if (o1.getRain() < o2.getRain())
            return 1;
        else if (o1.getRain() > o2.getRain())
            return -1;
        else
            return 0;
    }
}
