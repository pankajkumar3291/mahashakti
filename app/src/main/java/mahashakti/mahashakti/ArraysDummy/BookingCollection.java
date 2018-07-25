package mahashakti.mahashakti.ArraysDummy;

import java.util.ArrayList;

import mahashakti.mahashakti.Models.BookingModel;
import mahashakti.mahashakti.Models.ProgramModel;
import com.mahashakti.R;

/**
 * Created by dharamveer on 11/1/18.
 */

public class BookingCollection {

    public static ArrayList<BookingModel> getBookingList() {

        ArrayList<BookingModel> bookingModelArrayList = new ArrayList<>();

        BookingModel b = new BookingModel();

        b.setFestivalNameBooking("Makar Sankranti");
        b.setFestDescriptionBooking("Makar Sankranti refers both to a specific solar day in the Hindu calendar.");
        b.setDateBooking("12-10-2018");
        b.setTimeBooking("11:25 AM");
        b.setImageProgramBooking(R.drawable.makar);

        bookingModelArrayList.add(b);


        b = new BookingModel();
        b.setFestivalNameBooking("Makar Sankranti");
        b.setFestDescriptionBooking("Makar Sankranti refers both to a specific solar day in the Hindu calendar.");
        b.setDateBooking("12-10-2018");
        b.setTimeBooking("11:25 AM");
        b.setImageProgramBooking(R.drawable.makar);

        bookingModelArrayList.add(b);



        return bookingModelArrayList;
    }
}
