package mahashakti.mahashakti.ArraysDummy;

import java.util.ArrayList;

import mahashakti.mahashakti.Models.BookingModel;
import mahashakti.mahashakti.Models.NotificationModel;
import com.mahashakti.R;

/**
 * Created by dharamveer on 12/1/18.
 */

public class NotificationCollection  {


    public static ArrayList<NotificationModel> getNotificationList() {

        ArrayList<NotificationModel> notificationModelArrayList = new ArrayList<>();

        NotificationModel n = new NotificationModel();

        n.setNotificationName("NEW MESSAGE");
        n.setNotificationDesc("The New Message from God is a genuine, divine revelation from the creator to humanity. The New Message is not based on any existing religious tradition.");
        n.setImageNotification(R.drawable.makar);

        notificationModelArrayList.add(n);


        n = new NotificationModel();
        n.setNotificationName("NEW MESSAGE");
        n.setNotificationDesc("The New Message from God is a genuine, divine revelation from the creator to humanity. The New Message is not based on any existing religious tradition.");
        n.setImageNotification(R.drawable.makar);

        notificationModelArrayList.add(n);


        n = new NotificationModel();
        n.setNotificationName("NEW MESSAGE");
        n.setNotificationDesc("The New Message from God is a genuine, divine revelation from the creator to humanity. The New Message is not based on any existing religious tradition.");
        n.setImageNotification(R.drawable.makar);

        notificationModelArrayList.add(n);

        return notificationModelArrayList;
    }


}
