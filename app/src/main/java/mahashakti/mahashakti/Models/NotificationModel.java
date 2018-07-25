package mahashakti.mahashakti.Models;

/**
 * Created by dharamveer on 12/1/18.
 */

public class NotificationModel {


    private int imageNotification;
    private String notificationName,notificationDesc;

    public int getImageNotification() {
        return imageNotification;
    }

    public void setImageNotification(int imageNotification) {
        this.imageNotification = imageNotification;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public void setNotificationName(String notificationName) {
        this.notificationName = notificationName;
    }

    public String getNotificationDesc() {
        return notificationDesc;
    }

    public void setNotificationDesc(String notificationDesc) {
        this.notificationDesc = notificationDesc;
    }
}
