import java.util.Comparator;
/* Gets Temp Comparison */
public class maxTPComp implements Comparator<Project> {
    @Override
    public int compare(Project o1, Project o2) {
        if (o1.getMaxtp() > o2.getMaxtp())
            return -1;
        else if (o1.getMaxtp() < o2.getMaxtp())
            return +1;
        else
            return 0;
    }
}
