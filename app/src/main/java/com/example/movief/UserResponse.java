package com.example.movief;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class UserResponse implements Parcelable {

	@SerializedName("next")
	private Object next;

	@SerializedName("previous")
	private Object previous;

	@SerializedName("count")
	private int count;

	@SerializedName("results")
	private List<ResultsItem> results;

	protected UserResponse(Parcel in) {
		count = in.readInt();
		results = in.createTypedArrayList(ResultsItem.CREATOR);
	}

	public static final Creator<UserResponse> CREATOR = new Creator<UserResponse>() {
		@Override
		public UserResponse createFromParcel(Parcel in) {
			return new UserResponse(in);
		}

		@Override
		public UserResponse[] newArray(int size) {
			return new UserResponse[size];
		}
	};

	public Object getNext(){
		return next;
	}

	public Object getPrevious(){
		return previous;
	}

	public int getCount(){
		return count;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(count);
		parcel.writeTypedList(results);
	}
}