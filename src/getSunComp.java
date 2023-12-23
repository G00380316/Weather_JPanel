import java.util.Comparator;
/* Gets Sun Comparison */
public class getSunComp implements Comparator<Project> {
    @Override
    public int compare(Project o1, Project o2) {
        if (o1.getSun() > o2.getSun())
            return -1;
        else if (o1.getSun() < o2.getSun())
            return 1;
        else
            return 0;
    }
}