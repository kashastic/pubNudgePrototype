package com.example.nudgerewriten.models;

import android.os.Parcel;
import android.os.Parcelable;

public class products implements Parcelable {
    String Productname, ProductComany;
    int price,productimage;

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public products(String productname, String productComany, int price, int productimage) {
        Productname = productname;
        ProductComany = productComany;
        this.price = price;
        this.productimage = productimage;
    }

    protected products(Parcel in) {
        Productname = in.readString();
        ProductComany = in.readString();
        price = in.readInt();
    }

    public static final Creator<products> CREATOR = new Creator<products>() {
        @Override
        public products createFromParcel(Parcel in) {
            return new products(in);
        }

        @Override
        public products[] newArray(int size) {
            return new products[size];
        }
    };

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getProductComany() {
        return ProductComany;
    }

    public void setProductComany(String productComany) {
        ProductComany = productComany;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Productname);
        dest.writeString(ProductComany);
        dest.writeInt(price);
    }

}
