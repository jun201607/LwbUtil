package demo.lwb.com.myutils.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lwb on 2018/4/12.
 * Parcelable接口
 */

public class ParcelBean implements Parcelable{
    int userId;
    String userName;
    boolean isMale;
    public ParcelBean(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeString(userName);
        parcel.writeInt(isMale?1:0);
//        parcel.writeParcelable(userBean,0);
    }
    public static final Creator<ParcelBean> CREATOR = new Creator<ParcelBean>() {
        @Override
        public ParcelBean createFromParcel(Parcel in) {
            return new ParcelBean(in);
        }

        @Override
        public ParcelBean[] newArray(int size) {
            return new ParcelBean[size];
        }
    };
    protected ParcelBean(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readInt() == 1;
//        Parcelable parcelable = in.readParcelable(Thread.currentThread().getContextClassLoader());
    }
}
