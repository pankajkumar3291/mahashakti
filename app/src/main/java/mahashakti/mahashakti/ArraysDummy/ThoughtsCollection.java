package mahashakti.mahashakti.ArraysDummy;

import java.util.ArrayList;

import mahashakti.mahashakti.Models.ThoughtListModel;
import com.mahashakti.R;

/**
 * Created by dharamveer on 11/1/18.
 */

public class ThoughtsCollection {



    public static ArrayList<ThoughtListModel> getThoughts(){

        ArrayList<ThoughtListModel> thoughtListModels = new ArrayList<>();
        ThoughtListModel t = new ThoughtListModel();

        t.setName("Dharamveer");
        t.setChat("What are youe doing. I am working on the project");
        t.setDate("12-11-2017");
        t.setTime("12:10 PM");
        t.setImage(R.drawable.male);
        t.setLike("15");
        thoughtListModels.add(t);

        t = new ThoughtListModel();
        t.setName("Dharamveer");
        t.setChat("What are youe doing. I am working on the project");
        t.setDate("12-11-2017");
        t.setTime("12:10 PM");
        t.setImage(R.drawable.male);
        t.setLike("15");
        thoughtListModels.add(t);


        t = new ThoughtListModel();
        t.setName("Dharamveer");
        t.setChat("What are youe doing. I am working on the project");
        t.setDate("12-11-2017");
        t.setTime("12:10 PM");
        t.setImage(R.drawable.male);
        t.setLike("15");
        thoughtListModels.add(t);



        t = new ThoughtListModel();
        t.setName("Dharamveer");
        t.setChat("What are youe doing. I am working on the project");
        t.setDate("12-11-2017");
        t.setTime("12:10 PM");
        t.setImage(R.drawable.male);
        t.setLike("15");
        thoughtListModels.add(t);



        t = new ThoughtListModel();
        t.setName("Dharamveer");
        t.setChat("What are youe doing. I am working on the project");
        t.setDate("12-11-2017");
        t.setTime("12:10 PM");
        t.setImage(R.drawable.male);
        t.setLike("15");
        thoughtListModels.add(t);


        return thoughtListModels;
    }
}
