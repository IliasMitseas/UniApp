package ilias.uniapp.db;

import java.util.Comparator;

public class SortByViews implements Comparator<University> {
    public int compare(University a, University b){
        return a.getUniversityviews() - b.getUniversityviews();
    }
}
