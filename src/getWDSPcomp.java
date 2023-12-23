import java.util.Comparator;
/* Gets Wind Speed Comparison */
public class getWDSPcomp implements Comparator<Project> {
    @Override
    public int compare(Project o1, Project o2) {
        if (o1.getWdsp() < o2.getWdsp())
            return +1;
        else if (o1.getWdsp() > o2.getWdsp())
            return -1;
        else
            return 0;
    }
}