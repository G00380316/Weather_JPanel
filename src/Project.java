/*
    This Powers the main document to create all data types needed
    This is taken from the project document for all data types
    data is gotten and outputted through here
 */

public class Project implements Comparable<Project> {
    private float year;
    private float month;
    private float meant;
    private float maxtp;
    private float mintp;
    private float mnmax;
    private float mnmin;
    private float rain;
    private float gmin;
    private float wdsp;
    private float mxgt;
    private float sun;
    private int handle;

    public Project(float Year, float Month, float Meant, float Maxtp, float Mintp, float Mnmax, float Mnmin, float Rain, float Wdsp, float Gmin, float Mxgt, float Sun) {
        year = Year;
        month = Month;
        meant = Meant;
        maxtp = Maxtp;
        mintp = Mintp;
        mnmax = Mnmax;
        mnmin = Mnmin;
        rain = Rain;
        gmin = Gmin;
        wdsp = Wdsp;
        mxgt = Mxgt;
        sun = Sun;
    }

    public Project(int Handle) {
        handle = Handle;
    }

    @Override
    public String toString() {
        return "Project{" +
                "year=" + year +
                ", month=" + month +
                ", meant=" + meant +
                ", maxtp=" + maxtp +
                ", mintp=" + mintp +
                ", mnmax=" + mnmax +
                ", mnmin=" + mnmin +
                ", rain=" + rain +
                ", gmin=" + gmin +
                ", wdsp=" + wdsp +
                ", mxgt=" + mxgt +
                ", sun=" + sun +
                '}';
    }

    public float getYear() {
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }

    public float getMonth() {
        return month;
    }

    public void setMonth(float month) {
        this.month = month;
    }

    public float getMeant() {
        return meant;
    }

    public void setMeant(float meant) {
        this.meant = meant;
    }

    public float getMaxtp() {
        return maxtp;
    }

    public void setMaxtp(float maxtp) {
        this.maxtp = maxtp;
    }

    public float getMintp() {
        return mintp;
    }

    public void setMintp(float mintp) {
        this.mintp = mintp;
    }

    public float getMnmax() {
        return mnmax;
    }

    public void setMnmax(float mnmax) {
        this.mnmax = mnmax;
    }

    public float getMnmin() {
        return mnmin;
    }

    public void setMnmin(float mnmin) {
        this.mnmin = mnmin;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    public float getGmin() {
        return gmin;
    }

    public void setGmin(float gmin) {
        this.gmin = gmin;
    }

    public float getWdsp() {
        return wdsp;
    }

    public void setWdsp(float wdsp) {
        this.wdsp = wdsp;
    }

    public float getMxgt() {
        return mxgt;
    }

    public void setMxgt(float mxgt) {
        this.mxgt = mxgt;
    }

    public float getSun() {
        return sun;
    }

    public void setSun(float sun) {
        this.sun = sun;
    }


    @Override
    public int compareTo(Project o) {
        int value = 0;
            if (o.maxtp < this.maxtp) {
                value = -1;
            } else if (o.maxtp > this.maxtp) {
                value = 1;
            } else {
                value = 0;
            }
        return value;
    }

}
