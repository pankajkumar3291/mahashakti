package mahashakti.mahashakti.Models;

import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dharamveer on 11/1/18.
 */

public class ProgramModel {


    private int imageProgram;
    private String FestivalName,FestDescription,Date,Time;

    public int getImageProgram() {
        return imageProgram;
    }

    public void setImageProgram(int imageProgram) {
        this.imageProgram = imageProgram;
    }

    public String getFestivalName() {
        return FestivalName;
    }

    public void setFestivalName(String festivalName) {
        FestivalName = festivalName;
    }

    public String getFestDescription() {
        return FestDescription;
    }

    public void setFestDescription(String festDescription) {
        FestDescription = festDescription;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
