package mahashakti.mahashakti.ArraysDummy;

import java.util.ArrayList;

import mahashakti.mahashakti.Models.ProgramModel;
import mahashakti.mahashakti.Models.ThoughtListModel;
import com.mahashakti.R;

/**
 * Created by dharamveer on 11/1/18.
 */

public class ProgramCollection {


    public static ArrayList<ProgramModel> getProgramsList() {

        ArrayList<ProgramModel> programModelArrayList = new ArrayList<>();

        ProgramModel p = new ProgramModel();

        p.setFestivalName("Makar Sankranti");
        p.setFestDescription("Makar Sankranti refers both to a specific solar day in the Hindu calendar and a Hindu festival in reference to deity Surya that is observed in January every year.");
        p.setDate("12-10-2018");
        p.setTime("11:25 AM");
        p.setImageProgram(R.drawable.makar);
        programModelArrayList.add(p);


        p = new ProgramModel();
        p.setFestivalName("Makar Sankranti");
        p.setFestDescription("Makar Sankranti refers both to a specific solar day in the Hindu calendar and a Hindu festival in reference to deity Surya that is observed in January every year.");
        p.setDate("12-10-2018");
        p.setTime("11:25 AM");
        p.setImageProgram(R.drawable.logomahashakti);
        programModelArrayList.add(p);


        p = new ProgramModel();
        p.setFestivalName("Makar Sankranti");
        p.setFestDescription("Makar Sankranti refers both to a specific solar day in the Hindu calendar. ");
        p.setDate("12-10-2018");
        p.setTime("11:25 AM");
        p.setImageProgram(R.drawable.makar);
        programModelArrayList.add(p);

        p = new ProgramModel();
        p.setFestivalName("Makar Sankranti");
        p.setFestDescription("Makar Sankranti refers both to a specific solar day in the Hindu calendar and a Hindu festival in reference to deity Surya that is observed in January every year.");
        p.setDate("12-10-2018");
        p.setTime("11:25 AM");
        p.setImageProgram(R.drawable.makar);
        programModelArrayList.add(p);


        p = new ProgramModel();
        p.setFestivalName("Makar Sankranti");
        p.setFestDescription("Makar Sankranti refers both to a specific solar day in the Hindu calendar and a Hindu festival in referencer.");
        p.setDate("12-10-2018");
        p.setTime("11:25 AM");
        p.setImageProgram(R.drawable.logomahashakti);
        programModelArrayList.add(p);


        return programModelArrayList;


    }
}